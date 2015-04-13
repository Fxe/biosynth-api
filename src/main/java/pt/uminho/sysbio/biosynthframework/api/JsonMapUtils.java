package pt.uminho.sysbio.biosynthframework.api;

import java.util.List;
import java.util.Map;

public class JsonMapUtils {
	public static String getString(String key, Map<String, Object> map) {
		return (String) map.get(key);
	}
	
	public static Long getLong(String key, Map<String, Object> map) {
		return Math.round( (Double) map.get(key));
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getMap(String key, Map<String, Object> map) {
		return (Map<String, Object> ) map.get(key);
	}
	
	@SuppressWarnings("unchecked")
	public static List<Object> getList(String key, Map<String, Object> map) {
		return (List<Object>) map.get(key);
	}
}
