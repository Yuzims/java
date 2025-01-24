import jdk.swing.interop.SwingInterOpUtils;

import java.awt.*;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String operation = "1";
        ATM atm = new ATM();
        atm.initialArry();
        while(!operation.equals("0")){
            atm.start();
            System.out.println("请输入您要进行的操作：");
            operation = input.next();
            switch (operation){
                case "1":
                        int num= atm.login();
                        if(num!=-1){
                            String operation2 ="1";
                            while(!operation2.equals("6")&&!operation2.equals("5")) {
                                if (atm.account[num].sex.equals("男")) {
                                    System.out.println("======="+atm.account[num].name+"先生，您可以办理以下业务：==========");
                                }
                                else if(atm.account[num].sex.equals("女")){
                                    System.out.println("======="+atm.account[num].name+"女士，您可以办理以下业务：==========");
                                }
                                atm.service();
                                System.out.println("请输入您想要的操作2：");
                                operation2 = input.next();
                                switch (operation2) {
                                    case "1":
                                        atm.showAccount(num);
                                        break;
                                    case "2":
                                        System.out.println("==========用户存钱操作============");
                                        System.out.println("请输入您想存储的金额：");
                                        int insertMoney = input.nextInt();
                                        atm.account[num].accountMoney += insertMoney;
                                        System.out.println("恭喜您，存款成功！");
                                        atm.showAccount(num);
                                        break;
                                    case "3":
                                        System.out.println("==============用户取钱操作=============");
                                        System.out.println("请输入您想取出的金额：");//0元写好一些
                                        int getMoney = input.nextInt();
                                        if (getMoney > atm.account[num].accountMoney) {
                                            System.out.println("余额不足，您账户目前余额是：" + atm.account[num].accountMoney);
                                        } else if (getMoney > atm.account[num].limitMoney) {
                                            System.out.println("你当前取款金额超过每次限额，每次最多可取：" + atm.account[num].limitMoney);
                                        } else {
                                            atm.account[num].accountMoney -= getMoney;
                                            System.out.println("恭喜您，取款" + getMoney + "成功！当前账户信息如下：");
                                            atm.showAccount(num);
                                        }
                                        break;
                                    case "4":
                                        System.out.println("==========用户转账操作==========");
                                        int accountnum=0;
                                        for(int i=0;i<atm.account.length;i++){
                                            if(atm.account[i]!=null){
                                                accountnum++;
                                            }
                                        }
                                        if(accountnum<=1){
                                            System.out.println("该系统中不足2个账户，不能进行转账，请去开户吧~");
                                        }
                                        else {
                                            if (atm.account[num].accountMoney <= 0) {
                                                System.out.println("您自己都没钱，就别转了吧~");
                                            } else {
                                                System.out.println("请您输入对方账户的卡号：");
                                                long cardnum = input.nextInt();
                                                int j=0;
                                                for (j= 0;atm.account[j]!=null; j++) {
                                                    if (atm.account[j].cardNum == cardnum) {
                                                        System.out.println("请您输入转账金额:");
                                                        int transferMoney = input.nextInt();
                                                        if (transferMoney > atm.account[num].accountMoney) {
                                                            System.out.println("余额不足，您当前账户的余额为：" + atm.account[num].accountMoney);
                                                        } else {
                                                            atm.account[j].accountMoney += transferMoney;
                                                            atm.account[num].accountMoney -= transferMoney;
                                                            System.out.println("转账成功！转账金额为" + transferMoney);
                                                        }
                                                        break;
                                                    }
                                                }
                                                if(atm.account[j]==null){
                                                System.out.println("系统中不存在该账户卡号~");
                                                }
                                            }
                                        }
                                        break;
                                    case "5":
                                        System.out.println("============用户修改密码操作===========");
                                        String passport = "1";
                                        while(!(passport.equals(atm.account[num].passport))){
                                        System.out.println("请您输入原密码：");
                                        passport =input.next();
                                        if(passport.equals(atm.account[num].passport)) {
                                            String newpassport = passport;
                                            while (newpassport.equals(atm.account[num].passport)) {
                                                System.out.println("请输入新密码：");
                                                newpassport = input.next();
                                                if (newpassport.equals(passport)) {
                                                    System.out.println("新密码不可以与旧密码一致");
                                                } else {
                                                    atm.account[num].passport = newpassport;
                                                    System.out.println("修改成功~请重新登录");
                                                    break;//跳出内层循环
                                                }
                                            }
                                            break;//跳出外层循环
                                        }
                                        else {
                                            System.out.println("密码错误");
                                        }
                                        }
                                        break;
                                    case "6":
                                        System.out.println("您确定要退出账户吗？y/n");
                                        String quit = input.next();
                                        switch (quit){
                                            case "y":
                                            case "Y":
                                                System.out.println("退出成功，欢迎下次光临");
                                                break;
                                            case "n":
                                            case "N":
                                                operation2="1";
                                                break;
                                        }
                                        break;
                                    case "7":
                                        System.out.println("您确定要注销账户吗？y/n");
                                        String cancel = input.next();
                                        switch (cancel){
                                            case "y":
                                            case "Y":
                                                System.out.println("注销成功，感谢您的使用~");
                                                break;
                                            case "n":
                                            case "N":
                                                operation2="1";
                                                break;
                                        }
                                        break;
                                    default:
                                        System.out.println("指令错误");
                                        break;
                                }

                            }
                    };

                    break;
                case "2":
                    int k=0;
                    for(k=0;k<atm.account.length;k++){
                        if(atm.account[k]==null){
                        atm.account[k]=  atm.establish();
                        break;
                        }
                    }
                    if(k==atm.account.length){
                        System.out.println("抱歉，该系统账户已满");
                    }
                    break;
                case "0":
                    System.out.println("感谢使用黑马银行ATM系统！欢迎下次光临~");
                    break;
                default:
                    System.out.println("指令错误");
                    break;
             }
        }
    }
}
