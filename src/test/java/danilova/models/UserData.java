package danilova.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserData {
    String userName;
    String password;
    String confirmPassword;
    String fullName;
    String email;
}
