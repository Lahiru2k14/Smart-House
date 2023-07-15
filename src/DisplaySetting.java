import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class DisplaySetting extends JFrame {

    DisplaySetting() {
        setSize(300, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Controller");
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel listPenal = new JPanel();
        listPenal.setLayout(new GridLayout());


        String Rooms[] = {"TV Living Room", "Speaker Living Room", "Window Living Room",
                "TV Dining Room"};


        JList list = new JList(Rooms);



        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 1) {

                    String data = "";
                    if (list.getSelectedIndex() != -1) {

                        switch (list.getSelectedIndex()) {
                            case 0: new TVLRoomController();break;
                            case 1: new SPLRoomController();break;
                            case 2: new WDLRoomController();break;
                            case 3: new AddTime.TVDRoomController();break;

                        }
                    }
                }
            }
        });

        list.setSize(300, 300);

        listPenal.add(list);
        add(listPenal);
    }
}
