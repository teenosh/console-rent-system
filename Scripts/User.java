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
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


    // gettters
    public String getName(){
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // setters
    public void setName(String name){
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
