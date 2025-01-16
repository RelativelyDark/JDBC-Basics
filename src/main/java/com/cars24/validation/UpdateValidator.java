package com.cars24.validation;

import com.cars24.data.req.UpdateCustomerReq;

public class UpdateValidator {
    public static void validateUpdateReq(UpdateCustomerReq updateCustomerReq){
        if(updateCustomerReq.getCurmail() == null && updateCustomerReq.getCurphone() == null)
            throw new IllegalArgumentException("Cannot have both phone number and email empty");
    }
}
