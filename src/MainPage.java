import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainPage {

    //含主用户root，密码为123456，可以通过root操作，例如添加会员

    public static List<People> userList;
    public static Scanner sc;

    private static Integer pointRole;    //x积分兑换一元

    private static final String FILEPATH="object.dat";  //序列化路径


    static {

        pointRole = 10;
        sc = new Scanner(System.in);
        userList = new ArrayList<People>();
        userList=SerializationUtils.deserializeObject(FILEPATH);


    }

    public static void main(String[] args) {

        logo();
        while(true){
            boolean isLogin=true;
            People p1=login(sc);
            if(p1!=null){

                while(isLogin){
                    p1.showCtrl();
                    int choice=sc.nextInt();
                    switch(choice){
                        case 0:isLogin=false;break;
                        case 1:p1.method1();break;
                        case 2:p1.method2(sc);break;
                        case 3:p1.method3(sc);break;
                        case 4:p1.method4(sc);break;
                        case 5:p1.method5(sc);break;
                        default:
                            System.out.println("输入数字错误，请重新输入");
                    }
                }
                SerializationUtils.serializeObject(userList,FILEPATH);

            }
        }


    }


    public static Integer showRole(){
        System.out.println("当前积分兑换规则为："+pointRole+"积分兑换一元");
        return pointRole;
    }

    public static void logo(){
        System.out.println("*******欢迎您访问“一杯奶茶”会员积分平台*******");
        System.out.println("请先登录！");
    }


    public static People login(Scanner sc){

        System.out.println("请输入您的用户名：");
        String name=sc.next();
        System.out.println("请输入您的密码：");
        String password=sc.next();
        for(People p1:userList){
            if(p1.getName().equals(name)){
                if(p1.getPassword().equals(password)){
                    System.out.println("恭喜您登录成功！");
                    return p1;
                }

            }
        }
        System.out.println("登录失败，请检查用户名或密码");
        return null;

    }


    public static void changePoint(Scanner sc){
        System.out.println("修改积分兑换资格");
        System.out.println("请输入多少积分兑换一元：");

        Integer role=new Scanner(System.in).nextInt();
        pointRole=role;

        System.out.println("修改完成，现在是"+pointRole+"兑换一元");
    }
}
