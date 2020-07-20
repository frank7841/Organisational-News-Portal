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
    public int getUserid() {return userid; }

    public void setUserid(int userid) { this.userid = userid; }

    public static String getDatabaseType() {
        return DATABASE_TYPE;
    }
    public void  setDatabaseType(String type){
        type=DATABASE_TYPE;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
