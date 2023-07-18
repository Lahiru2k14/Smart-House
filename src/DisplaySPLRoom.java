import javax.swing.*;
import java.awt.*;

class DisplaySPLRoom extends JFrame implements SwitchActionObserver{
    private JLabel splLabel;
    private JLabel wdlLabel2;
    DisplaySPLRoom() {
        setSize(250, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Speaker - Living");

        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setVisible(true);
        getContentPane().setBackground(new Color(136, 191, 143));

        splLabel = new JLabel("OFF");
        splLabel.setHorizontalAlignment(JLabel.CENTER);
        splLabel.setFont(new Font("Cooper Black", 3, 25));

        add("Center",splLabel);

        wdlLabel2 = new JLabel("Speaker - Living Room");
        wdlLabel2.setHorizontalAlignment(JLabel.CENTER);
        wdlLabel2.setFont(new Font("Arial Rounded MT Bold", 1, 18));

        add( "North",wdlLabel2);
    }
    public void update (String switchAction){
        splLabel.setText(switchAction);

    }
}
