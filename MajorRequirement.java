public class MajorRequirement implements Requirement {
    private String title;
    private Keyword keyword;

    public MajorRequirement(String title, Keyword keyword) {
        this.title = title;
        this.keyword = keyword;
    }

    public String getTitle() {
        return title;
    }



    public Keyword getKeyword() {
        return keyword;
    }

    
    @Override
    public boolean SatisfiesRequirement(Student student) {
        return true;
    }
    
}
