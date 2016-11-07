package com.blog.bean;

import com.blog.model.User;
import com.blog.util.DBUtil;
import com.blog.util.MockupDBUtil;
import org.hibernate.criterion.Restrictions;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.HashSet;

@ManagedBean
@SessionScoped
public class SearchBean {

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    /* PropertyActionListener */
    private String selectedUserLogin;

    public void setSelectedUserLogin(String selectedUserLogin) {
        this.selectedUserLogin = selectedUserLogin;
    }


    /* SET - LIST */


    /*
        * GET USERS
        * TODO: Output exception and result message.
        * TODO: Get all.
        * */
    public String search() {
        try {
//            sessionBean.setSearchResults(MockupDBUtil.getUsers(sessionBean.getSearchingUser()));

            if (sessionBean.getSearchingUser().getName() != null && !"".equals(sessionBean.getSearchingUser().getName()) &&
                sessionBean.getSearchingUser().getAge() != null &&
                sessionBean.getSearchingUser().getGender() != null &&
                sessionBean.getSearchingUser().getCity() != null && !"".equals(sessionBean.getSearchingUser().getCity())) {

                sessionBean.setSearchResults(DBUtil.getAllUsers());

            } else {
                sessionBean.setSearchResults(DBUtil.getUsersByCriteria(sessionBean.getSearchingUser()));
            }
            return "success";
        } catch (Exception e) {
            sessionBean.setSearchResults(new ArrayList<User>());
//            sessionBean.setSearchResults(new HashSet<User>());
            System.out.println("### Exception: " + e.getMessage());
            return "fail";
        }
    }

    /*
    * USER VIEW
    * Redirect to selected user page.
    * */
    public String view() {
        for (User user : sessionBean.getSearchResults()) {
            if (user.getLogin().equals(selectedUserLogin)) {
                sessionBean.setSelectedUser(user);
                System.out.println("### " + user.getName());
            }
        }
        return "success";
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
}
