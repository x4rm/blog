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

    /*
    * SAVE USER
    * TODO: Output exception and result message.
    * */
    public String saveUser() {
        try {
            MockupDBUtil.saveUser(sessionBean.getCurrentUser());
        } catch (Exception e) {
            System.out.println("### Exception: " + e.getMessage());
            return "fail";
        }
        return "success";
    }

    /*
    * DELETE USER
    * TODO: Redirect after delete.
    * TODO: Output exception and result message.
    * */
    public String deleteUser() {
        try {
            MockupDBUtil.deleteUser(sessionBean.getCurrentUser());
        } catch (Exception e) {
            System.out.println("### Exception: " + e.getMessage());
            return "fail";
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
