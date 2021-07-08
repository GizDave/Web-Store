package main.java.com.sg.mthree.webstore.controller;

import main.java.com.sg.mthree.webstore.model.dao.*;
import main.java.com.sg.mthree.webstore.model.dto.CustomerOrder;
import main.java.com.sg.mthree.webstore.model.dto.CustomerPayment;
import main.java.com.sg.mthree.webstore.model.dto.CustomerPaymentSummary;
import main.java.com.sg.mthree.webstore.model.dto.Product;
import main.java.com.sg.mthree.webstore.service.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trade")
public class Trade {
    @Autowired
    private CustomerRepository customerDB;

    @Autowired
    private CustomerPaymentRepository customerPaymentDB;

    @Autowired
    private CustomerAddressRepository customerAddressDB;

    @Autowired
    private CustomerOrderRepository customerOrderDB;

    @Autowired
    private ProductRepository productDB;

    @Autowired
    private Converter convert;

    @GetMapping("/customerid/get")
    public ResponseEntity<Integer> getCustomerId(@RequestParam int userId) {
        Optional<List<Integer>> customerId = Optional.ofNullable(customerDB.findCustomerIdByUserId(userId));
        if(!customerId.isPresent() || customerId.get().size() == 0) {
            return ResponseEntity.badRequest()
                    .body(null);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(customerId.get().get(0));
        }
    }

    @GetMapping("/prefill")
    public ResponseEntity<CustomerPaymentSummary> prefillPaymentMethod(@RequestParam int customerId){
        CustomerPaymentSummary cps = convert.toCustomerPaymentSummary(customerId);
        if(cps == null) {
            return ResponseEntity.badRequest()
                    .body(null);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(cps);
        }
    }

    @GetMapping("/allOrders")
    public ResponseEntity<List<CustomerOrder>> findAllOrder(@RequestParam int customerId) {
        if(!customerDB.existsById(customerId)) {
            return ResponseEntity.badRequest()
                    .body(null);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(customerOrderDB.findAllByCustomerid(customerId));
        }
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<String> placeOrder(@RequestParam int productId,
                                             @RequestParam int quantity,
                                             @RequestParam int paymentMethodId){
        if(quantity <= 0) {
            return ResponseEntity.badRequest()
                    .body("Quantity cannot be less than 1.");
        }
        else if(!customerPaymentDB.existsById(paymentMethodId)) {
            return ResponseEntity.badRequest()
                    .body("Payment method does not exist.");
        }
        else {
            Optional<Product> p = productDB.findById(productId);
            if(!p.isPresent()) {
                return ResponseEntity.badRequest()
                        .body("Product does not exist.");
            }

            CustomerPayment cp = customerPaymentDB.findById(paymentMethodId).get();
            System.out.println(cp.getCustomerid());
            CustomerOrder newOrder = new CustomerOrder();
            newOrder.setCustomerPayment(cp);
            newOrder.setCustomer(customerDB.findById(cp.getCustomerid()).get());
            newOrder.setDate_ordered(LocalDateTime.now());
            newOrder.setTotal_price(p.get().getPrice() * quantity);
            newOrder = customerOrderDB.save(newOrder);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(String.format("Order %d is placed.", newOrder.getOrderid()));
        }
    }

    @DeleteMapping("/deleteOrder")
    public ResponseEntity<String> deleteOrder(@RequestParam int orderId){
        if(!customerOrderDB.existsById(orderId)) {
            return ResponseEntity.badRequest()
                    .body("Order does not exist.");
        }
        else {
            customerOrderDB.deleteById(orderId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Order is deleted");
        }
    }
}