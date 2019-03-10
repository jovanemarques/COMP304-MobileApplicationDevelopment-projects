package ca.centennialcollege.comp304_003_assignment4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBManager extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "TicketBooking.db";

    private static final String[] INITIAL_SCRIPTS = {
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
                    ");" +
                    "insert into Admin values (1, 'jovane', 'jjj', 'Jovane', 'Marques');",
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

    DBManager(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDb) {
        // initializing the db
        for (String script : INITIAL_SCRIPTS) {
            sqLiteDb.execSQL(script);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onCreate(sqLiteDatabase);
    }

    public void add(String tableName, String fields[], String record[]) {
        try (SQLiteDatabase db = this.getWritableDatabase()) {
            ContentValues contentValues = new ContentValues();
            for (int i = 0; i < record.length; i++) {
                contentValues.put(fields[i], record[i]);
            }
            db.insert(tableName, null, contentValues);
        }

    }

    public int update(String table, String fields[], String records[]) {
        try (SQLiteDatabase db = this.getWritableDatabase()) {
            ContentValues contentValues = new ContentValues();
            for (int i = 0; i < records.length; i++)
                contentValues.put(fields[i], records[i]);

            return db.update(table, contentValues, fields[0] + " = ?",
                    new String[]{records[0]});
        }
    }

    //    public object getOne(String table) {
//        getAll(table);
//    }
    public boolean checkLogin(String table, String username, String password) {
        return true;
//        try (SQLiteDatabase db = this.getReadableDatabase()) {
//            String sql = "SELECT * FROM " + table +
//                    "      WHERE userName = ?" +
//                    "        AND password = ?";
//            Cursor cursor = db.rawQuery(sql, new String[]{username, password});
//            return cursor.getCount() > 0 ? true : false;
//        }
    }

    public boolean checkAdminLogin(String username, String password) {
        return checkLogin("Admin", username, password);
    }

    public boolean checkAudienceLogin(String username, String password) {
        return checkLogin("AUDIENCE", username, password);
    }
//    public List getAll(String table) {
//        try (SQLiteDatabase db = this.getReadableDatabase()) {
//            List rows = new ArrayList();
//
//            String selectQuery = "SELECT * FROM " + table;
//
//            Cursor cursor = db.rawQuery(selectQuery, null);
//            ArrayList row = new ArrayList();
//            while (cursor.moveToNext()) {
//
//            }
////            if (cursor.moveToFirst()) {
////                do {
////                    for (int i = 0; i < cursor.getColumnCount(); i++) {
////                        row.add(cursor.getString(i));
////                    }
////
////                    rows.add(row);
////
////                } while (cursor.moveToNext());
////            }
//            return rows;
//        }
//    }
}
