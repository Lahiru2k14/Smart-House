import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.ArrayList;


interface SwitchActionObserver {
    public void update (String switchAction);
}

interface DataActionObserver {
    public void update (String dataAction);
}

class AddTime {
    private int startHour;
    private int startMinute;
    private int endHour;
    private int endMinute;


    public AddTime() {
    }

    public AddTime(int startHour, int startMinute, int endHour, int endMinute) {
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public int getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(int endMinute) {
        this.endMinute = endMinute;
    }

}

//----------------------------------TV Living Room----------------------------------//

class DisplayTVLRoom extends JFrame implements SwitchActionObserver{
    private JLabel tvlLabel;
    DisplayTVLRoom() {
        setSize(300, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Tv One");
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setVisible(true);

        tvlLabel = new JLabel("ON");
        tvlLabel.setFont(new Font("", 1, 25));

        add(tvlLabel);
    }
    public void update (String switchAction){
        tvlLabel.setText(switchAction);

    }
}

//------------------------------Speaker Living Room---------------------------------//

class DisplaySPLRoom extends JFrame implements SwitchActionObserver{
    private JLabel splLabel;
    DisplaySPLRoom() {
        setSize(300, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Speaker");
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setVisible(true);

        splLabel = new JLabel("ON");
        splLabel.setFont(new Font("", 1, 25));

        add(splLabel);
    }
    public void update (String switchAction){
        splLabel.setText(switchAction);

    }
}

//-------------------------------Window Living Room---------------------------------//

class DisplayWDLRoom extends JFrame implements SwitchActionObserver{
    private JLabel wdlLabel;
    DisplayWDLRoom () {
        setSize(300, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Window");
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setVisible(true);

        wdlLabel = new JLabel("ON");
        wdlLabel.setFont(new Font("", 1, 25));

        add( wdlLabel);
    }
    public void update (String switchAction){
        wdlLabel.setText(switchAction);

    }
}

//-----------------------------------TV Dining Room----------------------------------//

class DisplayTVDRoom extends JFrame implements SwitchActionObserver{
    private JLabel tvdLabel;
    DisplayTVDRoom () {
        setSize(300, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("TV Two");
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setVisible(true);

        tvdLabel = new JLabel("ON");
        tvdLabel.setFont(new Font("", 1, 25));

        add( tvdLabel);
    }
    public void update (String switchAction){
        tvdLabel.setText(switchAction);

    }
}
//-----------------------------Setting Window----------------------------------------//

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
                                                  case 3: new TVDRoomController();break;

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

//---------------------------------TVLRoom Controller--------------------------------//


class TVLRoomController extends JFrame {
    private JList list = null;
    DefaultListModel lm = null;

    TVLRoomController () {
        setSize(650, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("TV Living Room");
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel controller1ListPenal = new JPanel();
        controller1ListPenal .setLayout(new GridLayout());

        ArrayList<AddTime> addTimeList = new ArrayList();

        JPanel controller1TimePenal = new JPanel();

        controller1TimePenal.setLayout(new FlowLayout());

        //-------------------------------------------------------------------------------//

        JLabel controller1StartHourLbl =new JLabel("Start Hour:");
        controller1StartHourLbl.setFont(new Font("", 1, 15));

        SpinnerModel startHourValue = new SpinnerNumberModel(00, //initial value
                00, //minimum value
                24, //maximum value
                1); //step
        JSpinner controller1StartHourSpinner = new JSpinner(startHourValue);
        controller1StartHourSpinner .setBounds(10,100,20,10);
        controller1StartHourSpinner .setEditor(
                new JSpinner.NumberEditor(controller1StartHourSpinner , "00"));
        controller1StartHourSpinner .setFont(new Font("",1,15));

        JLabel controller1StartMinuteLbl =new JLabel("Start Minute:");
        controller1StartMinuteLbl.setFont(new Font("", 1, 15));

        SpinnerModel minuteValue = new SpinnerNumberModel(00, //initial value
                00, //minimum value
                60, //maximum value
                1); //step
        JSpinner controller1StartMinuteSpinner = new JSpinner(minuteValue);
        controller1StartMinuteSpinner.setBounds(100,100,20,10);
        controller1StartMinuteSpinner.setEditor(
                new JSpinner.NumberEditor(controller1StartMinuteSpinner, "00"));
        controller1StartMinuteSpinner.setFont(new Font("",1,15));

        //---------------------------------------------------------------------------------------//

        JLabel controller1EndHourLbl =new JLabel("End Hour:");
        controller1EndHourLbl.setFont(new Font("", 1, 15));

        SpinnerModel endHourValue = new SpinnerNumberModel(00, //initial value
                00, //minimum value
                24, //maximum value
                1); //step
        JSpinner controller1EndHourSpinner = new JSpinner(endHourValue);
        controller1EndHourSpinner.setBounds(100,100,20,10);
        controller1EndHourSpinner.setEditor(
                new JSpinner.NumberEditor(controller1EndHourSpinner, "00"));
        controller1EndHourSpinner.setFont(new Font("",1,15));

        JLabel controller1EndHourMinuteLbl =new JLabel("Minute:");
        controller1EndHourMinuteLbl.setFont(new Font("", 1, 15));

        SpinnerModel endMinuteValue =
                new SpinnerNumberModel(00, //initial value
                        00, //minimum value
                        60, //maximum value
                        1); //step
        JSpinner controller1EndMinuteSpinner = new JSpinner(endMinuteValue);
        controller1EndMinuteSpinner.setBounds(100,100,20,10);
        controller1EndMinuteSpinner.setEditor(
                new JSpinner.NumberEditor(controller1EndMinuteSpinner, "00"));
        controller1EndMinuteSpinner.setFont(new Font("",1,15));

        //---------------------------------------------------------------------------------------//

        JButton controller1SetBtn =new JButton("Set");
        controller1SetBtn.setFont(new Font("",1,15));
        controller1SetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ssp1= (int) controller1StartHourSpinner .getValue();
                int ssp2= (int) controller1StartMinuteSpinner .getValue();
                int esp1= (int) controller1EndHourSpinner .getValue();
                int esp2= (int) controller1EndMinuteSpinner .getValue();

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

        add("Center",controller1ListPenal);
        add("South",controller1TimePenal);

    }
}
//---------------------------------SPLRoom Controller--------------------------------//


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

//---------------------------------WDLRoom Controller--------------------------------//


class WDLRoomController extends JFrame {

