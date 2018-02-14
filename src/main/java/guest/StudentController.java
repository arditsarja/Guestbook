package guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentRepository repository;
    @RequestMapping(value="/save")
    @ResponseBody
    public String guestbooku() {
        // Handle a new guest (if any):
        // Prepare the result view (guest.jsp):
        return repository.save(new Student("ardit")).toString();
    }
    @RequestMapping(value="/all")
    @ResponseBody
    public String getAllStudents() {
        // Handle a new guest (if any):
        // Prepare the result view (guest.jsp):
        return repository.getAll().toString();
    }
    @RequestMapping(value="/get/{id}")
    @ResponseBody
    public String getByID(@PathVariable("id") Long id) {
        // Handle a new guest (if any):
        // Prepare the result view (guest.jsp):
        return repository.findById(id).toString();
    }
}