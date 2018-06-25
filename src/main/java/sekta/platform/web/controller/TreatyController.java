package sekta.platform.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sekta.platform.core.entity.Treaty;
import sekta.platform.core.entity.User;
import sekta.platform.core.service.TreatyService;
import sekta.platform.core.service.UserService;

import java.time.LocalDate;

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

        System.out.println("TREATY");
        return "treaty/treaty-list";
    }

    /*@RequestMapping(value = "create", method = RequestMethod.POST)
    public String createTreaty(@RequestParam("userId") Long userId,
                              @RequestParam("treaty") String treatyValue,
                              RedirectAttributes redirectAttributes){
        Treaty treaty = new Treaty();

        User user = new User();
        user.setUserId(userId);
        treaty.setUser(user);

        treaty.setTreaty(treatyValue);
        treaty.setDate(LocalDate.now());
        treatyService.createTreaty(treaty);
        redirectAttributes.addFlashAttribute("message", "Treaty successfully added!");
        return "redirect:/treaty";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") Long id, RedirectAttributes redirectAttributes){
        treatyService.deleteTreaty(id);
        redirectAttributes.addFlashAttribute("message", "Treaty successfully deleted!");
        return "redirect:/treaty";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String editUser(@PathVariable("id") Long id, ModelMap model){
        Treaty treaty = treatyService.getTreatyById(id);
        model.addAttribute(treaty);
        return "treaty/treaty-edit";
    }

    @RequestMapping(value = "treaty", method = RequestMethod.POST)
    public String updateTreaty(@RequestParam("id") Long id,
                              @RequestParam("treaty") String treatyValue,
                              RedirectAttributes redirectAttributes){
        Treaty treaty= treatyService.getTreatyById(id);

        treaty.setTreaty(treatyValue);
        treatyService.updateTreaty(treaty);
        redirectAttributes.addFlashAttribute("message", "Treaty successfully edited!");
        return "redirect:/treaty";
    }*/
}
