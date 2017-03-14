package com.example.yenhenchia.projectpractice.ContentProvider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yenhenchia.projectpractice.R;
import com.example.yenhenchia.projectpractice.SQLite.SQLiteActivity;

public class ContentProviderActivity extends AppCompatActivity {

    private EditText editName, editSex, editAddress, editShowData;
    private Button btnInsert, btnSearch, btnList;

    private ContentResolver contentResolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);

        contentResolver = getContentResolver();

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

    private Button.OnClickListener  onInsertClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            ContentValues contentValues = new ContentValues();

            contentValues.put("name", editName.getText().toString());
            contentValues.put("sex", editSex.getText().toString());
            contentValues.put("address", editAddress.getText().toString());

            contentResolver.insert(FriendContentProvider.CONTENT_URI, contentValues);
        }
    };

    private Button.OnClickListener onSearchClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            String projection[] = new String[]{"name", "sex", "address"};

            Cursor c = null;

            if (!editName.getText().toString().equals("")) {

                c = contentResolver.query(FriendContentProvider.CONTENT_URI, projection, "name=" + "\"" + editName.getText().toString() + "\"", null, null);
            }
            else if(editSex.getText().toString().equals("")) {

                c = contentResolver.query(FriendContentProvider.CONTENT_URI, projection, "sex=" + "\"" + editSex.getText().toString() + "\"", null, null);
            }
            else if(!editAddress.getText().toString().equals("")) {

                c = contentResolver.query(FriendContentProvider.CONTENT_URI, projection, "address=" + "\"" + editAddress.getText().toString() + "\"", null, null);
            }

            if (c == null) {

                editShowData.setText("");

                Toast.makeText(ContentProviderActivity.this, "沒有這筆資料", Toast.LENGTH_SHORT).show();
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

                    Toast.makeText(ContentProviderActivity.this, "沒有這筆資料", Toast.LENGTH_SHORT).show();
                }
            }

        }
    };

    private Button.OnClickListener onListClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            String project[] = new String[]{"name", "sex", "address"};

            Cursor c = null;

            c = contentResolver.query(FriendContentProvider.CONTENT_URI, project, null, null, null);

            if (c == null) {

                editShowData.setText("");

                Toast.makeText(ContentProviderActivity.this, "沒有這筆資料", Toast.LENGTH_SHORT).show();
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

                    Toast.makeText(ContentProviderActivity.this, "沒有這筆資料", Toast.LENGTH_SHORT).show();
                }
            }

        }
    };
}
