import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class DataWriter extends DataConstants{

    //puts user list into JSON files
    public static void saveUsers(){
        UserList users = UserList.getInstance();
        ArrayList<User> userList= users.getUser();

        JSONArray jsonUsers= new JSONArray();

        for(int i=0; i< userList.size();i++){
            jsonUsers.add(getUserJSON(userList.get(i)));

        }
        try (FileWriter File = new FileWriter(USER_FILE_NAME)){
            file.write(jsonUsers.toJSONString());
            file.flush();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

        public static JSONObject getUserJSON(User user){
            JSONObject userDetails = new JSONObject();

            userDetails.put(USER_EMAIL, user.getEmail());
            userDetails.put(USER_FIRST_NAME, user.getFirstName());
            userDetails.put(USER_ID, user.getID().toString());
            userDetails.put(USER_LAST_NAME, user.getLastName());
            userDetails.put(USER_PASSWORD, user.getPassword());
            userDetails.put(USER_USER_NAME, user.getUserName());

            return userDetails;
        }

        public static void saveAllStudents(){
            Student students =Student.getInstance();
            ArrayList<Student> Student = students.getStudents();
            JSONArray jsonStudents = new JSONArray();

            for(int i=0;i< Student.size();i++){
                jsonStudents.add(getStudentJSON(Student.get(i)));
            }

            try (FileWriter file = new FileWriter(STUDENT_FILE_NAME)) { 
                file.write(jsonCourses.toJSONString());
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }

