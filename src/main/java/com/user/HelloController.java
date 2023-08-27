package com.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes
public class HelloController {
    @Autowired
    UserDao userDao;

    /*It displays a form to input data, here "command" is a reserved request attribute
     *which is used to display object data into form
     */
    @RequestMapping("/userForm")
    public String showform(Model m){
        m.addAttribute("command", new UserData());
        return "hello_world";
    }

    @RequestMapping("/viewuser")
    public String viewemp(Model m){
        List<UserData> list=userDao.getUsers();
        m.addAttribute("list",list);
        return "viewUser";
    }

    /*It saves object into database. The @ModelAttribute puts request data
     *  into model object. You need to mention RequestMethod.POST method
     *  because default request is GET*/
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("userdata") UserData userData){
        userDao.save(userData);
        return "redirect:/userForm";
    }
    /* It displays object data into form for the given id.
     * The @PathVariable puts URL data into variable.*/
    @RequestMapping(value="/edituser/{id}")
    public String edit(@PathVariable int id, Model m){
        UserData user=UserDao.getUserById(id);
        m.addAttribute("command",user);
        return "userEdit";
    }

    /* It updates model object. */
    @RequestMapping(value="/editsave",method = RequestMethod.POST)
    public String editsave(@ModelAttribute("userdata") UserData userData){
        UserDao.update(userData);
        return "redirect:/viewuser";
    }

    /* It deletes record for the given id in URL and redirects to /viewemp */
    @RequestMapping(value="/deleteuser/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        UserDao.delete(id);
        return "redirect:/viewuser";
    }

}
