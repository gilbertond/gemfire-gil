package com.gil.expiry.monitor;

import com.gil.entities.Customer;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.query.*;

import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;

public class ExpiryMonitor {
    public static void main(String[] a) throws NameResolutionException, TypeMismatchException, QueryInvocationTargetException, FunctionDomainException {

        ClientCache clientCache = new ClientCacheFactory().set("cache-xml-file", "xml/clientCache.xml").create();

        Region<Integer, Customer> customerRegion = clientCache.getRegion("Customer");
        SelectResults<Customer> results = customerRegion.query("name.endsWith('e')");         //SELECT * FROM /Customer

        results.forEach(System.out::println);

        QueryService queryService = clientCache.getQueryService("clientPool");
        Query query = queryService.newQuery("SELECT * FROM /Customer");


        new Timer().schedule(new TimerTask() {

            int count = 1;

            @Override
            public void run() {
                System.out.println(count+ ": ***Checking customer expiration***");
                try {
                    Collection<Customer> customerCollection = (Collection<Customer>) query.execute();

                    for (Customer customer : customerCollection) {
                        System.out.println(customer);
                    }
                }catch (Exception ex)    {

                }

                count ++;
                System.out.println("************************************************************************\n");
            }
        }, 10, 3000);
    }
}
