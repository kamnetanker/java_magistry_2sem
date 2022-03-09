package com.kamnetanker;

import java.util.Objects;

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

    }
    private void PrintClass(){

    }
    private void PerformRecord(){

    }
    private void PrintRecord(){

    }
    public void Perform(){

    }
    // ==== business logic end ====
}
