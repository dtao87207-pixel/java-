package practice.array;

import java.util.ArrayList;

public class 增删改查 {
    static void main() {
        ArrayList<String>   list=new ArrayList<>();
        list.add("点赞");
        list.add("投币");
        list.add("转发");
        list.add("三连");
        for (int i = 0; i < list.size(); i++) {
            String a=list.get(i);
            System.out.print(a);
        }
    }
}
