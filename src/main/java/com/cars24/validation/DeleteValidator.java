package com.cars24.validation;

import com.cars24.data.req.DeleteCustomerReq;

public class DeleteValidator {
    public static void validateDeleteReq(DeleteCustomerReq deleteCustomerReq){
        if(deleteCustomerReq.getEmail() == null && deleteCustomerReq.getPhone() == null)
            throw new IllegalArgumentException("Cannot have both phone number and email empty");
    }
}
