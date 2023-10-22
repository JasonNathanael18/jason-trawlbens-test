package com.example.feature_repolist

import com.example.router.FeatureScreenRepoListRouteContract
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.example.repolist.R

class FeatureRepoListRouteContractImpl : FeatureScreenRepoListRouteContract {
    override fun show(dataToPass: String, navController: NavController) {
        navController.navigate(R.id.nav_graph_repolist,
            bundleOf("argRepoListValue" to dataToPass))
    }
}