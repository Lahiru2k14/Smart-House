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

    public void setStartTime2(String startTime2) {
        displaySPLRoom.update(startTime2);
    }

    public void setEndTime2(String endTime2) {
        displaySPLRoom.update(endTime2);
    }

    public void setStartTime3(String startTime3) {
        displayWDLRoom.update(startTime3);
    }

    public void setEndTime3(String endTime3) {
        displayWDLRoom.update(endTime3);
    }

    public void setStartTime4(String startTime4) {
        displayTVDRoom.update(startTime4);
    }

    public void setEndTime4(String endTime4) {
        displayTVDRoom.update(endTime4);
    }
}