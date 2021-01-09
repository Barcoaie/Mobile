package ubb.barcoaie.lab5_ma.model;

import java.util.List;

public class VegetableResponse {
    private int count;
    private String next, previous;
    private List<Vegetable> results;


    public VegetableResponse(int count, String next, String previous, List<Vegetable> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Vegetable> getResults() {
        return results;
    }

    public void setResults(List<Vegetable> results) {
        this.results = results;
    }
}
