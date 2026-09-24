package practice.goods;

import practice.goods.good;

public class goodtest {
    static void main() {
        good [] arr=new good[3];


        good g1= new good(01,"华为",6666,199);
        good g2= new good(02,"小米",1111,19);
        good g3= new good(03,"苹果",69999,1992);

        arr[0]=g1;
        arr[1]=g2;
        arr[2]=g3;
        for(int i=0;i<3;i++)
        {
            good temp=arr[i];
            System.out.println(temp.getId()+" "+temp.getKucun()+" "+temp.getName()+" "+temp.getPrice());
        }

    }
}
