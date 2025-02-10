package Scripts;

import java.util.List;

public class RentController {
    private final IRentRepository repo;

    public RentController(IRentRepository repo) {
        this.repo = repo;
    }

    public String CreateRent(int id, int providerId, int customerId, double rentTime, String status, int productId) {
        Rent rent = new Rent(id, providerId, customerId, rentTime, status, productId);
        boolean created = repo.createRent(rent);

        return (created ? "Product was created!" : "Product creating was failed!");
    }

    public String GetRent(int id) {
        Rent rent = repo.getRent(id);

        return (rent != null ? rent.PrintInformation() : "Product not found!");
    }

    public String getAllRents() {
        List<Rent> rents = repo.getAllRents();

        String response = "Rents: ";
        for (Rent rent : rents) {
            response += "\n";
            response += rent.PrintInformation();
        }

        return response;
    }
}
