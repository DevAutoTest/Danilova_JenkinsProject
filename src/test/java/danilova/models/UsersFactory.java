package danilova.models;

public class UsersFactory {
    public static final UserData VALID_USER = UserData.builder()
            .userName("User_1")
            .password("password")
            .confirmPassword("password")
            .fullName("User_1 full name")
            .email("User_1@email.com")
            .build();

    public static final UserData INVALID_USER_NAME = UserData.builder()
            .userName("User&")
            .password("password")
            .confirmPassword("password")
            .email("User_1@email.com")
            .build();
}
