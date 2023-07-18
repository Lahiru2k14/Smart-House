import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Objects;

public class TVDRoomController extends JFrame {

    private JList list = null;
    DefaultListModel lm = null;
    public ArrayList<AddTime> addTimeList4;
    int selectedIndex4=-1;
    TVDRoomController () {
        addTimeList4 = DisplaySwitch.addControllerTimeList4 ;
        setSize(650, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("TV Dining Room");
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setVisible(true);
        JPanel controller4ListPenal = new JPanel();
        controller4ListPenal .setLayout(new GridLayout());

        addTimeList4 = TimeController.getTime4();

        JPanel controller4TimePenal = new JPanel();

        controller4TimePenal.setLayout(new FlowLayout());

        //-------------------------------------------------------------------------------//

        JLabel controller4StartHourLbl =new JLabel("Start Hour:");
        controller4StartHourLbl.setFont(new Font("", 1, 15));

        SpinnerModel startHourValue = new SpinnerNumberModel(00, //initial value
                00, //minimum value
                24, //maximum value
                1); //step
        JSpinner controller4StartHourSpinner = new JSpinner(startHourValue);
        controller4StartHourSpinner .setBounds(10,100,20,10);
        controller4StartHourSpinner .setEditor(
                new JSpinner.NumberEditor(controller4StartHourSpinner , "00"));
        controller4StartHourSpinner .setFont(new Font("",1,15));

        JLabel controller4StartMinuteLbl =new JLabel("Start Minute:");
        controller4StartMinuteLbl.setFont(new Font("", 1, 15));

        SpinnerModel minuteValue = new SpinnerNumberModel(00, //initial value
                00, //minimum value
                60, //maximum value
                1); //step
        JSpinner controller4StartMinuteSpinner = new JSpinner(minuteValue);
        controller4StartMinuteSpinner.setBounds(100,100,20,10);
        controller4StartMinuteSpinner.setEditor(
                new JSpinner.NumberEditor(controller4StartMinuteSpinner, "00"));
        controller4StartMinuteSpinner.setFont(new Font("",1,15));

        //---------------------------------------------------------------------------------------//

        JLabel controller4EndHourLbl =new JLabel("End Hour:");
        controller4EndHourLbl.setFont(new Font("", 1, 15));

        SpinnerModel endHourValue = new SpinnerNumberModel(00, //initial value
                00, //minimum value
                24, //maximum value
                1); //step
        JSpinner controller4EndHourSpinner = new JSpinner(endHourValue);
        controller4EndHourSpinner.setBounds(100,100,20,10);
        controller4EndHourSpinner.setEditor(
                new JSpinner.NumberEditor(controller4EndHourSpinner, "00"));
        controller4EndHourSpinner.setFont(new Font("",1,15));

        JLabel controller4EndHourMinuteLbl =new JLabel("Minute:");
        controller4EndHourMinuteLbl.setFont(new Font("", 1, 15));

        SpinnerModel endMinuteValue =
                new SpinnerNumberModel(00, //initial value
                        00, //minimum value
                        60, //maximum value
                        1); //step
        JSpinner controller4EndMinuteSpinner = new JSpinner(endMinuteValue);
        controller4EndMinuteSpinner.setBounds(100,100,20,10);
        controller4EndMinuteSpinner.setEditor(
                new JSpinner.NumberEditor(controller4EndMinuteSpinner, "00"));
        controller4EndMinuteSpinner.setFont(new Font("",1,15));

        //---------------------------------------------------------------------------------------//

        JButton controller4SetBtn =new JButton("Set");
        controller4SetBtn.setFont(new Font("",1,15));
        controller4SetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ssp1= (int) controller4StartHourSpinner .getValue();
                int ssp2= (int) controller4StartMinuteSpinner .getValue();
                int esp1= (int) controller4EndHourSpinner .getValue();
                int esp2= (int) controller4EndMinuteSpinner .getValue();

                AddTime addTime4= new AddTime(ssp1,ssp2,esp1,esp2);

                String x1 = String.format("%02d", ssp1);
                String x2 = String.format("%02d", ssp2);
                String x3 = String.format("%02d", esp1);
                String x4 = String.format("%02d", esp2);

                String row = "Start at : " + x1 + "." + x2 + " " + "Ends at :" + x3 + "." + x4;

                if (Objects.equals(controller4SetBtn.getText(), "Set")) {

                    TimeController.addTime4(addTime4);

                    if (addTimeList4.isEmpty()) {
                        lm.clear();
                    }

                    lm.addElement(row);

                } else {

                    addTimeList4.set(selectedIndex4, addTime4);

                    lm.set(selectedIndex4,row);

                    controller4SetBtn.setText("Set");

                }
            }

        });

        String a,b,c,d;

        lm = new DefaultListModel();

            for (AddTime i: addTimeList4){
                a = String.valueOf(i.getStartHour());
                b = String.valueOf(i.getStartMinute());
                c = String.valueOf(i.getEndHour());
                d = String.valueOf(i.getEndMinute());

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

                controller4SetBtn.setText("Edit");

                selectedIndex4 = list.getSelectedIndex();

                int t1 = DBConnection.getInstance().getStartTime4().get(selectedIndex4).getStartHour();
                int t2 = DBConnection.getInstance().getStartTime4().get(selectedIndex4).getStartMinute();

                int t3 = DBConnection.getInstance().getStartTime4().get(selectedIndex4).getEndHour();
                int t4 = DBConnection.getInstance().getStartTime4().get(selectedIndex4).getEndMinute();

                controller4StartHourSpinner.setValue(t1);
                controller4StartMinuteSpinner.setValue(t2);
                controller4EndHourSpinner.setValue(t3);
                controller4EndMinuteSpinner.setValue(t4);

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


        controller4TimePenal.add(controller4StartHourLbl);
        controller4TimePenal.add(controller4StartHourSpinner);
        controller4TimePenal.add(controller4StartMinuteLbl);
        controller4TimePenal.add(controller4StartMinuteSpinner);

        controller4TimePenal.add(controller4EndHourLbl);
        controller4TimePenal.add(controller4EndHourSpinner);
        controller4TimePenal.add(controller4EndHourMinuteLbl);
        controller4TimePenal.add(controller4EndMinuteSpinner);

        controller4TimePenal.add(controller4SetBtn);

        controller4ListPenal.add(new JScrollPane(list), BorderLayout.CENTER);

        add("Center",controller4ListPenal);
        add("South",controller4TimePenal);

    }

}