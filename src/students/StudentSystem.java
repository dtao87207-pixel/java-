package students;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    private  static  final String add_student="1";
    private static  final String delete_student="2";
    private  static  final String update_student="3";
    private  static  final String quary_student="4";
    private  static  final  String exit="5";

     public static void startStudentSystem()  {
        ArrayList<Student> list = new ArrayList<>();
        System.out.println("-------------欢迎来到我的学生管理系统------------");
        loop:
        while (true) {
            System.out.println("1:添加学生");
            System.out.println("2:删除学生");
            System.out.println("3:修改学生");
            System.out.println("4:查询学生");
            System.out.println("5:退出");
            System.out.println("请输入你的选择：");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();

            switch (choose) {
                case add_student -> charu(list);
                case delete_student -> shanchu(list);
                case update_student-> xiugai(list);
                case quary_student -> chaxun(list);
                case exit -> {
                    tuichu(list);
                    break loop;
                }
                default -> System.out.println("请您重新输入：");
            }
        }
    }

    //插入
    public static void charu(ArrayList<Student> list) {
        Student s = new Student();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请输入id:");
            String id = sc.next();
            //这里是为了判断是否为1
            //如果存在就再次进行
            if (checkid(list, id)) {
                System.out.println("请重新输入你的id");
            } else {
                s.setId(id);
                break;
            }
        }

        System.out.println("请输入姓名：");
        String name = sc.next();
        s.setName(name);

        System.out.println("请输入年龄");
        int age = sc.nextInt();
        s.setAge(age);

        System.out.println("请输入家庭住址：");
        String address = sc.next();
        s.setAddress(address);

        list.add(s);
        System.out.println("输入完成");
    }

    //删除
    public static void shanchu (ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的id");
        String id = sc.next();
        //我只有的得到对应的位置才能删除所以找到位置的方法
        int weizhi=getindex(list,id);
        if(weizhi==-1){
            System.out.println("对不起，你所输入的id有误，请重新尝试");
        }else{
            list.remove(weizhi);
            System.out.println("id为"+id+"删除成功");
        }

    }

    //修改
    public static void xiugai(ArrayList<Student> list) {
        System.out.println("请输入要修改的学生id：");
        Scanner sc=new Scanner(System.in);
        String newid=sc.next();
        int index=getindex(list,newid);
        if(index==-1)
        {
            System.out.println("不存在该id，请重新输入");
        }else{
            //得到位置，逐个改变
            Student newq=list.get(index);

            newq.setId(newid);

            //name
            System.out.println("请输入要修改的姓名");
            String name =sc.next();
            newq.setName(name);

            //age
            System.out.println("请输入要修改的年龄");
            int age=sc.nextInt();
            newq.setAge(age);

            //address
            System.out.println("请输入要修改的地址");
            String address=sc.next();
            newq.setAddress(address);

            System.out.println("修改成功");
        }
    }

    //查询
    public static void chaxun(ArrayList<Student> list) {
        if (list.size() == 0) {
            System.out.println("当前系统无信息，请稍后再试");
            return;
        }
        System.out.println("id\t\t姓名\t年龄\t家庭住址\t");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId() + "\t" + list.get(i).getName() + "\t" + list.get(i).getAge() + "\t" + list.get(i).getAddress() + "\t");
        }
    }

    //退出
    public static void tuichu(ArrayList<Student> list) {
        System.out.println("退出");
    }

    //id是否唯一
    public static boolean checkid(ArrayList<Student> list, String id) {
        /*for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                return true;  // 找到相同ID，说明已存在，不唯一
            }
        }
        return false;*/
        int m=getindex(list,id);
        if(m>=0) return true;
        else {
            return false;
        }
    }

    //要查看Id是否存在,并返回位置
    public static int  getindex(ArrayList<Student> list, String id) {
        //得到对象
        //遍历集合，找是否存在
        for (int i = 0; i < list.size(); i++) {
            //得到对象
            Student s=list.get(i);
            //得到id
            String idd=s.getId();
            if(id.equals(idd))
            {
                return i;
            }
        }
        return -1;
    }
}
