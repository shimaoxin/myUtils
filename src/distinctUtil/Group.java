package distinctUtil;

import java.util.List;

public class Group implements DistinctParent<Type>{
    
    private String id;
    
    private String name;
    
    private String code;
    
    private List<Type> types;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    @Override
    public List<Type> getChildren() {
        return types;
    }

    @Override
    public void setChildren(List<Type> children) {
        this.types = children;
    }

    @Override
    public String toString() {
        return "Group [id=" + id + ", name=" + name + ", code=" + code
                + ", types=" + types + "]"; 
    }


    
}
