package weightUtil;

import java.util.List;
import java.util.Random;

public class WeightUtil {
    
   /** 
    * 得到权重后的对象
    * @param list 实现WeightAble的集合
    * @return    
    * @author 石茂新 232601982@qq.com   
    * @date 2017年10月9日 下午3:45:04 
    */
    public static <T extends WeightAble> T doWeight(List<T> list) {
        if(list == null || list.size() == 0) return null;
        int totalWeight = 0;
        for(T t : list) {
            totalWeight += t.getWeight();
        }
        if(totalWeight == 0) return null;
        Random r = new Random();
        int ranNum = r.nextInt(totalWeight) + 1;
        for(T t : list) {
            ranNum -= t.getWeight();
            if(ranNum <= 0) return t;
        }
        return null;
    }
    
}
