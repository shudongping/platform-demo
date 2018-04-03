package cn.zs.entity;

public class GSServiceRole {
    private String id;

    private String serviceId;

    private String roleId;

    public GSServiceRole(String id, String serviceId, String roleId) {
        this.id = id;
        this.serviceId = serviceId;
        this.roleId = roleId;
    }

    public GSServiceRole() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }
}