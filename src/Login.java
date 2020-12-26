import java.io.File;
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
        /*if(userName.equals("zhangsan")&&passWord.equals("123")){

            System.out.println("登录成功");

        }else{
            System.out.println("登录失败");*/

        File file =new File("C:\\Users\\lenovo\\Desktop\\111\\1111.xlsx");
        ReadExcel read=new ReadExcel();
        User user[]=read.readExcel(file);
        boolean f=false;
        for(int i =0;i<=user.length;i++){
        if (user[i].getUsername().equals(userName)&&user[i].getPassword().equals(passWord)){
            f=false;
            break;
        }
        if(f){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
        }
    }
}
