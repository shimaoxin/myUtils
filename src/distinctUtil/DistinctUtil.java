package distinctUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
* @ClassName: DistinctUtil 
* @author 石茂新 232601982@qq.com 
* @date 2017年1月13日 下午4:11:57 
*  
*/
public class DistinctUtil {
    
    /** 
    * 由于数据库一对多连表查询会有多条重复的字段数据，这里把重复的数据变为一条,不重复的放在集合里
    * 现在支持三层
    * @param pclass
    * @param repeats
    * @return
    * @throws Exception    
    * @author 石茂新 232601982@qq.com    
    * @date 2017年1月13日 下午4:14:40 
    */
    public static <S extends DistinctChild, C extends DistinctChild, P extends DistinctParent<C>> 
    List<P> distinct(List<?> repeats, Class<P> pclass,Class<C> cclass, Class<S> sclass) throws Exception {
        Map<Object, P> map = new HashMap<Object, P>();
        Map<Object, C> childMap = new HashMap<Object, C>();
        for(Object obj : repeats) {
            P parent = null;
            C child = null;
            List<C> children = null;
            Class<?> clazz = obj.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for(Field field : fields) {
                field.setAccessible(true);
                if(field.isAnnotationPresent(Unique.class)) {
                    Object key = field.get(obj);
                    parent = map.get(key);
                    if(parent == null) {
                        parent = pclass.newInstance();
                        parent.setChildren(new ArrayList<C>());
                        map.put(key, parent);
                    }
                    children = parent.getChildren();
                    break;
                }
            }
            if(parent == null) return null;
            for(Field field : fields) {
                field.setAccessible(true);
                if(field.isAnnotationPresent(ChildUnique.class)) {
                    Object key = field.get(obj);
                    child = childMap.get(key);
                    if(child == null) {
                        child = cclass.newInstance();
                        childMap.put(key, child);
                        children.add(child);
                    }
                    break;
                }
            }
            if(child == null) {
                child = cclass.newInstance();
                children.add(child);
            }
            S subChild = null;
            if(sclass != null) subChild =  sclass.newInstance();
            for(Field field : fields) {
                field.setAccessible(true);
                if(field.isAnnotationPresent(ParentValue.class)) {
                    ParentValue parentValue = field.getAnnotation(ParentValue.class);
                    Field pfield = pclass.getDeclaredField(parentValue.name());
                    if(pfield == null) continue;
                    pfield.setAccessible(true);
                    if(pfield.get(parent) != null) continue;
                    pfield.set(parent, field.get(obj));
                } 
                if(field.isAnnotationPresent(ChildValue.class)){
                    ChildValue childValue = field.getAnnotation(ChildValue.class);
                    Field cfield = cclass.getDeclaredField(childValue.name());
                    if(cfield == null) continue;
                    cfield.setAccessible(true);
                    if(cfield.get(child) != null) continue;
                    cfield.set(child, field.get(obj));
                }
                if(field.isAnnotationPresent(SubChildValue.class)) {
                    if(sclass != null && subChild != null) {
                        SubChildValue subChildValue = field.getAnnotation(SubChildValue.class);
                        Field sfield = sclass.getDeclaredField(subChildValue.name());
                        if(sfield == null) continue;
                        sfield.setAccessible(true);
                        sfield.set(subChild, field.get(obj));
                    }
                }
            }
            if(child instanceof DistinctParent && subChild != null) {
                @SuppressWarnings("unchecked")
                DistinctParent<S> dChild = (DistinctParent<S>) child;
                if(dChild.getChildren() == null) dChild.setChildren(new ArrayList<S>());
                dChild.getChildren().add(subChild);
            }
        }
        return new ArrayList<>(map.values());
    }
    
    public static <C extends DistinctChild, P extends DistinctParent<C>> 
    List<P> distinct(List<?> repeats, Class<P> pclass,Class<C> cclass) throws Exception {
        return distinct( repeats, pclass, cclass, null);
    }
    
}


