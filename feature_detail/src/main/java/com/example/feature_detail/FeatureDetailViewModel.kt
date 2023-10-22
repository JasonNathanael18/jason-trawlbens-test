package com.example.feature_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.repository.RepoEntity
import com.example.domain.usecase.LocalUseCase
import com.example.entity.RepoItemEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeatureDetailViewModel @Inject constructor(
    private val localUseCase: LocalUseCase
) : ViewModel() {

    fun saveToDatabase(item: RepoItemEntity){
        val repoEntity = RepoEntity(item)
        viewModelScope.launch {
            localUseCase.insertRecipes(repoEntity)
        }
    }

}