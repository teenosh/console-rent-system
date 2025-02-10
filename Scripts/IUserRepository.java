package Scripts;

import java.util.List;

public interface IUserRepository {
    boolean createCustomer(Customer customer);
    boolean createRenter(Renter renter);
    Renter getRenter(int id);
    Customer getCustomer(int id);
    List<User> getAllUsers();

}
