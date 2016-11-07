package com.blog.bean;

import com.blog.util.DBUtil;
import com.blog.util.MockupDBUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class AuthorizationBean implements Serializable {

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    private String login;
    private String password;

    /*
    * AUTHORIZATION
    * Get user by login, password.
    * TODO: Output exception message.
    * */
    public String authorization() {
        try {
//            sessionBean.setCurrentUser(MockupDBUtil.getUser(login, password));
            sessionBean.setCurrentUser(DBUtil.getUser(login, password));
            System.out.println("# user " + sessionBean.getCurrentUser().getLogin());
        } catch (Exception e) {
            System.out.println("### Exception: " + e.getMessage());
            return "fail";
        }
        login = password = "";
        return "success";
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
