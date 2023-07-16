import java.util.ArrayList;

public class DBConnection {

    ArrayList<AddTime> addMainTimeList;
    ArrayList<AddTime> addMainTimeList2;
    ArrayList<AddTime> addMainTimeList3;
    ArrayList<AddTime> addMainTimeList4;

    private static DBConnection dbConnection;

    private DBConnection() {
        addMainTimeList = new ArrayList<AddTime>();
        addMainTimeList2 = new ArrayList<AddTime>();
        addMainTimeList3 = new ArrayList<AddTime>();
        addMainTimeList4 = new ArrayList<AddTime>();

    }

    public static DBConnection getInstance() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    public ArrayList<AddTime> getAddTime() {
        return addMainTimeList;
    }

    public ArrayList<AddTime> getStartTime() {
        return addMainTimeList;
    }

    public ArrayList<AddTime> getAddTime2() {
        return addMainTimeList2;
    }

    public ArrayList<AddTime> getStartTime2() {
        return addMainTimeList2;
    }

    public ArrayList<AddTime> getAddTime3() {
        return addMainTimeList3;
    }

    public ArrayList<AddTime> getStartTime3() {
        return addMainTimeList3;
    }

    public ArrayList<AddTime> getAddTime4() {
        return addMainTimeList4;
    }

    public ArrayList<AddTime> getStartTime4() {
        return addMainTimeList4;
    }

}


