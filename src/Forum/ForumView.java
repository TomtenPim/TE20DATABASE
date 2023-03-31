package Forum;

import com.sun.org.apache.regexp.internal.RE;

import javax.swing.*;
import java.awt.*;

public class ForumView {
    private JButton loginButton;
    private JButton forumButton1;
    private JButton newButton;
    private JButton homeButton;
    private JButton errorButton;
    private JButton registerButton;
    private JTextArea textArea1;
    private JPanel ForumView;

    public JButton getLoginButton(){
        return loginButton;
    }

    public JButton getForumButton1(){
        return forumButton1;
    }

    public JButton getNewButton(){
        return newButton;
    }

    public JButton getHomeButton(){
        return homeButton;
    }

    public JButton getErrorButton(){
        return errorButton;
    }

    public JButton getRegisterButton(){
        return registerButton;
    }

    public void setTextArea1(JTextArea textArea1) {
        this.textArea1 = textArea1;
    }

    public Container getForumView() {
        return ForumView;
    }
}
