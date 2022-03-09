package com.kamnetanker;

import java.util.Comparator;

public class ComparablePriceNotebook implements Comparator<Notebook> {
    @Override
    public int compare(Notebook o1, Notebook o2) {
        return (int)(o1.get_price()-o2.get_price());
    }
}
