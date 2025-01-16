package com.cars24.sevices;

import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.res.CustomerProfileRes;

public interface CustomerService {
    String registerCustomer(AddCustomerReq addCustomerReq);

    void getCustomerProfile(CustomerProfileReq customerProfileReq);
}