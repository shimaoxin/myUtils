package distinctUtil;

import java.util.ArrayList;
import java.util.List;

public class Test {
    
    public static void main(String[] args) throws Exception {
        List<Attribute> list = new ArrayList<Attribute>();
        list.add(new Attribute("id1", "code1", "name1", "typeid1", "typename1","categoryid1","categoryname1"));
        list.add(new Attribute("id1", "code1", "name1", "typeid1", "typename1","categoryid2","categoryname2"));
        list.add(new Attribute("id1", "code1", "name1", "typeid2", "typename2","categoryid3","categoryname3"));
        list.add(new Attribute("id2", "code2", "name2", "typeid3", "typename3","categoryid4","categoryname4"));
        list.add(new Attribute("id2", "code2", "name2", "typeid4", "typename4","categoryid5","categoryname5"));
        list.add(new Attribute("id2", "code2", "name2", "typeid4", "typename4","categoryid6","categoryname6"));
        list.add(new Attribute("id2", "code2", "name2", "typeid3", "typename3","categoryid7","categoryname7"));
        list.add(new Attribute("id2", "code2", "name2", "typeid3", "typename3","categoryid8","categoryname8"));
        list.add(new Attribute("id2", "code2", "name2", "typeid3", "typename3","categoryid9","categoryname9"));
        list.add(new Attribute("id2", "code2", "name2", "typeid3", "typename3","categoryid10","categoryname10"));
        list.add(new Attribute("id2", "code2", "name2", "typeid3", "typename3","categoryid11","categoryname11"));
        list.add(new Attribute("id2", "code2", "name2", "typeid3", "typename3","categoryid12","categoryname12"));
        list.add(new Attribute("id2", "code2", "name2", "typeid3", "typename3","categoryid13","categoryname13"));
        long start = System.currentTimeMillis();
        List<Group> groups = DistinctUtil.distinct(list,Group.class, Type.class, Category.class);
        //List<Group> groups = DistinctUtil.distinct(list,Group.class, Type.class);
        long end = System.currentTimeMillis();
        System.out.println(groups);
        System.out.println(end - start);
    }
}
