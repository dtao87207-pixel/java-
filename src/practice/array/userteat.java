package practice.array;

import java.util.ArrayList;
import java.util.Scanner;

public class userteat {
    static void main() {

        ArrayList<user>  test=new ArrayList<>();


        user ab=new user("董涛","001","1234");
        user a1=new user("黄","999","89890");
        user a2=new user("西","8989","8765");
        test.add(ab);
        test.add(a1);
        test.add(a2);
        boolean n=checkuser(test,"8989");
        System.out.println(n);
    }


    public static boolean checkuser(ArrayList<user> list,String id)
    {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id))
            {
                return true;
            }
        }
        return false;
    }
}
