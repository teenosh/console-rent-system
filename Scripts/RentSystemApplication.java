package Scripts;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class RentSystemApplication {
    private final UserController userController;
    private final ProductController productController;
    private final RentController rentController;
    private final Scanner scanner;

    public RentSystemApplication(UserController userController, ProductController productController, RentController rentController) {
        this.userController = userController;
        this.productController = productController;
        this.rentController = rentController;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nWelcome to the Rent System Application!");
            System.out.println("Available options:");
            System.out.println("1. Get all users");
            System.out.println("2. Get all products");
            System.out.println("3. Get all rents");
            System.out.println("4. Get user by id");
            System.out.println("5. Get product by id");
            System.out.println("6. Get rent by id");
            System.out.println("7. Create a new user");
            System.out.println("8. Create a new product");
            System.out.println("9. Create a new rent");
            System.out.println("0. Exit\n");

            try {
                System.out.print("Please enter your choice: ");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    getAllUsersMenu();
                } else if (choice == 2) {
                    getAllProductsMenu();
                } else if (choice == 3) {
                    getAllRentsMenu();
                } else if (choice == 4) {
                    getUserByIdMenu();
                } else if (choice == 5) {
                    getProductByIdMenu();
                } else if (choice == 6) {
                    getRentByIdMenu();
                } else if (choice == 7) {
                    createUserMenu();
                } else if (choice == 8) {
                    createProductMenu();
                } else if (choice == 9) {
                    createRentMenu();
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

    public void getAllUsersMenu() {
        String response = userController.getAllUsers();
        System.out.println(response);
    }

    public void getAllProductsMenu() {
        String response = productController.getAllUProducts();
        System.out.println(response);
    }

    public void getAllRentsMenu() {
        String response = rentController.getAllRents();
        System.out.println(response);
    }

    public void getUserByIdMenu() {
        System.out.println("Enter user id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Is your user a renter? (Y/N)");
        String isRenter = scanner.nextLine();

        String response = userController.GetUser(id, isRenter.equals("Y"));
        System.out.println(response);

    }

    public void getProductByIdMenu() {
        System.out.println("Enter product id: ");
        int id = scanner.nextInt();

        String response = productController.GetProduct(id);
        System.out.println(response);
    }

    public void getRentByIdMenu() {
        System.out.println("Enter rent id: ");
        int id = scanner.nextInt();

        String response = rentController.GetRent(id);
        System.out.println(response);
    }

    public void createUserMenu() {
        System.out.println("Enter user id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter user name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Is your user a renter? (Y/N): ");
        String isRenter = scanner.nextLine();

        String response = userController.CreateUser(id, name, phoneNumber, isRenter.equals("Y"));
        System.out.println(response);
    }

    public void createProductMenu() {
        System.out.println("Enter product id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter product quantity: ");
        int quantity = scanner.nextInt();

        String response = productController.CreateProduct(id, name, quantity);
        System.out.println(response);
    }

    public void createRentMenu() {
        System.out.println("Enter rent id: ");
        int id = scanner.nextInt();
        System.out.println("Enter provider id: ");
        int providerId = scanner.nextInt();
        System.out.println("Enter customer id: ");
        int customerId = scanner.nextInt();
        System.out.println("Enter product id: ");
        int productId = scanner.nextInt();
        System.out.println("Enter rent time: ");
        double rentTime = scanner.nextDouble();
        System.out.println("Enter rent status: ");
        String rentStatus = scanner.nextLine();

        String response = rentController.CreateRent(id, providerId, customerId, rentTime, rentStatus, productId);
        System.out.println(response);
    }
}
