package cn.zs.entity;

public class GSUser {
    private String id;

    private String name;

    private String pwd;

    private String creatorId;

    public GSUser(String id, String name, String pwd, String creatorId) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.creatorId = creatorId;
    }

    public GSUser() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }
}