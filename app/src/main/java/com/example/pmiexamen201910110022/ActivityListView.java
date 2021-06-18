package com.example.pmiexamen201910110022;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pmiexamen201910110022.tables.Contacts;
import com.example.pmiexamen201910110022.transactions.Transactions;

import java.util.ArrayList;

public class ActivityListView extends AppCompatActivity {

    SQLiteConexion connection;
    ListView viewListContacts;
    ArrayList<Contacts> arrayListContacts;
    ArrayList<String> arrayListStringContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        connection = new SQLiteConexion(this, Transactions.nameDataBase, null, 1);
        viewListContacts = (ListView) findViewById(R.id.listContacts);
        
        getListContacts();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayListStringContacts);
        viewListContacts.setAdapter(arrayAdapter);

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