    private JList list = null;
    DefaultListModel lm = null;


    WDLRoomController () {
        setSize(650, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Window Living Room");
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setVisible(true);;

        JPanel controller3ListPenal = new JPanel();
        controller3ListPenal .setLayout(new GridLayout());

        ArrayList<AddTime> addTimeList = new ArrayList();

        JPanel controller3TimePenal = new JPanel();

        controller3TimePenal.setLayout(new FlowLayout());

        //-------------------------------------------------------------------------------//

        JLabel controller3StartHourLbl =new JLabel("Start Hour:");
        controller3StartHourLbl.setFont(new Font("", 1, 15));

        SpinnerModel startHourValue = new SpinnerNumberModel(00, //initial value
                00, //minimum value
                24, //maximum value
                1); //step
        JSpinner controller3StartHourSpinner = new JSpinner(startHourValue);
        controller3StartHourSpinner .setBounds(10,100,20,10);
        controller3StartHourSpinner .setEditor(
                new JSpinner.NumberEditor(controller3StartHourSpinner , "00"));
        controller3StartHourSpinner .setFont(new Font("",1,15));

        JLabel controller3StartMinuteLbl =new JLabel("Start Minute:");
        controller3StartMinuteLbl.setFont(new Font("", 1, 15));

        SpinnerModel minuteValue = new SpinnerNumberModel(00, //initial value
                00, //minimum value
                60, //maximum value
                1); //step
        JSpinner controller3StartMinuteSpinner = new JSpinner(minuteValue);
        controller3StartMinuteSpinner.setBounds(100,100,20,10);
        controller3StartMinuteSpinner.setEditor(
                new JSpinner.NumberEditor(controller3StartMinuteSpinner, "00"));
        controller3StartMinuteSpinner.setFont(new Font("",1,15));

        //---------------------------------------------------------------------------------------//

        JLabel controller3EndHourLbl =new JLabel("End Hour:");
        controller3EndHourLbl.setFont(new Font("", 1, 15));

        SpinnerModel endHourValue = new SpinnerNumberModel(00, //initial value
                00, //minimum value
                24, //maximum value
                1); //step
        JSpinner controller3EndHourSpinner = new JSpinner(endHourValue);
        controller3EndHourSpinner.setBounds(100,100,20,10);
        controller3EndHourSpinner.setEditor(
                new JSpinner.NumberEditor(controller3EndHourSpinner, "00"));
        controller3EndHourSpinner.setFont(new Font("",1,15));

        JLabel controller3EndHourMinuteLbl =new JLabel("Minute:");
        controller3EndHourMinuteLbl.setFont(new Font("", 1, 15));

        SpinnerModel endMinuteValue =
                new SpinnerNumberModel(00, //initial value
                        00, //minimum value
                        60, //maximum value
                        1); //step
        JSpinner controller3EndMinuteSpinner = new JSpinner(endMinuteValue);
        controller3EndMinuteSpinner.setBounds(100,100,20,10);
        controller3EndMinuteSpinner.setEditor(
                new JSpinner.NumberEditor(controller3EndMinuteSpinner, "00"));
        controller3EndMinuteSpinner.setFont(new Font("",1,15));

        //---------------------------------------------------------------------------------------//

        JButton controller3SetBtn =new JButton("Set");
        controller3SetBtn.setFont(new Font("",1,15));
        controller3SetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ssp1= (int) controller3StartHourSpinner .getValue();
                int ssp2= (int) controller3StartMinuteSpinner .getValue();
                int esp1= (int) controller3EndHourSpinner .getValue();
                int esp2= (int) controller3EndMinuteSpinner .getValue();

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

        add("Center",controller3ListPenal);
        add("South",controller3TimePenal);

    }

}

//---------------------------------TVDRoom Controller--------------------------------//


class TVDRoomController extends JFrame {

