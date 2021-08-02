package ua.training.magazinemain.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDTO {
    private String firstName;
    private String lastName;
    private String password;
    private String matchingPassword;
    private String email;
}
