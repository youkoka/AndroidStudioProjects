package com.example.yenhenchia.projectpractice.FileStream;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yenhenchia.projectpractice.R;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileStreamActivity extends AppCompatActivity {

    private EditText editIn;
    private Button btnAdd, btnList, btnClear;
    private TextView txtOut;

    private static final String FILE_NAME = "file.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_stream);

        this.editIn = (EditText)findViewById(R.id.editIn);

        this.btnAdd = (Button)findViewById(R.id.btnAdd);
        this.btnAdd.setOnClickListener(onAddClickListener);

        this.btnList = (Button)findViewById(R.id.btnList);
        this.btnList.setOnClickListener(onListClickListener);

        this.btnClear = (Button)findViewById(R.id.btnClear);
        this.btnClear.setOnClickListener(onClearClickListener);

        this.txtOut = (TextView)findViewById(R.id.txtOut);
    }

    private Button.OnClickListener onAddClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            try {

                FileOutputStream fileOutputStream = openFileOutput(FILE_NAME, MODE_APPEND);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                bufferedOutputStream.write(editIn.getText().toString().getBytes());
                bufferedOutputStream.close();

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    };

    private Button.OnClickListener onListClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            try {

                FileInputStream fileInputStream = openFileInput(FILE_NAME);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

                byte bufBytes[] = new byte[10];

                txtOut.setText("");

                do {

                    int c = bufferedInputStream.read(bufBytes);
                    if (c == -1) {

                        break;
                    }
                    else {

                        txtOut.append(new String(bufBytes, 0, c));
                    }

                }while (true);

                bufferedInputStream.close();
            }
            catch (Exception e) {

                e.printStackTrace();
            }
        }
    };

    private Button.OnClickListener onClearClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            try {

                FileOutputStream fileOutputStream = openFileOutput(FILE_NAME, MODE_PRIVATE);
                fileOutputStream.close();

                editIn.setText("");
                txtOut.setText("");

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    };
}
