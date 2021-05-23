package com.example.vuongvlkotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    var serviceMail: ServiceMail? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        serviceMail = ServiceMail()
        val mClient = ArrayList<Client>()
        Data(mClient)
        serviceMail!!.registerSpam(mClient)
    }

    private fun Data(mClient: ArrayList<Client>) {
        mClient.add(Client("Vo", true))
        mClient.add(Client("Long", false))
        mClient.add(Client("Vuong", false))
        mClient.add(Client("Hung", true))
    }

    fun spamMail(name: String) {
        Log.d("thongtin", "mail Spam duoc goi toi cho khach hang: $name")
    }
}