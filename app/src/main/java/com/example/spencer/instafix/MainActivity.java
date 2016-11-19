package com.example.spencer.instafix;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.spencer.instafix.customer.Customer;
import com.example.spencer.instafix.customer.Waiting;
import com.example.spencer.instafix.fragments.FaultFragment;
import com.example.spencer.instafix.maintenance.Maintenance;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // switched R.id.container to R.id....
        if (savedInstanceState == null) {

//            getFragmentManager().beginTransaction()
  //                  .add(R.id.container, new FaultFragment()).commit();
 //                   .add(R.id., new FaultFragment())

        }
    }

    public void buttonClickFunction(View view) {//buttonClickFunction in XML
        //if user is customer then next activity customer, otherwise maintenance
        //if credentials=customer
        EditText userNameEditText = (EditText) findViewById(R.id.editText);
        EditText passwordEditText = (EditText) findViewById(R.id.editText2);
        String username =userNameEditText.getText().toString();
        String password =passwordEditText.getText().toString();
       // Toast.makeText(this, username+""+password, Toast.LENGTH_SHORT).show();
        Intent intent = null;
        if("admin".equals(username)){
            intent = new Intent(this, Maintenance.class);
        }else if("customer".equals(username)){
            intent = new Intent(this, Waiting.class);
        }else{
            Toast.makeText(this, "User or password wrong!", Toast.LENGTH_SHORT).show();
        }


        if(intent != null){
            startActivity(intent);
        }

    }


}
