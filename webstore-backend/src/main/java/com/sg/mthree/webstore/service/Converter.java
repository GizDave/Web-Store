package com.sg.mthree.webstore.service;

import com.sg.mthree.webstore.model.dao.*;
import com.sg.mthree.webstore.model.dto.Customer;
import com.sg.mthree.webstore.model.dto.CustomerPaymentSummary;
import com.sg.mthree.webstore.model.dto.Product;
import com.sg.mthree.webstore.model.dto.ProductSummary;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Converter {
    @Autowired
    private ProductRepository productDB;

    @Autowired
    private ImageRepository imageDB;

    @Autowired
    private StockRepository stockDB;

    @Autowired
    private CustomerRepository customerDB;

    @Autowired
    private CustomerAddressRepository customerAddressDB;

    @Autowired
    private CustomerPaymentRepository customerPaymentDB;

    public List<ProductSummary> productToThumbnail(List<Product> products){
        List<ProductSummary> buffer = new ArrayList<>();

        for(Product p: products) {
            ProductSummary tn = new ProductSummary();
            tn.setProductid(p.getProductid());
            tn.setName(p.getName());
            tn.setInstock(stockDB.existsById(stockDB.findByProductId(p.getProductid())));
            tn.setPrice(p.getPrice());
            tn.setDescription(p.getDescription());
            tn.setThumbnail(p.getThumbnail());
            tn.setImages(imageDB.findByProductId(p.getProductid()));

            buffer.add(tn);
        }

        return buffer;
    }

    public CustomerPaymentSummary toCustomerPaymentSummary(int customerId){
        Optional<Customer> c = customerDB.findById(customerId);

        if(!c.isPresent()) {
            return null;
        }
        else {
            CustomerPaymentSummary cps = new CustomerPaymentSummary();
            cps.setCustomerid(customerId);
            cps.setFirst_name(c.get().getFirst_name());
            cps.setLast_name(c.get().getLast_name());
            cps.setPhone(c.get().getPhone());
            cps.setAddress(customerAddressDB.getAddressByCustomerId(customerId));
            cps.setPayment(customerPaymentDB.findByCustomerId(customerId));
            return cps;
        }
    }
}
