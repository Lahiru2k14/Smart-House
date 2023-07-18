import javax.swing.*;
import java.awt.*;

class DisplayTVLRoom extends JFrame {
    private JLabel tvlLabel;
    private JLabel wdlLabel2;

    DisplayTVLRoom() {
        setSize(250, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Tv - Living");

        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setVisible(true);
        getContentPane().setBackground(new Color(136, 191, 143));

        tvlLabel = new JLabel("OFF");
        tvlLabel.setHorizontalAlignment(JLabel.CENTER);
        tvlLabel.setFont(new Font("Cooper Black", 3, 25));

        add("Center",tvlLabel);

        wdlLabel2 = new JLabel("TV - Living Room");
        wdlLabel2.setHorizontalAlignment(JLabel.CENTER);
        wdlLabel2.setFont(new Font("Arial Rounded MT Bold", 1, 18));

        add( "North",wdlLabel2);
    }

    public void update(String switchAction) {

        tvlLabel.setText(switchAction);
    }




}





