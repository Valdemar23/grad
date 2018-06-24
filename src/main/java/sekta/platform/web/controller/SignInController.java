package sekta.platform.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import sekta.platform.core.entity.User;
import sekta.platform.core.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.util.List;

@Controller
@RequestMapping("login")
public class SignInController {
    @Autowired
    private UserService us;

    @RequestMapping(value="")
    public String showAll(@ModelAttribute("user") User userWantLogin) throws FileNotFoundException {//цей метод в мене для входу
        List<User> users=us.getAllUsers();//цим рядком ми отримуємо користувачів

        for(User user:users){
            System.out.println(user.getUserName());
            if(user.getUserName().equals(userWantLogin.getUserName()) && user.getPassword().equals(userWantLogin.getPassword())){
                if(user.isFlag())return "main";
                return "login/login-true";
            }
        }
        return "login/login";
    }

    @RequestMapping(value="login-true")//даний метод я не використовував  method = RequestMethod.POST
    public String showAll(ModelMap model){
        //model.addAttribute("login");

        return "login/login-true";
    }


    /*@RequestMapping(value="/login", method = RequestMethod.GET)//даний метод я не використовував
    public String login(@ModelAttribute List<User> users, RedirectAttributes redirectAttributes) {

        //Criteria criteriaDescription = us.getAllUsers();
        users=us.getAllUsers();
        for(User user:users) System.out.println(user.getUserName());
        return "login";
    }*/

    /*@RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("loginRequest") LoginRequest loginRequest, HttpServletRequest request) {
        if (loginService.login(loginRequest.getUsername(), loginRequest.getPassword(), request)) {
            return "redirect:/interface";
        }
        return "login";
    }*/
}

