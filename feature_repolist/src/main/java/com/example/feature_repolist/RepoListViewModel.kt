package com.example.feature_repolist

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.repository.RepoEntity
import com.example.domain.usecase.LocalUseCase
import com.example.domain.usecase.RepoListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.domain.utils.Result
import com.example.entity.RepoItemEntity
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class RepoListViewModel @Inject constructor(
    private val repoListUseCase: RepoListUseCase,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    enum class SavedStateKey {
        NextPageToLoad
    }

    var query = "kamrul3288"

    private val viewModelState = MutableStateFlow(RepoListViewModelState(isLoading = true))

    private var nextPageToLoad: Int = savedStateHandle[SavedStateKey.NextPageToLoad.name] ?: 1
        set(value) {
            savedStateHandle[SavedStateKey.NextPageToLoad.name] = value
            field = value
        }

    val uiState = viewModelState
        .map(RepoListViewModelState::toUiState)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    init {
        fetchRepoList()
    }

    private fun fetchRepoList() {
        viewModelScope.launch {
            repoListUseCase.execute(
                RepoListUseCase.Params(
                    userName = query,
                    perPage = 10,
                    page = nextPageToLoad
                )
            )
                .collect { response ->
                    when (response) {
                        is Result.Error -> viewModelState.update {
                            it.copy(error = response.message, isPreviousPageLoaded = nextPageToLoad > 1)
                        }

                        is Result.Loading -> viewModelState.update {
                            it.copy(error = "", isLoading = response.loading)
                        }

                        is Result.Success -> viewModelState.update {
                            it.copy(repoList = response.data, isPreviousPageLoaded = nextPageToLoad > 1)
                        }
                    }
                }
        }
    }

    fun requestMoreData() {
        nextPageToLoad++
        fetchRepoList()
    }

    fun requestSearch(query: String) {
        nextPageToLoad = 1
        this.query = query
        fetchRepoList()
    }

}

private data class RepoListViewModelState(
    val isLoading: Boolean = false,
    val error: String = "",
    val repoList: List<RepoItemEntity> = listOf(),
    val isPreviousPageLoaded: Boolean = false
) {
    fun toUiState(): RepoListUiState =
        if (repoList.isEmpty()) RepoListUiState.RepoListEmpty(isLoading = isLoading, error = error, isPreviousPageLoaded = isPreviousPageLoaded)
        else RepoListUiState.HasRepoList(isLoading = isLoading, error = error, repoList = repoList)
}

sealed interface RepoListUiState {
    val isLoading: Boolean
    val error: String

    data class HasRepoList(
        val repoList: List<RepoItemEntity>,
        override val isLoading: Boolean,
        override val error: String
    ) : RepoListUiState

    data class RepoListEmpty(
        override val isLoading: Boolean,
        override val error: String,
        val isPreviousPageLoaded: Boolean
    ) : RepoListUiState
}