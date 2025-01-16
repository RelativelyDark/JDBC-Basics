package com.cars24.runner;

import java.util.*;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.req.DeleteCustomerReq;
import com.cars24.data.req.UpdateCustomerReq;
import com.cars24.sevices.impl.CustomerServiceImpl;

public class UI {

    private static Scanner scanner  = new Scanner(System.in);
    private static CustomerServiceImpl customerServiceimpl = new CustomerServiceImpl();

    public static void addCustomer() {

        AddCustomerReq addCustomerReq = new AddCustomerReq();
        System.out.println("Enter customer details");
        System.out.println("Name : ");
        addCustomerReq.setName(scanner.next());
        System.out.println("Phone : ");
        addCustomerReq.setPhone(scanner.next());
        System.out.println("Email : ");
        addCustomerReq.setEmail(scanner.next());
        System.out.println("Address : ");
        addCustomerReq.setAddress(scanner.next());

        System.out.println(customerServiceimpl.registerCustomer(addCustomerReq));
    }

    public static void getCustomer() {

        CustomerProfileReq customerProfileReq = new CustomerProfileReq();

        System.out.println("Search customer details");

        System.out.println("Enter Email(NA if not applicable)  : ");
        String mail = scanner.next();
        if(!mail.equals("NA"))
            customerProfileReq.setEmail(mail);

        System.out.println("Enter Phone(NA if not applicable)  : ");
        String phone = scanner.next();
        if(!phone.equals("NA"))
            customerProfileReq.setPhone(phone);

        customerServiceimpl.getCustomerProfile(customerProfileReq);
    }

    public static void updateCustomer(){
        UpdateCustomerReq updateCustomerReq = new UpdateCustomerReq();

        System.out.println("Updating customer details");
        System.out.println("Enter the email whose details are to be updated(NA if not applicable) : ");
        String curmail = scanner.next();
        if(!curmail.equals("NA"))
            updateCustomerReq.setCurmail(curmail);

        System.out.println("Enter the phone number whose details are to be updated(NA if not applicable)  : ");
        String curphone = scanner.next();
        if(!curphone.equals("NA"))
            updateCustomerReq.setCurphone(curphone);

        System.out.println("Enter the new name(NA if not applicable) : ");
        String name = scanner.next();
        if(!name.equals("NA"))
            updateCustomerReq.setName(name);

        System.out.println("Enter the new phone number(NA if not applicable)  : ");
        String phone = scanner.next();
        if(!phone.equals("NA"))
            updateCustomerReq.setPhone(phone);

        System.out.println("Enter the new email(NA if not applicable) : ");
        String mail = scanner.next();
        if(!mail.equals("NA"))
            updateCustomerReq.setMail(mail);

        System.out.println("Enter the new address(NA if not applicable)  : ");
        String address = scanner.next();
        if(!address.equals("NA"))
            updateCustomerReq.setAddress(address);

        customerServiceimpl.updateCustomer(updateCustomerReq);
    }

    public static void deleteCustomer(){
        DeleteCustomerReq deleteCustomerReq = new DeleteCustomerReq();

        System.out.println("Deleting customer details");

        System.out.println("Enter Email(NA if not applicable)  : ");
        String mail = scanner.next();
        if(!mail.equals("NA"))
            deleteCustomerReq.setEmail(mail);

        System.out.println("Enter Phone(NA if not applicable)  : ");
        String phone = scanner.next();
        if(!phone.equals("NA"))
            deleteCustomerReq.setEmail(phone);

        System.out.println(customerServiceimpl.deleteCustomer(deleteCustomerReq));
    }
}