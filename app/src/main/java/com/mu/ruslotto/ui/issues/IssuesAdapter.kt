package com.mu.ruslotto.ui.issues

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mu.ruslotto.R
import com.mu.ruslotto.database.Issue

class IssuesAdapter(private val onItemClicked: (Issue) -> Unit) : RecyclerView.Adapter<IssuesAdapter.IssuesHolder>() {
    private var issues = emptyList<Issue>()

    class IssuesHolder(view: View) : RecyclerView.ViewHolder(view) {
        val issue: TextView = view.findViewById(R.id.tvItemIssue)
    }

    /*class IssuesHolder(private var binding: ItemIssueBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(issue: Issue) {
            binding.tvItemIssue.text = issue.issue.toString()
        }
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssuesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_issue, parent, false)
        return IssuesHolder(view)

        /*val viewHolder = IssuesHolder(
            ItemIssueBinding.inflate(
                LayoutInflater.from( parent.context),
                parent,
                false
            )
        )

        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            onItemClicked(issues[position])
        }

        return viewHolder*/
    }

    override fun getItemCount(): Int = issues.size

    override fun onBindViewHolder(holder: IssuesHolder, position: Int) {
        val issue = issues[position]
        holder.issue.text = issue.issue.toString()

        //holder.bind(issues[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setIssues(issues: List<Issue>) {
        this.issues = issues
        notifyDataSetChanged()
    }

}