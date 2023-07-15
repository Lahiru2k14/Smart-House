import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TVLRoomController extends JFrame {
    private JList list = null;
    private DefaultListModel lm = null;

    public ArrayList<AddTime> addTimeList;

    TVLRoomController() {
        addTimeList = DisplaySwitch.addControllerTimeList ;
        setSize(650, 300);
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

        SpinnerModel minuteValue = new SpinnerNumberModel(00, //initial value
                00, //minimum value
                60, //maximum value
                1); //step
        JSpinner controller1StartMinuteSpinner = new JSpinner(minuteValue);
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

        JButton controller1SetBtn = new JButton("Set");
        controller1SetBtn.setFont(new Font("", 1, 15));
        controller1SetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ssp1 = (int) controller1StartHourSpinner.getValue();
                int ssp2 = (int) controller1StartMinuteSpinner.getValue();
                int esp1 = (int) controller1EndHourSpinner.getValue();
                int esp2 = (int) controller1EndMinuteSpinner.getValue();

                AddTime addTime = new AddTime(ssp1, ssp2, esp1, esp2);

                TimeController.addTime(addTime);

                if (addTimeList.isEmpty()) {
                    lm.clear();
                }
//                addTimeList.add(addTime);

                String row = "Start at: " + ssp1 + "." + ssp2 + " " + "Ends at:" + esp1 + "." + esp2;

                lm.addElement(row);

            }
        });

        String a, b, c, d;

        lm = new DefaultListModel();

        if (addTimeList.isEmpty()) {
            a = b = c = d = " - ";
            String row = "Start at: " + a + "." + b + " " + "Ends at:" + c + "." + d;
            lm.addElement(row);
        } else {
            for (AddTime i : addTimeList) {
                a = String.valueOf(i.getStartHour());
                b = String.valueOf(i.getStartMinute());
                c = String.valueOf(i.getEndHour());
                d = String.valueOf(i.getEndMinute());

                String row = "Start at: " + a + "." + b + " " + "Ends at:" + c + "." + d;
                lm.addElement(row);

            }
        }

        list = new JList(lm);





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
