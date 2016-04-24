import javax.swing.*;

/**
 * Created by gunebakan on 24.04.2016.
 */
public class TeamSelectUi {


    private JPanel Panel1;
    private JButton button1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Takım Seçimi");
        frame.setContentPane(new TeamSelectUi().Panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
