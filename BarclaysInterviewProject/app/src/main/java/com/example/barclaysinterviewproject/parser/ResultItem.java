package com.example.barclaysinterviewproject.parser;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by DrakeBoltz on 11/14/2016.
 */

public class ResultItem implements Serializable {

    private int resultCount;

    public int getResultCount() { return this.resultCount; }

    public void setResultCount(int resultCount) { this.resultCount = resultCount; }

    private ArrayList<Result> results;

    public ArrayList<Result> getResults() { return this.results; }

    public void setResults(ArrayList<Result> results) { this.results = results; }
}
