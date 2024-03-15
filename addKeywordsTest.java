import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class addKeywordsTest {

    public static void main(String[] args) {
        CourseList courseList = new CourseList();
        ArrayList<Course> courses = courseList.getCourses();
        Keyword toAdd = Keyword.LSE;
        HashMap<String, String> test = KeywordMapTest.loadLSEKeywords();
        for (String key : test.keySet()) {
            String big = test.get(key);
            int thingyIndex = big.indexOf('-');
            if (thingyIndex < 0)
                thingyIndex = big.indexOf(',');
            if (thingyIndex < 0) {
                singleKeyWordMode(courseList, toAdd, courses, key, big);
                continue;
            }
            String leftValue = big.substring(0, thingyIndex);
            String rightValue = big.substring(thingyIndex + 1);
            // System.out.println(leftValue + " " + rightValue + " " + key);
            switch (big.charAt(thingyIndex)) {
                case '-':
                    rangeKeyWordMode(courseList, toAdd, courses, key, leftValue, rightValue);
                    break;
                case ',':
                    String[] list = big.split(",");
                    ArrayList<String> strings = new ArrayList<>(Arrays.asList(list));
                    pairKeyWordMode(courseList, toAdd, courses, key, strings);
                    break;
            }
        }
        // DataWriter.saveCourses();
    }

    private static void pairKeyWordMode(CourseList courseList, Keyword toAdd, ArrayList<Course> courses, String key,
            ArrayList<String> values) {
        for (String string : values) {
            Course swapCourse = courseList.getCourse(key, string);
            int swapIndex = courses.indexOf(swapCourse);
            System.out.println(key + string);
            System.out.println(swapCourse.getDesignator() + swapCourse.getNumber());
            swapCourse.addKeyword(toAdd);
            courses.set(swapIndex, swapCourse);
        }
    }

    private static void rangeKeyWordMode(CourseList courseList, Keyword toAdd, ArrayList<Course> courses, String key,
            String leftValue, String rightValue) {
        System.out.println(key + "\n");
        Course startCourse = courseList.getCourse(key, leftValue);
        int startIndex = courses.indexOf(startCourse);
        // System.out.println(startCourse.getDesignator() + " " +
        // startCourse.getNumber());
        Course endCourse = courseList.getCourse(key, rightValue);
        int endIndex = courses.indexOf(endCourse);
        // System.out.println(endCourse.getDesignator() + " " + endCourse.getNumber());
        for (int i = startIndex; i <= endIndex; i++) {
            courses.get(i).addKeyword(toAdd);
        }
    }

    private static void singleKeyWordMode(CourseList courseList, Keyword toAdd, ArrayList<Course> courses, String key,
            String big) {
        Course swapCourse = courseList.getCourse(key, big);
        int swapIndex = courses.indexOf(swapCourse);
        System.out.println(key + big);
        System.out.println(swapCourse.getDesignator() + swapCourse.getNumber());
        swapCourse.addKeyword(toAdd);
        courses.set(swapIndex, swapCourse);
    }

}
