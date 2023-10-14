import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Manager extends People implements Serializable {
    public List<People> userList;

    public List<People> getUserList() {
        return userList;
    }

    public void setUserList(List<People> userList) {
        this.userList = userList;
    }

    public Manager(){
        super();
    }

    public Manager(Integer ID, String name, String password, String phoneNum, Double money, Integer point, String part, List<People> userList) {
        super(ID,name,password,phoneNum,money,point,part);
        this.userList=userList;

    }


    /**
     * 显示能进行的操作
     */
    @Override
    public void showCtrl(){
        System.out.println("*******请选择您要进行的操作*******");
        System.out.println("0.退出");
        System.out.println("1.查看所有会员信息");
        System.out.println("2.添加会员");
        System.out.println("3.删除会员");
        System.out.println("4.初始化会员密码");
        System.out.println("5.修改积分兑换规则");
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
        addUser(sc);
    }

    @Override
    public void method3(Scanner sc) {
        delUser(sc);
    }

    @Override
    public void method4(Scanner sc) {
        chPassword(sc);
    }

    @Override
    public void method5(Scanner sc) {
        changeRole(sc);
    }

    /**
     * 查看所有会员信息
     */
    public void showInfo(){
        System.out.println("所有人员信息如下：");
        System.out.println("编号\t\t姓名\t\t密码\t\t\t\t电话\t\t\t\t金额\t\t积分\t\t角色");
        for (People u1:userList) {
            System.out.println(u1.getID()+"\t\t"+u1.getName()+"\t\t"+u1.getPassword()+"\t\t\t"+u1.getPhoneNum()+"\t\t"+u1.getMoney()+"\t\t"+u1.getPoint()+"\t\t"+u1.getPart());
        }
    }


    /**
     * 添加会员
     */
    public void addUser(Scanner sc){
        System.out.println("添加会员");

        System.out.println("请输入会员身份(u（ser）或m（anager）)");
        String part=sc.next();
        People p1;
        if("u".equals(part)){
            p1=new User();
        }else{
            p1=new Manager();
        }

        p1.setID(userList.size());

        System.out.println("请输入会员姓名(三个字符以内)");
        String name=sc.next();
        for (People p:userList){
            if(p.getName().equals(name)){
                System.out.println("姓名重复，创建会员失败");
                return;
            }
        }
        p1.setName(name);
        System.out.println("请输入会员密码(建议6位)");
        p1.setPassword(sc.next());
        System.out.println("请输入会员电话");
        p1.setPhoneNum(sc.next());

        p1.setPart(part);
        p1.setMoney(0.0);
        p1.setPoint(0);

        userList.add(p1);

    }

    /**
     * 删除会员
     * 在这里，为了避免ConCurrentModificationException异常使用迭代器删除元素
     */
    public void delUser(Scanner sc){
        System.out.println("请输入删除会员的姓名");
        String name=sc.next();
        if("root".equals(name)){
            System.out.println("root无法被删除");
            return;
        }
//        for (People p1:userList) {
//            if(p1.getName().equals(name)){
//                userList.remove(p1);
//            }
//        }
        Iterator<People> iterator=userList.iterator();
        while(iterator.hasNext()){
            People p1= iterator.next();
            if(p1.getName().equals(name)){
                iterator.remove();
                System.out.println("删除成功");
                return;
            }
        }
        System.out.println("删除失败，请确认名称是否正确");
    }


    /**
     * 初始化会员密码
     */
    public void chPassword(Scanner sc){
        System.out.println("请输入初始化密码会员的姓名");
        String name=sc.next();

        for (People p1:userList) {
            if(p1.getName().equals(name)){
                p1.setPassword("123456");
                System.out.println("初始化完成，密码为123456");
                return;
            }
        }
    }

    /**
     * 查看当前积分兑换规则
     * @param role
     */
    public void getRole(Integer role){
        System.out.println("当前是"+role+"分兑换一元");
    }

    /**
     * 修改积分兑换规则
     */
    public void changeRole(Scanner sc){
        MainPage.changePoint(sc);
    }



}
