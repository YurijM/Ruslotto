package com.mu.ruslotto.ui.issues.issue

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mu.ruslotto.R
import com.mu.ruslotto.database.Keg
import com.mu.ruslotto.database.Ticket
import com.mu.ruslotto.utils.COLS_COUNT
import com.mu.ruslotto.utils.showToast
import com.mu.ruslotto.utils.toLog

class IssueAdapter : RecyclerView.Adapter<IssueAdapter.IssueHolder>() {
    private var tickets = emptyList<Ticket>()
    private var kegs = emptyList<Keg>()

    class IssueHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ticket: TextView = view.findViewById(R.id.etItemTicketNumber)
        val cells: RecyclerView = view.findViewById(R.id.rvItemTicketCardsList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ticket, parent, false)
        return IssueHolder(view)
    }

    override fun getItemCount(): Int = tickets.size

    override fun onBindViewHolder(holder: IssueHolder, position: Int) {
        holder.ticket.text = tickets[position].ticket

        val cellLayoutManager = GridLayoutManager(holder.cells.context, COLS_COUNT)

        holder.cells.layoutManager = cellLayoutManager
        holder.cells.adapter = TicketAdapter(
            kegs.filter { keg -> keg.ticket_id == tickets[position].id }
        ) { keg -> onListIssueClick(keg) }
    }

    private fun onListIssueClick(keg: Keg) {
        //val message = keg.number.toString() ?: "empty"
        showToast("keg: ${keg.row}, ${keg.column}")
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setTickets(tickets: List<Ticket>) {
        this.tickets = tickets
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setKegs(kegs: List<Keg>) {
        this.kegs = kegs
        toLog("'kegs: ${this.kegs}")
        notifyDataSetChanged()
    }
}
