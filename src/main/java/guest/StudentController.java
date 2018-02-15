package guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import util.CustomErrorType;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentRepository repository;

    @RequestMapping(value = "/save")
    @ResponseBody
    public String guestbooku() {
        // Handle a new guest (if any):
        // Prepare the result view (guest.jsp):
        return repository.save(new Student("ardit")).toString();
    }

//    @RequestMapping(value = "/all")
//    @ResponseBody
//    public String getAllStudents() {
//        // Handle a new guest (if any):
//        // Prepare the result view (guest.jsp):
//        return repository.getAll().toString();
//    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> listAllUsers() {
        List<Student> students = repository.getAll();
        if (students.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
    }
    @RequestMapping(value = "/get/{id}")
    @ResponseBody
    public String getByID(@PathVariable("id") Long id) {
        // Handle a new guest (if any):
        // Prepare the result view (guest.jsp):
        return repository.findById(id).toString();
    }

    @RequestMapping(value = "/hello")
    public String openhellopage() {
        // Handle a new guest (if any):
        // Prepare the result view (guest.jsp):
        return "hello.jsp";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<Student> getUser(@PathVariable("id") long id) {

        Student user = repository.findById(id);
        ResponseEntity<Student> json;
        if (user == null) {
            json = new ResponseEntity(new CustomErrorType("User with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        } else
            json = new ResponseEntity<Student>(user, HttpStatus.OK);
        return json;
    }
}