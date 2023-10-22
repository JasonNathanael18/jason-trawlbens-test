package com.example.modularnoncompose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.router.FeatureScreenRepoListRouteContract
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {

    @Inject
    lateinit var featureRepolistRouteContractImpl: FeatureScreenRepoListRouteContract

//    @Inject
//    lateinit var featureProfileRouteContractImpl: FeatureScreenProfileRouteContract


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("here too")


//        buttonNavigateFeatureA.setOnClickListener {
        featureRepolistRouteContractImpl.show(
            dataToPass = "abc",
            navController = findNavController()
        )
//        }
//        buttonNavigateFeatureB.setOnClickListener {
//        featureProfileRouteContractImpl.show("def", findNavController())
//        }
//        toggleTheme.setOnClickListener {
//            MainActivity.accentTheme = !MainActivity.accentTheme
//            requireActivity().recreate()
//        }


    }
}