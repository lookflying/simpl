package semantic;
import java.util.HashMap;

public class Map<T> implements Cloneable{
	HashMap<String, T> map;
	public Map(){
		map = new HashMap<String, T>();
	}
	public void onion(String id, T t){
		map.put(id, t);
	}
	public T query(String id){
		return map.get(id);
	}
	public String toString(){
		return map.toString();
	}
	
	public Map<T> clone(){
		Map<T> newMap = new Map<T>();
		newMap.map = (HashMap<String, T>) this.map.clone();
		return newMap;		
	}
}
