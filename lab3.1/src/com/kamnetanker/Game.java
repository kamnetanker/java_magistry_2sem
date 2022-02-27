package com.kamnetanker;

public class Game {
    // ==== data part ====
    private IDiscipline[] _disciplines;
    private Athlet[] _athletes;
    // ==== data part end ====

    // ==== getters/setters part ====
    public IDiscipline[] getDisciplines() {
        return _disciplines;
    }

    public void setDisciplines(IDiscipline[] _disciplines) {
        this._disciplines = _disciplines;
    }

    public Athlet[] getAthletes() {
        return _athletes;
    }

    public void setAthletes(Athlet[] _athletes) {
        this._athletes = _athletes;
    }
    // ==== getters/setters part end ====

    // ==== constructors ====
    public Game(IDiscipline[] _disciplines, Athlet[] _athletes){
        this.setDisciplines(_disciplines);
        this.setAthletes(_athletes);
    }
    // ==== constructors end ====

    // ==== common funcs ====
    public void PerformGame(){
        for(IDiscipline id : this._disciplines){
            for(Athlet a : this._athletes){
                a.setResult(a.getResult()+id.getScore(a.PerformDiscipline(0,20)));
            }
        }
    }
    // ==== common funcs end ====
}
