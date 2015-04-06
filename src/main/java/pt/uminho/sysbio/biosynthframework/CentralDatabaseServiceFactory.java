package pt.uminho.sysbio.biosynthframework;

import retrofit.RestAdapter;

public class CentralDatabaseServiceFactory {
	private String endPoint = DefaultEndpoint.DEFAULT_ENDPOINT;
	
	public CentralDatabaseServiceFactory withEndpoint(String endPoint) {
		this.endPoint = endPoint;
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
