package pt.uminho.sysbio.biosynthframework.api;

import retrofit.RestAdapter;

public class CentralDatabaseServiceFactory {
	private String endPoint = DefaultEndpoint.DEFAULT_ENDPOINT;
	private int connectionTimeout = 15 * 1000;
	private int readTimeout = 30 * 1000;
	
	public CentralDatabaseServiceFactory withEndpoint(String endPoint) {
		this.endPoint = endPoint;
		return this;
	}
	
	public CentralDatabaseServiceFactory withConnectionTimeoutt(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
		return this;
	}
	
	public CentralDatabaseServiceFactory withReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
		return this;
	}
	
	public CentralDatabaseService build() {
		RestAdapter restAdapter = new RestAdapter.Builder()
			.setEndpoint(endPoint)
			.build();

		CentralDatabaseService api = restAdapter.create(CentralDatabaseService.class);
		return api;
	}
}
