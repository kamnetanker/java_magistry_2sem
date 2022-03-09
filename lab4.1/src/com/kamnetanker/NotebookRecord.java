package com.kamnetanker;

public record NotebookRecord(String _brend,double _price,Processor _processor) implements Comparable<NotebookRecord> {
    @Override
    public int compareTo(NotebookRecord o) {
        return this._brend.compareTo((o._brend));
    }
}
