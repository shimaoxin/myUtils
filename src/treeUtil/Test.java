package treeUtil;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Area> areas = new ArrayList<Area>();
        areas.add(new Area("china", "中国", null));
        areas.add(new Area("beijing", "北京", "china"));
        areas.add(new Area("chongqing", "重庆", "china"));
        areas.add(new Area("qijiang", "綦江区", "chongqing"));
        areas.add(new Area("wansheng", "万盛区", "chongqing"));
        areas.add(new Area("chaoyang", "朝阳区", "beijing"));
        areas.add(new Area("usa", "美国", null));
        areas.add(new Area("jz", "加州", "usa"));
        List<Area> list = TreeUtil.changeToTree(areas);
        System.out.println(list.toString());
    }
}
