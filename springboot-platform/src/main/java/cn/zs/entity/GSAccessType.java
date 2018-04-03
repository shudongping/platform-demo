package cn.zs.entity;

public class GSAccessType {
    private Integer id;

    private String name;

    public GSAccessType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public GSAccessType() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}