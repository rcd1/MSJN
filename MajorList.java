import java.util.ArrayList;

public class MajorList {
    private static MajorList majorList;
    private ArrayList<Major> majors;

    public MajorList() {
        majorList = this;
        majors = DataLoader.getMajors();
    }

    public static MajorList getInstance() {
        if (majorList == null) majorList = new MajorList();
        return majorList;
    }

    public Major getMajor(String majorName) {
        for (Major major : majors) {
            if (major.checkMajor(majorName))
            return major;
        }
        return null;
    }
}
