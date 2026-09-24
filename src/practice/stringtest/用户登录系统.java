package practice.stringtest;

import java.util.Scanner;
import java.util.StringJoiner;

public class 用户登录系统 {

    /*需求是已知正确的账号和密码，然后用户输入密码和账号，并有三次输入机会，会根据变化提示相应的内容*/

    static void main() {
        //已知正确的账号和密码

        StringJoiner st=new StringJoiner("--","(",")");
        st.add("qqq").add("hhh").add("uuu");
        System.out.println(st);
        String account="wasdt";
        String password="298989";
        for (int i = 0; i < account.length(); i++) {
            char temp=account.charAt(i);
            System.out.println("字符为："+temp+" ");
        }

        //用户输入账号和密码，并判断是否正确
        Scanner sc=new Scanner(System.in);
        //你有三次机会
        for (int i=0;i<3;i++) {
            System.out.println("请输入账户");
            String account1=sc.next();
            System.out.println("请输入密码");
            String password1=sc.next();
            if(account1.equals(account)&&password1.equals((password)))
            {
                System.out.println("恭喜正确");
                break;
            }
            else
            {
                System.out.println("对不起您的输入有误，您还有"+(2-i)+"次机会");
            }
        }
    }
}
