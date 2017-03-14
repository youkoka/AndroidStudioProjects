package com.example.yenhenchia.projectpractice.ContentProvider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.yenhenchia.projectpractice.SQLite.FriendDbOpenHelper;

/**
 * Created by yenhenchia on 2017/3/14.
 */

public class FriendContentProvider extends ContentProvider {

    private static final String AUTHORITY = "com.example.yenhenchia.projectpractice.ContentProvider.FriendContentProvider";
    private static final String DB_FILE = "friends.db", DB_TABLE = "friends";
    private static final int URI_ROOT = 0, URI_TABLE_FRIENDS = 1;
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + DB_TABLE);

    private static final UriMatcher uriMatcher = new UriMatcher(URI_ROOT);
    static {

        uriMatcher.addURI(AUTHORITY, DB_TABLE, URI_TABLE_FRIENDS);
    }

    private SQLiteDatabase friendDb;

    @Override
    public boolean onCreate() {

        FriendDbOpenHelper friendDbOpenHelper = new FriendDbOpenHelper(getContext(), DB_FILE, null, 1);
        friendDb = friendDbOpenHelper.getWritableDatabase();

        Cursor cursor = friendDb.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name= '" + DB_TABLE + "'", null);
        if (cursor != null) {

            if (cursor.getCount() == 0) {

                friendDb.execSQL("CREATE TABLE " + DB_TABLE + " (" +
                        "_id INTEGER PRIMARY_KEY," +
                        "name TEXT NOT NULL," +
                        "sex TEXT," +
                        "address TEXT);");
            }

            cursor.close();
        }

        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {

        if (uriMatcher.match(uri) != URI_TABLE_FRIENDS) {

            throw new IllegalArgumentException("Unknow URI : " + uri);
        }

        Cursor cursor = friendDb.query(true, DB_TABLE, projection, selection, selectionArgs, null, null, sortOrder, null);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {

        if (uriMatcher.match(uri) != URI_TABLE_FRIENDS) {

            throw new IllegalArgumentException("Unknow URI : " + uri);
        }

        long rowId = friendDb.insert(DB_TABLE, null, values);

        Uri insertUri = ContentUris.withAppendedId(CONTENT_URI, rowId);

        getContext().getContentResolver().notifyChange(insertUri, null);

        return insertUri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
