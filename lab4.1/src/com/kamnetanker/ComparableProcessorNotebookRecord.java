package com.kamnetanker;

import java.util.Comparator;

public class ComparableProcessorNotebookRecord implements Comparator<NotebookRecord> {
    @Override
    public int compare(NotebookRecord o1, NotebookRecord o2) {
        return (int)(o1._processor().get_numCores()-o2._processor().get_numCores());
    }
}