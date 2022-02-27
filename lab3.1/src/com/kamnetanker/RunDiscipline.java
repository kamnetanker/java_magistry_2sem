package com.kamnetanker;

public class RunDiscipline implements IDiscipline {
    // ==== data part ====
    private static int _thresholdValue = 10;


    // ==== data part end ====

    // ==== getters/setters part ====

    // ==== getters/setters part end ====

    // ==== constructors ====

    // ==== constructors end ====

    // ==== common funcs ====
    @Override
    public int getScore(int result) {
        int score = 1;
        if(result<RunDiscipline._thresholdValue){
            score = 2;
        }
        return score;
    }
    // ==== common funcs end ====
}
