/**
 * User
 */
public abstract class User {
    private int userId;
    private String name;
    private String email;
    private String password;
    private UserRole role; // data type? -> it's an enum
    private boolean active;

    User(){
        
    }
    
    User(int userId, String name, String email, String password, UserRole role, boolean active){
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.active = active;
    }

    // getters for the private variables

    String getProfile(){ // should this be made abstract? Make if they are unique to each type of user. your !DECISION
        System.out.println(this.userId);
        System.out.println(this.name);
        System.out.println(this.email);
        System.out.println(this.password);
        System.out.println(this.role);
        System.out.println(this.active);
        return "0";
    }

    void updateProfile(){}

    void changePassword(String newPassword){}
	
}