package com.kamnetanker;
import java.util.*;

public class Athlet {
    // ==== data part ====
    private int _result;
    private int _id;
    // ==== data part end ====

    // ==== getters/setters part ====
    public int getResult() {
        return _result;
    }

    public void setResult(int _result) {
        this._result = _result;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }
    // ==== getters/setters part end ====

    // ==== constructors ====
    public Athlet(int _id){
        this.setId(_id);
    }
    // ==== constructors end ====

    // ==== common funcs ====
    public int PerformDiscipline(int from, int to){
        return (new Random(this.hashCode()+this._id)).nextInt(from, to);
    }


    // ==== common funcs end ====
}
