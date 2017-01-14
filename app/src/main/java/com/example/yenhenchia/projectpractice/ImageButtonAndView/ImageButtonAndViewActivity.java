package com.example.yenhenchia.projectpractice.ImageButtonAndView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yenhenchia.projectpractice.R;

//public enum ActionType {
//
//    unknow(-1),
//    scissors(1),
//    stone(2),
//    paper(3);
//
//    private final int iCode;
//
//    ActionType(int type) {
//
//        this.iCode = type;
//    }
//    public int getCode() {
//
//        return this.iCode;
//    }
//
//    public static ActionType getEnum(int iType) {
//
//        for (ActionType type : values()) {
//
//            if (type.getCode() == iType) {
//
//                return type;
//            }
//        }
//
//        return unknow;
//    }
//}

public class ImageButtonAndViewActivity extends AppCompatActivity {

    private TextView txtResult;
    private ImageButton btnScissors, btnStone, btnPaper;
    private ImageView imgCmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_button_and_view);

        setTitle("ImageButtonAndView");

        this.imgCmp = (ImageView)findViewById(R.id.imgCmpPlay);

        this.txtResult = (TextView)findViewById(R.id.txtResult);

        this.btnScissors = (ImageButton) findViewById(R.id.btnScissors);
        this.btnScissors.setTag(ActionType.scissors);
        this.btnScissors.setOnClickListener(clickListener);

        this.btnStone = (ImageButton)findViewById(R.id.btnStone);
        this.btnStone.setTag(ActionType.stone);
        this.btnStone.setOnClickListener(clickListener);

        this.btnPaper = (ImageButton)findViewById(R.id.btnPaper);
        this.btnPaper.setTag(ActionType.paper);
        this.btnPaper.setOnClickListener(clickListener);
    }

    private Button.OnClickListener clickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            int cmp = (int)(Math.random() * 3 + 1);

            ActionType cmpAction = ActionType.getEnum(cmp);
            ActionType userAction = (ActionType)v.getTag();

            if (cmpAction != ActionType.unknow) {

                switch (cmpAction) {

                    case scissors: {

                        imgCmp.setImageResource(R.mipmap.icon_scissors);
                    }
                    break;
                    case stone: {

                        imgCmp.setImageResource(R.mipmap.icon_hammer);
                    }
                    break;
                    case paper: {

                        imgCmp.setImageResource(R.mipmap.icon_cloth);
                    }
                    break;
                }

                String result = getString(R.string.relativeResult);

                if (cmp == userAction.getCode()) {

                    result += "平手";
                } else if ((userAction.getCode() - cmp == -2) || (userAction.getCode() - cmp == 1)) {

                    result += "贏";
                } else {

                    result += "輸";
                }

                txtResult.setText(result);
            }
        }
    };
}
