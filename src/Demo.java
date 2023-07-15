import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.ArrayList;


    class Demo {
        public static void main(String[] args) {


            DisplaySwitchController displaySwitchController=new DisplaySwitchController();

            displaySwitchController.addDisplayTVLRoom(new DisplayTVLRoom());
            displaySwitchController.addDisplaySPLRoom(new DisplaySPLRoom());
            displaySwitchController.addDisplayWDLRoom(new DisplayWDLRoom());
            displaySwitchController.addDisplayTVDRoom(new DisplayTVDRoom());

            new DisplaySwitch(displaySwitchController).setVisible(true);

        }
    }











