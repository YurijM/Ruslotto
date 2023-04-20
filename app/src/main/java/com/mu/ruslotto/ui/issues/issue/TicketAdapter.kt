package com.mu.ruslotto.ui.issues.issue

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mu.ruslotto.R
import com.mu.ruslotto.database.Keg

class TicketAdapter(
    private val cells: List<Keg>,
    private val onItemClicked: (Keg) -> Unit
) : RecyclerView.Adapter<TicketAdapter.TicketHolder>() {
    class TicketHolder(
        view: View,
        private val onItemClicked: (Keg) -> Unit
    ) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val cell: TextView = view.findViewById(R.id.tvCell)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            val keg = v.tag as Keg
            onItemClicked(keg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cell, parent, false)
        return TicketHolder(view, onItemClicked)
    }

    override fun getItemCount(): Int = cells.size

    override fun onBindViewHolder(holder: TicketHolder, position: Int) {
        val number = cells[position].number

        holder.itemView.tag = cells[position]
        holder.cell.text = if (number == 0) "" else number.toString()
    }
}