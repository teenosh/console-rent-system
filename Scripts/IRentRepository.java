package Scripts;

import java.util.List;

public interface IRentRepository {
    boolean createRent(Rent rent);
    Rent getRent(int id);
    List<Rent> getAllRents();
}
