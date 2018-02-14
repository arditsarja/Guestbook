package guest;
 
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class GuestController {
 
    @Autowired
    private GuestDao guestDao;
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value="/guest")
    public ModelAndView guestbooksdf(HttpServletRequest request) {
        // Handle a new guest (if any):
        String name = request.getParameter("name");
        if (name != null)
            guestDao.persist(new Guest(name));

        ModelAndView modelAndView = new ModelAndView("guest.jsp", "guestDao", guestDao);

        modelAndView.addObject("studentDao",studentRepository);
        // Prepare the result view (guest.jsp):
        return modelAndView;
    }

    @RequestMapping(value="/student")
    public ModelAndView guestboosaasdfak(HttpServletRequest request) {
        // Handle a new guest (if any):
        String name = request.getParameter("name");
        if (name != null)
            studentRepository.save(new Student(name));

        ModelAndView modelAndView = new ModelAndView("guest.jsp", "guestDao", guestDao);

        modelAndView.addObject("studentDao",studentRepository);
        // Prepare the result view (guest.jsp):
        return modelAndView;
    }

    @RequestMapping(value="/save")
    @ResponseBody
    public String guestbooku(HttpServletRequest request) {
        // Handle a new guest (if any):
        // Prepare the result view (guest.jsp):
        return studentRepository.save(new Student("ardit")).toString();
    }
}