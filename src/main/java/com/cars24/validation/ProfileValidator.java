package com.cars24.validation;

import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.req.UpdateCustomerReq;

public class ProfileValidator {
    public static void validateProfileReq(CustomerProfileReq customerProfileReq){
        if(customerProfileReq.getEmail() == null && customerProfileReq.getPhone() == null)
            throw new IllegalArgumentException("Cannot have both phone number and email empty");
    }
}
