package br.com.simulatedatas.model;

import java.util.HashMap;

public class Result {

	private HashMap <Object,Object> hash_map = null;
	
	public Result() {
		this.hash_map = new HashMap <Object,Object> ();
	}
	
	public HashMap<Object,Object> get_hash_map(){
		return this.hash_map;
	}
	
	public void set_hash_map(Object key, Object value) {
		this.hash_map.put(key, value);
	}
	
	public String return_value_key(Object key) {
		return this.hash_map.get(key).toString();
	}
	
	public void print() {
		this.hash_map.forEach((key,value) -> System.out.println("Key: " + key + " Value: " + value));
	}
	
	public boolean contain_value(Object value) { 
		return this.hash_map.containsValue(value);
	}

	@Override
	public String toString() {
		return "Result [hash_map=" + hash_map + "]";
	}
	
	
}
