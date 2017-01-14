package com.example.yenhenchia.projectpractice.RelativeLayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yenhenchia.projectpractice.R;

public class RelativeLayoutActivity extends AppCompatActivity {

    private TextView txtCmp, txtResult;
    private Button btnScissors, btnStone, btnPaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);

        setTitle("RelativeLayout");

        this.txtCmp = (TextView)findViewById(R.id.txtCmpPlay);
        this.txtResult =(TextView)findViewById(R.id.txtResult);

        this.btnScissors = (Button)findViewById(R.id.btnScissors);
        this.btnScissors.setTag("1");
        this.btnScissors.setOnClickListener(clickListener);

        this.btnStone = (Button)findViewById(R.id.btnStone);
        this.btnStone.setTag("2");
        this.btnStone.setOnClickListener(clickListener);

        this.btnPaper = (Button)findViewById(R.id.btnPaper);
        this.btnPaper.setTag("3");
        this.btnPaper.setOnClickListener(clickListener);
    }

    private Button.OnClickListener clickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            int cmp = (int)(Math.random() * 3 + 1);
            int user = Integer.parseInt(v.getTag().toString());

            String sCmp = "";

            switch (cmp) {

                case 1: {

                    sCmp = getString(R.string.scissors);
                }
                    break;
                case 2: {

                    sCmp = getString(R.string.stone);
                }
                    break;
                case 3: {

                    sCmp = getString(R.string.paper);
                }
                    break;
            }

            txtCmp.setText(sCmp);

            String result = getString(R.string.relativeResult);

            if (cmp == user) {

                result += "平手";
            }
            else if( (user - cmp == -2) || (user - cmp == 1) ) {

                result += "贏";
            }
            else {

                result += "輸";
            }

            txtResult.setText(result);
        }
    };

}
