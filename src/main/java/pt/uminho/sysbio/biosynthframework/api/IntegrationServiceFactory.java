package pt.uminho.sysbio.biosynthframework.api;

import retrofit.RestAdapter;

public class IntegrationServiceFactory {
	private String endPoint = DefaultEndpoint.DEFAULT_ENDPOINT;
	
	public IntegrationServiceFactory withEndpoint(String endPoint) {
		this.endPoint = endPoint;
		return this;
	}
	
	public IntegrationService build() {
		RestAdapter restAdapter = new RestAdapter.Builder()
			.setEndpoint(endPoint)
			.build();

		IntegrationService api = restAdapter.create(IntegrationService.class);
		return api;
	}
}
