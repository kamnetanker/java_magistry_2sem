package com.kamnetanker;

public class JumpDiscipline implements IDiscipline {
    // ==== data part ====
    private static int _thresholdValue = 8;


    // ==== data part end ====

    // ==== getters/setters part ====

    // ==== getters/setters part end ====

    // ==== constructors ====

    // ==== constructors end ====

    // ==== common funcs ====
    @Override
    public int getScore(int result) {
        int score = 1;
        if(result>JumpDiscipline._thresholdValue){
            score = 2;
        }
        return score;
    }
    // ==== common funcs end ====
}
