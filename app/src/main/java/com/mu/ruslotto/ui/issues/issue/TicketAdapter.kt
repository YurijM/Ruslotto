package com.mu.ruslotto.ui.issues.issue

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mu.ruslotto.R
import com.mu.ruslotto.database.Keg

class TicketAdapter(private val cells: List<Keg>) : RecyclerView.Adapter<TicketAdapter.TicketHolder>() {
    class TicketHolder(view: View): RecyclerView.ViewHolder(view) {
        val cell: TextView = view.findViewById(R.id.tvCell)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cell, parent, false)
        return TicketHolder(view)
    }

    override fun getItemCount(): Int = cells.size

    override fun onBindViewHolder(holder: TicketHolder, position: Int) {
        val number = cells[position].number
        holder.cell.text = if (number == 0) "" else number.toString()
    }
}