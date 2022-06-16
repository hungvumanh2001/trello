package model;

public class Post {
    private int id;
    private String title;
    private int dateCreated;
    private String content;
    private String description;
    private String authority;
    private String status;
    private String userid;
    private String typeid;

    public Post() {
    }

    public Post(int id, String title, int dateCreated, String content, String description, String authority, String status, String userid, String typeid) {
        this.id = id;
        this.title = title;
        this.dateCreated = dateCreated;
        this.content = content;
        this.description = description;
        this.authority = authority;
        this.status = status;
        this.userid = userid;
        this.typeid = typeid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(int dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }
}
