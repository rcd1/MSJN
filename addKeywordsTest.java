import java.util.ArrayList;
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
            if (thingyIndex < 0) thingyIndex = big.indexOf(',');
            String leftValue = big.substring(0, thingyIndex);
            String rightValue = big.substring(thingyIndex+1);
            // System.out.println(leftValue + " " + rightValue + " " + key);
            // switch(big.charAt(thingyIndex)) {
            //     case '-':
            //     System.out.println(key + "\n");
            //     Course startCourse = courseList.getCourse(key, leftValue);
            //     int startIndex = courses.indexOf(startCourse);
            //     // System.out.println(startCourse.getDesignator() + " " + startCourse.getNumber());
            //     Course endCourse = courseList.getCourse(key, rightValue);
            //     int endIndex = courses.indexOf(endCourse);
            //     // System.out.println(endCourse.getDesignator() + " " + endCourse.getNumber());
            //     for (int i = startIndex; i <= endIndex; i++) {
            //         courses.get(i).addKeyword(Keyword.LSE);
            //     }
            //     break;
            //     case ',':
            //     Course swapCourse = courseList.getCourse(key, leftValue);
            //     int swapIndex = courses.indexOf(swapCourse);
            //     System.out.println(key +"\n" + swapCourse.getDesignator() + swapCourse.getNumber());
            //     swapCourse.addKeyword(Keyword.LSE);
            //     courses.set(swapIndex, swapCourse);
            //     swapCourse = courseList.getCourse(key, rightValue);
            //     swapIndex = courses.indexOf(swapCourse);
            //     // System.out.println(key +"\n" + swapCourse.getDesignator() + swapCourse.getNumber());
            //     swapCourse.addKeyword(Keyword.LSE);
            //     courses.set(swapIndex, swapCourse);
            //     break;
            // }
        }
        // DataWriter.saveCourses();
    }
    
    
    
}

