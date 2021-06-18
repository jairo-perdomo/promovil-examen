package com.example.pmiexamen201910110022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAddContact = findViewById(R.id.btnAddContact);
        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAddContact = new Intent(getApplicationContext(), ActivityInsert.class);
                startActivity(intentAddContact);
            }
        });

        Button btnListContacts = findViewById(R.id.btnListContacts);
        btnListContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentListContacts = new Intent(getApplicationContext(), ActivityListView.class);
                startActivity(intentListContacts);
            }
        });
    }
}