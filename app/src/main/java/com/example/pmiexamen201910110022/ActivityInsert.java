package com.example.pmiexamen201910110022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class ActivityInsert extends AppCompatActivity {
    EditText name, phone, note;
    Spinner spinnerCountries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        spinnerCountries = findViewById(R.id.viewSpinnerCountries);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.array_countries, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerCountries.setAdapter(adapter);

        Button btnSave = findViewById(R.id.viewBtnSaveContact);
        spinnerCountries = findViewById(R.id.viewSpinnerCountries);
        name = findViewById(R.id.etName);
        phone = findViewById(R.id.etPhone);
        note = findViewById(R.id.etNote);
    }
}