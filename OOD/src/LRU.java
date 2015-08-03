import java.util.LinkedHashMap;
import java.util.Map;


class Cache<K, V> extends LinkedHashMap<K, V>
{
	int capacity;
	
	public Cache(int capacity)
	{
		super();
		this.capacity = capacity;
	}
	
	@Override
	protected boolean removeEldestEntry(Map.Entry<K,V> eldest)
	{
		return size() > capacity;
	}
}
public class LRU {
	
}
