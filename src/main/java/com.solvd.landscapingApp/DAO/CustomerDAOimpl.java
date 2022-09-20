package com.solvd.landscapingApp.DAO;

import com.solvd.landscapingApp.connection.ConnectionPool;

import com.solvd.landscapingApp.models.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOimpl implements CustomerDAO {

    private final static Logger LOGGER = LogManager.getLogger(CustomerDAOimpl.class);

    public Customer get(int id) throws SQLException {

        Customer customer = null;
        PreparedStatement ps = null;

        try {
            ConnectionPool con = ConnectionPool.getInstance();
            String sql = "SELECT id, name, Routes_id FROM Customers WHERE id = ?";

            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int cId = rs.getInt("id");
                String name = rs.getString("name");
                int routeId = rs.getInt(("Routes_id"));

                customer = new Customer(cId, name, routeId);
            }
            return customer;

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            assert ps != null;
            ps.close();
            ConnectionPool.getInstance().getConnection().close();
        }
        return customer;
    }

    @Override
    public List<Customer> getAll() throws SQLException {

        List<Customer> customers = new ArrayList<>();
        PreparedStatement ps = null;

        try {

            ConnectionPool con = ConnectionPool.getInstance();
            String sql = "SELECT id, name, Routes_id FROM Customers";

            ps = con.getConnection().prepareStatement(sql);
            ResultSet rs= ps.executeQuery(sql);

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int routeId = rs.getInt(("Routes_id"));

                Customer customer = new Customer(id, name, routeId);
                customers.add(customer);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            assert ps != null;
            ps.close();
            ConnectionPool.getInstance().getConnection().close();
        }
        return customers;
    }

    @Override
    public int insert(Customer customer) throws SQLException {

        PreparedStatement ps = null;
        int result = 0;

        try{
            ConnectionPool con = ConnectionPool.getInstance();

            String sql = "INSERT INTO Customers (id, name, Routes_id) VALUES (?, ?, ?)";

            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, customer.getId());
            ps.setString(2, customer.getName());
            ps.setInt(3, customer.getRouteID());

            result = ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            assert ps != null;
            ps.close();
            ConnectionPool.getInstance().getConnection().close();
        }
        return result;
    }

    @Override
    public int update(Customer customer) throws SQLException {

        PreparedStatement ps = null;
        int result = 0;

        try{
            ConnectionPool con = ConnectionPool.getInstance();

            String sql = "UPDATE Customers set id = ?, name = ?, Routes_id = ? WHERE id = ?";

            ps = con.getConnection().prepareStatement(sql);

            ps.setInt(1, customer.getId());
            ps.setString(2, customer.getName());
            ps.setInt(3, customer.getRouteID());
            ps.setInt(4, customer.getId());

            result = ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            assert ps != null;
            ps.close();
            ConnectionPool.getInstance().getConnection().close();
        }
        return result;
    }

    @Override
    public int delete(Customer customer) throws SQLException {

        PreparedStatement ps = null;
        int result = 0;

        try{
            ConnectionPool con = ConnectionPool.getInstance();

            String sql = "DELETE FROM Customers WHERE id = ?";

            ps = con.getConnection().prepareStatement(sql);

            ps.setInt(1, customer.getId());

            result = ps.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            assert ps != null;
            ps.close();
            ConnectionPool.getInstance().getConnection().close();
        }
        return result;
    }
}