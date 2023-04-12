package com.mu.ruslotto.ui.issues.issue

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mu.ruslotto.R
import com.mu.ruslotto.database.Ticket
import com.mu.ruslotto.utils.toLog

class IssueAdapter : RecyclerView.Adapter<IssueAdapter.IssueHolder>() {
    private var tickets = emptyList<Ticket>()

    class IssueHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ticket: TextView = view.findViewById(R.id.etTicketNumber)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ticket, parent, false)
        return IssueHolder(view)
    }

    override fun getItemCount(): Int = tickets.size

    override fun onBindViewHolder(holder: IssueHolder, position: Int) {
        holder.ticket.text = tickets[position].ticket
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setTickets(tickets: List<Ticket>) {
        this.tickets = tickets
        toLog("tickets: ${this.tickets}")
        notifyDataSetChanged()
    }
}
