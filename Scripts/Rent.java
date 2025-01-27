package Scripts

public final class Rent{
    private User provider;
    private User renter;
    private float rentTime;
    private String status; // Canceled, Pending, Ended
    private int rentId;
    private static int id_gen = 1;

    Rent(){
        rentId = id_gen++;
    }

    Rent(User provider, User renter, float rentId, String status){
        this();
        this.provider = provider;
        this.renter = renter;
        this.rentId = rentId;
        this.status = status;
    }



    // setters

    public void SetProvider(User provider){
        this.provider = provider;
    }

    public void SetRenter(User renter){
        this.renter = renter;
    }

    public void SetRentTime(float rentTime){
        this.rentTime = rentTime;
    }

    public void SetStatus(String status){
        this.status = status;
    }


    // getters
    public User SetProvider(){
        return provider;
    }

    public User SetRenter(){
        return renter;
    }

    public float SetRentTime(){
        return rentTime;
    }

    public String SetStatus(){
        return status;
    }

}