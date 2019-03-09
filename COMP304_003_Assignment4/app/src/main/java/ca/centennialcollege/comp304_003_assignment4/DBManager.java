package ca.centennialcollege.comp304_003_assignment4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBManager extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "TicketBooking.db";

    private static final String[] TABLES = {
            "drop table if exists Audience; " +
            "create table Audience (" +
                    "emailId    text not null primary key, " +
                    "userName   text not null, " +
                    "password   text not null," +
                    "firstName  text not null," +
                    "lastName   text not null," +
                    "address    text not null," +
                    "city       text not null," +
                    "postalCode text not null" +
                    ");",
            "drop table if exists Admin; " +
            "create table Admin (" +
                    "employeeId integer primary key autoincrement, " +
                    "userName   text not null, " +
                    "password   text not null," +
                    "firstName  text not null," +
                    "lastName   text not null" +
                    ");",
            "drop table if exists Movies; " +
            "create table Movies (" +
                    "movieId   integer primary key autoincrement, " +
                    "movieName text not null, " +
                    "director  text not null," +
                    "genre     text not null" +
                    ");",
            "drop table if exists Booking; " +
            "create table Booking (" +
                    "emailId       text not null, " +
                    "bookingId     integer primary key autoincrement, " +
                    "movieId       int not null, " +
                    "paymentDate   text not null, " +
                    "amountPaid    text not null, " +
                    "showDate      text not null, " +
                    "showTime      text not null, " +
                    "bookingStatus text not null " +
                    ");"
    };

    public DBManager(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDb) {
        // initializing the db
        for (int i = 0; i < TABLES.length; i++) {
            sqLiteDb.execSQL(TABLES[i]);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
