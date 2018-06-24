package sekta.platform.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sekta.platform.core.entity.Grade;
import sekta.platform.core.service.GradeService;
import sekta.platform.core.service.UserService;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("report")
public class ReportController {
    @Autowired
    private GradeService gr;

    @RequestMapping(value="")
    public String showAll(){//цей метод в мене для входу


        List<Grade> grades=gr.getAllGrades();

        for(Grade grade: grades){
            LocalDate l=grade.getDate();
            if(grade.getDate().equals(grade.getDate())){
                System.out.println(true);
            }
        }
        return "";
    }

}
