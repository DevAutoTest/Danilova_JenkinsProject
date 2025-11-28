package danilova.models;

public class UsersFactory {
    public static final UserData VALID_USER1 = UserData.builder()
            .userName("User_1")
            .password("password")
            .confirmPassword("password")
            .fullName("User_1 full name")
            .email("User_1@email.com")
            .build();

    public static final UserData VALID_USER2 = UserData.builder()
            .userName("2_User_2")
            .password("#123_PASSWORD+!%)password")
            .confirmPassword("#123_PASSWORD+!%)password")
            .fullName("2_User_2 full name")
            .email("2_User_2@email.com")
            .build();

    public static final UserData VALID_USER3 = UserData.builder()
            .userName("3_User_3")
            .password("&%#123_PASSWORD+!%)password")
            .confirmPassword("&%#123_PASSWORD+!%)password")
            .fullName("3_User_3full name")
            .email("3_User_3@email.com")
            .build();

    public static final UserData VALID_USER4 = UserData.builder()
            .userName("1000000000000000000000_User_4")
            .password("@&%#123_PASSWORD+!%)password_")
            .confirmPassword("@&%#123_PASSWORD+!%)password_")
            .fullName("4_User_4full name")
            .email("4_User_4@email.com")
            .build();

    public static final UserData VALID_USER5 = UserData.builder()
            .userName("000000000000000000000_User_5")
            .password("~@&%#123_PASSWORD+!%)password_")
            .confirmPassword("~@&%#123_PASSWORD+!%)password_")
            .fullName("5_User_5full name")
            .email("5_User_5@email.com")
            .build();

    public static final UserData VALID_USER6 = UserData.builder()
            .userName("_User_6")
            .password("~^^@&%#123_PASSWORD+!%)password_")
            .confirmPassword("~^^@&%#123_PASSWORD+!%)password_")
            .fullName("6_User_6full name")
            .email("6_User_6@email.com")
            .build();

    public static final UserData VALID_USER7 = UserData.builder()
            .userName("_____User_7")
            .password("+~^^@&%#123_PASSWORD+!%)password_")
            .confirmPassword("+~^^@&%#123_PASSWORD+!%)password_")
            .fullName("7_User_7full name")
            .email("7_User_7@email.com")
            .build();

    public static final UserData VALID_USER8 = UserData.builder()
            .userName("userUser_8")
            .password("=_*/?+~^^@&%#123_PASSWORD+!%)password_")
            .confirmPassword("=_*/?+~^^@&%#123_PASSWORD+!%)password_")
            .fullName("8_User_8full name")
            .email("8_User_8@email.com")
            .build();

    public static final UserData VALID_USER9 = UserData.builder()
            .userName("user_9")
            .password("=_   */?+~^^@&%#123_PASSWORD+!%)password_")
            .confirmPassword("=_   */?+~^^@&%#123_PASSWORD+!%)password_")
            .fullName("9_User_9full name")
            .email("9_User_9@email.com")
            .build();

    public static final UserData VALID_USER10 = UserData.builder()
            .userName("User_10")
            .password("ъ=_   */?+~^^@&%#123_PASSWORD+!%)password_")
            .confirmPassword("ъ=_   */?+~^^@&%#123_PASSWORD+!%)password_")
            .fullName("10_User_10full name")
            .email("10_User_10@email.com")
            .build();

    public static final UserData INVALID_USER_NAME = UserData.builder()
            .userName("User&")
            .password("password")
            .confirmPassword("password")
            .email("User_1@email.com")
            .build();
}
