package com.mu.ruslotto.ui.issues

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.mu.ruslotto.R
import com.mu.ruslotto.database.Issue
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class IssuesAdapter(private val onItemClicked: (Issue) -> Unit) : RecyclerView.Adapter<IssuesAdapter.IssuesHolder>() {
    private var issues = emptyList<Issue>()

    class IssuesHolder(
        view: View,
        private val onItemClicked: (Issue) -> Unit
    ) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val date: TextView = view.findViewById(R.id.tvItemIssueDate)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            val issue = v.tag as Issue
            onItemClicked(issue)
        }
    }

    /*class IssuesHolder(private var binding: ItemIssueBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(issue: Issue) {
            binding.tvItemIssue.text = issue.issue.toString()
        }
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssuesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_issue, parent, false)
        return IssuesHolder(view, onItemClicked)

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

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: IssuesHolder, position: Int) {
        val issue = issues[position]

        holder.itemView.tag = issue
        holder.date.text = LocalDate.parse(issue.date).format(DateTimeFormatter.ofPattern("dd.MM.y"))

        //holder.bind(issues[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setIssues(issues: List<Issue>) {
        this.issues = issues
        notifyDataSetChanged()
    }
}