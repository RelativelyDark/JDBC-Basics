package com.cars24.runner;

import com.cars24.config.DbConfig;
import com.cars24.dao.impl.CustomerDaoImpl;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.sevices.CustomerService;
import com.cars24.sevices.impl.CustomerServiceImpl;
import com.cars24.util.DbUtil;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Enter choice : ");
            System.out.println("1 for adding customer");
            System.out.println("2 for getting customer");
            System.out.println("0 to exit");
            int choice = scanner.nextInt();
            switch(choice){
                case 1 : UI.addCustomer();
                break;
                case 2 : UI.getCustomer();
                break;
                case 0 : System.exit(0);
            }
        }
    }
}
