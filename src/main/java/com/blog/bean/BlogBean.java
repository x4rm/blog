package com.blog.bean;

import com.blog.model.Message;
import com.blog.model.User;
import com.blog.util.DBUtil;
import com.blog.util.MockupDBUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.*;

@ManagedBean
@SessionScoped
public class BlogBean {

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    private Message message = new Message();

    /*
    * GET USER MESSAGES
    * Get message history.
    * TODO: Synchronization page-session-db problem.
    * TODO: Replace method.
    * */


    /* SET - LIST */

    /* TODO: if (user.getMessages().isEmpty()) */
    public List<Message> getUserMessages(User user) {
//    public Set<Message> getUserMessages(User user) {
        /*if (user.getMessages().isEmpty()) {
            user.setMessages(MockupDBUtil.getUserMessages(user));
        }*/
        if (user.getId() != null && user.getId() != 0) {
            user.setMessages(DBUtil.getUserMessages(user));
            return user.getMessages();
        } else {
            return new ArrayList<Message>();
        }
    }

    /*
    * PUBLISH MESSAGE
    * Add message to session.
    * TODO: "Save message to db" method.
    * TODO: Write formatter method.
    * */
    public String publishMessage() {
        if (message.getText() != null && !"".equals(message.getText())) {

            Calendar calendar = Calendar.getInstance();
            Formatter formatter = new Formatter();
            formatter.format("%tk:%tM %te.%tm.%tY", calendar, calendar, calendar, calendar, calendar);

            message.setId(1);
            message.setDate(calendar);
            message.setReadableTimeForm(formatter.toString());
            message.setUser(sessionBean.getCurrentUser());

            sessionBean.getCurrentUser().getMessages().add(message);

            DBUtil.addMessage(sessionBean.getCurrentUser(), message);

            message = new Message();
            return "success";
        } else {
            return "fail";
        }
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
