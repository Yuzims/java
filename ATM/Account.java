public class Account {
    long cardNum;
    String name;
    String sex;
    String passport;
    int accountMoney;
    int limitMoney;
    public Account(){

    }
    public Account(long cardNum, String name, String sex, String passport, int accountMoney, int limitMoney){
        this.cardNum = cardNum;
        this.name = name;
        this.sex = sex;
        this.passport = passport;
        this.accountMoney = accountMoney;
        this.limitMoney = limitMoney;
    }

}
