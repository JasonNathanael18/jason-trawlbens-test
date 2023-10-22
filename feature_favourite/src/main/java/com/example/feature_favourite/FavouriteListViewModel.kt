package com.example.feature_favourite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.LocalUseCase
import com.example.entity.RepoItemEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteListViewModel @Inject constructor(
    private val localUseCase: LocalUseCase
) : ViewModel() {

    private val viewModelState = MutableStateFlow(FavouriteListViewModelState())

    val uiState = viewModelState
        .map(FavouriteListViewModelState::toUiState)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    fun getRepoList() {
        viewModelScope.launch {
            localUseCase.readRecipes().collect { data ->
                val listFavourite = mutableListOf<RepoItemEntity>()
                if (data.isNotEmpty()) {
                    data.map {
                        listFavourite.add(
                            it.repo
                        )
                    }
                }
                viewModelState.update {
                    it.copy(repoList = listFavourite)
                }
            }
        }
    }
}

private data class FavouriteListViewModelState(
    val repoList: List<RepoItemEntity> = listOf(),
    val isEmpty: Boolean = false
) {
    fun toUiState(): FavouriteListUiState =
        if (repoList.isEmpty()) FavouriteListUiState.RepoListEmpty(isEmpty = true)
        else FavouriteListUiState.HasRepoList(repoList = repoList)
}

sealed interface FavouriteListUiState {

    data class HasRepoList(
        val repoList: List<RepoItemEntity>,

        ) : FavouriteListUiState

    data class RepoListEmpty(
        val isEmpty: Boolean
    ) : FavouriteListUiState
}