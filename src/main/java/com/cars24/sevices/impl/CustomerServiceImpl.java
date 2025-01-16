package com.cars24.sevices.impl;

import com.cars24.dao.impl.CustomerDaoImpl;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.req.DeleteCustomerReq;
import com.cars24.data.req.UpdateCustomerReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.sevices.CustomerService;
import com.cars24.validation.CustomerValidator;
import com.cars24.validation.DeleteValidator;
import com.cars24.validation.ProfileValidator;
import com.cars24.validation.UpdateValidator;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerDaoImpl customerDaoimpl = new CustomerDaoImpl();

    @Override
    public String registerCustomer(AddCustomerReq addCustomerReq) {

        try {
            CustomerValidator.validateAddCustomerReq(addCustomerReq);
            customerDaoimpl.createCustomer(addCustomerReq);
            System.out.println("Successful insert");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "";
    }

    @Override
    public String getCustomerProfile(CustomerProfileReq customerProfileReq) {

        try {
            ProfileValidator.validateProfileReq(customerProfileReq);
            System.out.println(customerDaoimpl.getCustomer(customerProfileReq));
            return "Valid Search";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "";
        }
    }

    @Override
    public String updateCustomer(UpdateCustomerReq updateCustomerReq) {

        try {
            UpdateValidator.validateUpdateReq(updateCustomerReq);
            System.out.println(customerDaoimpl.updateCustomer(updateCustomerReq));
            return "Update was successful";
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "";
        }
    }

    @Override
    public String deleteCustomer(DeleteCustomerReq deleteCustomerReq) {

        try {
            DeleteValidator.validateDeleteReq(deleteCustomerReq);
            return customerDaoimpl.deleteCustomer(deleteCustomerReq);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "";
        }
    }

}
