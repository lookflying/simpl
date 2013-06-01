package semantic;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import syntax.Value;

public class Map implements Cloneable{
	HashMap<String, Value> map;
	public Map(){
		map = new HashMap<String, Value>();
	}
	public void onion(String id, Value v){
		map.put(id, v);
	}
	public Value query(String id){
		return map.get(id);
	}
	public String toString(){
		return map.toString();
	}
	
	public Map clone(){
		Map newMap = new Map();
		newMap.map = cloneMap(map);
		return newMap;		
	}
	
	private HashMap<String, Value> cloneMap(HashMap<String ,Value> m){
		HashMap<String, Value> nm = new HashMap<String, Value>();
		Iterator<Entry<String, Value>> it = m.entrySet().iterator();
		while(it.hasNext()){
			Entry<String, Value> pair = it.next();
			nm.put(pair.getKey(), pair.getValue().clone());
		}
		return nm;
		
	}
}
