package com.example.yenhenchia.projectpractice.ImageButtonAndView;

/**
 * Created by HenChia on 2017/1/12.
 */

public enum ActionType {

    unknow(-1),
    scissors(1),
    stone(2),
    paper(3);

    private final int iCode;

    ActionType(int type) {

        this.iCode = type;
    }
    public int getCode() {

        return this.iCode;
    }

    public static ActionType getEnum(int iType) {

        for (ActionType type : values()) {

            if (type.getCode() == iType) {

                return type;
            }
        }

        return unknow;
    }
}
