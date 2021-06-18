package com.example.pmiexamen201910110022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class ActivityInsert extends AppCompatActivity {
    EditText name, phone, note;
    Spinner spinnerCountries;
    ArrayList<String> arrayListCountries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        Button btnSave = findViewById(R.id.viewBtnSaveContact);
        spinnerCountries = findViewById(R.id.viewSpinnerCountries);
        name = findViewById(R.id.etName);
        phone = findViewById(R.id.etPhone);
        note = findViewById(R.id.etNote);
    }
}