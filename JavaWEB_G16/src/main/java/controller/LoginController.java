package controller;

import domain.Coursemember;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.CoursememberDao;

/**
 *
 * @author dylan
 */
@Controller
public class LoginController
{
     @Autowired
    private CoursememberDao coursememberDao;

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String printWelcome(Model model, Principal principal)
    {
        model.addAttribute("message", "Give a day peerassessment");
        model.addAttribute("username", coursememberDao.getByUsername(principal.getName()).getName());
        List<Coursemember> coursemembers = new ArrayList<>();
        Coursemember current = coursememberDao.getByUsername(principal.getName());
        coursemembers.add(new Coursemember("Student1"));
        coursemembers.add(new Coursemember("Student2"));
        coursemembers.add(new Coursemember("Student3"));
        coursemembers.add(new Coursemember("Student4"));

        coursemembers = current.getGbGroep().getCoursemembers();
        model.addAttribute("gbgroup", current.getGbGroep().getName());
        String text = "";
      
         for (Coursemember c : coursemembers)
         {
             text += "<li>" + c.getName() + "</li>";
         }
        model.addAttribute("coursemembers", String.format("<ul>%s</ul>", text));
        return "hello";
    }

    @RequestMapping(value = "/login")
    public String login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout, Model model)
    {

        if (error != null)
        {
            model.addAttribute("error", "Ongeldige inloggegevens!");
        }
        if (logout != null)
        {
            model.addAttribute("msg", "You've been logged out successfully.");
        }
        return "login";
    }

}