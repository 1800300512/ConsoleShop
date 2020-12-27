import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) throws ClassNotFoundException {
        boolean f=true;
        Scanner sc = new Scanner(System.in);
        while(f) {
            System.out.println("请输入用户名");

            String userName = sc.next();
            //yzdlx6 System.out.println("你输入的用户名为：" + userName);
            System.out.println("请输入密码");
            String passWord = sc.next();
            // System.out.println("你输入的密码为：" + passWord);



            // File file = new File("C:\\Users\\lenovo\\Desktop\\111\\1111.xlsx");
            InputStream in = Class.forName("Login").getResourceAsStream("/1111.xlsx");
            ReadExcel read = new ReadExcel();
            User user[] = read.readExcel(in);

            for (int i = 0; i < user.length; i++) {
                if (user[i].getUsername().equals(userName) && user[i].getPassword().equals(passWord)) {
                    f = false;
                    break;
                }

            }
            if (!f) {
                System.out.println("登录成功");
            } else {
                System.out.println("登录失败");
            }
        }
        sc.close();
    }
}
