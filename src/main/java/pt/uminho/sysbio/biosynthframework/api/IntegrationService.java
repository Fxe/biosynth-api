package pt.uminho.sysbio.biosynthframework.api;

import java.util.List;
import java.util.Map;
import java.util.Set;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface IntegrationService {
  
  @GET("/integration/explore")
  public List<Map<String, Object>> listAllIntegrationSets();
  
  @GET("/integration/explore/{itg}/cpd")
  public Map<String, Object> listAllMetaboliteClustersByIntegrationSetId(@Path("itg") String itg);
  
  @GET("/integration/explore/{itg}/rxn")
  public Map<String, Object> listAllReactionClustersByIntegrationSetId(@Path("itg") String itg);
  
  //http://darwin.di.uminho.pt:8080/biosynth-web-biobase//integration/explore/cpd/findByReferenceId?referenceId=1324007
  @GET("/integration/explore/cpd/findByReferenceId")
  public Map<Long, Set<Long>> findByReferenceId(@Query("referenceId") long referenceId);
  
  //integration/explore/FINAL_CORRECT_F/cpd/id:212855
  @GET("/integration/explore/{itg}/cpd/{ctr}")
  public Map<String, Object> getIntegratedMetaboliteCluster(@Path("itg") String itg, @Path("ctr") String ctr);
  
  @GET("/integration/explore/{itg}/rxn/{ctr}")
  public Map<String, Object> getIntegratedReactionCluster(@Path("itg") String itg, @Path("ctr") String ctr);
  
  @GET("/integration/explore/{itg}/cpd/unimap")
  public Map<Long, Long> getIntegrationSetMetaboliteUnificationMap(@Path("itg") String itg);
  
  @GET("/integration/scaffold/{itg}/integrate/single/{strategy}/{instance}")
  public Map<String, Object> integrateSingleInstance(@Path("itg") String itg, 
                                                     @Path("strategy") String strategy, 
                                                     @Path("instance") Long instanceId,
                                                     @Query("entry") String entry,
                                                     @Query("filter") boolean filter,
                                                     @Query("eval") boolean eval,
                                                     @Query("assemble") boolean assemble);
}
