import java.util.Random;
import java.util.Scanner;

public class ATM {
Account[] account;


public void initialArry(){
    account = new Account[50];
}
    Scanner input = new Scanner(System.in);
//首页
    public void start(){
        System.out.println("==欢迎进入黑马银行ATM系统==");
        System.out.println("1、用户登录");
        System.out.println("2、用户开户");
        System.out.println("0、退出系统");
    }

    //登录页
    public int login() {
        System.out.println("===========系统登录操作============");
        if (this.account [0]== null) {
            System.out.println("您好，当前系统无账户~");
            return -1;
        } else {
            System.out.println("请您输入登录卡号：");
            long num1 = input.nextInt();
            int i=0;
            for(i=0;this.account[i]!=null;i++){
                if(this.account[i].cardNum==num1) {
                    System.out.println("请您输入登录密码：");
                    String passport1 = input.next();

                        while(!(this.account[i].passport.equals(passport1))) {
                            System.out.println("密码错误");
                            System.out.println("请您重新输入登录密码：");
                            passport1 = input.next();
                        }

                        if (this.account[i].sex.equals("男")) {
                            System.out.println("恭喜您，" + this.account[i].name + "先生，您已进入系统，您的卡号是" + this.account[i].cardNum);

                        }
                        else if(this.account[i].sex.equals("女")){
                            System.out.println("恭喜您，" + this.account[i].name + "女士，您已进入系统，您的卡号是" + this.account[i].cardNum);

                        }
                        //登陆成功
                    return i;//此处进入另一个页面
                }
            }
                System.out.println("系统中不存在该账户卡号~");
            }
        return -1;
    }

    //开户页 两个问题
    public Account establish(){
        System.out.println("=========系统开户操作==========");
        System.out.println("请输入您的账号用户名：");
        String name = input.next();
        System.out.println("请输入您的性别");//性别使用元素查找法
        String sex = input.next();
        while(!sex.equals("男")&&!sex.equals("女")){
            System.out.println("您输入的性别有误");
            System.out.println("请输入您的性别:");
            sex = input.next();
        }
        System.out.println("请输入您的账户密码：");
        String passport1 = input.next();
        System.out.println("请再次输入您的账户密码：");
        String passport2 = input.next();
        while(!(passport1.equals(passport2))){
            System.out.println("您两次输入的密码不一致，请重新确认~");
            System.out.println("请输入您的账户密码：");
            passport1 = input.next();
            System.out.println("请再次输入您的账户密码：");
            passport2 = input.next();
        }
        System.out.println("请输入您的账户每次取款限额：");//此处加上判断输入的是否是数字:可以通过异常
        int limitMoney = input.nextInt();
        Random random = new Random();
        int[] num=new int[8];
        for(int i =0;i<8;i++){
        num[i]= random.nextInt(10);
        }
        long cardNum = 0;
        for(int i =0;i<8;i++){
            int bit = (int) Math.pow(10, 7 - i);//记一记
            cardNum +=num[i]*bit;
        }
        if (sex.equals("男")) {
            System.out.println("恭喜您，" +name + "先生，您开户成功，您的卡号是" +cardNum);
        }
        else if(sex.equals("女")){
            System.out.println("恭喜您，" +name + "女士，您开户成功，您的卡号是" +cardNum);
        }
        int accountMoney = 0;
         Account account = new Account(cardNum, name, sex,passport1, accountMoney,limitMoney);
         return account;
    }
//业务页
    public void service(){
        System.out.println("1、查询账户");
        System.out.println("2、存款");
        System.out.println("3、取款");
        System.out.println("4、转账");
        System.out.println("5、修改密码");
        System.out.println("6、退出");
        System.out.println("7、注销账户");
    }
//查询账户页面
    public void showAccount(int num) {
        System.out.println("==============当前账户信息如下============");
        System.out.println("卡号："+this.account[num].cardNum);
        System.out.println("户主："+this.account[num].name);
        System.out.println("性别："+this.account[num].sex);
        System.out.println("余额："+this.account[num].accountMoney);
        System.out.println("限额："+this.account[num].limitMoney);
    }
}

