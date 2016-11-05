package com.blog.bean;

import com.blog.model.User;
import com.blog.util.MockupDBUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class RegistrationBean {

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    private User user = new User();

    /*
    * REGISTRATION
    * Save user.
    * TODO: Output exception message.
    * */
    public String registration() {
        try {
            MockupDBUtil.saveUser(user);
        } catch (Exception e) {
            System.out.println("### Exception: " + e.getMessage());
            return "fail";
        }
        user = new User();
        return "success";
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User newUser) {
        this.user = newUser;
    }

}
