package pt.uminho.sysbio.biosynthframework.api;

import java.io.IOException;
import java.net.HttpURLConnection;

import retrofit.RestAdapter;
import retrofit.client.Request;
import retrofit.client.UrlConnectionClient;

public class IntegrationServiceFactory {
	private String endPoint = DefaultEndpoint.DEFAULT_ENDPOINT;
	private int connectionTimeout = 15 * 1000;
	private int readTimeout = 30 * 1000;
	
	public final class InternalConnection extends UrlConnectionClient {
		
		@Override
		protected HttpURLConnection openConnection(Request request)
				throws IOException {
		    HttpURLConnection connection = super.openConnection(request);
		    connection.setConnectTimeout(connectionTimeout);
		    connection.setReadTimeout(readTimeout);
		    return connection;
		}
	}
	
	public IntegrationServiceFactory withEndpoint(String endPoint) {
		this.endPoint = endPoint;
		return this;
	}
	
	public IntegrationServiceFactory withConnectionTimeoutt(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
		return this;
	}
	
	public IntegrationServiceFactory withReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
		return this;
	}
	
	public IntegrationService build() {
		RestAdapter restAdapter = new RestAdapter.Builder()
			.setEndpoint(endPoint)
			.setClient(new InternalConnection())
			.build();

		IntegrationService api = restAdapter.create(IntegrationService.class);
		return api;
	}
}

