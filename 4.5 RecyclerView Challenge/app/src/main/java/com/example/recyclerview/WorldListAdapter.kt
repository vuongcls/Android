package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class WordListAdapter(context: Context?, wordList: LinkedList<String>) :
    RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {
    private val mWordList: LinkedList<String>
    private val mInflater: LayoutInflater

    inner class WordViewHolder(itemView: View, adapter: WordListAdapter) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val wordItemView: TextView
        val mAdapter: WordListAdapter

        override fun onClick(view: View) {
            val mPosition = layoutPosition

            val element = mWordList[mPosition]
            mWordList[mPosition] = "Clicked! $element"

            mAdapter.notifyDataSetChanged()
        }

        init {
            wordItemView = itemView.findViewById(R.id.word)
            mAdapter = adapter
            itemView.setOnClickListener(this)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WordViewHolder {
        val mItemView: View = mInflater.inflate(
            R.layout.worldlist_item, parent, false
        )
        return WordViewHolder(mItemView, this)
    }

    override fun onBindViewHolder(
        holder: WordViewHolder,
        position: Int
    ) {

        val mCurrent = mWordList[position]

        holder.wordItemView.text = mCurrent
    }

    override fun getItemCount(): Int {
        return mWordList.size
    }

    init {
        mInflater = LayoutInflater.from(context)
        mWordList = wordList
    }
}