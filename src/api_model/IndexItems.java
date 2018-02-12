package api_model;

import java.util.ArrayList;

import control.CommonData;

public class IndexItems {
	
	private int count;
	private String previous;
	private ArrayList<Results> results = new ArrayList<>();
	private String next;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getPrevious() {
		return previous;
	}
	public void setPrevious(String previous) {
		this.previous = previous;
	}
	public ArrayList<Results> getResults() {
		return results;
	}
	public void setResults(ArrayList<Results> results) {
		this.results = results;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	
	public void appendOnCatalogue() {
		CommonData.itemCatalogue.addAll(results);
	}

}
