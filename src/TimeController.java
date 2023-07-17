import java.util.ArrayList;

public class TimeController {
    public static boolean addTime(AddTime addTimes) {
        ArrayList<AddTime> addTimeList = DBConnection.getInstance().getStartTime();
        addTimeList.add(addTimes);

        return true;
    }

    public static ArrayList<AddTime> getTime() {
        ArrayList<AddTime> addTimeList = DBConnection.getInstance().getStartTime();

        return addTimeList;
    }

    public static boolean addTime2(AddTime addTimes2) {
        ArrayList<AddTime> addTimeList2 = DBConnection.getInstance().getStartTime2();
        addTimeList2.add(addTimes2);

        return true;
    }

    public static ArrayList<AddTime> getTime2() {
        ArrayList<AddTime> addTimeList2 = DBConnection.getInstance().getStartTime2();

        return addTimeList2;
    }

    public static boolean addTime3(AddTime addTimes3) {
        ArrayList<AddTime> addTimeList3 = DBConnection.getInstance().getStartTime3();
        addTimeList3.add(addTimes3);

        return true;
    }

    public static ArrayList<AddTime> getTime3() {
        ArrayList<AddTime> addTimeList3 = DBConnection.getInstance().getStartTime3();

        return addTimeList3;
    }

    public static boolean addTime4(AddTime addTimes4) {
        ArrayList<AddTime> addTimeList4 = DBConnection.getInstance().getStartTime4();
        addTimeList4.add(addTimes4);

        return true;
    }

    public static ArrayList<AddTime> getTime4() {
        ArrayList<AddTime> addTimeList4 = DBConnection.getInstance().getStartTime4();

        return addTimeList4;
    }


}

