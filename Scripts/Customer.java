package Scripts;

public final class Customer extends User{
    private String adress;

    Customer(String name, String phoneNumber) {
        super(name, phoneNumber);
    }

    Customer(String name, String phoneNumber, String adress) {
        super(name, phoneNumber);
        this.adress = adress;
    }

    // getters
    public String getAdress() {
        return adress;
    }

    // setters
    public void setAdress(String adress) {
        this.adress = adress;
    }
}
