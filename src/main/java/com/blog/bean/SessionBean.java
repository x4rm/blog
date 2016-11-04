package com.blog.bean;

import com.blog.model.User;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SessionBean {

    private User currentUser = new User();
    private User searchingUser = new User();

    @PostConstruct
    public void init() {
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getSearchingUser() {
        return searchingUser;
    }

    public void setSearchingUser(User searchingUser) {
        this.searchingUser = searchingUser;
    }
}
