package com.cars24.dao.impl;

import com.cars24.dao.CustomerDao;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.util.DbUtil;

import java.sql.*;

public class CustomerDaoImpl implements CustomerDao {

    private final static String INSERT_SUCCESS_MESSAGE = "Customer added successfully!";
    private final static String INSERT_ERROR_MESSAGE = "Error! while adding the customer";

    @Override
    public String createCustomer(AddCustomerReq addCustomerReq) {

        Connection connection = DbUtil.getDbConnection();
        String insertSQL =
                "INSERT INTO customers (name,phone,email,address) VALUES"
                        + "("+ "'" + addCustomerReq.getName() + "' ," + "'" + addCustomerReq.getPhone() + "' , '" + addCustomerReq.getEmail() + "' ,'" + addCustomerReq.getAddress() + "'" + ");";
//        System.out.println(insertSQL);

        try {
            Statement statement = connection.createStatement();
            int rowsInserted = statement.executeUpdate(insertSQL);
//            System.out.println(rowsInserted + " row(s) inserted.");
            return INSERT_SUCCESS_MESSAGE;
        } catch (SQLException e){
            System.out.println("Error while inserting data to customer table " + e);
            e.printStackTrace();
            return INSERT_ERROR_MESSAGE;
        }
    }

    @Override
    public CustomerProfileRes getCustomer(CustomerProfileReq customerProfileReq) {
        CustomerProfileRes customerProfileRes = new CustomerProfileRes();

        Connection connection = DbUtil.getDbConnection();
        String selectSQL = "SELECT name, phone, email, address FROM customers where email = ? or phone = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, customerProfileReq.getEmail());
            preparedStatement.setString(2, customerProfileReq.getPhone());

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                customerProfileRes.setName(resultSet.getString("name"));
                customerProfileRes.setPhone(resultSet.getString("phone"));
                customerProfileRes.setEmail(resultSet.getString("email"));
                customerProfileRes.setAddress(resultSet.getString("address"));
            }
            return customerProfileRes;

        } catch (SQLException e) {
            System.out.println("Data not found");
        }
        return customerProfileRes;
    }

    @Override
    public void updateCustomer(AddCustomerReq addCustomerReq) {

    }

    public String createCustomerV2(AddCustomerReq addCustomerReq){
        Connection connection = DbUtil.getDbConnection();

        String insertSQL = "INSERT INTO customers (name, phone, email, address) VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, addCustomerReq.getName());
            preparedStatement.setString(2, addCustomerReq.getPhone());
            preparedStatement.setString(3, addCustomerReq.getEmail());
            preparedStatement.setString(4, addCustomerReq.getAddress());

            int rowsInserted = preparedStatement.executeUpdate();
//            System.out.println("Rows inserted : " + rowsInserted);
            return INSERT_SUCCESS_MESSAGE;
        }

        catch (Exception e){
            System.out.println(e);
            return INSERT_ERROR_MESSAGE;
        }
    }
}