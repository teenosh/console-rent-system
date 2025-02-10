package Scripts;

public abstract class User {
    private String name;
    private String phoneNumber;
    private int id;

    User(int id){
        this.id = id;
    }

    // constructors
    User(int id, String name, String phoneNumber){
        this(id);
        SetName(name);
        SetPhoneNumber(phoneNumber);
    }

    public String GetInformation(){
        return (this.GetId() + ": " + this.GetName() + " - " + this.GetPhoneNumber());
    }


    // gettters
    public String GetName(){
        return name;
    }

    public String GetPhoneNumber() {
        return phoneNumber;
    }

    public int GetId() {
        return id;
    }

    // setters
    public void SetName(String name){
        this.name = name;
    }

    public void SetPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
