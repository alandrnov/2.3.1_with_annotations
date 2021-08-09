package spring_mvc_nibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring_mvc_nibernate.entity.User;
import spring_mvc_nibernate.service.UserService;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String showAllUsers(Model model){

      List<User> allUsers = userService.getAllUsers();
      model.addAttribute("allUs",allUsers);

        return "all-users";
    }
    @RequestMapping("/addnewuser")
    public String addNewUser(Model model) {

        User user = new User();
        model.addAttribute("user",user);

        return "user-info";
    }

    @RequestMapping("saveUser")
    public String saveUser(@ModelAttribute("user") User user){

        userService.saveUser(user);

        return "redirect:/";
    }
    @RequestMapping("/updateInfo")
    public String updateUser(@RequestParam("usId") int id, Model model){

        User user = userService.getUser(id);
        model.addAttribute("user",user);

        return "user-info";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("usId") int id){
        userService.deleteUser(id);

        return "redirect:/";
    }
}
