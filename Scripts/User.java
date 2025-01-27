package Scripts;

public abstract class User {
    private String name;
    private String phoneNumber;
    private int id;
    private static int id_gen = 1;

    User(){
        this.id = id_gen;
    }

    // constructors
    User(String name, String phoneNumber){
        this();
        SetName(name);
        SetPhoneNumber(phoneNumber);
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
