import javax.swing.*;
import java.awt.*;

class DisplaySPLRoom extends JFrame implements SwitchActionObserver{
    private JLabel splLabel;
    DisplaySPLRoom() {
        setSize(300, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Speaker");
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setVisible(true);

        splLabel = new JLabel("OFF");
        splLabel.setFont(new Font("", 1, 25));

        add(splLabel);
    }
    public void update (String switchAction){
        splLabel.setText(switchAction);

    }
}
