package com.kamnetanker;

import java.util.Objects;

public class Notebook implements Comparable<Notebook> {
    // ==== data begin ====
    private String _brend;
    private double _price;
    private Processor _processor;
    // ==== data end ====
    // ==== get/set begin ====
    public String get_brend() {
        return _brend;
    }

    public void set_brend(String _brend) {
        this._brend = _brend;
    }

    public double get_price() {
        return _price;
    }

    public void set_price(double _price) {
        this._price = _price;
    }

    public Processor get_processor() {
        return _processor;
    }

    public void set_processor(Processor _processor) {
        this._processor = _processor;
    }


    // ==== get/set end ====
    // ==== constructors begin ====
    Notebook(String _brend, double _price, Processor _processor){
        this.set_brend(_brend);
        this.set_price(_price);
        this.set_processor(_processor);

    }
    // ==== constructors end ====
    // ==== POJO begin ====
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return Double.compare(notebook.get_price(), get_price()) == 0 && get_brend().equals(notebook.get_brend()) && Objects.equals(get_processor(), notebook.get_processor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_brend(), get_price(), get_processor());
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "_brend='" + _brend + '\'' +
                ", _price=" + _price +
                ", _processor=" + _processor +
                '}';
    }
    // ==== POJO end ====

    @Override
    public int compareTo(Notebook o) {
        return this._brend.compareTo(o._brend);
    }

}
