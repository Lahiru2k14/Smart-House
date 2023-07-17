import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Objects;

class SPLRoomController extends JFrame {
    private JList list = null;
    DefaultListModel lm = null;
    public ArrayList<AddTime> addTimeList2;
    int selectedIndex2=-1;
    SPLRoomController () {
        addTimeList2 = DisplaySwitch.addControllerTimeList2 ;
        setSize(650, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Speaker Living Room");
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel controller2ListPenal = new JPanel();
        controller2ListPenal .setLayout(new GridLayout());

        addTimeList2 = TimeController.getTime2();

        JPanel controller2TimePenal = new JPanel();

        controller2TimePenal.setLayout(new FlowLayout());

        //-------------------------------------------------------------------------------//

        JLabel controller2StartHourLbl =new JLabel("Start Hour:");
        controller2StartHourLbl.setFont(new Font("", 1, 15));

        SpinnerModel startHourValue = new SpinnerNumberModel(00, //initial value
                00, //minimum value
                24, //maximum value
                1); //step
        JSpinner controller2StartHourSpinner = new JSpinner(startHourValue);
        controller2StartHourSpinner .setBounds(10,100,20,10);
        controller2StartHourSpinner .setEditor(
                new JSpinner.NumberEditor(controller2StartHourSpinner , "00"));
        controller2StartHourSpinner .setFont(new Font("",1,15));

        JLabel controller2StartMinuteLbl =new JLabel("Start Minute:");
        controller2StartMinuteLbl.setFont(new Font("", 1, 15));

        SpinnerModel minuteValue = new SpinnerNumberModel(00, //initial value
                00, //minimum value
                60, //maximum value
                1); //step
        JSpinner controller2StartMinuteSpinner = new JSpinner(minuteValue);
        controller2StartMinuteSpinner.setBounds(100,100,20,10);
        controller2StartMinuteSpinner.setEditor(
                new JSpinner.NumberEditor(controller2StartMinuteSpinner, "00"));
        controller2StartMinuteSpinner.setFont(new Font("",1,15));

        //---------------------------------------------------------------------------------------//

        JLabel controller2EndHourLbl =new JLabel("End Hour:");
        controller2EndHourLbl.setFont(new Font("", 1, 15));

        SpinnerModel endHourValue = new SpinnerNumberModel(00, //initial value
                00, //minimum value
                24, //maximum value
                1); //step
        JSpinner controller2EndHourSpinner = new JSpinner(endHourValue);
        controller2EndHourSpinner.setBounds(100,100,20,10);
        controller2EndHourSpinner.setEditor(
                new JSpinner.NumberEditor(controller2EndHourSpinner, "00"));
        controller2EndHourSpinner.setFont(new Font("",1,15));

        JLabel controller2EndHourMinuteLbl =new JLabel("Minute:");
        controller2EndHourMinuteLbl.setFont(new Font("", 1, 15));

        SpinnerModel endMinuteValue =
                new SpinnerNumberModel(00, //initial value
                        00, //minimum value
                        60, //maximum value
                        1); //step
        JSpinner controller2EndMinuteSpinner = new JSpinner(endMinuteValue);
        controller2EndMinuteSpinner.setBounds(100,100,20,10);
        controller2EndMinuteSpinner.setEditor(
                new JSpinner.NumberEditor(controller2EndMinuteSpinner, "00"));
        controller2EndMinuteSpinner.setFont(new Font("",1,15));

        //---------------------------------------------------------------------------------------//

        JButton controller2SetBtn =new JButton("Set");
        controller2SetBtn.setFont(new Font("",1,15));
        controller2SetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ssp1= (int) controller2StartHourSpinner .getValue();
                int ssp2= (int) controller2StartMinuteSpinner .getValue();
                int esp1= (int) controller2EndHourSpinner .getValue();
                int esp2= (int) controller2EndMinuteSpinner .getValue();

                AddTime addTime2= new AddTime(ssp1,ssp2,esp1,esp2);

                String f1 = String.format("%02d", ssp1);
                String f2 = String.format("%02d", ssp2);
                String f3 = String.format("%02d", esp1);
                String f4 = String.format("%02d", esp2);

                String row = "Start at: " + f1 + "." + f2 + " " + "Ends at:" + f3 + "." + f4;

                if (Objects.equals(controller2SetBtn.getText(), "Set")) {

                    TimeController.addTime(addTime2);

                    if (addTimeList2.isEmpty()) {
                        lm.clear();
                    }

                    lm.addElement(row);

                } else {

                    addTimeList2.set(selectedIndex2, addTime2);

                    lm.set(selectedIndex2,row);

                    controller2SetBtn.setText("Set");

                }
            }

        });

        String a,b,c,d;

        lm = new DefaultListModel();

            for (AddTime i: addTimeList2){
                a = String.valueOf(i.getStartHour());
                b = String.valueOf(i.getStartMinute());
                c = String.valueOf(i.getEndHour());
                d = String.valueOf(i.getEndMinute());

                String row ="Start at : "+a+"."+b+" "+"Ends at :"+c+"."+d;
                lm.addElement(row);

        }

        list = new JList(lm);

        //---------------------------------------------------------------------------------------//
        list.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                System.out.println("Clicked");

                controller2SetBtn.setText("Edit");

                selectedIndex2 = list.getSelectedIndex();
                System.out.println(selectedIndex2);

                int t1 = DBConnection.getInstance().getStartTime2().get(selectedIndex2).getStartHour();
                int t2 = DBConnection.getInstance().getStartTime2().get(selectedIndex2).getStartMinute();

                int t3 = DBConnection.getInstance().getStartTime2().get(selectedIndex2).getEndHour();
                int t4 = DBConnection.getInstance().getStartTime2().get(selectedIndex2).getEndMinute();

                controller2StartHourSpinner.setValue(t1);
                controller2StartMinuteSpinner.setValue(t2);
                controller2EndHourSpinner.setValue(t3);
                controller2EndMinuteSpinner.setValue(t4);

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

        controller2TimePenal.add(controller2StartHourLbl);
        controller2TimePenal.add(controller2StartHourSpinner);
        controller2TimePenal.add(controller2StartMinuteLbl);
        controller2TimePenal.add(controller2StartMinuteSpinner);

        controller2TimePenal.add(controller2EndHourLbl);
        controller2TimePenal.add(controller2EndHourSpinner);
        controller2TimePenal.add(controller2EndHourMinuteLbl);
        controller2TimePenal.add(controller2EndMinuteSpinner);

        controller2TimePenal.add(controller2SetBtn);

        controller2ListPenal.add(new JScrollPane(list), BorderLayout.CENTER);

        add("Center",controller2ListPenal);
        add("South",controller2TimePenal);

    }

}
