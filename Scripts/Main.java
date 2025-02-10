package Scripts;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IUserRepository userRepo = new UserRepository(db);
        IProductRepository productRepo = new ProductRepository(db);
        IRentRepository rentRepo = new RentRepository(db);
        UserController userController = new UserController(userRepo);
        ProductController productController = new ProductController(productRepo);
        RentController rentController = new RentController(rentRepo);
        RentSystemApplication app = new RentSystemApplication(userController, productController, rentController);
        app.start();

    }
}
