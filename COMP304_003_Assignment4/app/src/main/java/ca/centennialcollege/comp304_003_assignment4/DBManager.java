package ca.centennialcollege.comp304_003_assignment4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBManager extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "TicketBooking.db";
    private static final String[] INITIAL_SCRIPTS = {
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
            "insert into Audience values ('jovanemarques@gmail.com', 'jovane', 'jjj', 'Jovane', " +
                    "'Marques', 'Street Av. 999', 'Toronto', 'A1A1A1');",
            "create table Admin (" +
                    "employeeId integer primary key autoincrement, " +
                    "userName   text not null, " +
                    "password   text not null," +
                    "firstName  text not null," +
                    "lastName   text not null" +
                    ");",
            "insert into Admin values (1, 'admin', 'admin', 'Admin', 'Admin');",
            "create table Movies (" +
                    "movieId   integer primary key autoincrement, " +
                    "movieName text not null, " +
                    "director  text not null," +
                    "genre     text not null" +
                    ");",
            "insert into Movies values (1, 'Captain Marvel', 'Director Bla', 'Action');",
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
    private static DBManager db;

    private DBManager(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        deleteDB(context);
    }

    public static DBManager getDb(Context context) {
        if (db == null) {
            db = new DBManager(context);
        }
        return db;
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
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        for (int i = 0; i < record.length; i++) {
            contentValues.put(fields[i], record[i]);
        }
        db.insert(tableName, null, contentValues);
        db.close();
    }

    public int update(String table, String fields[], String records[]) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        for (int i = 0; i < records.length; i++)
            contentValues.put(fields[i], records[i]);
        int result = db.update(table, contentValues, fields[0] + " = ?",
                new String[]{records[0]});
        db.close();
        return result;
    }

    //    public object getOne(String table) {
//        getAll(table);
//    }
    public boolean checkLogin(String table, String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + table +
                "      WHERE userName = ?" +
                "        AND password = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{username, password});
        int c = cursor.getCount();
        db.close();
        return c > 0 ? true : false;
    }

//    public List<String> getMovies() {
//        // get movies
//    }

//    public List<String> getAudience(String email) {
//        //get an user
//        List<String> result = new ArrayList<String>();
//        result.add("adcavav");
//        result.add("vavasvas");
//        return result;
//    }

    public void deleteDB(Context context) {
        context.deleteDatabase(DB_NAME);
    }

    public boolean checkAdminLogin(String[] data) {
        return checkLogin("Admin", data[0], data[1]);
    }

    public boolean checkAudienceLogin(String[] data) {
        return checkLogin("Audience", data[0], data[1]);
    }

    public void signUpSaveOrUpdate(String city, String password, String username, String address,
                                   String email, String firstName, String lastName, String postalCode) {
        //verify, if already exist, update, otherwise, save it
        ContentValues cv = new ContentValues();
        cv.put("emailId", email);
        cv.put("userName", username);
        cv.put("password", password);
        cv.put("firstName", firstName);
        cv.put("lastName", lastName);
        cv.put("address", address);
        cv.put("city", city);
        cv.put("postalCode", postalCode);

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("Audience", null, cv);
        db.close();
    }

    public void bookSave(String emailId, String bookingId, String movieId, String paymentDate, String amountPaid, String showDate, String showTime, String bookingStatus) {
        ContentValues cv = new ContentValues();
        cv.put("emailId", emailId);
        cv.put("bookingId", bookingId);
        cv.put("movieId", movieId);
        cv.put("paymentDate", paymentDate);
        cv.put("amountPaid", amountPaid);
        cv.put("showDate", showDate);
        cv.put("showTime", showTime);
        cv.put("bookingStatus", bookingStatus);

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("Booking", null, cv);
        db.close();
    }

    public List<String> getAudienceInfo(String emailId) {
        //List<List<String>> rows = new ArrayList<>();
        List<String> cols = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM Audience WHERE emailId = ?";
        Cursor cursor = db.rawQuery(selectQuery, new String[]{emailId});
        //return only the first line
        if (cursor.moveToFirst()) {
//                do {
            for (int i = 0; i < cursor.getColumnCount(); i++) {
                cols.add(cursor.getString(i));
            }
//                    rows.add(cols);
//                } while (cursor.moveToNext());
        }
        db.close();
        return cols;
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
