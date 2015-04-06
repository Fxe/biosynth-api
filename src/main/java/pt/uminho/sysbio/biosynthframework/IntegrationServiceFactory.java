package pt.uminho.sysbio.biosynthframework;

import retrofit.RestAdapter;

public class IntegrationServiceFactory {
	private String endPoint = DefaultEndpoint.DEFAULT_ENDPOINT;
	
	public IntegrationServiceFactory withEndpoint(String endPoint) {
		this.endPoint = endPoint;
		return this;
	}
	
	public IntegrationApi build() {
		RestAdapter restAdapter = new RestAdapter.Builder()
			.setEndpoint(endPoint)
			.build();

		IntegrationApi api = restAdapter.create(IntegrationApi.class);
		return api;
	}
}
