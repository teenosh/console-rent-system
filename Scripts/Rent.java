package Scripts;

public final class Rent{
    private User provider;
    private User customer;
    private float rentTime;
    private String status; // Canceled, Pending, Ended
    private int rentId;
    private static int id_gen = 1;

    Rent(){
        rentId = id_gen++;
    }

    Rent(User provider, User customer, float rentTime, String status){
        this();
        this.provider = provider;
        this.customer = customer;
        this.rentTime = rentTime;
        this.status = status;
    }


    public void ExtendTime(float amount){
        rentTime += amount;
    }

    // setters

    public void SetProvider(User provider){
        this.provider = provider;
    }

    public void SetRenter(User customer){
        this.customer = customer;
    }

    public void SetRentTime(float rentTime){
        this.rentTime = rentTime;
    }

    public void SetStatus(String status){
        this.status = status;
    }


    // getters
    public User GetProvider(){
        return provider;
    }

    public User GetRCustomer(){
        return customer;
    }

    public float GetRentTime(){
        return rentTime;
    }

    public String GetStatus(){
        return status;
    }

}