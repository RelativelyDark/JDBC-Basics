package com.cars24.validation;

import com.cars24.data.req.UpdateCustomerReq;

import java.util.regex.Pattern;

public class UpdateValidator {
    public static void validateUpdateReq(UpdateCustomerReq updateCustomerReq){
        if(updateCustomerReq.getCurmail() == null && updateCustomerReq.getCurphone() == null)
            throw new IllegalArgumentException("Cannot have both phone number and email empty");

        if(updateCustomerReq.getMail() != null)
            validateEmail(updateCustomerReq.getMail());
        else
            validatePhone(updateCustomerReq.getPhone());

    }

    private static void validateEmail(String email){
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

    private static void validatePhone(String phone){
        if(phone.length() != 10)
            throw new IllegalArgumentException("Phone number is invalid");
    }

}
