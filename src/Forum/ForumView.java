package Forum;

import javax.swing.*;
import java.awt.*;

public class ForumView {
    private JButton loginButton;
    private JButton profileButton;
    private JButton newButton;
    private JButton homeButton;
    private JButton errorButton;
    private JButton registerButton;
    private JTextArea textArea;
    private JPanel forumView;

    public JButton getLoginButton(){
        return loginButton;
    }

    public JButton getProfileButton(){
        return profileButton;
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

    public void setTextArea1(JTextArea textArea) {
        this.textArea = textArea;
    }

    public Container getForumView() {
        return forumView;
    }
}
