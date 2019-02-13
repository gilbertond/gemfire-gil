package com.gil.loader;

import com.gil.entities.BookOrder;
import com.gil.entities.Customer;
import com.gil.entities.OrderItem;
import com.gil.entities.OrderKey;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;

import java.util.Arrays;
import java.util.Date;

public class GilDataLoader {

    ClientCache clientCache;

    public static void main(String[] a){
        GilDataLoader gilDataLoader = new GilDataLoader();
        gilDataLoader.setUpCache();

        gilDataLoader.populateCustomers();
//
        gilDataLoader.fetchFromProxyRegions()   ;


//        gilDataLoader.deleteCustomers();

        gilDataLoader.populateOrders();

        gilDataLoader.closeCache();

    }

    private void populateCustomers() {

        Region<Integer, Customer> customers = clientCache.getRegion("Customer");
        System.out.println("Found regions: \n" + customers);

        Customer customer1 = new Customer(21, "Paul Kagame", "pk@gmail.com", "92939393");
        Customer customer2 = new Customer(22, "Mugabe Godwin", "mg@gmail.com", "423656256");
        Customer customer3 = new Customer(23, "Albert Gabiro", "ag@gmail.com", "65432156");
        Customer customer4 = new Customer(24, "Kabera Dunstun", "kd@gmail.com", "543214");
        Customer customer5 = new Customer(25, "Karen Uwera", "ku@gmail.com", "4235224");
        Customer customer6 = new Customer(26, "Bonita Abera", "ba@gmail.com", "5435342");
        Customer customer7 = new Customer(27, "Renita Ingabire", "ri@gmail.com", "423423");
        Customer customer8 = new Customer(28, "Daniel Ndamagye", "dn@gmail.com", "423423");

        customers.put(customer1.getId(), customer1);
        customers.put(customer2.getId(), customer2);
        customers.put(customer3.getId(), customer3);
        customers.put(customer4.getId(), customer4);
        customers.put(customer5.getId(), customer5);
        customers.put(customer6.getId(), customer6);
        customers.put(customer7.getId(), customer7);
        customers.put(customer8.getId(), customer8);
        
    }

    private void deleteCustomers() {

        Region<Integer, Customer> customers = clientCache.getRegion("Customer");

        Customer customer1 = new Customer(21, "Paul Kagame", "pk@gmail.com", "92939393");
        Customer customer2 = new Customer(22, "Mugabe Godwin", "mg@gmail.com", "423656256");
        Customer customer3 = new Customer(23, "Albert Gabiro", "ag@gmail.com", "65432156");
        Customer customer4 = new Customer(24, "Kabera Dunstun", "kd@gmail.com", "543214");
        Customer customer5 = new Customer(25, "Karen Uwera", "ku@gmail.com", "4235224");
        Customer customer6 = new Customer(26, "Bonita Abera", "ba@gmail.com", "5435342");
        Customer customer7 = new Customer(27, "Renita Ingabire", "ri@gmail.com", "423423");
        Customer customer8 = new Customer(28, "Daniel Ndamagye", "dn@gmail.com", "423423");

        customers.destroy(customer1.getId());
        customers.destroy(customer2.getId());
        customers.destroy(customer3.getId());
        customers.destroy(customer4.getId());
        customers.destroy(customer5.getId());
        customers.destroy(customer6.getId());
        customers.destroy(customer7.getId());
        customers.destroy(customer8.getId());

    }

    public void fetchFromProxyRegions(){

        Region<Integer, Customer> customers = clientCache.getRegion("Customer");

        System.out.print("***"+ customers.get(14) +"**");
        Integer[] keys = {28,21, 26};

        System.out.println();
        System.out.println();

        customers.getAll(Arrays.asList(keys)).values().forEach(System.out::println);

        System.out.println();
        System.out.println();

        Customer customer = customers.get(28);//0 shud be the customerID

        clientCache.getCurrentServers().forEach(x -> {
            System.out.println( "Server: " +x.getHostName()+ ":" + x.getPort() + "----" +customer);
        });

    }

    private void populateOrders(){
        try {

            Region<OrderKey, BookOrder> orders = clientCache.getRegion("BookOrder");
            OrderKey orderKey1 = new OrderKey(21, 21);
            OrderKey orderKey2 = new OrderKey(21, 22);
            OrderKey orderKey3 = new OrderKey(21, 23);
            OrderKey orderKey4 = new OrderKey(22, 24);
            OrderKey orderKey5 = new OrderKey(23, 24);

            BookOrder bookOrder1 = new BookOrder(21, Arrays.asList(new OrderItem[]{new OrderItem()}), new Date(), 3000.0);
            BookOrder bookOrder2 = new BookOrder(22, Arrays.asList(new OrderItem[]{new OrderItem()}), new Date(), 3000.0);
            BookOrder bookOrder3 = new BookOrder(23, Arrays.asList(new OrderItem[]{new OrderItem()}), new Date(), 3000.0);
            BookOrder bookOrder4 = new BookOrder(24, Arrays.asList(new OrderItem[]{new OrderItem()}), new Date(), 3000.0);
            BookOrder bookOrder5 = new BookOrder(25, Arrays.asList(new OrderItem[]{new OrderItem()}), new Date(), 3000.0);

            orders.put(orderKey1, bookOrder1);
            orders.put(orderKey1, bookOrder2);
            orders.put(orderKey1, bookOrder3);
            orders.put(orderKey1, bookOrder4);
            orders.put(orderKey2, bookOrder5);
        }catch (Exception e){
                  e.printStackTrace();
        }
    }

    public void closeCache(){
        this.clientCache.close();
    }

    public void setUpCache(){
        //U can also use a properties file for below: new ClientCacheFactory(Properties props)
        this.clientCache = new ClientCacheFactory()
                                                    .set("name", "gilDataLoader")
                                                    .set("cache-xml-file", "xml/clientCache.xml")
                                                    .create();
    }
}
