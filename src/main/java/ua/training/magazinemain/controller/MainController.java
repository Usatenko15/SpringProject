package ua.training.magazinemain.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.training.magazinemain.entity.Magazine;
import ua.training.magazinemain.repository.MagazineRepository;

@Controller
public class MainController {
    @Autowired
    private MagazineRepository magazinesRepo;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

   // @GetMapping("/magazines")
    @RequestMapping("/magazines")
    public String showMagazines(Model model) {
        model.addAttribute("magazines",magazinesRepo.findAll());
        return "magazines";
    }

}
