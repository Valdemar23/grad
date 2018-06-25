package sekta.platform.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import sekta.platform.core.service.TreatyService;
import sekta.platform.core.service.UserService;

@Controller
@RequestMapping("treaty")
public class TreatyController {
    @Autowired
    private TreatyService treatyService;

    @Autowired
    private UserService userService;


    @RequestMapping("")
    public String showAll(ModelMap model){
        model.addAttribute("treaty", treatyService.getAllTreaty());
        model.addAttribute("users", userService.getAllUsers());
        return "treaty/treaty-list";
    }
}
