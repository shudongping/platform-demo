package cn.zs.entity;

public class GSRole {
    private String id;

    private String name;

    private Integer roleType;

    private String creatorId;

    public GSRole(String id, String name, Integer roleType, String creatorId) {
        this.id = id;
        this.name = name;
        this.roleType = roleType;
        this.creatorId = creatorId;
    }

    public GSRole() {
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

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }
}