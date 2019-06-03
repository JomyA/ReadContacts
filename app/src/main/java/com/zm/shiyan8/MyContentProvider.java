package com.zm.shiyan8;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {
    public static final int CONTACT_ALL=0;
    public static final int CONTACT_ITEM=1;
    public static final String AUTHORITY="com.zm.shiyan8.provider";
    private MyDatabaseHelper dbHelper;
    private static UriMatcher uriMatcher;
    static {
        uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY,"contacts",CONTACT_ALL);
        uriMatcher.addURI(AUTHORITY,"contacts/#",CONTACT_ITEM);
    }

    @Override
    public boolean onCreate() {
        dbHelper =new MyDatabaseHelper(getContext(),"Contacts.db",null,1);
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        Cursor cursor=null;
        switch (uriMatcher.match(uri)){
            case CONTACT_ALL:
                cursor=db.query("contacts",projection,selection,selectionArgs,null,null,sortOrder);
                break;
            case CONTACT_ITEM:
                String cName=uri.getPathSegments().get(1);
                cursor=db.query("contacts",projection,"name=?",new String[]{cName},null,null,sortOrder);
                break;
            default:
                break;
        }
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
