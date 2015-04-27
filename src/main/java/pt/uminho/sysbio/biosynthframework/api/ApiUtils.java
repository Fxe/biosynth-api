package pt.uminho.sysbio.biosynthframework.api;

import java.util.Map;

import pt.uminho.sysbio.biosynthframework.GenericMetabolite;

public class ApiUtils {
	public static GenericMetabolite toMetabolite(Map<String, Object> data) {
		GenericMetabolite cpd = new GenericMetabolite();
		cpd.setId(JsonMapUtils.getLong("id", data));
		cpd.setEntry(JsonMapUtils.getString(data, "entry"));
		cpd.setSource(JsonMapUtils.getString(data, "majorLabel"));
		cpd.setName(JsonMapUtils.getString(data, "name"));
		return cpd;
	}
}
