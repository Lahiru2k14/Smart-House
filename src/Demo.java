

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











