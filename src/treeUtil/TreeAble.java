package treeUtil;

import java.util.Collection;

public interface TreeAble<C extends Collection<T>, T> {
    public String getId();
    
    public String getParentId();
    
    public C getChildren();
    
    public void setChildren(C c);
}
