package ua.training.magazinemain.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ua.training.magazinemain.dto.UserDTO;
import ua.training.magazinemain.entity.User;

public interface IUserService extends UserDetailsService {
    User registerNewUserAccount(UserDTO userDto) throws UsernameNotFoundException;
}
