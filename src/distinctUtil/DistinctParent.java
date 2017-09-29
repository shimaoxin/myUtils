package distinctUtil;

import java.util.List;

public interface DistinctParent<T extends DistinctChild> {
    
    public List<T> getChildren();
    
    public void setChildren(List<T> children);
    
}
