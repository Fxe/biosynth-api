package pt.uminho.sysbio.biosynthframework.api;

import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestIntegrationService {

  private static String ENDPOINT = "http://localhost:8080/biosynth-web-biobase/";
  private static IntegrationService service;
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    service = new IntegrationServiceFactory()
      .withEndpoint(ENDPOINT)
      .build();
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void test() {
    Object o1 = service.findByReferenceId(1023395L);
    System.out.println(o1);
    boolean filter = false;
    Map<String, Object> o2 = service.integrateSingleInstance("a", "xref", 1023395L, "test", filter, true, true);
    System.out.println(o2.keySet());
    List<Object> list = JsonMapUtils.getList("members", o2);
    System.out.println(list.size());
  }

}
