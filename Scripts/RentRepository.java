package Scripts;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class RentRepository implements IRentRepository {
    private final IDB db;

    public RentRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createRent(Rent rent){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO rents(rent_id, rent_time, status, provider_id, customer_id, product_id) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, rent.GetId());
            st.setDouble(2, rent.GetRentTime());
            st.setString(3, rent.GetStatus());
            st.setInt(4, rent.GetProviderId());
            st.setInt(5, rent.GetCustomerId());
            st.setInt(6, rent.GetProductId());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Rent getRent(int id){
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT * FROM rents WHERE rent_id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()){
                Rent rent = new Rent(rs.getInt("rent_id"), rs.getInt("provider_id"), rs.getInt("customer_id"), rs.getDouble("rent_time"), rs.getString("status"), rs.getInt("product_id"));

                return rent;
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Rent> getAllRents(){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM rents";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Rent> rents = new LinkedList<>();
            while (rs.next()) {
                Rent rent = new Rent(rs.getInt("rent_id"), rs.getInt("provider_id"), rs.getInt("customer_id"), rs.getDouble("rent_time"), rs.getString("status"), rs.getInt("product_id"));

                rents.add(rent);
            }

            return rents;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
