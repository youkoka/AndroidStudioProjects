package com.example.yenhenchia.projectpractice.SimpleFragment;


import android.app.Activity;
import android.content.Context;
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
public class SimpleButtonFragment extends Fragment {

    public enum ShowResultType {

        SHOW_RESULT_TYPE_UNKNOW,
        SHOW_RESULT_TYPE_RESULT1, SHOW_RESULT_TYPE_RESULT2, SHOW_RESULT_TYPE_HIDE

    };

    public interface SimpleButtonIngerface {

        public void resultOfShow(ShowResultType showResultType);
    }

    private Button btnResult1, btnResutl2, btnResultHide;

    public SimpleButtonIngerface mCallback;

    public SimpleButtonFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_simple_button, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.btnResult1 = (Button)getView().findViewById(R.id.btnResult1);
        this.btnResult1.setTag(ShowResultType.SHOW_RESULT_TYPE_RESULT1);
        this.btnResult1.setOnClickListener(onClickListener);

        this.btnResutl2 = (Button)getView().findViewById(R.id.btnResult2);
        this.btnResutl2.setTag(ShowResultType.SHOW_RESULT_TYPE_RESULT2);
        this.btnResutl2.setOnClickListener(onClickListener);

        this.btnResultHide = (Button)getView().findViewById(R.id.btnHide);
        this.btnResultHide.setTag(ShowResultType.SHOW_RESULT_TYPE_HIDE);
        this.btnResultHide.setOnClickListener(onClickListener);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = null;

        if (context instanceof Activity) {

            activity = (Activity)context;
        }

        if (activity != null) {

            try {

                mCallback = (SimpleButtonIngerface) activity;
            }
            catch (ClassCastException e) {

                e.printStackTrace();
            }
        }
    }

    private Button.OnClickListener onClickListener = new Button.OnClickListener() {

        @Override
        public void onClick(View view) {

            ShowResultType showResultType = (ShowResultType)view.getTag();

            if (mCallback != null && showResultType != null) {

                mCallback.resultOfShow(showResultType);
            }
        }
    };
}
