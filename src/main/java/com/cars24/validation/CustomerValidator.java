package com.cars24.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cars24.data.req.AddCustomerReq;

public class CustomerValidator {

    public static void validateAddCustomerReq(AddCustomerReq addCustomerReq){
        validateCustomerName(addCustomerReq.getName());
        validateCustomerNumber(addCustomerReq.getPhone());
        validateCustomerMail(addCustomerReq.getEmail());
    }

    private static void validateCustomerName(String name){

        if(name.length() < 3 || name.length() > 100){
            throw new IllegalArgumentException("Name should be of minimum 3 characters long and less than 100 characters");
        }

    }

    private static void validateCustomerNumber(String phone){
        if(phone.length() != 10)
            throw new IllegalArgumentException("Invalid Mobile Number");
    }

    private static void validateCustomerMail(String email) {
        String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email is null or empty");
        }

        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        if (!pattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email format");
        }

        if (!email.endsWith("@gmail.com"))
            throw new IllegalArgumentException("Email is valid but not a Gmail address");

    }

}
