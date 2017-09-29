package distinctUtil;

import java.util.List;

public class Type implements DistinctChild,DistinctParent<Category>{
    
    private String id;
    
    private String name;
    
    private List<Category> categorys;
    
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

    

    @Override
    public String toString() {
        return "Type [id=" + id + ", name=" + name + ", categorys=" + categorys
                + "]";
    }

    @Override
    public List<Category> getChildren() {
        return categorys;
    }

    @Override
    public void setChildren(List<Category> children) {
        categorys = children;
    }
    
    
}
