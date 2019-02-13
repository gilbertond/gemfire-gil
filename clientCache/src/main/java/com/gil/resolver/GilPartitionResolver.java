package com.gil.resolver;

import com.gil.entities.BookOrder;
import com.gil.entities.OrderKey;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.EntryOperation;
import org.apache.geode.cache.FixedPartitionResolver;

import java.util.Set;

//Go to Server cache and add this partition resolver on the region: BookOrder
public class GilPartitionResolver implements Declarable, FixedPartitionResolver<OrderKey, BookOrder> {
    @Override
    public Object getRoutingObject(EntryOperation<OrderKey, BookOrder> opDetails) {
        return opDetails.getKey().getCustomerId();
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }

    @Override
    public void close() {

    }

    @Override
    public String getPartitionName(EntryOperation<OrderKey, BookOrder> opDetails, Set<String> targetPartitions) {
        return opDetails.getKey().getCustomerId().toString();
    }
}
