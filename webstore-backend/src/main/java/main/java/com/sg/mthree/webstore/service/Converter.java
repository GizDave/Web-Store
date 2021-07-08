package main.java.com.sg.mthree.webstore.service;

import main.java.com.sg.mthree.webstore.model.dao.*;
import main.java.com.sg.mthree.webstore.model.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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

    public List<ProductSummary> productToThumbnail(List<Product> products, List<ProductSummary> buffer){
        System.out.println("convert():");
        for(Product p: products) {
            ProductSummary tn = new ProductSummary();
//            System.out.println(p.getProductid()); //
            tn.setProductid(p.getProductid());
//            System.out.println(p.getName()); //
            tn.setName(p.getName());
            tn.setInstock(stockDB.hasStock(p.getProductid()));
//            System.out.println(tn.getInstock()); //
//            System.out.println(p.getPrice()); //
            tn.setPrice(p.getPrice());
//            System.out.println(p.getDescription()); //
            tn.setDescription(p.getDescription());
//            System.out.println(p.getThumbnail()); //
            tn.setThumbnail(p.getThumbnail());
            tn.setImages(imageDB.findByProductId(p.getProductid()));
//            System.out.println(tn.getImages().size()); //
//            System.out.println("-------------------"); //

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
            cps.setAddress(customerAddressDB.getAddressByCustomerId(customerId).get(0));
            cps.setPayment(customerPaymentDB.findByCustomerId(customerId));
            return cps;
        }
    }
}
