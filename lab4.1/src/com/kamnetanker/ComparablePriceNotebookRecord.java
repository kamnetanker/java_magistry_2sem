package com.kamnetanker;

import java.util.Comparator;

public class ComparablePriceNotebookRecord implements Comparator<NotebookRecord> {
    @Override
    public int compare(NotebookRecord o1, NotebookRecord o2) {
        return (int)(o1._price()-o2._price());
    }
}
