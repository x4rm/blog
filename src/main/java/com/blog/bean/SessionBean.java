package com.blog.bean;

import com.blog.model.User;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@ManagedBean
@SessionScoped
public class SessionBean {

    private User currentUser = new User();
    private User searchingUser = new User();
    private User selectedUser = new User();


    /* SET - LIST */

    private ArrayList<User> searchResults = new ArrayList<User>();
//    private Set<User> searchResults = new HashSet<User>();

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




    /* SET - LIST */

    public ArrayList<User> getSearchResults() {
//    public Set<User> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(ArrayList<User> searchResults) {
//    public void setSearchResults(Set<User> searchResults) {
        this.searchResults = searchResults;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }
}
