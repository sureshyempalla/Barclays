package com.example.sureshreddy.barclays.parser;

import java.io.Serializable;
import java.util.ArrayList;



public class ResultItem implements Serializable{

    private int resultCount;

    public int getResultCount() { return this.resultCount; }

    public void setResultCount(int resultCount) { this.resultCount = resultCount; }

    private ArrayList<Result> results;

    public ArrayList<Result> getResults() { return this.results; }

    public void setResults(ArrayList<Result> results) { this.results = results; }
}
