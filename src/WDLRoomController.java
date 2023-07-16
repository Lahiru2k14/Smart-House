import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

class WDLRoomController extends JFrame {
    private JList list = null;
    DefaultListModel lm = null;
    public ArrayList<AddTime> addTimeList3;
    WDLRoomController() {
        addTimeList3 = DisplaySwitch.addControllerTimeList3 ;
        setSize(650, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Window Living Room");
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel controller3ListPenal = new JPanel();
        controller3ListPenal.setLayout(new GridLayout());

        addTimeList3 = TimeController.getTime3();

        JPanel controller3TimePenal = new JPanel();

        controller3TimePenal.setLayout(new FlowLayout());

        //-------------------------------------------------------------------------------//

        JLabel controller3StartHourLbl = new JLabel("Start Hour:");
        controller3StartHourLbl.setFont(new Font("", 1, 15));

        SpinnerModel startHourValue = new SpinnerNumberModel(00, //initial value
                00, //minimum value
                24, //maximum value
                1); //step
        JSpinner controller3StartHourSpinner = new JSpinner(startHourValue);
        controller3StartHourSpinner.setBounds(10, 100, 20, 10);
        controller3StartHourSpinner.setEditor(
                new JSpinner.NumberEditor(controller3StartHourSpinner, "00"));
        controller3StartHourSpinner.setFont(new Font("", 1, 15));

        JLabel controller3StartMinuteLbl = new JLabel("Start Minute:");
        controller3StartMinuteLbl.setFont(new Font("", 1, 15));

        SpinnerModel minuteValue = new SpinnerNumberModel(00, //initial value
                00, //minimum value
                60, //maximum value
                1); //step
        JSpinner controller3StartMinuteSpinner = new JSpinner(minuteValue);
        controller3StartMinuteSpinner.setBounds(100, 100, 20, 10);
        controller3StartMinuteSpinner.setEditor(
                new JSpinner.NumberEditor(controller3StartMinuteSpinner, "00"));
        controller3StartMinuteSpinner.setFont(new Font("", 1, 15));

        //---------------------------------------------------------------------------------------//

        JLabel controller3EndHourLbl = new JLabel("End Hour:");
        controller3EndHourLbl.setFont(new Font("", 1, 15));

        SpinnerModel endHourValue = new SpinnerNumberModel(00, //initial value
                00, //minimum value
                24, //maximum value
                1); //step
        JSpinner controller3EndHourSpinner = new JSpinner(endHourValue);
        controller3EndHourSpinner.setBounds(100, 100, 20, 10);
        controller3EndHourSpinner.setEditor(
                new JSpinner.NumberEditor(controller3EndHourSpinner, "00"));
        controller3EndHourSpinner.setFont(new Font("", 1, 15));

        JLabel controller3EndHourMinuteLbl = new JLabel("Minute:");
        controller3EndHourMinuteLbl.setFont(new Font("", 1, 15));

        SpinnerModel endMinuteValue =
                new SpinnerNumberModel(00, //initial value
                        00, //minimum value
                        60, //maximum value
                        1); //step
        JSpinner controller3EndMinuteSpinner = new JSpinner(endMinuteValue);
        controller3EndMinuteSpinner.setBounds(100, 100, 20, 10);
        controller3EndMinuteSpinner.setEditor(
                new JSpinner.NumberEditor(controller3EndMinuteSpinner, "00"));
        controller3EndMinuteSpinner.setFont(new Font("", 1, 15));

        //---------------------------------------------------------------------------------------//

        JButton controller3SetBtn = new JButton("Set");
        controller3SetBtn.setFont(new Font("", 1, 15));
        controller3SetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ssp1 = (int) controller3StartHourSpinner.getValue();
                int ssp2 = (int) controller3StartMinuteSpinner.getValue();
                int esp1 = (int) controller3EndHourSpinner.getValue();
                int esp2 = (int) controller3EndMinuteSpinner.getValue();

                AddTime addTime3 = new AddTime(ssp1, ssp2, esp1, esp2);

                TimeController.addTime3(addTime3);

                if (addTimeList3.isEmpty()) {
                    lm.clear();
                }

                String row = "Start at: " + ssp1 + "." + ssp2 + " " + "Ends at:" + esp1 + "." + esp2;

                lm.addElement(row);

            }
        });

        String a, b, c, d;

        lm = new DefaultListModel();

            for (AddTime i : addTimeList3) {
                a = String.valueOf(i.getStartHour());
                b = String.valueOf(i.getStartMinute());
                c = String.valueOf(i.getEndHour());
                d = String.valueOf(i.getEndMinute());

                String row = "Start at: " + a + "." + b + " " + "Ends at:" + c + "." + d;
                lm.addElement(row);

        }

        list = new JList(lm);

        //---------------------------------------------------------------------------------------//
        list.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                System.out.println("Clicked");

                controller3SetBtn.setText("Edit");

                int selectedIndex = list.getSelectedIndex();
                System.out.println(selectedIndex);

                int t1 = DBConnection.getInstance().getStartTime3().get(selectedIndex).getStartHour();
                int t2 = DBConnection.getInstance().getStartTime3().get(selectedIndex).getStartMinute();

                int t3 = DBConnection.getInstance().getStartTime3().get(selectedIndex).getEndHour();
                int t4 = DBConnection.getInstance().getStartTime3().get(selectedIndex).getEndMinute();

                controller3StartHourSpinner.setValue(t1);
                controller3StartMinuteSpinner.setValue(t2);
                controller3EndHourSpinner.setValue(t3);
                controller3EndMinuteSpinner.setValue(t4);

                System.out.println(t1);
                System.out.println(t2);
                System.out.println(t3);
                System.out.println(t4);
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

        controller3TimePenal.add(controller3StartHourLbl);
        controller3TimePenal.add(controller3StartHourSpinner);
        controller3TimePenal.add(controller3StartMinuteLbl);
        controller3TimePenal.add(controller3StartMinuteSpinner);

        controller3TimePenal.add(controller3EndHourLbl);
        controller3TimePenal.add(controller3EndHourSpinner);
        controller3TimePenal.add(controller3EndHourMinuteLbl);
        controller3TimePenal.add(controller3EndMinuteSpinner);

        controller3TimePenal.add(controller3SetBtn);

        controller3ListPenal.add(new JScrollPane(list), BorderLayout.CENTER);

        add("Center", controller3ListPenal);
        add("South", controller3TimePenal);

    }

}
