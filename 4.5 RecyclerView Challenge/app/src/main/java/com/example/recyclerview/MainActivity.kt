package com.example.recyclerview

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.content_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val mWordList: LinkedList<String> = LinkedList()
    private var mAdapter: WordListAdapter? = null
    private var mRecyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val wordListSize: Int = mWordList.size
                mWordList.addLast("+ Word $wordListSize")
                recyclerview!!.adapter!!.notifyItemInserted(wordListSize)
                recyclerview!!.smoothScrollToPosition(wordListSize)
            }
        })

        for (i in 0..19) {
            mWordList.addLast("Word $i")
        }

        mRecyclerView = findViewById(R.id.recyclerview);

        mAdapter = WordListAdapter(this, mWordList)
        recyclerview.adapter = mAdapter
        recyclerview.setLayoutManager(LinearLayoutManager(this))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.getItemId()

        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }
}