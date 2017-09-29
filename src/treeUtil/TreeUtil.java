package treeUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TreeUtil {
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <C extends Collection<T>, T extends TreeAble> C changeToTree(C collection) {
        if(collection == null || collection.size() == 0) return null;
        Map<String, C> parentMap = new HashMap<String, C>();
        Map<String, T> map = new HashMap<String, T>();
        C c = (C)new ArrayList<T>();
        for(T t : collection) {
            map.put(t.getId(), t);
            if(t.getParentId() == null || "".equals(t.getParentId())) {
                c.add(t);
            } else {
                C parents = parentMap.get(t.getParentId());
                if(parents == null) {
                    parents = (C)new ArrayList<T>();
                    parentMap.put(t.getParentId(), parents);
                }
                parents.add(t);
            }
        }
        for(String parentId : parentMap.keySet()) {
            T t = map.get(parentId);
            t.setChildren(parentMap.get(parentId));
        }
        return c;
    }
    
}
