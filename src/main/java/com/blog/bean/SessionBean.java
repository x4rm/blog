package com.blog.bean;

import com.blog.model.User;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;

@ManagedBean
@SessionScoped
public class SessionBean {

    private User currentUser = new User();
    private User searchingUser = new User();
    private ArrayList<User> searchResults = new ArrayList<User>();

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

    public ArrayList<User> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(ArrayList<User> searchResults) {
        this.searchResults = searchResults;
    }
}
