package treeUtil;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Area> areas = new ArrayList<Area>();
        areas.add(new Area("china", "�й�", null));
        areas.add(new Area("beijing", "����", "china"));
        areas.add(new Area("chongqing", "����", "china"));
        areas.add(new Area("qijiang", "�뽭��", "chongqing"));
        areas.add(new Area("wansheng", "��ʢ��", "chongqing"));
        areas.add(new Area("chaoyang", "������", "beijing"));
        areas.add(new Area("usa", "����", null));
        areas.add(new Area("jz", "����", "usa"));
        List<Area> list = TreeUtil.changeToTree(areas);
        System.out.println(list.toString());
    }
}
