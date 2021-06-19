package com.example.pmiexamen201910110022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityCall extends AppCompatActivity {
//    EditText etPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
//
//        Bundle recoverPhone = this.getIntent().getExtras();
//        String phoneToCall = recoverPhone.getString("phone");
//
//        etPhone = findViewById(R.id.etActCallPhone);
//
//        etPhone.setText(phoneToCall);
//        Button buttonCall = findViewById(R.id.btnActCall);
//        buttonCall.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent callIntent = new Intent(Intent.ACTION_CALL);
//                callIntent.setData(Uri.parse("tel:"+ phoneToCall));
//                startActivity(callIntent);
//            }
//        });
    }
}