package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "AppDatabase.db";
    private static final int DATABASE_VERSION = 1;

    // Table Name
    public static final String TABLE_USERS = "users";

    // Column Names
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_ROLE = "role";

    // Create Table Query
    private static final String CREATE_TABLE_USERS = "CREATE TABLE " + TABLE_USERS + " ("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_USERNAME + " TEXT UNIQUE NOT NULL, "
            + COLUMN_PASSWORD + " TEXT NOT NULL, "
            + COLUMN_ROLE + " TEXT NOT NULL"
            + ");";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    /**
     * Add a new user to the database.
     *
     * @param user User object containing username, password, and role.
     * @return Row ID of newly inserted record, or -1 if an error occurred.
     */
    public long addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, user.getUsername());
        values.put(COLUMN_PASSWORD, user.getPassword());
        values.put(COLUMN_ROLE, user.getRole());

        long result = db.insert(TABLE_USERS, null, values);
        db.close();
        return result;
    }

    /**
     * Check if username and password combination is valid.
     *
     * @param username Username to check.
     * @param password Password to check.
     * @return User object if valid, null otherwise.
     */
    public User checkUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {COLUMN_ID, COLUMN_USERNAME, COLUMN_PASSWORD, COLUMN_ROLE};
        String selection = COLUMN_USERNAME + " = ?" + " AND " + COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query(TABLE_USERS, columns, selection, selectionArgs, null, null, null);
        User user = null;

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int idIndex = cursor.getColumnIndex(COLUMN_ID);
                int usernameIndex = cursor.getColumnIndex(COLUMN_USERNAME);
                int passwordIndex = cursor.getColumnIndex(COLUMN_PASSWORD);
                int roleIndex = cursor.getColumnIndex(COLUMN_ROLE);

                int id = idIndex != -1 ? cursor.getInt(idIndex) : 0;
                String uname = usernameIndex != -1 ? cursor.getString(usernameIndex) : "";
                String pwd = passwordIndex != -1 ? cursor.getString(passwordIndex) : "";
                String role = roleIndex != -1 ? cursor.getString(roleIndex) : "";

                user = new User(id, uname, pwd, role);
            }
            cursor.close();
        }
        db.close();
        return user;
    }

    /**
     * Check if a username already exists in the database.
     *
     * @param username Username to check.
     * @return true if username exists, false otherwise.
     */
    public boolean checkUsernameExists(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_ID};
        String selection = COLUMN_USERNAME + " = ?";
        String[] selectionArgs = {username};

        Cursor cursor = db.query(TABLE_USERS, columns, selection, selectionArgs, null, null, null);
        boolean exists = false;

        if (cursor != null) {
            exists = cursor.getCount() > 0;
            cursor.close();
        }
        db.close();
        return exists;
    }

    /**
     * Retrieve a user by username.
     *
     * @param username Username to query.
     * @return User object if found, null otherwise.
     */
    public User getUserByUsername(String username) {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {COLUMN_ID, COLUMN_USERNAME, COLUMN_PASSWORD, COLUMN_ROLE};
        String selection = COLUMN_USERNAME + " = ?";
        String[] selectionArgs = {username};

        Cursor cursor = db.query(TABLE_USERS, columns, selection, selectionArgs, null, null, null);
        User user = null;

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int idIndex = cursor.getColumnIndex(COLUMN_ID);
                int usernameIndex = cursor.getColumnIndex(COLUMN_USERNAME);
                int passwordIndex = cursor.getColumnIndex(COLUMN_PASSWORD);
                int roleIndex = cursor.getColumnIndex(COLUMN_ROLE);

                int id = idIndex != -1 ? cursor.getInt(idIndex) : 0;
                String uname = usernameIndex != -1 ? cursor.getString(usernameIndex) : "";
                String pwd = passwordIndex != -1 ? cursor.getString(passwordIndex) : "";
                String role = roleIndex != -1 ? cursor.getString(roleIndex) : "";

                user = new User(id, uname, pwd, role);
            }
            cursor.close();
        }
        db.close();
        return user;
    }

    /**
     * Retrieve all users from the database.
     *
     * @return List of all User objects.
     */
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_USERS;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int idIndex = cursor.getColumnIndex(COLUMN_ID);
                int usernameIndex = cursor.getColumnIndex(COLUMN_USERNAME);
                int passwordIndex = cursor.getColumnIndex(COLUMN_PASSWORD);
                int roleIndex = cursor.getColumnIndex(COLUMN_ROLE);

                do {
                    int id = idIndex != -1 ? cursor.getInt(idIndex) : 0;
                    String uname = usernameIndex != -1 ? cursor.getString(usernameIndex) : "";
                    String pwd = passwordIndex != -1 ? cursor.getString(passwordIndex) : "";
                    String role = roleIndex != -1 ? cursor.getString(roleIndex) : "";

                    User user = new User(id, uname, pwd, role);
                    userList.add(user);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        db.close();
        return userList;
    }

    /**
     * Update existing user details.
     *
     * @param user User object containing updated details and valid ID.
     * @return Number of rows affected.
     */
    public int updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, user.getUsername());
        values.put(COLUMN_PASSWORD, user.getPassword());
        values.put(COLUMN_ROLE, user.getRole());

        int rows = db.update(TABLE_USERS, values, COLUMN_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
        return rows;
    }

    /**
     * Delete a user record by ID.
     *
     * @param id ID of the user to delete.
     * @return Number of rows affected.
     */
    public int deleteUser(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int rows = db.delete(TABLE_USERS, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
        return rows;
    }
}
