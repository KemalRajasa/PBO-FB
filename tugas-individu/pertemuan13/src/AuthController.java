public class AuthController {

    private User validUser;

    public AuthController() {
        validUser = new User("admin", "12345");
    }

    public boolean authenticate(String username, String password) {
        return username.equals(validUser.getUsername()) &&
                password.equals(validUser.getPassword());
    }
}