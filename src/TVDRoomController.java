import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TVDRoomController extends JFrame {

    private JList list = null;
    DefaultListModel lm = null;

    public ArrayList<AddTime> addTimeList4;

    TVDRoomController () {
        addTimeList4 = DisplaySwitch.addControllerTimeList4 ;
        setSize(650, 300);
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

                TimeController.addTime4(addTime4);

                if(addTimeList4.isEmpty()){
                    lm.clear();
                }

//                addTimeList.add(addTime);


                String row ="Start at: "+ssp1+"."+ssp2+" "+"Ends at:"+esp1+"."+esp2;

                lm.addElement(row);

            }
        });

        String a,b,c,d;

        lm = new DefaultListModel();

        if(addTimeList4.isEmpty()){
            a = b = c = d = " - ";
            String row ="Start at: "+a+"."+b+" "+"Ends at:"+c+"."+d;
            lm.addElement(row);
        }else{
            for (AddTime i: addTimeList4){
                a = String.valueOf(i.getStartHour());
                b = String.valueOf(i.getStartMinute());
                c = String.valueOf(i.getEndHour());
                d = String.valueOf(i.getEndMinute());

                String row ="Start at: "+a+"."+b+" "+"Ends at:"+c+"."+d;
                lm.addElement(row);

            }
        }

        list = new JList(lm);

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