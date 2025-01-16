package com.cars24.sevices;

import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.req.DeleteCustomerReq;
import com.cars24.data.req.UpdateCustomerReq;
import com.cars24.data.res.CustomerProfileRes;

public interface CustomerService {
    String registerCustomer(AddCustomerReq addCustomerReq);
    String getCustomerProfile(CustomerProfileReq customerProfileReq);
    String updateCustomer(UpdateCustomerReq updateCustomerReq);
    String deleteCustomer(DeleteCustomerReq deleteCustomerReq);
}