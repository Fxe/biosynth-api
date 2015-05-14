package CentralDatabaseService;

import static org.junit.Assert.fail;

import java.io.File;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import pt.uminho.sysbio.biosynthframework.api.CentralDatabaseService;
import pt.uminho.sysbio.biosynthframework.api.CentralDatabaseServiceFactory;
import pt.uminho.sysbio.biosynthframework.api.JsonMapUtils;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedFile;

public class TestCentralDatabaseService {

//	private static String ENDPOINT = "http://darwin.di.uminho.pt:8080/biosynth-web-biobase/";
	private static String ENDPOINT = "http://localhost:8080/biosynth-web-biobase/";
	private static CentralDatabaseService service;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new CentralDatabaseServiceFactory()
			.withEndpoint(ENDPOINT)
			.build();
	}
	
//	@Test
	public void omg() {
	  Map<String, Object> biomass1 = service.getModelReactionEntity("iMM904", "1757270");
	  System.out.println(biomass1.keySet());
	  System.out.println(biomass1.get("leftStoichiometry"));
	  System.out.println(biomass1.get("rightStoichiometry"));
	  
	  Map<String, Object> biomass2 = service.getModelReactionEntity("ymn6_06_cobra", "1765625");
    System.out.println(biomass2.keySet());
    System.out.println(biomass2.get("leftStoichiometry"));
    System.out.println(biomass2.get("rightStoichiometry"));
	}
	
	@Test
	public void gg() {
	  Object o1 = service.deleteAllMetabolicModelSpecieReferences("Ec_core");
	  System.out.println(o1);
	  TypedFile typedFile = new TypedFile("multipart/form-data", new File("D:/var/ec_core_spi_db_map.tsv"));
//	  Callback<Object> cb = new Callback<Object>() {
//      
//      @Override
//      public void success(Object arg0, Response response) {
//        System.out.println(arg0);
//        System.out.println(response);
//      }
//      
//      @Override
//      public void failure(RetrofitError error) {
//        System.out.println(error);
//      }
//    };
//	  service.uploadMetabolicModelSpecieReferences("Ec_core", typedFile, cb);
//	  
//	  cb.
	  
//	  Object o2 = service.uploadMetabolicModelSpecieReferences("Ec_core", typedFile);
//	  System.out.println(o2);
	}
	
//	@Test
//	public void test() {
//
//		
//		long[] equalSig = new long[] {
//				1645083, 1643616, 1637536, 1654664, 1651675, 1643631, 1645210, 1647205, 1647229, 1643634, 1644359, 
//				1638657, 1649387, 1634528, 1643647, 1640585, 1655905, 1634387, 1643992, 1655908, 1665747, 1667688, 
//				1644815, 1668383, 1638058, 1647578, 1656033, 1637518, 1659158, 1634396, 1665380, 1665383, 1651024, 
//				1645221, 1647193, 1665402, 1669860, 1640614, 1646954, 1638180, 1649709, 1645090, 1661772, 1666267, 
//				1655948, 1653637, 1634835, 1659586, 1645271, 1665408, 1651941, 1659735, 1644799, 1644428, 1645250, 
//				1653655, 1649041, 1649870, 1657844, 1653650, 1644771, 1649862, 1635560, 1665574, 1649859, 1645537, 
//				1641175, 1637995, 1653667, 1652059, 1662097, 1657892, 1643672, 1667767, 1649896, 1643541, 1664605, 
//				1647125, 1644749, 1645425, 1635671};
//		for (long rxnId : equalSig) {
//			Map<String, Object> o = service.getDatabaseReactionEntity("LigandReaction", "id:" + rxnId);
//			String entry = JsonMapUtils.getString(o, "entry");
//			String equation = JsonMapUtils.getString(JsonMapUtils.getMap("properties", o), "equation");
//			
//			System.out.println(entry);
//			System.out.println(equation);
//		}
//		
//		
////		fail("Not yet implemented");
//	}

}
