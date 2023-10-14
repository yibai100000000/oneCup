import java.io.Serializable;
import java.util.Scanner;

public class User extends People implements Serializable {
    public User(){
        super();
    }
    public User(Integer ID, String name, String password, String phoneNum, Double money, Integer point, String part) {
        super(ID,name,password,phoneNum,money,point,part);
    }


    /**
     * 显示能进行的操作
     */
    @Override
    public void showCtrl(){
        System.out.println("*******请选择您要进行的操作*******");
        System.out.println("0.退出");
        System.out.println("1.查看个人信息");
        System.out.println("2.修改个人信息");
        System.out.println("3.充值");
        System.out.println("4.消费");
        System.out.println("5.兑换积分");
    }


    /**
     * 重写父类方法
     */
    @Override
    public void method1() {
        showInfo();
    }

    @Override
    public void method2(Scanner sc) {
        changeInfo(sc);
    }

    @Override
    public void method3(Scanner sc) {
        reCharge(sc);
    }

    @Override
    public void method4(Scanner sc) {
        spend(sc);
    }

    @Override
    public void method5(Scanner sc) {
        exchange(sc);
    }

    /**
     * 查看个人信息
     */
    public void showInfo(){
        System.out.println("编号\t\t姓名\t\t密码\t\t\t\t电话\t\t\t\t金额\t\t积分\t\t角色");
        System.out.println(this.getID()+"\t\t"+this.getName()+"\t\t"+this.getPassword()+"\t\t\t"+this.getPhoneNum()+"\t\t"+this.getMoney()+"\t\t"+this.getPoint()+"\t\t"+this.getPart());
    }

    /**
     * 充值
     */
    public void reCharge(Scanner sc){
        System.out.println("请输入您的充值金额：");
        Double d1=sc.nextDouble();
        this.setMoney(this.getMoney()+d1);
        System.out.println(("已充值：" + d1 + "当前余额：" + this.getMoney()));
        System.out.println("您充值后的金额为："+this.getMoney());

    }

    /**
     * 消费
     */
    public void spend(Scanner sc){
        System.out.println("您的消费金额：");
        Double d1=sc.nextDouble();
        this.setMoney(this.getMoney()-d1);
        System.out.println("已消费："+d1+"，当前余额："+this.getMoney());
        System.out.println("您的剩余金额为："+this.getMoney());
    }


    /**
     * 修改个人信息
     */
    public void changeInfo(Scanner sc){
        System.out.println("请输入新的个人信息：");
        System.out.println("姓名：");
        this.setName(sc.next());
        System.out.println("密码：");
        this.setPassword(sc.next());
        System.out.println("电话号码：");
        this.setPhoneNum(sc.next());
        System.out.println("修改完成！");
    }

    /**
     * 兑换积分
     */
    public void exchange(Scanner sc){
        Integer role=MainPage.showRole();
        System.out.println("请输入您需要兑换的积分数量");

        int usePoint=sc.nextInt();
        setPoint(getPoint()-usePoint);
        setMoney(getMoney()+(usePoint/role));

        System.out.println("您当前剩余积分为："+getPoint());
        System.out.println("当前剩余积分为"+getPoint()+",卡上金额为"+getMoney()+"元");
    }


    /**
     * 退出
     */





}
