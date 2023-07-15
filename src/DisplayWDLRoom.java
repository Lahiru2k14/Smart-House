import javax.swing.*;
import java.awt.*;

class DisplayWDLRoom extends JFrame implements SwitchActionObserver{
    private JLabel wdlLabel;
    DisplayWDLRoom () {
        setSize(300, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Window");
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setVisible(true);

        wdlLabel = new JLabel("OFF");
        wdlLabel.setFont(new Font("", 1, 25));

        add( wdlLabel);
    }
    public void update (String switchAction){
        wdlLabel.setText(switchAction);

    }
}