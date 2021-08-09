package ua.training.magazinemain.dto;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import ua.training.magazinemain.entity.RoleType;
import ua.training.magazinemain.entity.User;

import java.util.Collection;
import java.util.List;

@Data
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
