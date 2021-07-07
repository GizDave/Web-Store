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

    @GetMapping("/prefill/{userId}")
    public ResponseEntity<CustomerPayment> getCustomer(@RequestParam("CustomerId") int userId) {
        Optional<Integer> customerId = Optional.ofNullable(customerDB.getCustomerIdByUserId(userId));
        if(!customerId.isPresent()) {
            return ResponseEntity.badRequest()
                    .body(null);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(customerPaymentDB.findById(customerId.get()).get());
        }
    }

    private Converter convert;

    public Trade() {
        convert = new Converter();
    }

    @GetMapping("/detail/paymentmethod")
    public ResponseEntity<CustomerPaymentSummary> prefillPaymentMethod(int customerId){
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

    @PostMapping("/placeorder")
    public ResponseEntity<String> placeOrder(@RequestParam("ProductId") int productId,
                                              @RequestParam("Quantity") int quantity,
                                              @RequestParam("PaymentMethodId") int paymentMethodId){
        if(!customerPaymentDB.existsById(paymentMethodId)) {
            return ResponseEntity.badRequest()
                    .body("Payment method does not exist.");
        }
        else {
            Optional<Product> p = productDB.findById(productId);
            if(!p.isPresent()) {
                return ResponseEntity.badRequest()
                        .body("Product does not exist.");
            }

            CustomerPayment cp = customerPaymentDB.getById(paymentMethodId);

            CustomerOrder newOrder = new CustomerOrder();
            newOrder.setPaymentmethodid(cp.getPaymentmethodid());
            newOrder.setCustomerid(cp.getCustomerid());
            newOrder.setDate_ordered(LocalDateTime.now());
            newOrder.setTotal_price(p.get().getPrice() * quantity);
            newOrder = customerOrderDB.save(newOrder);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(String.format("Order %d is placed.", newOrder.getOrderid()));
        }
    }

    @DeleteMapping("/deleteorder/{orderId}")
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