package Scripts;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User{
    private String address;
    private List<Rent> rents = new ArrayList<Rent>();

    Customer(){
        super();
    }

    Customer(String name, String phoneNumber) {
        super(name, phoneNumber);
    }

    Customer(String name, String phoneNumber, String address) {
        super(name, phoneNumber);
        SetAddress(address);
    }

    Customer(String name, String phoneNumber, String address, List<Rent> rents) {
        super(name, phoneNumber);
        SetAddress(address);
        SetRents(rents);
    }

    public void AddRent(Rent rent) {
        rents.add(rent);
    }

    public void RemoveRent(Rent rent) {
        rents.remove(rent);
    }

    public void PrintRents() {
        for (Rent rent : rents) {
            rent.PrintInformation();
        }
    }

    @Override
    public void GetInformation() {
        System.out.println(this.GetId() + ": " + this.GetName() + " - " + this.GetPhoneNumber() + " - " + this.GetAddress());
    }

    // getters
    public List<Rent> GetRents() {
        return rents;
    }

    public String GetAddress() {
        return address;
    }

    // setters
    public void SetAddress(String address) {
        this.address = address;
    }

    public void SetRents(List<Rent> rents) {
        this.rents = rents;
    }
}
