import java.io.Serializable;
import java.util.Scanner;

public class People implements Serializable {
    private Integer ID;
    private String name;
    private String password;
    private String phoneNum;
    private Double money;
    private Integer point;  //积分
    private String part;    //部门

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public People(Integer ID, String name, String password, String phoneNum, Double money, Integer point, String part) {
        this.ID = ID;
        this.name = name;
        this.password = password;
        this.phoneNum = phoneNum;
        this.money = money;
        this.point = point;
        this.part = part;
    }

    public People() {

    }

    public void showCtrl(){

    }

    public void method1(){}

    public void method2(Scanner sc){}

    public void method3(Scanner sc){}

    public void method4(Scanner sc){}

    public void method5(Scanner sc){}
}
