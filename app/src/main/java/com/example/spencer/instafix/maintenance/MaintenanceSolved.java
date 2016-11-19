package com.example.spencer.instafix.maintenance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.spencer.instafix.R;

public class MaintenanceSolved extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance_solved);
    }

    public void buttonClickFunction1(View view) {//buttonClickFunction in XML
        Intent intent = new Intent(this, Maintenance.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
}
