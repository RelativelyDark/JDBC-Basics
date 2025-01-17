package com.cars24.dao.impl;

import com.cars24.dao.CustomerDao;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.req.DeleteCustomerReq;
import com.cars24.data.req.UpdateCustomerReq;
import com.cars24.data.res.CustomerProfileRes;
import com.cars24.util.DbUtil;

import java.sql.*;

public class CustomerDaoImpl implements CustomerDao {

    private final Connection connection = DbUtil.getDbConnection();
    private final static String INSERT_SUCCESS_MESSAGE = "Customer added successfully!";
    private final static String INSERT_ERROR_MESSAGE = "Error! while adding the customer";

    @Override
    public String createCustomer(AddCustomerReq addCustomerReq) {

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

    @Override
    public CustomerProfileRes getCustomer(CustomerProfileReq customerProfileReq) {
        CustomerProfileRes customerProfileRes = new CustomerProfileRes();

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
    public String updateCustomer(UpdateCustomerReq updateCustomerReq) {

        String selectSQL = "SELECT name, phone, email, address from customers where phone = ? or email = ?";
        String updateSQL = "UPDATE customers SET name = ?, phone = ?, email = ?, address = ? where phone = ? or email = ?";

        try {
            PreparedStatement preparedStatement1 = connection.prepareStatement(selectSQL);
            preparedStatement1.setString(1, updateCustomerReq.getCurphone());
            preparedStatement1.setString(2, updateCustomerReq.getCurmail());

            ResultSet resultSet = preparedStatement1.executeQuery();

            if(resultSet.next()){

                if(updateCustomerReq.getName() == null)
                    updateCustomerReq.setName(resultSet.getString("name"));

                if(updateCustomerReq.getPhone() == null)
                    updateCustomerReq.setPhone(resultSet.getString("phone"));

                if(updateCustomerReq.getMail() == null)
                    updateCustomerReq.setMail(resultSet.getString("email"));

                if(updateCustomerReq.getAddress() == null)
                    updateCustomerReq.setAddress(resultSet.getString("address"));
            }
            else
                throw new IllegalArgumentException("No such entry exists");

            System.out.println(updateCustomerReq);

            PreparedStatement preparedStatement2 = connection.prepareStatement(updateSQL);
            preparedStatement2.setString(1, updateCustomerReq.getName());
            preparedStatement2.setString(2, updateCustomerReq.getPhone());
            preparedStatement2.setString(3, updateCustomerReq.getMail());
            preparedStatement2.setString(4, updateCustomerReq.getAddress());
            preparedStatement2.setString(5, updateCustomerReq.getCurphone());
            preparedStatement2.setString(6, updateCustomerReq.getCurmail());

            int rows_inserted = preparedStatement2.executeUpdate();
            return "Updated Successfully";

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return "Failed";
    }



    @Override
    public String deleteCustomer(DeleteCustomerReq deleteCustomerReq) {
        String deleteSQL = "DELETE FROM customers WHERE phone = ? or email = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setString(1, deleteCustomerReq.getPhone());
            preparedStatement.setString(2, deleteCustomerReq.getEmail());

            int rows_deleted = preparedStatement.executeUpdate();
            if(rows_deleted > 0)
                return rows_deleted + " row(s) were deleted";
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return "Deleted Successfully";
    }
}