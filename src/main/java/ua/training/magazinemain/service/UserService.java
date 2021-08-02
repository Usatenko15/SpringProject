package ua.training.magazinemain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.training.magazinemain.dto.UserDTO;
import ua.training.magazinemain.entity.RoleType;
import ua.training.magazinemain.entity.User;
import ua.training.magazinemain.repository.UserRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }


    @Override
    public User registerNewUserAccount(UserDTO userDto) throws UsernameNotFoundException {
        if (!emailExists(userDto.getEmail())) {
            throw new UsernameNotFoundException("There is an account with that email address: "
                    + userDto.getEmail());
        }

        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setRole(RoleType.ROLE_USER);

        return userRepository.save(user);
    }

    private boolean emailExists(String email) {
        return userRepository.findByEmail(email) != null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).get();
        if (user==null) {
            throw new UsernameNotFoundException("Invalid");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),mapRolesToAuthorities(Arrays.stream(RoleType.values()).collect(Collectors.toList())));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<RoleType> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.ROLE_USER.name())).collect(Collectors.toList());
    }
}
