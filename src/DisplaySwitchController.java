class DisplaySwitchController {

    private String switchAction;
    static DisplayTVLRoom displayTVLRoom;
    private DisplaySPLRoom displaySPLRoom;
    private DisplayWDLRoom displayWDLRoom;
    private DisplayTVDRoom displayTVDRoom;


    public void addDisplayTVLRoom(DisplayTVLRoom displayTVLRoom) {

        this.displayTVLRoom=displayTVLRoom;
    }

    public void addDisplaySPLRoom(DisplaySPLRoom displaySPLRoom) {
        this.displaySPLRoom=displaySPLRoom;
    }

    public void addDisplayWDLRoom(DisplayWDLRoom displayWDLRoom) {
        this.displayWDLRoom=displayWDLRoom;
    }

    public void addDisplayTVDRoom(DisplayTVDRoom displayTVDRoom) {
        this.displayTVDRoom=displayTVDRoom;
    }

    public void setSwitchAction(String switchAction){
        if(this.switchAction!=switchAction){
            this.switchAction=switchAction;
            notifyObjects();
        }
    }
    public void notifyObjects(){

        displayTVLRoom.update(switchAction);
        displaySPLRoom.update(switchAction);
        displayWDLRoom.update(switchAction);
        displayTVDRoom.update(switchAction);

    }


    public void setStartTime(String startTime) {
        displayTVLRoom.update(startTime);
    }

    public void setEndTime(String endTime) {
        displayTVLRoom.update(endTime);
    }
}