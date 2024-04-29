package com.pgwaktupagi.ecommerce.dto;

import com.pgwaktupagi.ecommerce.entity.Address;
import com.pgwaktupagi.ecommerce.entity.Customer;
import com.pgwaktupagi.ecommerce.entity.Order;
import com.pgwaktupagi.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
