package com.cars24.sevices.impl;

import com.cars24.dao.impl.CustomerDaoImpl;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.sevices.CustomerService;
import com.cars24.validation.CustomerValidator;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDaoImpl customerDaoimpl = new CustomerDaoImpl();
    @Override
    public String registerCustomer(AddCustomerReq addCustomerReq) {

        try {
            CustomerValidator.validateAddCustomerReq(addCustomerReq);
            customerDaoimpl.createCustomer(addCustomerReq);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return "";
    }

    @Override
    public void getCustomerProfile(CustomerProfileReq customerProfileReq) {
        System.out.println(customerDaoimpl.getCustomer(customerProfileReq));
    }

}
