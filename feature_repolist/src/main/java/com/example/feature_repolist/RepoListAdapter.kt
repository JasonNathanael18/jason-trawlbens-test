package com.example.feature_repolist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.entity.RepoItemEntity
import com.example.repolist.R
import com.example.repolist.databinding.RepolistCompItemBinding
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class RepoListAdapter @Inject constructor(@ActivityContext private val context: Context) :
    RecyclerView.Adapter<RepoListAdapter.RepoListViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(view: View, item: RepoItemEntity)
    }

    inner class RepoListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = RepolistCompItemBinding.bind(view)
    }

    private var onItemClickListener: OnItemClickListener? = null
    var datas = ArrayList<RepoItemEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.repolist_comp_item,
            parent, false
        )
        return RepoListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RepoListViewHolder, position: Int) {
        val data = datas[position]
        holder.binding.name.text = data.repoName + " " + position
        holder.binding.desc.text = data.repoDescription

        holder.binding.vPromos.setOnClickListener {
            onItemClickListener?.onItemClick(it, datas[position])
        }
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

    fun setOnItemClickListener(listener: OnItemClickListener) {
        onItemClickListener = listener
    }
}