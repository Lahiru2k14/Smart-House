import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

class DisplaySwitch extends JFrame {
    private DisplaySwitchController displaySwitchController;
    private JToggleButton switchBtn;
    private JButton settingBtn;
    JSpinner switchMenuHourSpinner;
    JSpinner switchMenuMinuteSpinner;

    static ArrayList<AddTime> addControllerTimeList = new ArrayList();

    static ArrayList<AddTime> addControllerTimeList2 = new ArrayList();

    static ArrayList<AddTime> addControllerTimeList3 = new ArrayList();

    static ArrayList<AddTime> addControllerTimeList4 = new ArrayList();


    DisplaySwitch(DisplaySwitchController displaySwitchController) {
        setSize(450, 260);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Switch");
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(102, 210, 227));

        this.displaySwitchController = displaySwitchController;

        switchBtn = new JToggleButton("ON");
        switchBtn.setBackground(new Color(136, 191, 143));
//        switchBtn.setBackground(Color.gray);
//        switchBtn.setForeground(Color.white);

        switchBtn.setFont(new Font("Arial Rounded MT Bold", 5, 18));
        switchBtn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (switchBtn.isSelected()) {
                    switchBtn.setText("OFF");

                } else {
                    switchBtn.setText("ON");
                }

                String switchAction;

                if (switchBtn.getText().equals("OFF")) {
                    switchAction = "ON";
                } else {
                    switchAction = "OFF";
                }


                System.out.println("switch Action -" + switchAction);


                displaySwitchController.setSwitchAction(switchAction);

            }
        });

        settingBtn = new JButton("Settings");
//        settingBtn.setBackground(Color.gray);
//        settingBtn.setForeground(Color.white);
        settingBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                new DisplaySetting();
            }
        });

        settingBtn.setFont(new Font("Arial Rounded MT Bold", 3, 18));
        settingBtn.setBackground(new Color(136, 191, 143));

        //---------------------------------------------------------------------------------//

        JPanel switchMenuTimePenal = new JPanel();
        switchMenuTimePenal.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel switchMenuHourLbl = new JLabel("Hour:");
        switchMenuHourLbl.setFont(new Font("", 1, 18));

        SpinnerModel valueHour =
                new SpinnerNumberModel(00, //initial value
                        00, //minimum value
                        24, //maximum value
                        1); //step
        switchMenuHourSpinner = new JSpinner(valueHour);
        switchMenuHourSpinner.setBounds(100, 100, 50, 30);
        switchMenuHourSpinner.setEditor(
                new JSpinner.NumberEditor(switchMenuHourSpinner, "00"));
        switchMenuHourSpinner.setFont(new Font("", 1, 18));

        switchMenuHourSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                setStartTime();


            }
        });


        JLabel switchMenuMinuteLbl = new JLabel("Minute:");
        switchMenuMinuteLbl.setFont(new Font("", 1, 18));

        SpinnerModel valueMinute =
                new SpinnerNumberModel(00, //initial value
                        00, //minimum value
                        60, //maximum value
                        1); //step
        switchMenuMinuteSpinner = new JSpinner(valueMinute);
        switchMenuMinuteSpinner.setBounds(100, 100, 50, 30);
        switchMenuMinuteSpinner.setEditor(
                new JSpinner.NumberEditor(switchMenuMinuteSpinner, "00"));
        switchMenuMinuteSpinner.setFont(new Font("", 1, 18));

        switchMenuMinuteSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                setStartTime();

            }
        });


        switchMenuTimePenal.add(switchMenuHourLbl);
        switchMenuTimePenal.add(switchMenuHourSpinner);
        switchMenuTimePenal.add(switchMenuMinuteLbl);
        switchMenuTimePenal.add(switchMenuMinuteSpinner);

        JPanel centerPenal =new JPanel();
        centerPenal.setBackground(new Color(136, 191, 143));



        JLabel northLbl=new JLabel("Super Home Controller");
        northLbl.setForeground(Color.black);


        JLabel northLbl2=new JLabel("");


        JPanel northPenal =new JPanel();
        northPenal.setBackground(new Color(136, 191, 143));
        northPenal.setForeground(Color.RED);
