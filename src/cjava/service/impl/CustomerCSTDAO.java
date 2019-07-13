package cjava.service.impl;

import cjava.beans.Customer;
import cjava.service.CustomerService;
import cjava.util.DBConn;
import cjava.util.Util;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerCSTDAO implements CustomerService {

    private Connection connection;
    private ResultSet resultSet;
    private CallableStatement callableStatement;

    @Override
    public void create(Customer t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer find(Object id) {
        Customer customer = null;
        try {
            connection = DBConn.getConnection();
            callableStatement = connection.prepareCall("{CALL sp_find_curso(?)}");
            callableStatement.setString(1, id.toString());
            resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
                customer = new Customer();
//               customer.setCodigo(rs.getString(1));
//               customer.setNombre(rs.getString(2));
//               customer.setCreditos(3);
            }
            resultSet.close();
            callableStatement.close();
            connection.close();
        } catch (SQLException ex) {
            try {
                resultSet.close();
                callableStatement.close();
                connection.close();
            } catch (SQLException ex1) {
                System.out.println(Util.error);
            }
        }
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> list = new ArrayList<>();
        Customer customer;
        try {
            connection = DBConn.getConnection();
            callableStatement = connection.prepareCall("{CALL sp_findAll_cliente()}");
            resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer();
                customer.setId(resultSet.getInt(1));
                customer.setLastName(resultSet.getString(2));
                customer.setName(resultSet.getString(3));
                customer.setMail(resultSet.getString(4));
                customer.setPhoneNumber(resultSet.getString(5));
                list.add(customer);
            }
            resultSet.close();
            callableStatement.close();
            connection.close();
        } catch (SQLException ex) {
            try {
                resultSet.close();
                callableStatement.close();
                connection.close();
            } catch (SQLException ex1) {
                System.out.println(Util.error);
            }
        }
        return list;
    }

    @Override
    public void update(Customer t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
