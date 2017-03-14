package com.example.yenhenchia.projectpractice.SQLite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yenhenchia.projectpractice.R;

public class SQLiteActivity extends AppCompatActivity {

    private static final String DB_FILE = "friends.db", DB_TABLE = "friends";

    private SQLiteDatabase friendDb;

    private EditText editName, editSex, editAddress, editShowData;
    private Button btnInsert, btnSearch, btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        setTitle("SQLiteDatabase");

        FriendDbOpenHelper friendDbOpenHelper = new FriendDbOpenHelper(getApplicationContext(), DB_FILE, null, 1);
        friendDb = friendDbOpenHelper.getWritableDatabase();

        Cursor cursor = friendDb.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '" + DB_TABLE + "'", null);

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

        this.editName = (EditText)findViewById(R.id.editName);
        this.editSex = (EditText)findViewById(R.id.editSex);
        this.editAddress = (EditText)findViewById(R.id.editAddress);
        this.editShowData = (EditText)findViewById(R.id.edtShowData);

        this.btnInsert = (Button)findViewById(R.id.btnInsert);
        this.btnInsert.setOnClickListener(onInsertClickListener);

        this.btnSearch = (Button)findViewById(R.id.btnSearch);
        this.btnSearch.setOnClickListener(onSearchClickListener);

        this.btnList = (Button)findViewById(R.id.btnList);
        this.btnList.setOnClickListener(onListClickListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (friendDb != null) {

            friendDb.close();
        }
    }

    private Button.OnClickListener  onInsertClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            ContentValues contentValues = new ContentValues();

            contentValues.put("name", editName.getText().toString());
            contentValues.put("sex", editSex.getText().toString());
            contentValues.put("address", editAddress.getText().toString());

            friendDb.insert(DB_TABLE, null, contentValues);
        }
    };

    private Button.OnClickListener onSearchClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            Cursor c = null;

            if (!editName.getText().toString().equals("")) {

                c = friendDb.query(true, DB_TABLE, new String[]{"name", "sex", "address"}, "name=" + "\"" + editName.getText().toString() + "\"", null, null, null, null, null);
            }
            else if(editSex.getText().toString().equals("")) {

                c = friendDb.query(true, DB_TABLE, new String[]{"name", "sex", "address"}, "sex=" + "\"" + editName.getText().toString() + "\"", null, null, null, null, null);
            }
            else if(!editAddress.getText().toString().equals("")) {

                c = friendDb.query(true, DB_TABLE, new String[]{"name", "sex", "address"}, "address=" + "\"" + editName.getText().toString() + "\"", null, null, null, null, null);
            }

            if (c == null) {

                editShowData.setText("");

                Toast.makeText(SQLiteActivity.this, "沒有這筆資料", Toast.LENGTH_SHORT).show();
            }
            else {

                if (c.getCount() > 0) {

                    c.moveToFirst();

                    editShowData.setText(c.getString(0) + "/" + c.getString(1) + "/" + c.getString(2));

                    while (c.moveToNext()) {

                        editShowData.append(c.getString(0) + "/" + c.getString(1) + "/" + c.getString(2));
                    }
                }
                else {

                    editShowData.setText("");

                    Toast.makeText(SQLiteActivity.this, "沒有這筆資料", Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

    private Button.OnClickListener onListClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            Cursor c = null;

            c = friendDb.query(true, DB_TABLE, new String[]{"name", "sex", "address"}, null, null, null, null, null, null);

            if (c == null) {

                editShowData.setText("");

                Toast.makeText(SQLiteActivity.this, "沒有這筆資料", Toast.LENGTH_SHORT).show();
            }
            else {

                if (c.getCount() > 0) {

                    c.moveToFirst();

                    editShowData.setText(c.getString(0) + "/" + c.getString(1) + "/" + c.getString(2));

                    while (c.moveToNext()) {

                        editShowData.append("\n" + c.getString(0) + "/" + c.getString(1) + "/" + c.getString(2));
                    }
                }
                else {

                    editShowData.setText("");

                    Toast.makeText(SQLiteActivity.this, "沒有這筆資料", Toast.LENGTH_SHORT).show();
                }
            }
        }
    };
}
