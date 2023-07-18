import javax.swing.*;
import java.awt.*;

class DisplayTVDRoom extends JFrame implements SwitchActionObserver{
    private JLabel tvdLabel;
    private JLabel wdlLabel2;
    DisplayTVDRoom () {
        setSize(250, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("TV - Dining ");

        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setVisible(true);
        getContentPane().setBackground(new Color(136, 191, 143));

        tvdLabel = new JLabel("OFF");
        tvdLabel.setHorizontalAlignment(JLabel.CENTER);
        tvdLabel.setFont(new Font("Cooper Black", 3, 25));

        add( "Center",tvdLabel);

        wdlLabel2 = new JLabel("TV - Dining Room");
        wdlLabel2.setHorizontalAlignment(JLabel.CENTER);
        wdlLabel2.setFont(new Font("Arial Rounded MT Bold", 1, 18));

        add( "North",wdlLabel2);
    }
    public void update (String switchAction){
        tvdLabel.setText(switchAction);

    }
}