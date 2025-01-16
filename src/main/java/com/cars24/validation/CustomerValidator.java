package com.cars24.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cars24.data.req.AddCustomerReq;

public class CustomerValidator {

    public static void validateAddCustomerReq(AddCustomerReq addCustomerReq){
        validateCustomerName(addCustomerReq.getName());
    }

    private static void validateCustomerName(String name){

        if(name.length() < 3 || name.length() > 100){
            throw new IllegalArgumentException("Name should be of minimum 3 characters long and less than 100 characters");
        }

    }

    private static void validateCustomerNumber(String email){
        String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        if (email == null) {

        }

    }

    private static void validateCustomerEmail(String phone){

    }

}
