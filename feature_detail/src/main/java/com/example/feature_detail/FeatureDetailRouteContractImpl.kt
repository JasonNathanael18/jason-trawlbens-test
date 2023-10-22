package com.example.feature_detail

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.example.detail.R
import com.example.router.FeatureScreenDetailRouteContract

class FeatureDetailRouteContractImpl : FeatureScreenDetailRouteContract {
    override fun show(dataToPass: String, navController: NavController) {
        navController.navigate(R.id.nav_graph_detail, bundleOf("argDetailValue" to dataToPass))
    }
}