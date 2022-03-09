package com.kamnetanker;

import java.util.Comparator;

public class ComparableProcessorNotebook implements Comparator<Notebook> {

    @Override
    public int compare(Notebook o1, Notebook o2) {
        return (int)(o1.get_processor().get_numCores()-o2.get_processor().get_numCores());
    }
}
