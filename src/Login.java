import java.io.InputStream;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) throws ClassNotFoundException {
        boolean f = true;
        Scanner sc = new Scanner(System.in);
        while (f) {
            System.out.println("请输入用户名");
            String userName = sc.next();
            System.out.println("请输入密码");
            String passWord = sc.next();
            InputStream in = Class.forName("Login").getResourceAsStream("/1111.xlsx");
            InputStream out = Class.forName("Login").getResourceAsStream("/2222.xlsx");
            ReadUserExcel read = new ReadUserExcel();
            User user[] = read.readExcel(in);
            for (int i = 0; i < user.length; i++) {
                if (user[i].getUsername().equals(userName) && user[i].getPassword().equals(passWord)) {
                    f = false;
                    break;
                }
            }

            if (!f) {
                ReadProductExcel readProductExcel = new ReadProductExcel();
                Product product[] = readProductExcel.readExcel(out);
                System.out.println("登录成功");
                System.out.print("商品id" + "\t");
                System.out.print("商品名字" + "\t");
                System.out.print("商品价格" + "\t");
                System.out.println("商品描述");
                for (int i = 0; i < product.length; i++) {
                    System.out.print(product[i].getId() + "\t");
                    System.out.print(product[i].getName() + "\t");
                    System.out.print(product[i].getPrice() + "\t");
                    System.out.println(product[i].getDsc());
                }
            } else {
                System.out.println("登录失败");
            }
        }
        sc.close();
    }
}
