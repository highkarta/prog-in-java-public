/**
 * Authenticatable
 */
public interface Authenticatable {
    boolean login(String email, String password);
    void logout();
}