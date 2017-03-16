package com.example.yenhenchia.projectpractice.ScreenSizeFragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.yenhenchia.projectpractice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSizeButtonFragment extends Fragment {


    public enum SwitchType {

        SWITCH_TYPE_SHOWGAME, SWITCH_TYPE_SHOWRESULT
    }

    public interface ScreenSizeButtonInterface {

        void switchFragment(SwitchType switchType);
    }

    public SwitchType switchType;

    public ScreenSizeButtonInterface mCallback;

    private Button btnSwitch;

    public ScreenSizeButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_screen_size_button, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.switchType = SwitchType.SWITCH_TYPE_SHOWRESULT;

        this.btnSwitch = (Button)getView().findViewById(R.id.btnSwitch);
        this.btnSwitch.setOnClickListener(onSwitchClickListener);
    }

    private Button.OnClickListener onSwitchClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            if (mCallback != null) {

                switch (switchType) {

                    case SWITCH_TYPE_SHOWGAME: {

                        btnSwitch.setText("回到遊戲");
                    }
                        break;
                    case SWITCH_TYPE_SHOWRESULT: {

                        btnSwitch.setText("顯示結果");
                    }
                        break;
                }

                mCallback.switchFragment(switchType);

                switchType = (switchType == SwitchType.SWITCH_TYPE_SHOWGAME) ? SwitchType.SWITCH_TYPE_SHOWRESULT : SwitchType.SWITCH_TYPE_SHOWGAME;
            }
        }
    };
}
