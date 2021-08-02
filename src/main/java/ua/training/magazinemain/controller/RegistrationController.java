package ua.training.magazinemain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import ua.training.magazinemain.dto.UserDTO;
import ua.training.magazinemain.service.IUserService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private IUserService userService;

    public RegistrationController(IUserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserDTO userDTO(Model model){

        return new UserDTO();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserDTO userDTO){
        userService.registerNewUserAccount(userDTO);
        return "redirect:/registration?success";
    }
}
