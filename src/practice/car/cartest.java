package practice.car;



import java.util.Scanner;

public class cartest {
    static void main() {
        car[] arr =new car[3];
        Scanner sc=new Scanner(System.in);
        sc.nextInt();
        for (int i=0;i<arr.length;i++) {
            //创建汽车对象
            car a = new car();
            String brand = sc.next();
            a.setBrand(brand);
            int price = sc.nextInt();
            a.setPrice(price);
            String color = sc.next();
            a.setColor(color);
            arr[i]=a;
        }
        for (int i = 0; i < arr.length; i++) {
            car temp=arr[i];
            System.out.println(temp.getBrand()+" "+temp.getColor()+" "+temp.getPrice());
        }

    }

}
