package com.example.spencer.instafix.customer;

import android.app.Activity;
import android.app.PendingIntent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import android.content.IntentFilter;


import com.example.spencer.instafix.R;
import com.example.spencer.instafix.maintenance.Maintenance;

/**
 * Created by spencer on 12.11.2016.
 */

public class Waiting extends Activity {

    NfcAdapter nfcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);


        // add nfc
        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if(nfcAdapter != null && nfcAdapter.isEnabled()){
        }else{
            Toast.makeText(this, "NFC is not available", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    //Added
    @Override
    protected void onNewIntent(Intent intent) {
        Toast.makeText(this, "Nfc intent received!", Toast.LENGTH_SHORT).show();
        super.onNewIntent(intent);
        Intent customerIntent = new Intent(this, Customer.class);

        if(customerIntent != null){
            startActivity(customerIntent);
        }
    }

    //Added
    @Override
    protected void onResume() {

        Intent intent = new Intent(this, Waiting.class);
        intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,0);
        IntentFilter[] intentFilter = new IntentFilter[]{};

        nfcAdapter.enableForegroundDispatch(this, pendingIntent, intentFilter, null);

        super.onResume();
    }

    //Added
    @Override
    protected void onPause() {
        nfcAdapter.disableForegroundDispatch(this);
        super.onPause();
    }



    }