package com.example.pmiexamen201910110022.transactions;

public class Transactions {
    public static final String tableContacts = "contacts";

    public static final String id = "id";
    public static final String country = "country";
    public static final String name = "name";
    public static final String phone = "phone";
    public static final String note = "note";


    /* Tables - Create, Drop */
    public static final String createTableContacts = "CREATE TABLE contacts( id INTEGER PRIMARY KEY AUTOINCREMENT, country TEXT, name TEXT, phone TEXT, note TEXT)";

    public static final String dropTable = "DROP TABLE IF EXISTS" + tableContacts;

    public static final String nameDataBase = "DBSchedule";
}
