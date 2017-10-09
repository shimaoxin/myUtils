package weightUtil;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Award> list = new ArrayList<Award>();
        list.add(new Award("iphone8", 1));
        list.add(new Award("激活红包", 10));
        list.add(new Award("现金红包", 40));
        list.add(new Award("话费", 59));
        for(int i=0; i<100; i++) {
            System.out.println(WeightUtil.doWeight(list));
        }
        
    }
}
