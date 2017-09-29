package distinctUtil;

/** 
 * 类别
* @author 石茂新 232601982@qq.com 
* @date 2017年9月29日 下午5:51:11 
*  
*/
public class Category implements DistinctChild{
    
    private String id;
    
    private String name;

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
        return "Category [id=" + id + ", name=" + name + "]";
    }
    
    
}
