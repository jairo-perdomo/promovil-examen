package com.example.pmiexamen201910110022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pmiexamen201910110022.transactions.Transactions;

import java.util.ArrayList;

public class ActivityInsert extends AppCompatActivity {
    EditText name, phone, note;
    Spinner spinnerCountries;
    String country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        spinnerCountries = findViewById(R.id.viewSpinnerCountries);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.array_countries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountries.setAdapter(adapter);

        Button btnSave = findViewById(R.id.viewBtnSaveContact);
        spinnerCountries = findViewById(R.id.viewSpinnerCountries);
        name = findViewById(R.id.etName);
        phone = findViewById(R.id.etPhone);
        note = findViewById(R.id.etNote);
        country = spinnerCountries.getSelectedItem().toString();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addContact();
            }
        });
    }

    private void addContact() {
        SQLiteConexion connection = new SQLiteConexion(this, Transactions.nameDataBase, null, 1);
        SQLiteDatabase db = connection.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Transactions.country, country = spinnerCountries.getSelectedItem().toString());
        values.put(Transactions.name, name.getText().toString());
        values.put(Transactions.phone, phone.getText().toString());
        values.put(Transactions.note, note.getText().toString());

        Long result = db.insert(Transactions.tableContacts, Transactions.id, values);
        Toast.makeText(getApplicationContext(),"Contacto guardado correctamente"+ result.toString(), Toast.LENGTH_LONG).show();
        db.close();

        ClearFields();
    }

    private void ClearFields() {
        name.setText("");
        phone.setText("");
        note.setText("");
    }
}