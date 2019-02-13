//import com.gemstone.gemfire.cache.Region;
//import com.gemstone.gemfire.cache.client.ClientCache;
//import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gil.entities.Customer;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.query.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Ignore
public class ClientCacheTest implements Serializable {
    private ClientCache cache;

    private Region<Integer, Customer> customers;

    @Before
    public void setTup() throws InterruptedException{
           this.cache = new ClientCacheFactory()
                                .set("name", "customCacheName")
                                .set("cache-xml-file", "xml/clientCache.xml")
                                .create();

        Customer customer1 = new Customer(12, "gilberto", "gil@gmail.com", "123456") ;
        Customer customer2 = new Customer(13, "gilberto1", "gil1@gmail.com", "1234567") ;
        Customer customer3 = new Customer(14, "gilberto2", "gil2@gmail.com", "12345678") ;

           Customer customer4 = new Customer(15, "gilberto", "gil@gmail.com", "123456") ;
           Customer customer5 = new Customer(16, "gilberto1", "gil1@gmail.com", "1234567") ;
           Customer customer6 = new Customer(17, "gilberto2", "gil2@gmail.com", "12345678") ;

           List<Customer> toSave = Arrays.asList(customer1, customer2, customer3, customer4, customer4, customer5, customer6);

           //Save records
           toSave.stream().forEach(customer -> cache.getRegion("Customer").put(customer.getId(), customer));

           Thread.sleep(2000);

           customers = cache.getRegion("Customer");

           assertNotNull("Failed to fetch customer region!", customers);
    }

    @Test
    public void fetchFromProxyRegions(){

        System.out.print("***"+ customers.get(14) +"**");
        Integer[] keys = {12,13, 15};

        System.out.println();
        System.out.println();

        customers.getAll(Arrays.asList(keys)).values().forEach(System.out::println);

        System.out.println();
        System.out.println();

       Customer customer = customers.get(15);//0 shud be the customerID
        assertNotNull("Customer should not be null", customer);
        assertEquals("Failed to find by name", "gilberto", customer.getName());

    }

    @Test
    public void testQueryService() throws NameResolutionException, TypeMismatchException, QueryInvocationTargetException, FunctionDomainException {
        QueryService queryService = cache.getQueryService("clientPool");

        String param1 = "gil";
        Query query = queryService.newQuery("select * from /Customer where name.contains($1)");
        Query query2 = queryService.newQuery("select id, name from /Customer");


        SelectResults<Customer> results = (SelectResults<Customer>)query.execute(new Object[]{param1});
        SelectResults<Struct> resultProjection = (SelectResults<Struct>)query.execute();

        
        for (Customer customer : results.asList()) {
           System.out.println(customer);
        }

        for (Struct struct : resultProjection.asList()) {
            System.out.println(struct.get("name"));
            System.out.println(struct.get("id"));

        }
    }
}
