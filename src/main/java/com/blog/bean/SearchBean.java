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

    public ArrayList<User> getUsers() {
        return MockupDBUtil.getUsers(sessionBean.getSearchingUser());
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
}
