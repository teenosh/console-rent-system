package Scripts;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private final IDB db;

    public ProductRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createProduct(Product product){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO products(product_id, name, quantity) VALUES (?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, product.GetId());
            st.setString(2, product.GetName());
            st.setInt(3, product.GetQuantity());

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
    public Product getProduct(int id){
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT * FROM products WHERE product_id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()){
                Product product = new Product(rs.getInt("product_id"), rs.getString("name"), rs.getInt("quantity"));

                return product;
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
    public List<Product> getAllProducts(){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM products";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Product> products = new LinkedList<>();
            while (rs.next()) {
                Product product = new Product(rs.getInt("product_id"), rs.getString("name"), rs.getInt("quantity"));

                products.add(product);
            }

            return products;
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
