import java.util.HashMap;

public class KeywordMapTest {
    private static HashMap<String,String> test;

    public static HashMap<String,String> loadLAEKeywords() {
        test = new HashMap<String, String>();
        test.put("AERO","401,402");
        test.put("AFAM", "201-580");
        test.put("ANTH","101-499");
        test.put("ARMY", "401,402");
        test.put("ARTE", "101,260");
        test.put("ARTH", "105-366");
        test.put("ARTS", "103-261");
        test.put("CHIN", "122-550");
        test.put("CLAS", "220-598");
        test.put("CPLT", "150-597");
        test.put("CRJU", "101-494");
        test.put("DANC", "101-381");
        test.put("ECON", "123-499");
        test.put("ENGL", "270-499");
        test.put("FAMS", "180-581");
        test.put("FREN", "109-615");
        test.put("GEOG", "103-595");
        test.put("GERM" ,"109-615"); 
        test.put("HIST" ,"101-692"); 
        test.put("ITAL" ,"121-561"); 
        test.put("JAPA" ,"121-500"); 
        test.put("LASP" ,"201-451"); 
        test.put("LATN" ,"109-580"); 
        test.put("LING" ,"101-600");
        test.put("MART","110-341"); 
        test.put("MUSC","110-140"); 
        test.put("NAVY","401,402"); 
        test.put("PHIL","101-103"); 
        test.put("PHIL","114-598"); 
        test.put("POLI","101-499"); 
        test.put("PORT","121-615"); 
        test.put("PSYC","101-498"); 
        test.put("RELG","101-552"); 
        test.put("RUSS","121-616"); 
        test.put("SOCY","101-399"); 
        test.put("SOST","101-500"); 
        test.put("SPAN","109-615"); 
        test.put("THEA","170-565"); 
        test.put("WGST","112-555");
        return test;
    }

    public static HashMap<String,String> loadLSEKeywords() {
        test = new HashMap<String, String>();
        test.put("ANTH","161-161");
        test.put("ASTR","101-101");
        test.put("BIOL","101,101L"); 
        test.put("BIOL","110-110");
        test.put("CHEM","111,111L"); 
        test.put("CHEM","141-141");
        test.put("ENVR","101,101L"); 
        test.put("ENVR","200-200");
        test.put("GEOG","201,202");
        test.put("GEOL","101,103");
        test.put("GEOL","201,201");
        test.put("GEOL","215,215L"); 
        test.put("GEOL","302-302");
        test.put("MSCI","101,102");
        test.put("MSCI","210,210L"); 
        test.put("MSCI","215,215L"); 
        test.put("PHYS","211,211L");
        return test;
    }
}
