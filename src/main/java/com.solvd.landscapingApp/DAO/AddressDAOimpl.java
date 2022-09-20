package com.solvd.landscapingApp.DAO;

import com.solvd.landscapingApp.connection.ConnectionPool;
import com.solvd.landscapingApp.models.Address;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDAOimpl implements AddressDAO {

    private final static Logger LOGGER = LogManager.getLogger(AddressDAOimpl.class);

    public Address get(int id) throws SQLException {

        Address address = null;
        PreparedStatement ps = null;

        try {
            ConnectionPool con = ConnectionPool.getInstance();
            String sql = "SELECT id, streetAddress, zipCode, city FROM Address WHERE id = ?";

            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int aId = rs.getInt("id");
                String employeeId = rs.getString("streetAddress");
                int zipCode = rs.getInt("zipCode");
                String city = rs.getString("city");

                address = new Address(aId, employeeId, city, zipCode);
            }
            return address;

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            assert ps != null;
            ps.close();
            ConnectionPool.getInstance().getConnection().close();
        }
        return address;
    }

    @Override
    public List<Address> getAll() throws SQLException {

        List<Address> addresses = new ArrayList<>();
        PreparedStatement ps = null;

        try {

            ConnectionPool con = ConnectionPool.getInstance();
            String sql = "SELECT id, streetAddress, zipCode, city FROM Address";

            ps = con.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String streetAddress = rs.getString("streetAddress");
                int zipCode = rs.getInt("zipCode");
                String city = rs.getString("city");

                Address address = new Address(id, streetAddress, city, zipCode);
                addresses.add(address);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            assert ps != null;
            ps.close();
            ConnectionPool.getInstance().getConnection().close();
        }
        return addresses;
    }

    @Override
    public int insert(Address address) throws SQLException {

        PreparedStatement ps = null;
        int result = 0;

        try {
            ConnectionPool con = ConnectionPool.getInstance();

            String sql = "INSERT INTO Address (id, streetAddress, zipCode, city) VALUES (?, ?, ?, ?)";

            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, address.getId());
            ps.setString(2, address.getStreetAddress());
            ps.setInt(3, address.getZipCode());
            ps.setString(4, address.getCity());

            result = ps.executeUpdate();

            return result;
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
    public int update(Address address) throws SQLException {

        PreparedStatement ps = null;
        int result = 0;

        try {
            ConnectionPool con = ConnectionPool.getInstance();

            String sql = "UPDATE Address set id = ?, streetAddress = ?, zipCode = ?, city = ? WHERE id = ?";

            ps = con.getConnection().prepareStatement(sql);

            ps.setInt(1, address.getId());
            ps.setString(2, address.getStreetAddress());
            ps.setInt(3, address.getZipCode());
            ps.setString(4, address.getCity());
            ps.setInt(5, address.getId());

            result = ps.executeUpdate();

            return result;
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
    public int delete(Address address) throws SQLException {
        PreparedStatement ps = null;
        int result = 0;
        try {
            ConnectionPool con = ConnectionPool.getInstance();

            String sql = "DELETE FROM Address WHERE id = ?";

            ps = con.getConnection().prepareStatement(sql);

            ps.setInt(1, address.getId());

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
