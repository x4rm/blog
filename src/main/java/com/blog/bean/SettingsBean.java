package com.blog.bean;

import com.blog.util.MockupDBUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SettingsBean {

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    /* Save user */
    public String saveUser() {
        /* TODO: Show message after save */
        try {
            MockupDBUtil.saveUser(sessionBean.getCurrentUser());
        } catch (Exception e) {
            return "fail";
        }
        return "success";
    }

    /* Delete user */
    public String deleteUser() {
        /* TODO: Redirect after delete */
        /* TODO: Show message after delete */
        MockupDBUtil.deleteUser(sessionBean.getCurrentUser());
        return "success";
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
}
