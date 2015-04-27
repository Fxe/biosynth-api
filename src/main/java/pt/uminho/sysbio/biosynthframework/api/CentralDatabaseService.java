package pt.uminho.sysbio.biosynthframework.api;

import java.util.Map;
import java.util.Set;

import retrofit.http.GET;
import retrofit.http.Path;

public interface CentralDatabaseService {
	
	@GET("/central/cpd/get/{label}/{id}")
	public Map<String, Object> getDatabaseMetaboliteEntity(@Path("label") String database, @Path("id") String id);
	
	@GET("/central/cpd/get/{label}/{id}/{property}")
	public Map<String, Object> getDatabaseMetaboliteEntityProperty(@Path("label") String database, @Path("id") String id, @Path("property") String property);
	
	@GET("/central/rxn/get/{label}/{id}")
	public Map<String, Object> getDatabaseReactionEntity(@Path("label") String database, @Path("id") String id);
	
	@GET("/central/cpd/list/{label}")
	public Map<String, Object> listDsaMetabolitesByDatabase(@Path("label") String database);
	
	@GET("/central/rxn/list/{label}")
	public Map<String, Object> listDsaReactionsByDatabase(@Path("label") String database);
	
	@GET("/metabolic/model/mmd/{model}/spi/{id}")
	public Map<String, Object> getModelSpecieEntity(@Path("model") String model, @Path("id") String id);
	
	@GET("/metabolic/model/mmd/{model}/cpd/{id}")
	public Map<String, Object> getModelMetaboliteEntity(@Path("model") String model, @Path("id") String id);
	
	@GET("/metabolic/model/mmd/{model}/rxn/{id}")
	public Map<String, Object> getModelReactionEntity(@Path("model") String model, @Path("id") String id);
	
	@GET("/central/cpd/property/{property}/list")
	public Set<Long> listMetabolitePropertyIdByType(@Path("property") String property);
	
	@GET("/central/cpd/property/{property}/get/{id}")
	public Map<String, Object> getMetabolitePropertyByTypeAndId(@Path("property") String property, @Path("id") long id);
}
