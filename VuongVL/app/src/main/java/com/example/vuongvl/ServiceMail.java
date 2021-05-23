package com.example.vuongvl;

import android.os.CountDownTimer;
import java.util.ArrayList;

public class ServiceMail {
    CountDownTimer timer;
    ArrayList<Client> word;
    ISpam iSpam;

    public ServiceMail(ISpam iSpam) {
        this.iSpam = iSpam;
    }

    public void registerSpam(final ArrayList<Client> mClient) {
        timer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                for (Client client : mClient) {
                    if (client.typeService) {
                        iSpam.spamMail(client.getName());
                    }
                }
                timer.start();
            }
        };
        timer.start();
    }
}
