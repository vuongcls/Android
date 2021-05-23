package com.example.vuongvlkotlin

import android.os.CountDownTimer
import java.util.*

class ServiceMail{
    var timer: CountDownTimer? = null
    var word: ArrayList<Client>? = null
    var iSpam: ISpam? = null

    fun ServiceMail(iSpam: ISpam?) {
        this.iSpam = iSpam
    }

    fun registerSpam(mClient: ArrayList<Client>) {
        timer = object: CountDownTimer(30000, 1000) {
             override fun onTick(millisUntilFinished: Long) {}

             override fun onFinish() {
                 for (a in mClient) {
                     if (a.typeSerive) {
                         iSpam!!.spamMail(a.name)
                     }
                 }
                timer!!.start()
            }
        }
        timer!!.start()
    }
}