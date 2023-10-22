package com.example.feature_detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.detail.R
import com.example.detail.databinding.FragmentFeatureDetailBinding
import com.example.domain.utils.DataConvert
import com.example.entity.RepoItemEntity
import com.example.router.FeatureScreenFavouriteRouteContract
import com.example.uicomponent.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailFragment : BaseFragment(R.layout.fragment_feature_detail) {

    @Inject
    lateinit var dataConvert: DataConvert

    private lateinit var binding: FragmentFeatureDetailBinding

    private lateinit var repoData: RepoItemEntity

    private val viewModel: FeatureDetailViewModel by viewModels()

    @Inject
    lateinit var featureFavouriteRouteContractImpl: FeatureScreenFavouriteRouteContract

    override fun initComponent() {
        super.initComponent()
        binding = FragmentFeatureDetailBinding.bind(requireView())

        println("the passed data to fragment b is ${DetailFragmentArgs.fromBundle(requireArguments()).argDetailValue}")

        val data = DetailFragmentArgs.fromBundle(requireArguments()).argDetailValue

        repoData = dataConvert.toData(data)!!
        println("the passed data to fragment b is ${repoData.repoName}")

        binding.name.text = repoData.repoName
        binding.desc.text = repoData.repoDescription
    }

    override fun initEventListener() {
        super.initEventListener()
        binding.addToFavourite.setOnClickListener {
            viewModel.saveToDatabase(repoData)
        }

        binding.goToFavourite.setOnClickListener {
            featureFavouriteRouteContractImpl.show(findNavController())
        }
    }

}