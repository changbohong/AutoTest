package edu.bupt.cbh.testing.vo;

/**
 * Created by changbohong on 2017/11/16.
 */
public class ZTreeNodeVO {
    private String id;
    private String pId;
    private String name;
    private Boolean open;

    public ZTreeNodeVO(String id, String pId, String name, Boolean open) {
        this.id = id;
        this.pId = pId;
        this.name = name;
        this.open = open;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    @Override
    public String toString() {
        return "ZTreeNodeVO{" +
                "id='" + id + '\'' +
                ", pId='" + pId + '\'' +
                ", name='" + name + '\'' +
                ", open=" + open +
                '}';
    }
}
