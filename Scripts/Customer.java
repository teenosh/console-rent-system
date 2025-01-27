package Scripts;

public final class Customer extends User{
    private String address;

    Customer(String name, String phoneNumber) {
        super(name, phoneNumber);
    }

    Customer(String name, String phoneNumber, String adress) {
        super(name, phoneNumber);
        this.address = adress;
    }

    // getters
    public String getAdress() {
        return address;
    }

    // setters
    public void setAdress(String adress) {
        this.address = adress;
    }
}
