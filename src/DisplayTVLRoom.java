import javax.swing.*;
import java.awt.*;

class DisplayTVLRoom extends JFrame {
    private JLabel tvlLabel;

    DisplayTVLRoom() {
        setSize(300, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Tv One");
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setVisible(true);

        tvlLabel = new JLabel("OFF");
        tvlLabel.setFont(new Font("", 1, 25));

        add(tvlLabel);
    }

    public void update(String switchAction) {

        tvlLabel.setText(switchAction);
    }




}





