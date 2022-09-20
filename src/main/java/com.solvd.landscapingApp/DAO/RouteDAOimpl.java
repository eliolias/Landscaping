package com.solvd.landscapingApp.DAO;

import com.solvd.landscapingApp.connection.ConnectionPool;

import com.solvd.landscapingApp.models.Route;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteDAOimpl implements RouteDAO {

    private final static Logger LOGGER = LogManager.getLogger(CustomerDAOimpl.class);

    public Route get(int id) throws SQLException {

        Route route = null;
        PreparedStatement ps = null;

        try {
            ConnectionPool con = ConnectionPool.getInstance();
            String sql = "SELECT id, name, company_id FROM Routes WHERE id = ?";

            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int rId = rs.getInt("id");
                String name = rs.getString("licensePlate");
                int companyId = rs.getInt("company_id");

                route = new Route(rId, name, companyId);
            }
            return route;

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            assert ps != null;
            ps.close();
            ConnectionPool.getInstance().getConnection().close();
        }
        return route;
    }

    @Override
    public List<Route> getAll() throws SQLException {

        List<Route> routes = new ArrayList<>();
        PreparedStatement ps = null;

        try {

            ConnectionPool con = ConnectionPool.getInstance();
            String sql = "SELECT id, name, company_id FROM Routes";

            ps = con.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {
                int tId = rs.getInt("id");
                String name = rs.getString("name");
                int companyId = rs.getInt("company_id");

                Route route  = new Route(tId, name, companyId);
                routes.add(route);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            assert ps != null;
            ps.close();
            ConnectionPool.getInstance().getConnection().close();
        }
        return routes;
    }

    @Override
    public int insert(Route route) throws SQLException {

        PreparedStatement ps = null;
        int result = 0;

        try {
            ConnectionPool con = ConnectionPool.getInstance();

            String sql = "INSERT INTO Routes (id, name, company_id) VALUES (?, ?, ?)";

            ps = con.getConnection().prepareStatement(sql);

            ps.setInt(1, route.getId());
            ps.setString(2, route.getName());
            ps.setInt(3, route.getCompanyID());

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
    public int update(Route route) throws SQLException {

        PreparedStatement ps = null;
        int result = 0;

        try {
            ConnectionPool con = ConnectionPool.getInstance();

            String sql = "UPDATE Routes set id = ?, name = ?, company_id = ? WHERE id = ?";

            ps = con.getConnection().prepareStatement(sql);

            ps.setInt(1, route.getId());
            ps.setString(2, route.getName());
            ps.setInt(3, route.getCompanyID());
            ps.setInt(4, route.getId());

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
    public int delete(Route route) throws SQLException {

        PreparedStatement ps = null;
        int result = 0;

        try {
            ConnectionPool con = ConnectionPool.getInstance();

            String sql = "DELETE FROM Routes WHERE id = ?";

            ps = con.getConnection().prepareStatement(sql);

            ps.setInt(1, route.getId());

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