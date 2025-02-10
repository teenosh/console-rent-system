package Scripts;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private final IDB db;

    public UserRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createCustomer(Customer customer) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO users(user_id, name, phone_number, renter) VALUES (?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, customer.GetId());
            st.setString(2, customer.GetName());
            st.setString(3, customer.GetPhoneNumber());
            st.setBoolean(4, false);

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
    public boolean createRenter(Renter renter) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO users(user_id, name, phone_number, renter) VALUES (?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, (renter.GetId()));
            st.setString(2, renter.GetName());
            st.setString(3, renter.GetPhoneNumber());
            st.setBoolean(4, true);

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
    public Renter getRenter(int id) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT * FROM users WHERE user_id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()){
                Renter renter = new Renter(rs.getInt("user_id"), rs.getString("name"), rs.getString("phone_number"));

                return renter;
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
    public Customer getCustomer(int id) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT * FROM users WHERE user_id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()){
                Customer customer = new Customer(rs.getInt("user_id"), rs.getString("name"), rs.getString("phone_number"));

                return customer;
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
    public List<User> getAllUsers() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM users";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<User> users = new LinkedList<>();
            while (rs.next()) {
                User user;
                if (rs.getBoolean("renter")){
                    user = new Renter(rs.getInt("user_id"), rs.getString("name"), rs.getString("phone_number"));
                } else {
                    user = new Customer(rs.getInt("user_id"), rs.getString("name"), rs.getString("phone_number"));
                }

                users.add(user);
            }

            return users;
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
