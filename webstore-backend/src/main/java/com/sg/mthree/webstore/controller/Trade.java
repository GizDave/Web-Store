package main.java.com.sg.mthree.webstore.controller;

import main.java.com.sg.mthree.webstore.model.dao.CustomerAddressRepository;
import main.java.com.sg.mthree.webstore.model.dao.CustomerOrderRepository;
import main.java.com.sg.mthree.webstore.model.dao.CustomerPaymentRepository;
import main.java.com.sg.mthree.webstore.model.dao.CustomerRepository;
import main.java.com.sg.mthree.webstore.model.dto.CustomerOrder;
import main.java.com.sg.mthree.webstore.model.dto.CustomerPayment;
import main.java.com.sg.mthree.webstore.model.dto.CustomerPaymentSummary;
import main.java.com.sg.mthree.webstore.service.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/detail")
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
    public ResponseEntity<Integer> placeOrder(CustomerPaymentSummary paymentInformation){

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