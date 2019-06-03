package com.zm.shiyan8;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddDbData extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_db_data);
        dbHelper=new MyDatabaseHelper(this,"Contacts.db",null,1);
        Button crateDb=(Button)findViewById(R.id.add_db);
        Button addData=(Button)findViewById(R.id.add_contacts);
        crateDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();

                values.put("name","AA");
                values.put("phone","111111111");
                values.put("sex","男");
                db.insert("contacts",null,values);
                values.clear();

                values.put("name","BB");
                values.put("phone","222222222");
                values.put("sex","女");
                db.insert("contacts",null,values);
                values.clear();

                values.put("name","CC");
                values.put("phone","333333333");
                values.put("sex","女");
                db.insert("contacts",null,values);
                values.clear();

                values.put("name","DD");
                values.put("phone","444444444");
                values.put("sex","男");
                db.insert("contacts",null,values);
                values.clear();

                values.put("name","EE");
                values.put("phone","555555555");
                values.put("sex","女");
                db.insert("contacts",null,values);
                values.clear();

                values.put("name","FF");
                values.put("phone","666666666");
                values.put("sex","男");
                db.insert("contacts",null,values);
                values.clear();

                values.put("name","GG");
                values.put("phone","777777777");
                values.put("sex","男");
                db.insert("contacts",null,values);
                values.clear();

                values.put("name","HH");
                values.put("phone","888888888");
                values.put("sex","男");
                db.insert("contacts",null,values);
                values.clear();

                values.put("name","II");
                values.put("phone","999999999");
                values.put("sex","女");
                db.insert("contacts",null,values);
                values.clear();

                values.put("name","OO");
                values.put("phone","000000000");
                values.put("sex","女");
                db.insert("contacts",null,values);
            }
        });
    }
}
