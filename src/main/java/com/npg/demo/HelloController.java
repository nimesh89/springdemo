package com.npg.demo;

import com.npg.demo.model.User;
import com.npg.demo.request.model.UserRequestModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by nimesh on 1/31/16.
 */
@Controller
public class HelloController {
    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping(value = "/helloWorld", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public String helloWorld(@RequestBody UserRequestModel user, Model model) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User userdata = new User();
        userdata.setFirstName(user.getFirstName());
        userdata.setLastName(user.getLastName());
        session.save(userdata);
        session.getTransaction().commit();
        model.addAttribute("message", "Added User: " + userdata.getFirstName() + " " + userdata.getLastName() + ", Id: " + userdata.getId());
        return "helloWorld";
    }
}
