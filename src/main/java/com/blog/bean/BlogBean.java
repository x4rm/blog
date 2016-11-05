package com.blog.bean;

import com.blog.model.Message;
import com.blog.util.MockupDBUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;

@ManagedBean
@SessionScoped
public class BlogBean {

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    /*
    * GET USER MESSAGES
    * Get message history.
    * TODO: Optimize getMessages().isEmpty() situation.
    * */
    public ArrayList<Message> getUserMessages() {
//        if (sessionBean.getCurrentUser().getMessages().isEmpty()) {
//            sessionBean.getCurrentUser().setMessages();
//        }
//        return sessionBean.getCurrentUser().getMessages();

        return MockupDBUtil.getUserMessages(sessionBean.getCurrentUser());
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

}
