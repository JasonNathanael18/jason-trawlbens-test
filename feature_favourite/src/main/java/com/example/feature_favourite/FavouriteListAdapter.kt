package com.example.feature_favourite

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.entity.RepoItemEntity
import com.example.favourite.R
import com.example.favourite.databinding.FavouritelistCompItemBinding
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class FavouriteListAdapter @Inject constructor(@ActivityContext private val context: Context) :
    RecyclerView.Adapter<FavouriteListAdapter.FavouriteListViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(view: View, item: RepoItemEntity)
    }

    inner class FavouriteListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = FavouritelistCompItemBinding.bind(view)
    }

    var datas = ArrayList<RepoItemEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.favouritelist_comp_item,
            parent, false
        )
        return FavouriteListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FavouriteListViewHolder, position: Int) {
        val data = datas[position]
        holder.binding.name.text = data.repoName + " " + position
        holder.binding.desc.text = data.repoDescription
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    fun addData(newData: List<RepoItemEntity>) {
        val previousCount = datas.size
        datas.addAll(newData)
        notifyItemRangeInserted(previousCount, datas.size)
    }

    fun clearData() {
        datas.clear()
        notifyDataSetChanged()
    }
}