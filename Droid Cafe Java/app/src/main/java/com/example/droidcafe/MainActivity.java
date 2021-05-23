package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private String localString= "";
    private FloatingActionButton transfer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        transfer = findViewById(R.id.cart);

        getTransfer();
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void showDonutOrder(View view) {
        localString = getString(R.string.donut_order_message);
        displayToast(getString(R.string.donut_order_message));
    }

    public void showIceCreamOrder(View view) {
        localString = getString(R.string.ice_cream_order_message);
        displayToast(getString(R.string.ice_cream_order_message));
    }

    public void showFroyoOrder(View view) {
        localString = getString(R.string.froyo_order_message);
        displayToast(getString(R.string.froyo_order_message));
    }

    private void getTransfer() {
        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), OrderActivity.class);
                intent.putExtra("check", localString);
                startActivity(intent);
            }
        });
    }
}