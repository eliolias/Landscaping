package com.solvd.landscapingApp.DAO;

import com.solvd.landscapingApp.connection.ConnectionPool;

import com.solvd.landscapingApp.models.Trailer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrailerDAOimpl implements TrailerDAO {

    private final static Logger LOGGER = LogManager.getLogger(CustomerDAOimpl.class);

    public Trailer get(int id) throws SQLException {

        Trailer trailer = null;
        PreparedStatement ps = null;

        try {
            ConnectionPool con = ConnectionPool.getInstance();
            String sql = "SELECT id, licensePlate, length, Trucks_id FROM Trailers WHERE id = ?";

            ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int tId = rs.getInt("id");
                String licensePlate = rs.getString("licensePlate");
                int length = rs.getInt("length");
                int truckId = rs.getInt(("Trucks_id"));

                trailer = new Trailer(tId, licensePlate, length, truckId);
            }
            return trailer;

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            assert ps != null;
            ps.close();
            ConnectionPool.getInstance().getConnection().close();
        }
        return trailer;
    }

    @Override
    public List<Trailer> getAll() throws SQLException {

        List<Trailer> trailers = new ArrayList<>();
        PreparedStatement ps = null;

        try {

            ConnectionPool con = ConnectionPool.getInstance();
            String sql = "SELECT id, licensePlate, length, Trucks_id FROM Trailers";

            ps = con.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {
                int tId = rs.getInt("id");
                String licensePlate = rs.getString("licensePlate");
                int length = rs.getInt("length");
                int truckId = rs.getInt(("Trucks_id"));

                Trailer trailer = new Trailer(tId, licensePlate, length, truckId);
                trailers.add(trailer);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            assert ps != null;
            ps.close();
            ConnectionPool.getInstance().getConnection().close();
        }
        return trailers;
    }

    @Override
    public int insert(Trailer trailer) throws SQLException {

        PreparedStatement ps = null;
        int result = 0;

        try {
            ConnectionPool con = ConnectionPool.getInstance();

            String sql = "INSERT INTO Trailers (id, licensePlate, length, Trucks_id) VALUES (?, ?, ?, ?)";

            ps = con.getConnection().prepareStatement(sql);

            ps.setInt(1, trailer.getId());
            ps.setString(2, trailer.getLicensePlate());
            ps.setInt(3, trailer.getLength());
            ps.setInt(4, trailer.getTruckID());

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
    public int update(Trailer trailer) throws SQLException {

        PreparedStatement ps = null;
        int result = 0;

        try {
            ConnectionPool con = ConnectionPool.getInstance();

            String sql = "UPDATE Trailers set id = ?, licensePlate = ?, length = ?, Trucks_id = ? WHERE id = ?";

            ps = con.getConnection().prepareStatement(sql);

            ps.setInt(1, trailer.getId());
            ps.setString(2, trailer.getLicensePlate());
            ps.setInt(3, trailer.getLength());
            ps.setInt(4, trailer.getTruckID());
            ps.setInt(5, trailer.getId());

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
    public int delete(Trailer trailer) throws SQLException {

        PreparedStatement ps = null;
        int result = 0;

        try {
            ConnectionPool con = ConnectionPool.getInstance();

            String sql = "DELETE FROM Trailers WHERE id = ?";

            ps = con.getConnection().prepareStatement(sql);

            ps.setInt(1, trailer.getId());

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
