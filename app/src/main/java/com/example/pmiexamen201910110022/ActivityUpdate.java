package com.example.pmiexamen201910110022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pmiexamen201910110022.transactions.Transactions;

public class ActivityUpdate extends AppCompatActivity {
    SQLiteConexion connection;
    Spinner spCountry;
    String country;
    String idReceived;
    EditText updateName, updatePhone, updateNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        spCountry = findViewById(R.id.spCountry);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.array_countries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCountry.setAdapter(adapter);

        updateName = findViewById(R.id.etUpdateName);
        updatePhone = findViewById(R.id.etUpdatePhone);
        updateNote = findViewById(R.id.etUpdateNote);

        Bundle recoverValuesBundle = this.getIntent().getExtras();

        idReceived = String.valueOf(recoverValuesBundle.getString("id"));
        updateName.setText(recoverValuesBundle.getString("name"));
        updatePhone.setText(recoverValuesBundle.getString("phone"));
        updateNote.setText(recoverValuesBundle.getString("note"));

    }

    private void updateContact() {
        SQLiteDatabase db = connection.getWritableDatabase();
        String[] params = {idReceived};

        ContentValues values = new ContentValues();
        country = spCountry.getSelectedItem().toString();
        values.put(Transactions.name, updateName.getText().toString());
        values.put(Transactions.phone, updatePhone.getText().toString());
        values.put(Transactions.note, updateNote.getText().toString());
        db.update(Transactions.tableContacts, values, Transactions.id + "=?", params);
        Toast.makeText(getApplicationContext(), "Contacto actualizado", Toast.LENGTH_LONG).show();

    }
}