    private JList list = null;
    DefaultListModel lm = null;

    TVDRoomController () {
        setSize(650, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("TV Dining Room");
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setVisible(true);
        JPanel controller4ListPenal = new JPanel();
        controller4ListPenal .setLayout(new GridLayout());

        ArrayList<AddTime> addTimeList = new ArrayList();

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


//---------------------------------Main Switch----------------------------------------//

    class DisplaySwitch extends JFrame {
    private DisplaySwitchController displaySwitchController;
        private JToggleButton switchBtn;
        private JButton settingBtn;
        DisplaySwitch(DisplaySwitchController displaySwitchController) {
            setSize(450, 200);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("Switch");
            setLocationRelativeTo(null);
            setLayout(new GridLayout(3,1));

            this.displaySwitchController=displaySwitchController;

            switchBtn = new JToggleButton("ON");
            switchBtn.setFont(new Font("", 1, 20));
            switchBtn.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (switchBtn.isSelected()) {
                        switchBtn.setText("OFF");

                    } else{
                        switchBtn.setText("ON");
                    }

                    String switchAction;

                    if (switchBtn.getText().equals("OFF")){
                        switchAction = "ON";
                    }else {
                        switchAction = "OFF";
                    }

                    System.out.println("switch Action -"+ switchAction);

                    displaySwitchController.setSwitchAction(switchAction);

                }
            });

            settingBtn =new JButton("Settings");
            settingBtn.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent evt){

                            new DisplaySetting();
                        }
                    });

            settingBtn.setFont(new Font("", 1, 20));

            //---------------------------------------------------------------------------------//

            JPanel switchMenuTimePenal =new JPanel();
            switchMenuTimePenal.setLayout(new FlowLayout(FlowLayout.CENTER));

            JLabel switchMenuHourLbl =new JLabel("Hour:");
            switchMenuHourLbl.setFont(new Font("", 1, 20));

            SpinnerModel valueHour =
                    new SpinnerNumberModel(00, //initial value
                            00, //minimum value
                            24, //maximum value
                            1); //step
            JSpinner switchMenuHourSpinner = new JSpinner(valueHour);
            switchMenuHourSpinner.setBounds(100,100,50,30);
            switchMenuHourSpinner.setEditor(
                    new JSpinner.NumberEditor(switchMenuHourSpinner, "00"));
            switchMenuHourSpinner.setFont(new Font("",1,20));

            JLabel switchMenuMinuteLbl =new JLabel("Minute:");
            switchMenuMinuteLbl.setFont(new Font("", 1, 20));

            SpinnerModel valueMinute =
                    new SpinnerNumberModel(00, //initial value
                            00, //minimum value
                            60, //maximum value
                            1); //step
            JSpinner switchMenuMinuteSpinner = new JSpinner(valueMinute);
            switchMenuMinuteSpinner.setBounds(100,100,50,30);
            switchMenuMinuteSpinner.setEditor(
                    new JSpinner.NumberEditor(switchMenuMinuteSpinner, "00"));
            switchMenuMinuteSpinner.setFont(new Font("",1,20));

            switchMenuTimePenal.add(switchMenuHourLbl);
            switchMenuTimePenal.add(switchMenuHourSpinner);
            switchMenuTimePenal.add(switchMenuMinuteLbl);
            switchMenuTimePenal.add(switchMenuMinuteSpinner);

            add(switchBtn);
            add(settingBtn);
            add(switchMenuTimePenal);
        }
    }

//--------------------------------------Main Switch Controller-----------------------------------//

    class DisplaySwitchController{
    private  SwitchActionObserver [] observerArray=new SwitchActionObserver[0];
        private String switchAction;
        public void addSwitchActionObserver (SwitchActionObserver switchActionObserver){

            SwitchActionObserver[] temp=new SwitchActionObserver[observerArray.length+1];

            for (int i=0; i<observerArray.length; i++){
                temp [i]=observerArray[i];
            }
            temp [observerArray.length]=switchActionObserver;
            observerArray=temp;
        }

        public void setSwitchAction(String switchAction){
            if(this.switchAction!=switchAction){
                this.switchAction=switchAction;
                notifyObservers();
            }
        }

        public void notifyObservers(){
            for (SwitchActionObserver ob : observerArray){
                ob.update(switchAction);
            }
        }
        }

//---------------------------------------------------------------------------------------------//

    class Demo {
        public static void main(String[] args) {

            DisplaySwitchController displaySwitchController=new DisplaySwitchController();

            displaySwitchController.addSwitchActionObserver(new DisplayTVLRoom());
            displaySwitchController.addSwitchActionObserver(new DisplaySPLRoom());
            displaySwitchController.addSwitchActionObserver(new DisplayWDLRoom());
            displaySwitchController.addSwitchActionObserver(new DisplayTVDRoom());

            new DisplaySwitch(displaySwitchController).setVisible(true);

        }
    }











