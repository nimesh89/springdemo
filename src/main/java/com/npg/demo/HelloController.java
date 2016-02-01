package com.npg.demo;

import com.npg.demo.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by nimesh on 1/31/16.
 */
@Controller
public class HelloController {
    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping("/helloWorld")
    public String helloWorld(Model model) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = new User();
        user.setFirstName("Nimesh");
        user.setLastName("Gunasekara");
        user.setCreateDate(new Date());
        session.save(user);
        session.getTransaction().commit();
        model.addAttribute("message", "Hello World!ssss");
        return "helloWorld";
    }
}
