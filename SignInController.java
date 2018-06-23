package sekta.platform.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sekta.platform.core.entity.User;
import sekta.platform.core.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

@Controller
@RequestMapping("login")
public class SignInController {
    @Autowired
    private UserService us;

    @RequestMapping("")
    @ResponseBody//повертає html
    public String showAll(@ModelAttribute("user") User userWantLogin,HttpServletRequest request,method = RequestMethod.POST) throws FileNotFoundException {//цей метод в мене для входу
        Scanner scanner = new Scanner(new File("src/main/webapp/WEB-INF/jsp/login/login.html"));
        String html = "";
        while (scanner.hasNextLine()) {
            html += scanner.nextLine();
        }
        List<User> users=us.getAllUsers();//цим рядком ми отримуємо користувачів

        for(User user:users){
            System.out.println(user.getUserName());
            if(user.getUserName().equals(userWantLogin.getUserName()) && user.getPassword().equals(userWantLogin.getPassword())){
                if(user.isFlag()==true)html="Your admin";
                else html="Your user";
                break;
            }
        }
        return html;
    }

    @RequestMapping("login-true")//даний метод я не використовував
    public String showAll(ModelMap model){

        model.addAttribute("login");

        return "login/login";
    }
    @RequestMapping(value="/login", method = RequestMethod.GET)//даний метод я не використовував
    public String login(@ModelAttribute List<User> users, RedirectAttributes redirectAttributes) {

        //Criteria criteriaDescription = us.getAllUsers();
        users=us.getAllUsers();
        for(User user:users) System.out.println(user.getUserName());
        return "login";
    }

    /*@RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("loginRequest") LoginRequest loginRequest, HttpServletRequest request) {
        if (loginService.login(loginRequest.getUsername(), loginRequest.getPassword(), request)) {
            return "redirect:/interface";
        }
        return "login";
    }*/
}

