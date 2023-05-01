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

class IssueAdapter(private val onCellClick: (Keg) -> Unit) : RecyclerView.Adapter<IssueAdapter.IssueHolder>() {
    private var tickets = emptyList<Ticket>()
    private var kegs = emptyList<Keg>()

    class IssueHolder(view: View,
                      private val onCellClick: (Keg) -> Unit) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val ticket: TextView = view.findViewById(R.id.etItemTicketNumber)
        val card1: RecyclerView = view.findViewById(R.id.rvItemTicketCard1)
        val card2: RecyclerView = view.findViewById(R.id.rvItemTicketCard2)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            if (v.tag is Keg) {
                val keg = v.tag as Keg
                onCellClick(keg)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ticket, parent, false)
        return IssueHolder(view, onCellClick)
    }

    override fun getItemCount(): Int = tickets.size

    override fun onBindViewHolder(holder: IssueHolder, position: Int) {
        holder.ticket.text = tickets[position].ticket

        holder.card1.layoutManager = GridLayoutManager(holder.card1.context, COLS_COUNT)
        holder.card1.adapter = TicketAdapter(
            kegs.filter { keg -> keg.ticket_id == tickets[position].id && keg.card == 1 }
        ) { keg -> onCellClick(keg) }

        holder.card2.layoutManager = GridLayoutManager(holder.card2.context, COLS_COUNT)
        holder.card2.adapter = TicketAdapter(
            kegs.filter { keg -> keg.ticket_id == tickets[position].id && keg.card == 2 }
        ) { keg -> onCellClick(keg) }
    }

    /*private fun onCellClick(keg: Keg) {
        showCell(keg)
    }*/

    @SuppressLint("NotifyDataSetChanged")
    fun setTickets(tickets: List<Ticket>) {
        this.tickets = tickets
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setKegs(kegs: List<Keg>) {
        this.kegs = kegs
        notifyDataSetChanged()
    }
}
