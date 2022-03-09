package com.kamnetanker;

import java.util.Objects;

public class Processor {
    // ==== data begin ====
    private short _numCores;
    // ==== data end ====
    // ==== get/set begin ====
    public short get_numCores() {
        return _numCores;
    }

    public void set_numCores(short _numCores) {
        this._numCores = _numCores;
    }
    // ==== get/set end ====
    // ==== constructors begin ====
    Processor(short _numCores){
        this.set_numCores(_numCores);
    }
    // ==== constructors end ====
    // ==== POJO begin ====
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Processor processor = (Processor) o;
        return get_numCores() == processor.get_numCores();
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_numCores());
    }

    @Override
    public String toString() {
        return "Processor{" +
                "_numCores=" + _numCores +
                '}';
    }
    // ==== POJO end ====
}
