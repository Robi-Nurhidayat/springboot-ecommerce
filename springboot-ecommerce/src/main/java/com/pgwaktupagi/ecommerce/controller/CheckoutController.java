package com.pgwaktupagi.ecommerce.controller;


import com.pgwaktupagi.ecommerce.dto.Purchase;
import com.pgwaktupagi.ecommerce.dto.PurchaseResponse;
import com.pgwaktupagi.ecommerce.service.CheckoutService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }
}
