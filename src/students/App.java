package students;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //我们在注册的时候，必须使用集合来封装我们的对象
        ArrayList<User> list=new ArrayList<>();

        System.out.println("欢迎来到dt的学神管理系统");
        System.out.println("请选择操作：1登录 2注册 3 忘记密码");
        Scanner sc=new Scanner(System.in);
        loop:while (true) {
            String choose=sc.next();
            switch (choose){
                //进行登录的操作
                case "1"->login(list);
                case "2"->regist(list);
                case"3"->forgetPassword(list);
                case"4"->{
                    System.out.println("谢谢你的使用，期待下次见面");
                    break loop;
                }
                default-> System.out.println("没有这个选项，请重新输入");
            }
        }
    }

    //登录操作
    private static  void login(ArrayList<User> list) {
        Scanner sc=new Scanner(System.in);
        for (int i=0;i<3;i++) {
            System.out.println("请输入用户名");
            String username=sc.next();
            boolean flag=contain( list,username);
            if(!flag){
                System.out.println("用户名未注册，请先前往注册");
                return;
            }
            System.out.println("请输入密码：");
            String password=sc.next();


            while (true) {
                String code=getcode();
                System.out.println("当前正确的验证码为："+code);
                System.out.println("请输入正确的验证码");
                String scode=sc.next();
                if(!scode.equalsIgnoreCase(code)){
                    System.out.println("验证码错误，请重新输入");
                    continue;
                }else {
                    System.out.println("验证码正确");
                    break;
                }
            }
            //验证用户名和密码正确
            //是否在集合中包含
            //用一个方法来验证是否用户名和密码正确

            //封装
            User userinfo=new User(username,null,null,password);
            //验证集合中是否满足用户名和密码校队正确
            boolean flag1=checkuserinfo(list,userinfo);
            if(!flag1){
                System.out.println("用户名和密码有误，请重新输入");
                if(i==2){
                    return ;
                }else{
                    System.out.println("你还有"+(2-i)+"次尝试机会，之后系统将被锁定");
                }
            }else{
                System.out.println("恭喜,可以使用管理系统了");
                StudentSystem ss=new StudentSystem();
                ss.startStudentSystem();
                break;
            }
        }
    }


    //注册操作
    /*优先级最高：
     */

    private static  boolean checkuserinfo(ArrayList<User> list,User userinfo){
        //遍历找集合中是否是与输入的相同
        for (int i = 0; i < list.size(); i++) {
            User user=list.get(i);
            if(user.getPassword().equals(userinfo.getPassword())&&user.getUsername().equals(userinfo.getUsername())){
                return true;
            }
        }
        return false;
    }

    private static  void regist(ArrayList<User> list) {
        //把用户信息放在对象中再填入集合中
        Scanner sc=new Scanner(System.in);
        //先输入用户名：
        /*长度3~15
          唯一
          必须是字母加上数字
         */
        //先验证格式是否正确，再确定是否唯一，保证效率，现在本地做
        String username;

        while (true) {
            System.out.println("请输入你的用户名");
             username=sc.next();

            boolean flag=checkusername(username);
            if(!flag)
            {
                System.out.println("格式不正确");
                //这里注意在不正确的时候，要注意重新输入直接在这个类中进行操作，所以我们使用循环进行包裹
                continue;//不正确，直接跳过后续，进入下一个循环
            }
            //现在我们进行判断用户名是否唯一getindex  or contain
            boolean checkIsOnly = contain(list,username);
            if(checkIsOnly){
                //如果是true代表存在相同的也就是不唯一
                System.out.println("用户名已被注册，请重新输入");
                continue;
            }else
            {
                break;
            }
        }

        //输入密码
        String password;
        while (true) {
            System.out.println("请输入您的密码：");
             password=sc.next();
            System.out.println("请再一次输入您的密码：");
            String password00=sc.next();
            if(!password00.equals(password))
            {
                System.out.println("请您重新输入，密码需要一致");
                continue;
            }else{
                System.out.println("密码输入成功，请进行后续操作");
                break;
            }
        }

        //输入身份证
        String id;
        while (true) {
            System.out.println("请输入您的身份证号码");
            id=sc.next();
            boolean flag=checkid(id);
            if(!flag){
                System.out.println("对不起，您的身份证输入错误，请重试");
                continue;
            }else{
                System.out.println("输入正确，注册完成");
                break;
            }
        }

        //输入手机号码
        String phone;
        while (true) {
            System.out.println("请输入手机号码：");
            phone=sc.next();
            boolean flag=checkphone(phone);
            if(!flag)
            {
                System.out.println("输入错误，请重新输入");
                continue;
            }else {
                System.out.println("输入成功");
                break;
            }
        }


        User u=new User(username,id,phone,password);
        list.add(u);
        System.out.println("注册成功");
        printlist(list);


    }

    private static void printlist(ArrayList<User> list) {
        for (int i = 0; i < list.size(); i++) {
           User u=list.get(i);
            System.out.println(u.getUsername()+'\t'+u.getId()+'\t'+u.getTelephone()+'\t'+u.getPassword());


        }
    }

    private  static  boolean checkphone(String phone) {
          if(phone.length()!=11) return false;
          if(phone.charAt(0)=='0') return false;
          for (int i = 0; i < phone.length(); i++) {
              char p=phone.charAt(i);
              if(!(p>='0'&&p<='9'))
              {
                  return false;
              }
          }
          return true;
      }

    private static boolean contain(ArrayList<User> list, String username) {
        //在集合中进行遍历看看是否有对象的name是一致的吗
        for (int i = 0; i < list.size(); i++) {
            String newname= list.get(i).getUsername();
            if(newname.equals(username)){
                return true;
            }
        }
        return false;
    }

    //忘记密码操作
    private static  void forgetPassword(ArrayList<User> list) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username=sc.next();
        boolean flag=contain(list,username);
        if(!flag){
            System.out.println("当前用户不存在，已退出当前操作");
            return;
        }
        System.out.println("请输入身份证号：");
        String personid=sc.next();
        System.out.println("请输入手机号码：");
        String telephone=sc.next();
        //先找到对应的位置
        int index=findindex(list,username);
        if(!(list.get(index).getId().equalsIgnoreCase(personid)&&list.get(index).getTelephone().equals(telephone))){
            System.out.println("对不起，您当前的账号信息不匹配，修改失败，已退出");
            return;
        }
        System.out.println("您现在可以输入密码了");
        String password=sc.next();
        list.get(index).setPassword(password);
        System.out.println("您的密码已经修改成功，已返回主程序，请完成登录操作");


    }
    private  static int findindex(ArrayList<User> list,String usename){
        for (int i = 0; i < list.size(); i++) {
            User st=list.get(i);
            String name=st.getUsername();
            if(usename.equals(name)){
                return i;
            }
        }return -1;
    }

    //定义一个判断格式是否正确的方法
    private  static boolean  checkusername(String username) {
        //先判断长度是否正确
        int length=username.length();
        if(length<3||length>15)
        {
            return false;
        }
            //判断是否全部为数字还是字母

            //只能是字母或者是数字不能是其他的
            for (int i = 0; i < username.length(); i++) {
                char c=username.charAt(i);
                if(!((c>'a'&&c<'z')||(c>'A'&&c<'Z')||(c>'0'&&c<'9')))
                {
                    return false;
                }
        }
            //还有不能全是数字
        //我们直接统计字母，看看是否大于1
        int count=0;
        for (int i = 0; i < username.length(); i++) {
            char c=username.charAt(i);
            if((c>='a'&&c<='z')||(c>='A'&&c<='Z'))
            {
                count++;
                if(count>0)
                {
                    break;
                }
            }
        }
       return count>0;

    }


    private   static  boolean checkid(String id){
        //输入身份证
        //长度18
        //不能以0为首
        //最后一位可以是x,X
        //前17位必须是数字
        if(id.length()!=18){
            return false;
        }
        char c=id.charAt(0);
        if(c=='0') {
            return false;
        }
        //前17位全部是数字
        for (int i = 0; i < id.length()-1; i++) {
            char cc =id.charAt(i);
            if(!(cc >='0'&& cc <='9')){
                return false;
            }
        }
        //最后一位是————————
        char mo=id.charAt(id.length()-1);
        if(!((mo>='0'&&mo<='9')||(mo=='x')||(mo=='X')))
        {
            return false;
        }
        return  true;


    }

    private  static String getcode(){
        //创建一个集合用来添加所有的大写和小写的字符
        ArrayList<Character> list=new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char)('a'+i));
            list.add((char)('A'+i));

        }
        StringBuilder sb=new StringBuilder();
       //随机抽取4个字符
        Random r=new Random();
        for (int i = 0; i < 4; i++) {
            //获取随机索引
            int index = r.nextInt(list.size());
            char c=list.get(index);
            sb.append(c);
        }
        sb.append(r.nextInt(10));
        //修改字符串的内容，，先改成字符数组
        char []arr =sb.toString().toCharArray();
        //拿着最后一个索引跟前面的随机索引进行交换
        int randomindex=r.nextInt(arr.length);
         //进行交换
        char temp=arr[randomindex];
        arr[randomindex]=arr[arr.length-1];
        arr[arr.length-1]=temp;
        return new String(arr);

    }
}
