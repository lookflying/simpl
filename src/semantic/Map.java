package semantic;
import java.util.HashMap;
import type.*;

public class Map<T> {
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
}
