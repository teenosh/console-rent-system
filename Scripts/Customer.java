package Scripts;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User{
    private List<Rent> rents = new ArrayList<Rent>();

    Customer(int id){
        super(id);
    }

    Customer(int id, String name, String phoneNumber) {
        super(id, name, phoneNumber);
    }

    Customer(int id, String name, String phoneNumber, List<Rent> rents) {
        super(id, name, phoneNumber);
        SetRents(rents);
    }

    public void AddRent(Rent rent) {
        rents.add(rent);
    }

    public void RemoveRent(Rent rent) {
        rents.remove(rent);
    }

    public void ListRents() {
        for (Rent rent : rents) {
            rent.PrintInformation();
        }
    }

    @Override
    public String GetInformation() {
        return (this.GetId() + ": " + this.GetName() + " -> " + this.GetPhoneNumber());
    }

    // getters
    public List<Rent> GetRents() {
        return rents;
    }

    // setters
    public void SetRents(List<Rent> rents) {
        this.rents = rents;
    }
}
