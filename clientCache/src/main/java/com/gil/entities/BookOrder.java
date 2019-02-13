package com.gil.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BookOrder implements Serializable {
    private Integer orderId;
    private List<OrderItem> orderItems;
    private Date orderDate;
    private Double totalCost;

    public BookOrder(Integer orderId, List<OrderItem> orderItems, Date orderDate, Double totalCost){
        this.orderDate = orderDate;
        this.orderId = orderId;
        this.orderItems = orderItems;
        this.totalCost = totalCost;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void addItem(OrderItem orderItem){
        orderItems.add(orderItem);
    }
}
