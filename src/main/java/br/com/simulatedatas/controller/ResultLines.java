package br.com.simulatedatas.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.com.simulatedatas.model.Result;

public class ResultLines {

	private ArrayList <Result> lines = null;
	private Object columns [] = null;
	
	public ResultLines() { //ok
		this.lines = new ArrayList<Result>();
	}
	
	public ArrayList<Result> getResultLines(){ //ok
		return this.lines;
	}
	
	public void set_result_lines(Result result) { //ok
		this.lines.add(result);
	}
	
	public void set_result_columns(Object [] columns) {//ok
		this.columns = columns;
	}
	
	public void print() { //ok
		for(Result line: lines) {
			for (Object column : columns) {
				System.out.print(line.return_value_key(column) + " | ");
			}
			System.out.println();
		}
	}
	
	public void sort(Object key) { //ok
		this.lines.sort((valueA,valueB) -> valueA.return_value_key(key).compareTo(valueB.return_value_key(key)));
	}
	
	public boolean contain_value(Object value) {
		Iterator <Result> iterator = this.lines.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().contain_value(value) == true) return true;}
		return false;
	}
	
	public <T> List<Result> filter_datas_for_value(String value) {
		List<Result> list = this.lines.stream().filter(lista -> ((Result) lista).contain_value(value)).collect(Collectors.toList());
		return list;
	}
	
	public ArrayList<Result> contain_value_list(ArrayList<Result> list, String key) {
		ArrayList<Result> listFilter = new ArrayList<Result>();
		Iterator<Result> iterator = list.iterator();
		
		while(iterator.hasNext()) {
				String name = iterator.next().return_value_key(key);
				
				listFilter.add(this.lines.stream()
				.filter(data -> data.contain_value(name))
				.findAny()
				.orElse(null));
		}
		
		return listFilter;
	}
}
