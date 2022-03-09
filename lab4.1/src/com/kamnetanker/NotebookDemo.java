package com.kamnetanker;

import java.util.*;

public class NotebookDemo {
    // ==== data begin ====
    private Notebook[] _nbArray = {
            new Notebook("Acer", 19999.99d, new Processor((short)10)),
            new Notebook("Lenovo", 7554.99d, new Processor((short)5)),
            new Notebook("Asus", 12555.5d, new Processor((short)1234))
    };
    private NotebookRecord[] _nbrArray={
            new NotebookRecord("Acer", 19999.99d, new Processor((short)10)),
            new NotebookRecord("Lenovo", 7554.99d, new Processor((short)5)),
            new NotebookRecord("Asus", 12555.5d, new Processor((short)1234))
    };

    // ==== data end ====
    // ==== get/set begin ====

    public Notebook[] get_nbArray() {
        return _nbArray;
    }

    public void set_nbArray(Notebook[] _nbArray) {
        this._nbArray = _nbArray;
    }

    public NotebookRecord[] get_nbrArray() {
        return _nbrArray;
    }

    public void set_nbrArray(NotebookRecord[] _nbrArray) {
        this._nbrArray = _nbrArray;
    }

    // ==== get/set end ====
    // ==== constructors begin ====

    NotebookDemo(){}

    // ==== constructors end ====
    // ==== POJO begin ====


    // ==== POJO end ====
    // ==== business logic begin ====
    private void PerformClass(){
        List<Notebook> _nbList = new ArrayList<Notebook>(List.of(this._nbArray));
        Collections.sort(_nbList, new ComparablePriceNotebook());
        PrintClass(_nbList);
        Collections.sort(_nbList, new ComparableProcessorNotebook());
        PrintClass(_nbList);
    }
    private void PrintClass( List<Notebook> _nbList ){
        for(Notebook n : _nbList){
            System.out.println(n.toString());
        }
    }
    private void PerformRecord(){
        List<NotebookRecord> _nbrList = new ArrayList<NotebookRecord>(List.of(this._nbrArray));
        Collections.sort(_nbrList, new ComparablePriceNotebookRecord());
        PrintRecord(_nbrList);
        Collections.sort(_nbrList, new ComparableProcessorNotebookRecord());
        PrintRecord(_nbrList);
    }
    private void PrintRecord(List<NotebookRecord> _nbrList){
        for(NotebookRecord n : _nbrList){
            System.out.println(n.toString());
        }
    }
    public void Perform(){
        PerformClass();
        PerformRecord();
    }
    // ==== business logic end ====
}
