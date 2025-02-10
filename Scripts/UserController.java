package Scripts;

import java.util.List;

public class UserController {
    private final IUserRepository repo;

    public UserController(IUserRepository repo) {
        this.repo = repo;
    }

    public String CreateUser(int id, String username, String phoneNumber, boolean isRenter) {
        boolean created = false;
        if (isRenter) {
            Renter renter = new Renter(id, username, phoneNumber);
            created = repo.createRenter(renter);
        }else {
            Customer customer = new Customer(id, username, phoneNumber);
            created = repo.createCustomer(customer);
        }

        return (created ? "User was created!" : "User creating was failed!");

    }

    public String GetUser(int id, boolean isRenter) {
        if (isRenter) {
           Renter user = repo.getRenter(id);
           return (user == null ? "User not found!" : user.GetInformation());
        } else {
            Customer user = repo.getCustomer(id);
            return (user == null ? "User not found!" : user.GetInformation());
        }

    }

    public String getAllUsers() {
        List<User> users = repo.getAllUsers();

        String response = "Users: ";
        for (User user : users) {
            response += '\n';
            response += user.GetInformation();
        }

        return response;
    }
}
