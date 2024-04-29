package com.pgwaktupagi.ecommerce.service;

import com.pgwaktupagi.ecommerce.dto.Purchase;
import com.pgwaktupagi.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
