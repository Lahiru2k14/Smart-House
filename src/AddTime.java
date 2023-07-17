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

    public void setStartHour() {
        this.startHour = startHour;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public void setStartMinute() {
        this.startMinute = startMinute;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour() {
        this.endHour = endHour;
    }

    public int getEndMinute() {
        return endMinute;
    }

    public void setEndMinute() {
        this.endMinute = endMinute;
    }

}