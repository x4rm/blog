package com.blog.bean;

import com.blog.model.User;
import com.blog.util.MockupDBUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;

@ManagedBean
@SessionScoped
public class SearchBean {

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    /*
    * GET USERS
    * TODO: Output exception and result message.
    * */
    public String search() {
        try {
            sessionBean.setSearchResults(MockupDBUtil.getUsers(sessionBean.getSearchingUser()));
            return "success";
        } catch (Exception e) {
            sessionBean.setSearchResults(new ArrayList<User>());
            System.out.println("### Exception: " + e.getMessage());
            return "fail";
        }
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
}
