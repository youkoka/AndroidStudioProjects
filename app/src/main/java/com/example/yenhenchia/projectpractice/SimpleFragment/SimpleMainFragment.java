package com.example.yenhenchia.projectpractice.SimpleFragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yenhenchia.projectpractice.ImageButtonAndView.ActionType;
import com.example.yenhenchia.projectpractice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleMainFragment extends Fragment {

    public enum GameResultWinType {

        GAME_RESULT_WIN_TYPE_UNKNOW,
        GAME_RESULT_WIN_TYPE_DRAW, GAME_RESULT_WIN_TYPE_PLAYER, GAME_RESULT_WIN_TYPECOMPUTER
    };

    public interface SimpleMainInterface {

        public void resultOfWin(GameResultWinType winType);
    };

    private TextView txtResult;
    private ImageButton btnScissors, btnStone, btnPaper;
    private ImageView imgCmp;
    private GameResultWinType winType;

    public SimpleMainInterface mCallback;

    public SimpleMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_simple_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.imgCmp = (ImageView)getView().findViewById(R.id.imgCmpPlay);

        this.txtResult = (TextView)getView().findViewById(R.id.txtResult);

        this.btnScissors = (ImageButton)getView().findViewById(R.id.btnScissors);
        this.btnScissors.setTag(ActionType.scissors);
        this.btnScissors.setOnClickListener(clickListener);

        this.btnStone = (ImageButton)getView().findViewById(R.id.btnStone);
        this.btnStone.setTag(ActionType.stone);
        this.btnStone.setOnClickListener(clickListener);

        this.btnPaper = (ImageButton)getView().findViewById(R.id.btnPaper);
        this.btnPaper.setTag(ActionType.paper);
        this.btnPaper.setOnClickListener(clickListener);
    }

    private Button.OnClickListener clickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            winType = GameResultWinType.GAME_RESULT_WIN_TYPE_UNKNOW;

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

                    winType = GameResultWinType.GAME_RESULT_WIN_TYPE_DRAW;

                } else if ((userAction.getCode() - cmp == -2) || (userAction.getCode() - cmp == 1)) {

                    result += "贏";

                    winType = GameResultWinType.GAME_RESULT_WIN_TYPE_PLAYER;

                } else {

                    result += "輸";

                    winType = GameResultWinType.GAME_RESULT_WIN_TYPECOMPUTER;
                }

                txtResult.setText(result);

                if (mCallback != null) {

                    mCallback.resultOfWin(winType);
                }
            }
        }
    };

}
