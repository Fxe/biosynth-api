package pt.uminho.sysbio.biosynthframework.api;

import java.util.Map;
import java.util.Set;

import retrofit.Callback;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Path;
import retrofit.mime.TypedFile;

public interface CentralDatabaseService {
	
	@GET("/central/cpd/get/{label}/{id}")
	public Map<String, Object> getDatabaseMetaboliteEntity(@Path("label") String database, @Path("id") String id);
	
	@GET("/central/cpd/get/{label}/{id}/{property}")
	public Map<String, Object> getDatabaseMetaboliteEntityProperty(@Path("label") String database, 
	                                                               @Path("id") String id, 
	                                                               @Path("property") String property);
	
	@GET("/central/rxn/get/{label}/{id}")
	public Map<String, Object> getDatabaseReactionEntity(@Path("label") String database, @Path("id") String id);
	
	@GET("/central/cpd/list/{label}")
	public Map<String, Object> listDsaMetabolitesByDatabase(@Path("label") String database);
	
	@GET("/central/rxn/list/{label}")
	public Map<String, Object> listDsaReactionsByDatabase(@Path("label") String database);
	
	@DELETE("/metabolic/model/mmd/{model}/spi/ref/clear")
	public Map<String, Map<String, Integer>> deleteAllMetabolicModelSpecieReferences(@Path("model") String model);
	
	@DELETE("/metabolic/model/mmd/{model}/cpd/ref/clear")
  public Map<String, Object> deleteAllMetabolicModelMetaboliteReferences(@Path("model") String model);
	
	@DELETE("/metabolic/model/mmd/{model}/cpd/clear")
  public Object deleteAllMetabolicModelMetaboliteMap(@Path("model") String model);
	
	@DELETE("/metabolic/model/mmd/{model}/rxn/ref/clear")
  public Map<String, Object> deleteAllMetabolicModelReactionReferences(@Path("model") String model);
	
//	@Multipart
//	@POST("/metabolic/model/mmd/{model}/spi/ref/upload")
//	public void uploadMetabolicModelSpecieReferences(@Path("model") String model, 
//	                                                 @Part("file") TypedFile file,
//	                                                 Callback<Object> cb);
	
	@Multipart
	@POST("/metabolic/model/mmd/{model}/spi/ref/upload")
	public Object uploadMetabolicModelSpecieReferences(@Path("model") String model, @Part("file") TypedFile file);
	
	@Multipart
  @POST("/metabolic/model/mmd/{model}/cpd/upload")
  public Object uploadMetabolicModelMetaboliteMap(@Path("model") String model, @Part("file") TypedFile file);
	
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
