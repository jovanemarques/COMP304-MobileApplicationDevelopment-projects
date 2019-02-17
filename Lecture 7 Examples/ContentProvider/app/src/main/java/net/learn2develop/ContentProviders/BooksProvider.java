package net.learn2develop.ContentProviders;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

public class BooksProvider extends ContentProvider {
	static final String PROVIDER_NAME =
			"net.learn2develop.provider.Books";
	//protocol
	static final Uri CONTENT_URI =
			Uri.parse("content://" + PROVIDER_NAME + "/books");

	static final String _ID = "_id";
	static final String TITLE = "title";
	static final String ISBN = "isbn";

	static final int BOOKS = 1;
	static final int BOOK_ID = 2;

	private static final UriMatcher uriMatcher;

	//static initializer
	static {
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI(PROVIDER_NAME, "books", BOOKS);
		uriMatcher.addURI(PROVIDER_NAME, "books/#", BOOK_ID);
	}

	//---for database use---
	SQLiteDatabase booksDB;
	static final String DATABASE_NAME = "Books";
	static final String DATABASE_TABLE = "titles";
	static final int DATABASE_VERSION = 1;
	static final String DATABASE_CREATE =
			"create table " + DATABASE_TABLE +
					" (_id integer primary key autoincrement, "
					+ "title text not null, isbn text not null);";

	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) {
		return 0;
	}


	@Override
	public int update(Uri uri, ContentValues values, String selection,
					  String[] selectionArgs) {
		return 0;
	}

	private static class DatabaseHelper extends SQLiteOpenHelper
	{
		//override the class constructor
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db)
		{

			db.execSQL(DATABASE_CREATE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion,
				int newVersion) {
			Log.w("Upgrading database",
					"from version " +
							oldVersion + " to " + newVersion +
					", which will destroy all old data");
			db.execSQL("DROP TABLE IF EXISTS titles");
			onCreate(db);
		}
	}

	@Override
	public String getType(Uri uri) {
		switch (uriMatcher.match(uri)){
		//---get all books---
		case BOOKS:
			return "vnd.android.cursor.dir/vnd.learn2develop.books " +
					"";
			
		//---get a particular book---
		case BOOK_ID:
			return "vnd.android.cursor.item/vnd.learn2develop.books ";
			
		default:
			throw new IllegalArgumentException("Unsupported URI: " + uri);
		}
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		//---add a new book---
		long rowID = booksDB.insert(
				DATABASE_TABLE,
				"",
				values);

		//---if added successfully---
		if (rowID>0)
		{
			Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
			getContext().getContentResolver().notifyChange(_uri, null);
			return _uri;
		}
		throw new SQLException("Failed to insert row into " + uri);
	}

	@Override
	public boolean onCreate() {
		Context context = getContext();
		DatabaseHelper dbHelper = new DatabaseHelper(context);
		booksDB = dbHelper.getWritableDatabase();
		return (booksDB == null)? false:true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteQueryBuilder sqlBuilder = new SQLiteQueryBuilder();
		sqlBuilder.setTables(DATABASE_TABLE);

		if (uriMatcher.match(uri) == BOOK_ID)
			//---if getting a particular book---
			sqlBuilder.appendWhere(
					_ID + " = " + uri.getPathSegments().get(1));

		if (sortOrder==null || sortOrder=="")
			sortOrder = TITLE;

		Cursor c = sqlBuilder.query(
			booksDB,
			projection,
			selection,
			selectionArgs,
			null,
			null,
			sortOrder);

		//---register to watch a content URI for changes---
		c.setNotificationUri(getContext().getContentResolver(), uri);
		return c;
	}
}
