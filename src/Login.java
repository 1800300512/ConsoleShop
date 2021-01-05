import java.io.InputStream;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) throws ClassNotFoundException {
        boolean f = true;
        boolean t = false;
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
                for (int i = 0; i < product.length; i++) {
                    System.out.print(product[i].getId() + "\t");
                    System.out.print(product[i].getName() + "\t");
                    if (i != 0) {
                        System.out.print(product[i].getPrice() + "\t");
                    } else
                        System.out.print("price" + "\t");
                    System.out.println(product[i].getDsc());
                }
                int k = 0;
                int l = 0;
                Product spc[] = new Product[10];
                while (true) {
                    System.out.println("请输入要购买的商品编号");
                    String i = sc.next();


                    for (int j = 1; j < product.length; j++) {
                        if (i.equals(product[j].getId())) {
                            spc[k] = product[j];
                            t = true;
                            k++;
                            break;
                        }
                    }
                    if (!t) {
                        System.out.println("没有这个商品");
                    }
                    if (l == 0) {
                        System.out.println("是否继续购买，继续输入0，不继续输入1");
                        l = sc.nextInt();
                        if (l == 1)
                            break;
                    }
                }
                float a = 0;
                try {
                    for (int j = 0; j < spc.length; j++) {
                        if (spc[j].getId() != null) {
                            System.out.println(spc[j].getId());
                            System.out.println(spc[j].getName());
                            System.out.println(spc[j].getPrice());
                            System.out.println(spc[j].getDsc());
                            a = a + spc[j].getPrice();
                        }
                    }
                    System.out.println("总价格：" + a);
                } catch (NullPointerException e) {

                }
            } else {
                System.out.println("登录失败");
            }
        }
        sc.close();
    }
}
