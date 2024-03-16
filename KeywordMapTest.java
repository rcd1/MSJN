import java.util.HashMap;

public class KeywordMapTest {
    private static HashMap<String, String> test;

    public static HashMap<String, String> loadLAEKeywords() {
        test = new HashMap<String, String>();
        test.put("AERO", "401,402");
        test.put("AFAM", "201-580");
        test.put("ANTH", "101-499");
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
        test.put("GERM", "109-615");
        test.put("HIST", "101-692");
        test.put("ITAL", "121-561");
        test.put("JAPA", "121-500");
        test.put("LASP", "201-451");
        test.put("LATN", "109-580");
        test.put("LING", "101-600");
        test.put("MART", "110-341");
        test.put("MUSC", "110-140");
        test.put("NAVY", "401,402");
        test.put("PHIL", "101-103");
        test.put("PHIL", "114-598");
        test.put("POLI", "101-499");
        test.put("PORT", "121-615");
        test.put("PSYC", "101-498");
        test.put("RELG", "101-552");
        test.put("RUSS", "121-616");
        test.put("SOCY", "101-399");
        test.put("SOST", "101-500");
        test.put("SPAN", "109-615");
        test.put("THEA", "170-565");
        test.put("WGST", "112-555");
        return test;
    }

    public static HashMap<String, String> loadLSEKeywords() {
        test = new HashMap<String, String>();
        // test.put("ANTH", "161-161");
        // test.put("ASTR", "101-101");
        test.put("BIOL", "101,101L");
        // test.put("BIOL", "110-110");
        test.put("CHEM", "111,111L");
        // test.put("CHEM", "141-141");
        test.put("ENVR", "101,101L");
        // test.put("ENVR", "200-200");
        // test.put("GEOG", "201,202");
        test.put("GEOL", "101,103,201,201,215,215L");
        // test.put("GEOL", "302-302");
        test.put("MSCI", "101,102");
        test.put("MSCI", "210,210L");
        // test.put("MSCI", "215,215L");
        // test.put("PHYS", "211,211L");
        return test;
    }

    public static HashMap<String, String> loadAIUKeywords() {
        test = new HashMap<>();
        test.put("AFAM", "202");
        test.put("ARTE", "101,260");
        test.put("ARTH", "105,106");
        test.put("ARTS", "103,104,210");
        test.put("CLAS", "220");
        test.put("CPLT", "150,270");
        test.put("DANC", "101");
        test.put("ENGL", "200,270,280,282,283,284,285,286,287,288");
        test.put("FAMS", "110,180,240");
        test.put("FREN", "290");
        test.put("GERM", "270,290");
        test.put("MART", "101,110,201,210");
        test.put("MUSC", "110,113,114,115,140,310");
        test.put("RELG", "270");
        test.put("RUSS", "280");
        test.put("SPAN", "220");
        test.put("THEA","170,181,200");
        return test;
    }

    public static HashMap<String, String> loadAP1Keywords() {
        test = new HashMap<>();
        test.put("STAT","511,512,513");
        return test;
    }

    public static HashMap<String, String> loadAP2Keywords() {
        test = new HashMap<>();
        test.put("MATH","242,300,520,546,554,574");
        return test;
    }

    public static HashMap<String, String> loadAP3Keywords() {
        test = new HashMap<>();
        test.put("MART","201,210,380,581D,371,571C");
        test.put("MATH","527,576");
        return test;
    }

    public static HashMap<String, String> loadAP4Keywords() {
        test = new HashMap<>();
        test.put("EMCH","535");
        test.put("ELCT","331,531");
        return test;
    }

    public static HashMap<String, String> loadAP5Keywords() {
        test = new HashMap<>();
        test.put("LING","340,421,440,565,567");
        return test;
    }

    public static HashMap<String, String> loadCMSKeywords() {
        test = new HashMap<>();
        test.put("PHIL","213,325");
        test.put("SAEL","200");
        test.put("SPCH","140,145,213,230,260");
        return test;
    }

    public static HashMap<String, String> loadGSSKeywords() {
        test = new HashMap<>();
        test.put("AFAM","201,218,355");
        test.put("ANTH","101,102,204,210,211,212,213,244,273,280");
        test.put("COLA","298");
        test.put("CRJU","101");
        test.put("EDEX","205");
        test.put("EDTE","202,218");
        test.put("EDUC","360");
        test.put("GEOG","103,121,210,221,223,224,225,226,228");
        test.put("JSTU","218");
        test.put("LASP","331");
        test.put("LING","101,273");
        test.put("MUSC","210");
        test.put("POLI","101,201");
        test.put("PSYC","101");
        test.put("RELG","101,338");
        test.put("SOCY","101,301,307,309,310,340,355");
        test.put("SOWK","222");
        test.put("WGST","112,113,210,300");
        return test;
    }

    public static HashMap<String, String> loadGHSKeywords() {
        test = new HashMap<>();
        test.put("ARTH","107");
        test.put("FAMS","300");
        test.put("GERM","280");
        test.put("HIST","101,102,103,104,105,106,108,109,110,111,112,201,214");
        test.put("SOST","201,202");
        return test;
    }

    public static HashMap<String, String> loadGFLKeywords() {
        test = new HashMap<>();
        test.put("ARAB","121,122");
        test.put("ASLG","121,122");
        test.put("CHIN","121,122");
        test.put("FREN","109,110,121,122");
        test.put("GERM","109,110,121,122");
        test.put("GREK","121,122");
        test.put("ITAL","121,122");
        test.put("JAPA","121,122");
        test.put("LATN","109,110,121,122");
        test.put("PORT","121,122");
        test.put("RUSS","121,122");
        test.put("SPAN","109,110,111,121,122");
        return test;
    }
}
