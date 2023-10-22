package com.example.feature_favourite

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.favourite.R
import com.example.favourite.databinding.FragmentFavouriteListBinding
import com.example.uicomponent.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class FavouriteListFragment : BaseFragment(R.layout.fragment_favourite_list) {

    private lateinit var binding: FragmentFavouriteListBinding

    private val viewModel: FavouriteListViewModel by viewModels()

    @Inject
    lateinit var adapter: FavouriteListAdapter

    override fun initComponent() {
        super.initComponent()
        binding = FragmentFavouriteListBinding.bind(requireView())

        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        binding.rvFavouriteList.apply {
            setLayoutManager(layoutManager)
            setAdapter(adapter)
            initialHideList()
        }

        viewModel.getRepoList()
    }

    override fun initObserver() {
        super.initObserver()
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    when (it) {
                        is FavouriteListUiState.HasRepoList -> {
                            adapter.addData(it.repoList)
                            binding.rvFavouriteList.apply {
                                hideWait()
                                showData()
                            }
                        }
                        is FavouriteListUiState.RepoListEmpty -> {
                            binding.rvFavouriteList.apply {
                                showEmpty("No Data Found")
                            }
                        }
                    }
                }
            }
        }
    }

}