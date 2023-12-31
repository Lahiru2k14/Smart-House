import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Objects;

public class TVLRoomController extends JFrame {
    private JList list = null;
    private DefaultListModel lm = null;
    public ArrayList<AddTime> addTimeList;
    int selectedIndex=-1;

    TVLRoomController() {
        addTimeList = DisplaySwitch.addControllerTimeList ;
        setSize(650, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("TV Living Room");
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel controller1ListPenal = new JPanel();
        controller1ListPenal.setLayout(new GridLayout());

        addTimeList = TimeController.getTime();

        JPanel controller1TimePenal = new JPanel();

        controller1TimePenal.setLayout(new FlowLayout());

        //-------------------------------------------------------------------------------//

        JLabel controller1StartHourLbl = new JLabel("Start Hour:");
        controller1StartHourLbl.setFont(new Font("", 1, 15));

        SpinnerModel startHourValue = new SpinnerNumberModel(00, //initial value
                00, //minimum value
                24, //maximum value
                1); //step
        JSpinner controller1StartHourSpinner = new JSpinner(startHourValue);
        controller1StartHourSpinner.setBounds(10, 100, 20, 10);
        controller1StartHourSpinner.setEditor(
                new JSpinner.NumberEditor(controller1StartHourSpinner, "00"));
        controller1StartHourSpinner.setFont(new Font("", 1, 15));

        JLabel controller1StartMinuteLbl = new JLabel("Start Minute:");
        controller1StartMinuteLbl.setFont(new Font("", 1, 15));

        SpinnerModel startMinuteValue = new SpinnerNumberModel(00, //initial value
                00, //minimum value
                60, //maximum value
                1); //step
        JSpinner controller1StartMinuteSpinner = new JSpinner(startMinuteValue);
        controller1StartMinuteSpinner.setBounds(100, 100, 20, 10);
        controller1StartMinuteSpinner.setEditor(
                new JSpinner.NumberEditor(controller1StartMinuteSpinner, "00"));
        controller1StartMinuteSpinner.setFont(new Font("", 1, 15));

        //---------------------------------------------------------------------------------------//

        JLabel controller1EndHourLbl = new JLabel("End Hour:");
        controller1EndHourLbl.setFont(new Font("", 1, 15));

        SpinnerModel endHourValue = new SpinnerNumberModel(00, //initial value
                00, //minimum value
                24, //maximum value
                1); //step
        JSpinner controller1EndHourSpinner = new JSpinner(endHourValue);
        controller1EndHourSpinner.setBounds(100, 100, 20, 10);
        controller1EndHourSpinner.setEditor(
                new JSpinner.NumberEditor(controller1EndHourSpinner, "00"));
        controller1EndHourSpinner.setFont(new Font("", 1, 15));

        JLabel controller1EndHourMinuteLbl = new JLabel("Minute:");
        controller1EndHourMinuteLbl.setFont(new Font("", 1, 15));

        SpinnerModel endMinuteValue =
                new SpinnerNumberModel(00, //initial value
                        00, //minimum value
                        60, //maximum value
                        1); //step
        JSpinner controller1EndMinuteSpinner = new JSpinner(endMinuteValue);
        controller1EndMinuteSpinner.setBounds(100, 100, 20, 10);
        controller1EndMinuteSpinner.setEditor(
                new JSpinner.NumberEditor(controller1EndMinuteSpinner, "00"));
        controller1EndMinuteSpinner.setFont(new Font("", 1, 15));

        //---------------------------------------------------------------------------------------//

        JToggleButton controller1SetBtn = new JToggleButton("Set");

        controller1SetBtn.setFont(new Font("", 1, 15));
        controller1SetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ssp1 = (int) controller1StartHourSpinner.getValue();
                int ssp2 = (int) controller1StartMinuteSpinner.getValue();
                int esp1 = (int) controller1EndHourSpinner.getValue();
                int esp2 = (int) controller1EndMinuteSpinner.getValue();

                AddTime addTime = new AddTime(ssp1, ssp2, esp1, esp2);

                String x1 = String.format("%02d", ssp1);
                String x2 = String.format("%02d", ssp2);
                String x3 = String.format("%02d", esp1);
                String x4 = String.format("%02d", esp2);

                String row = "Start at : " + x1 + "." + x2 + " " + "Ends at :" + x3 + "." + x4;

                if (Objects.equals(controller1SetBtn.getText(), "Set")) {

                    TimeController.addTime(addTime);

                    if (addTimeList.isEmpty()) {
                        lm.clear();
                    }

                    lm.addElement(row);

                } else {

                    addTimeList.set(selectedIndex, addTime);

                    lm.set(selectedIndex,row);

                    controller1SetBtn.setText("Set");

                }
            }

        });

        int a, b, c, d;

        lm = new DefaultListModel();


            for (AddTime i : addTimeList) {
                a = i.getStartHour();
                b = i.getStartMinute();
                c = i.getEndHour();
                d = i.getEndMinute();

                String y1 = String.format("%02d", a);
                String y2 = String.format("%02d", b);
                String y3 = String.format("%02d", c);
                String y4 = String.format("%02d", d);

                String row = "Start at : " + y1 + "." + y2 + " " + "Ends at :" + y3 + "." + y4;

                lm.addElement(row);

            }

        list = new JList(lm);
            list.setFont(new Font("",1,17));
            list.setBackground(new Color(136, 191, 143));


        //---------------------------------------------------------------------------------------//
        list.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

                    controller1SetBtn.setText("Edit");

                    selectedIndex = list.getSelectedIndex();

                    int t1 = DBConnection.getInstance().getStartTime().get(selectedIndex).getStartHour();
                    int t2 = DBConnection.getInstance().getStartTime().get(selectedIndex).getStartMinute();

                    int t3 = DBConnection.getInstance().getStartTime().get(selectedIndex).getEndHour();
                    int t4 = DBConnection.getInstance().getStartTime().get(selectedIndex).getEndMinute();

                    controller1StartHourSpinner.setValue(t1);
                    controller1StartMinuteSpinner.setValue(t2);
                    controller1EndHourSpinner.setValue(t3);
                    controller1EndMinuteSpinner.setValue(t4);


            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        controller1TimePenal.add(controller1StartHourLbl);
        controller1TimePenal.add(controller1StartHourSpinner);
        controller1TimePenal.add(controller1StartMinuteLbl);
        controller1TimePenal.add(controller1StartMinuteSpinner);

        controller1TimePenal.add(controller1EndHourLbl);
        controller1TimePenal.add(controller1EndHourSpinner);
        controller1TimePenal.add(controller1EndHourMinuteLbl);
        controller1TimePenal.add(controller1EndMinuteSpinner);

        controller1TimePenal.add(controller1SetBtn);

        controller1ListPenal.add(new JScrollPane(list), BorderLayout.CENTER);

        add("Center", controller1ListPenal);
        add("South", controller1TimePenal);

    }
}
