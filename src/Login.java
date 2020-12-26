import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        System.out.println("请输入用户名");
        Scanner sc=new Scanner(System.in);
        String userName =sc.next();
        System.out.println("你输入的用户名为：" + userName);
        System.out.println("请输入密码");
        String passWord= sc.next();
        System.out.println("你输入的密码为：" + passWord);
        sc.close();
    }
}
