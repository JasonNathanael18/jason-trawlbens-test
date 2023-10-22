package com.example.feature_repolist

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.utils.DataConvert
import com.example.entity.RepoItemEntity
import com.example.repolist.R
import com.example.repolist.databinding.FragmentFeatureRepolistBinding
import com.example.router.FeatureScreenDetailRouteContract
import com.example.uicomponent.BaseFragment
import com.example.uicomponent.CompRecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class RepolistFragment : BaseFragment(R.layout.fragment_feature_repolist),
    RepoListAdapter.OnItemClickListener,
    CompRecyclerView.LoadMoreListener {

    private lateinit var binding: FragmentFeatureRepolistBinding

    @Inject
    lateinit var dataConvert: DataConvert

    @Inject
    lateinit var adapter: RepoListAdapter

    @Inject
    lateinit var featureProfileRouteContractImpl: FeatureScreenDetailRouteContract

    private val viewModel: RepoListViewModel by viewModels()

    override fun initComponent() {
        super.initComponent()
        binding = FragmentFeatureRepolistBinding.bind(requireView())

        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        binding.rvRepoList.apply {
            setLayoutManager(layoutManager)
            setAdapter(adapter)
            initialHideList()
            listener = this@RepolistFragment
        }

        println("the passed data to fragment a is ${RepolistFragmentArgs.fromBundle(requireArguments()).argRepoListValue}")
    }

    override fun initEventListener() {
        super.initEventListener()
        adapter.setOnItemClickListener(this)

        binding.compSearchBox.onSearchPerformed { query ->
            hideKeyboard()
            adapter.clearData()
            binding.rvRepoList.showWait()
            viewModel.requestSearch(query)
        }
    }

    override fun initObserver() {
        super.initObserver()
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    when {
                        it.isLoading -> {
                            binding.rvRepoList.showWait()
                        }

                        it is RepoListUiState.HasRepoList -> {
                            adapter.addData(it.repoList)
                            binding.rvRepoList.apply {
                                hideWait()
                                showData()
                            }
                        }

                        it is RepoListUiState.RepoListEmpty -> {
                            if (it.error.isNotEmpty()) {
                                binding.rvRepoList.apply {
                                    hideWait()
                                    showEmpty("No Data Found")
                                }
                                Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                            } else {
                                binding.rvRepoList.apply {
                                    if (!it.isLoading){
                                        hideWait()
                                        if (!it.isPreviousPageLoaded) showEmpty("No Data Found")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onItemClick(view: View, item: RepoItemEntity) {
        val repoItemJsonData = dataConvert.toJson(item) ?: ""
        featureProfileRouteContractImpl.show(repoItemJsonData, findNavController())
    }

    override fun onMoreRequest() {
        viewModel.requestMoreData()
    }

    private fun hideKeyboard() {
        val imm: InputMethodManager =
            activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}