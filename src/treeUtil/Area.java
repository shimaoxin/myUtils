package treeUtil;

import java.util.List;

public class Area implements TreeAble<List<Area>, Area>{
    
    private String code;
    
    private String name;
    
    private String parentCode;
    
    private List<Area> children;
    
    public Area(String code, String name, String parentCode) {
        super();
        this.code = code;
        this.name = name;
        this.parentCode = parentCode;
    }

    @Override
    public String getId() {
        return code;
    }

    @Override
    public String getParentId() {
        return parentCode;
    }

    @Override
    public void setChildren(List<Area> c) {
        this.children = c;
    }
    @Override
    public List<Area> getChildren() {
        return children;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    @Override
    public String toString() {
        String childrenString = "null";
        if(children != null) {
            childrenString = children.toString();
        }
        return "Area [code=" + code + ", name=" + name + ", parentCode="
                + parentCode + ", children=" + childrenString + "]";
    }
    
    
}
