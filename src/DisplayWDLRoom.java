import javax.swing.*;
import java.awt.*;

class DisplayWDLRoom extends JFrame implements SwitchActionObserver{
    private JLabel wdlLabel;
    private JLabel wdlLabel2;

    DisplayWDLRoom () {
        setSize(250, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Window - Living");

        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setVisible(true);
        getContentPane().setBackground(new Color(136, 191, 143));

        wdlLabel = new JLabel("OFF");
        wdlLabel.setHorizontalAlignment(JLabel.CENTER);
        wdlLabel.setFont(new Font("Cooper Black", 3, 25));

        add( "Center",wdlLabel);

        wdlLabel2 = new JLabel("Window - Living Room");
        wdlLabel2.setHorizontalAlignment(JLabel.CENTER);
        wdlLabel2.setFont(new Font("Arial Rounded MT Bold", 1, 18));

        add( "North",wdlLabel2);

    }
    public void update (String switchAction){
        wdlLabel.setText(switchAction);

    }
}