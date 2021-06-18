package com.example.pmiexamen201910110022;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pmiexamen201910110022.tables.Contacts;
import com.example.pmiexamen201910110022.transactions.Transactions;

import java.util.ArrayList;

public class ActivityListView extends AppCompatActivity {

    SQLiteConexion connection;
    ListView viewListContacts;
    ArrayList<Contacts> arrayListContacts;
    ArrayList<String> arrayListStringContacts;
    int listrowposition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        connection = new SQLiteConexion(this, Transactions.nameDataBase, null, 1);
        viewListContacts = findViewById(R.id.listContacts);
        
        getListContacts();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayListStringContacts);
        viewListContacts.setAdapter(arrayAdapter);

        viewListContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listrowposition = arrayListContacts.get(position).getId();
                String positionString = String.valueOf(listrowposition);
                Toast.makeText(getApplicationContext(), positionString, Toast.LENGTH_SHORT).show();
            }
        });

        Button btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteItem();
                Intent intent = new Intent(getApplicationContext(), ActivityListView.class);
                startActivity(intent);
            }
        });

        Button btnUpdate = findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValuesToSendUpdateScreen();
            }
        });
    }
    private void DeleteItem(){
        SQLiteDatabase db = connection.getWritableDatabase();
        String[] parameterId = {String.valueOf(listrowposition)};

        db.delete(Transactions.tableContacts, Transactions.id + "=?", parameterId);
        Toast.makeText(getApplicationContext(), "Registro Eliminado", Toast.LENGTH_LONG).show();
    }

    private void getValuesToSendUpdateScreen(){
        SQLiteDatabase db = connection.getWritableDatabase();
        String[] parameterId = {String.valueOf(listrowposition)};
        String[] fields = {Transactions.country,
                           Transactions.name,
                           Transactions.phone,
                           Transactions.note};

        String whereCondition = Transactions.id + "=?";

        try {
            Cursor cursorQueryContact = db.query(Transactions.tableContacts, fields, whereCondition, parameterId,
                    null, null, null);

            cursorQueryContact.moveToFirst();

            Intent intentUpdate = new Intent(this, ActivityUpdate.class);
            Bundle sendValuesforUpdate = new Bundle();
            sendValuesforUpdate.putString("country", cursorQueryContact.getString(0));
            sendValuesforUpdate.putString("name", cursorQueryContact.getString(1));
            sendValuesforUpdate.putString("phone", cursorQueryContact.getString(2));
            sendValuesforUpdate.putString("note", cursorQueryContact.getString(3));

            intentUpdate.putExtras(sendValuesforUpdate);
            startActivity(intentUpdate);
        } catch (Exception e){
            Toast.makeText(getApplicationContext(), "Ocurrio un error", Toast.LENGTH_SHORT).show();
        }
    }

    private void getListContacts() {
        SQLiteDatabase db = connection.getReadableDatabase();
        Contacts listContacts;
        arrayListContacts = new ArrayList<>();

        Cursor cursorQueryContacts = db.rawQuery("SELECT * FROM " + Transactions.tableContacts, null);

        while (cursorQueryContacts.moveToNext()) {
            listContacts = new Contacts();
            listContacts.setId(cursorQueryContacts.getInt(0));
            listContacts.setCountry(cursorQueryContacts.getString(1));
            listContacts.setName(cursorQueryContacts.getString(2));
            listContacts.setPhone(cursorQueryContacts.getString(3));
            listContacts.setNote(cursorQueryContacts.getString(4));

            arrayListContacts.add(listContacts);
        }
        
        cursorQueryContacts.close();
        fillList();
    }

    private void fillList() {
        arrayListStringContacts = new ArrayList<>();
        for(int i= 0; i < arrayListContacts.size(); i++){
            arrayListStringContacts.add(arrayListContacts.get(i).getId()+" | "
                +arrayListContacts.get(i).getName() + " | "
                +arrayListContacts.get(i).getPhone());
        }
    }
}