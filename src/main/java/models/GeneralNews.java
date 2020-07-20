package models;

public class GeneralNews extends News {
    private static final String DATABASE_TYPE= "general";//Constant
    private int id;
    public GeneralNews(String content,int userid){
        this.content=content;
        this.userid=userid;
        type=DATABASE_TYPE;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
