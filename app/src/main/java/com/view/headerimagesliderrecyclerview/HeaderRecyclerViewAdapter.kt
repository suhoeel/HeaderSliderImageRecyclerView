package com.view.headerimagesliderrecyclerview

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class HeaderRecyclerViewAdapter(val list: Array<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_ITEM = 1
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_HEADER) {
            return VHHeader(View(parent.context)) // TMP VIEW
        } else if (viewType == TYPE_ITEM) {
            return VHItem(View(parent.context)) // TMP VIEW
        }
        throw RuntimeException("there is no type that matches the type $viewType make sure your using types correctly")
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        super.onBindViewHolder(holder, position, payloads)
    }

    override fun getItemViewType(position: Int): Int {
        if (isPositionHeader(position)) {
            return TYPE_HEADER
        }
        return TYPE_ITEM
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is VHItem) {
            val dataItem = getItem(position)

        } else if (holder is VHHeader) {

        }
    }

    override fun getItemCount(): Int = list.size + 1

    private fun isPositionHeader(position: Int): Boolean = (position == 0)

    private fun getItem(position: Int): String = list[position - 1]

    inner class VHItem(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }

    inner class VHHeader(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}