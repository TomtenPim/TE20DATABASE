package Forum;

import javax.swing.*;

public class ForumControler {
    private ForumModel m;
    private ForumView v;

    public ForumControler(ForumModel m, ForumView v){
        JFrame frame = new JFrame("ViewClient");
        frame.setContentPane(v.getForumView());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog(null,"Enter name here");
        ForumControler c = new ForumControler(new ForumModel(), new ForumView());
    }
}
