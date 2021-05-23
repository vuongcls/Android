package com.example.vuongvl;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ISpam {
    ServiceMail serviceMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serviceMail = new ServiceMail(this);
        ArrayList<Client> mClient = new ArrayList<>();
        Data(mClient);
        serviceMail.registerSpam(mClient);
    }

    private void Data(ArrayList<Client> mClient) {
        mClient.add(new Client("Vo", true));
        mClient.add(new Client("Long", false));
        mClient.add(new Client("Vuong", false));
        mClient.add(new Client("Hung", true));
    }

    @Override
    public void spamMail(String name) {
        Log.d("thongtin", "mail Spam duoc goi toi cho khach hang: " + name);
    }
}