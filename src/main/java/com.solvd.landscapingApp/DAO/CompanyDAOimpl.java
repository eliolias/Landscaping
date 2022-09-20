package com.solvd.landscapingApp.DAO;

import com.solvd.landscapingApp.connection.ConnectionPool;

import com.solvd.landscapingApp.models.Company;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAOimpl implements CompanyDAO {

    private final static Logger LOGGER = LogManager.getLogger(CompanyDAOimpl.class);

    public Company get(int id) throws SQLException {

        Company company = null;
        PreparedStatement ps = null;

        try {
            ConnectionPool con = ConnectionPool.getInstance();
            String sql = "SELECT id, name FROM Company WHERE id = ?";

            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int cId = rs.getInt("id");
                String name = rs.getString("name");

                company = new Company(cId, name);
            }
            return company;

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            assert ps != null;
            ps.close();
            ConnectionPool.getInstance().getConnection().close();
        }
        return company;
    }

    @Override
    public List<Company> getAll() throws SQLException {

        List<Company> companies = new ArrayList<>();
        PreparedStatement ps = null;

        try {

            ConnectionPool con = ConnectionPool.getInstance();
            String sql = "SELECT id, name FROM Company";

            ps = con.getConnection().prepareStatement(sql);
            ResultSet rs= ps.executeQuery(sql);

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");

                Company company = new Company(id, name);
                companies.add(company);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            assert ps != null;
            ps.close();
            ConnectionPool.getInstance().getConnection().close();
        }
        return companies;
    }

    @Override
    public int insert(Company company) throws SQLException {

        PreparedStatement ps = null;
        int result = 0;

        try{
            ConnectionPool con = ConnectionPool.getInstance();

            String sql = "INSERT INTO Company (id, name) VALUES (?, ?)";

            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, company.getId());
            ps.setString(2, company.getName());

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
    public int update(Company company) throws SQLException {

        PreparedStatement ps = null;
        int result = 0;

        try{
            ConnectionPool con = ConnectionPool.getInstance();

            String sql = "UPDATE Company set id = ?, name = ? WHERE id = ?";

            ps = con.getConnection().prepareStatement(sql);

            ps.setInt(1, company.getId());
            ps.setString(2, company.getName());
            ps.setInt(3, company.getId());

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
    public int delete(Company company) throws SQLException {

        PreparedStatement ps = null;
        int result = 0;

        try{
            ConnectionPool con = ConnectionPool.getInstance();

            String sql = "DELETE FROM Address WHERE id = ?";

            ps = con.getConnection().prepareStatement(sql);

            ps.setInt(1, company.getId());

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
