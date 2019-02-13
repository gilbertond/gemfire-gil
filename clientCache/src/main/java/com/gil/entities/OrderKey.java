package com.gil.entities;

import org.apache.commons.lang.IllegalClassException;

public class OrderKey {

    private static final long serialVersionUId = 1L;
    
    private Integer customerId; // This will be used in the customPartitionResolver to generate a bucket
    private Integer orderId;

    public OrderKey(Integer customeId, Integer orderId)  {
       this.orderId = orderId;
       this.customerId = customeId;
    }

    @Override
    public String toString() {
        return "{orderId: "+orderId+", customerId: "+customerId+"}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass())  throw new IllegalClassException("Cannot compare different object types");

        OrderKey key = (OrderKey) obj;
        return this.orderId.equals(key.orderId);
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (this.orderId == null? 0: this.orderId.hashCode());
        return result;
    }
}
