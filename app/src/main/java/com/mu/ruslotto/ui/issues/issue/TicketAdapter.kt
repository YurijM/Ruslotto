package com.mu.ruslotto.ui.issues.issue

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableRow
import androidx.recyclerview.widget.RecyclerView
import com.mu.ruslotto.R
import com.mu.ruslotto.models.TicketModel

class TicketAdapter() : RecyclerView.Adapter<TicketAdapter.TicketHolder>() {
    private var ticket = emptyList<TicketModel>()

    class TicketHolder(view: View) : RecyclerView.ViewHolder(view) {
        val card1Row0: TableRow = view.findViewById(R.id.trTicketCard1Row0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cards, parent, false)
        return TicketHolder(view)
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: TicketHolder, position: Int) {

    }
}
