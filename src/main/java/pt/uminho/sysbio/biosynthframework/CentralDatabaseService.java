package pt.uminho.sysbio.biosynthframework;

import java.util.Map;

import retrofit.http.GET;
import retrofit.http.Path;

public interface CentralDatabaseService {
	
	@GET("/central/cpd/get/{label}/{entry}")
	public Map<String, Object> getDatabaseMetaboliteEntity(@Path("label") String database, @Path("entry") String entry);
	
	@GET("/central/rxn/get/{label}/{entry}")
	public Map<String, Object> getDatabaseReactionEntity(@Path("label") String database, @Path("entry") String entry);
	
	@GET("/central/cpd/list/{label}")
	public Map<String, Object> listDsaMetabolitesByDatabase(@Path("label") String database);
	
	@GET("/central/rxn/list/{label}")
	public Map<String, Object> listDsaReactionsByDatabase(@Path("label") String database);
}