//        northPenal.setForeground(Color.gray);

        northPenal.setLayout(new GridLayout(2,1));

        northPenal.add(northLbl);
        northPenal.add(northLbl2);

        northLbl.setFont(new Font("Cooper Black",3,30));
        northLbl.setHorizontalAlignment(JLabel.CENTER);

        JPanel midPenal =new JPanel();
        midPenal.setLayout(new FlowLayout());
        JPanel midPenal2 =new JPanel();
        midPenal2.setLayout(new FlowLayout());

         midPenal.add(switchBtn);
         midPenal2.add(settingBtn);

        centerPenal.add(midPenal);
        centerPenal.add(midPenal2);

        add("Center",centerPenal);

        add("South",switchMenuTimePenal);

        add("North",northPenal);




    }


    public void setStartTime() {

        int ssp3 = (int) switchMenuHourSpinner.getValue();
        int ssp4 = (int) switchMenuMinuteSpinner.getValue();

        System.out.println();


        for (int i = 0; i < DBConnection.getInstance().addMainTimeList.size(); i++) {

            int tVLRStartHourTime = DBConnection.getInstance().getStartTime().get(i).getStartHour();
            int tVLRStartMinuteTime = DBConnection.getInstance().getStartTime().get(i).getStartMinute();

            int tVLREndHourTime = DBConnection.getInstance().getStartTime().get(i).getEndHour();
            int tVLREndMinuteTime = DBConnection.getInstance().getStartTime().get(i).getEndMinute();

            if (ssp3 == tVLRStartHourTime & ssp4 == tVLRStartMinuteTime) {

                System.out.println("TVLR Start Time :" + tVLRStartHourTime);
                System.out.println("TVLR Minute Time :" + tVLRStartMinuteTime);

                String startTime = "ON";

                displaySwitchController.setStartTime(startTime);

            }

            if (ssp3 == tVLREndHourTime & ssp4 == tVLREndMinuteTime) {

                System.out.println("TVLR Start Time :" + tVLREndHourTime);
                System.out.println("TVLR Minute Time :" + tVLREndMinuteTime);

                String endTime = "OFF";

                displaySwitchController.setEndTime(endTime);

            }

        }

        for (int i = 0; i < DBConnection.getInstance().addMainTimeList2.size(); i++) {

            int sPLRStartHourTime = DBConnection.getInstance().getStartTime2().get(i).getStartHour();
            int sPLRStartMinuteTime = DBConnection.getInstance().getStartTime2().get(i).getStartMinute();

            int sPLREndHourTime = DBConnection.getInstance().getStartTime2().get(i).getEndHour();
            int sPLREndMinuteTime = DBConnection.getInstance().getStartTime2().get(i).getEndMinute();


            if (ssp3 == sPLRStartHourTime & ssp4 == sPLRStartMinuteTime) {

                System.out.println("SPLR Start Time :" + sPLRStartHourTime);
                System.out.println("SPLR Minute Time :" + sPLRStartMinuteTime);

                String startTime2 = "ON";

                displaySwitchController.setStartTime2(startTime2);

            }

            if (ssp3 == sPLREndHourTime & ssp4 == sPLREndMinuteTime) {

                System.out.println("SPLR Start Time :" + sPLREndHourTime);
                System.out.println("SPLR Minute Time :" + sPLREndMinuteTime);

                String endTime2 = "OFF";

                displaySwitchController.setEndTime2(endTime2);

            }

        }

        for (int i = 0; i < DBConnection.getInstance().addMainTimeList3.size(); i++) {



            int wDLRStartHourTime = DBConnection.getInstance().getStartTime3().get(i).getStartHour();
            int wDLRStartMinuteTime = DBConnection.getInstance().getStartTime3().get(i).getStartMinute();

            int wDLREndHourTime = DBConnection.getInstance().getStartTime3().get(i).getEndHour();
            int wDLREndMinuteTime = DBConnection.getInstance().getStartTime3().get(i).getEndMinute();


            if (ssp3 == wDLRStartHourTime & ssp4 == wDLRStartMinuteTime) {

                System.out.println("WDLR Start Time :" + wDLRStartHourTime);
                System.out.println("WDLR Minute Time :" + wDLRStartMinuteTime);

                String startTime3 = "ON";

                displaySwitchController.setStartTime3(startTime3);

            }

            if (ssp3 == wDLREndHourTime & ssp4 == wDLREndMinuteTime) {

                System.out.println("wDLR Start Time :" + wDLREndHourTime);
                System.out.println("wDLR Minute Time :" + wDLREndMinuteTime);

                String endTime3 = "OFF";

                displaySwitchController.setEndTime3(endTime3);

            }



        }

        for (int i = 0; i < DBConnection.getInstance().addMainTimeList4.size(); i++) {

            int tVDRStartHourTime = DBConnection.getInstance().getStartTime4().get(i).getStartHour();
            int tVDRStartMinuteTime = DBConnection.getInstance().getStartTime4().get(i).getStartMinute();

            int tVDREndHourTime = DBConnection.getInstance().getStartTime4().get(i).getEndHour();
            int tVDREndMinuteTime = DBConnection.getInstance().getStartTime4().get(i).getEndMinute();


            if (ssp3 == tVDRStartHourTime & ssp4 == tVDRStartMinuteTime) {

                System.out.println("tVDR Start Time :" + tVDRStartHourTime);
                System.out.println("tVDRMinute Time :" + tVDRStartMinuteTime);

                String startTime4 = "ON";

                displaySwitchController.setStartTime4(startTime4);

            }

            if (ssp3 == tVDREndHourTime & ssp4 == tVDREndMinuteTime) {

                System.out.println("tVDR Start Time :" + tVDREndHourTime);
                System.out.println("tVDR Minute Time :" + tVDREndMinuteTime);

                String endTime4 = "OFF";

                displaySwitchController.setEndTime4(endTime4);

            }



        }
    }
}



