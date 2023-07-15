import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class SPLRoomController extends JFrame {

    private JList list = null;
    DefaultListModel lm = null;

    SPLRoomController () {
        setSize(650, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Speaker Living Room");
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel controller2ListPenal = new JPanel();
        controller2ListPenal .setLayout(new GridLayout());

        ArrayList<AddTime> addTimeList = new ArrayList();

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

                AddTime addTime= new AddTime(ssp1,ssp2,esp1,esp2);

                if(addTimeList.isEmpty()){
                    lm.clear();
                }

                addTimeList.add(addTime);

                String row ="Start at: "+ssp1+"."+ssp2+" "+"Ends at:"+esp1+"."+esp2;

                lm.addElement(row);

            }
        });

        String a,b,c,d;

        lm = new DefaultListModel();

        if(addTimeList.isEmpty()){
            a = b = c = d = " - ";
            String row ="Start at: "+a+"."+b+" "+"Ends at:"+c+"."+d;
            lm.addElement(row);
        }else{
            for (AddTime i: addTimeList){
                a = String.valueOf(i.getStartHour());
                b = String.valueOf(i.getStartMinute());
                c = String.valueOf(i.getEndHour());
                d = String.valueOf(i.getEndMinute());

                String row ="Start at: "+a+"."+b+" "+"Ends at:"+c+"."+d;
                lm.addElement(row);

            }
        }

        list = new JList(lm);



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
