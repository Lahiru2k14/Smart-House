import javax.swing.*;
import java.awt.*;

class DisplayTVDRoom extends JFrame implements SwitchActionObserver{
    private JLabel tvdLabel;
    DisplayTVDRoom () {
        setSize(300, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("TV Two");
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setVisible(true);

        tvdLabel = new JLabel("OFF");
        tvdLabel.setFont(new Font("", 1, 25));

        add( tvdLabel);
    }
    public void update (String switchAction){
        tvdLabel.setText(switchAction);

    }
}