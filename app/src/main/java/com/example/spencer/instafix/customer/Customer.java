package com.example.spencer.instafix.customer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.spencer.instafix.customer.Waiting;
import com.example.spencer.instafix.R;

public class Customer extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        final Button button = (Button) findViewById(R.id.button);
        final Intent intent = new Intent(this, Waiting.class);
        final Context thisClass = this;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Toast.makeText(thisClass, "We are working on your solution!", Toast.LENGTH_LONG).show();
                startActivity(intent);


            }
        });
        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                startActivity(intent);

            }

        });
    }
}

