package web.transfer;

public interface AccountDao {
    //加钱
    void addMoney(int id,double money);
    //减钱
    void reduceMoney(int id,double money);



}
//事物绑定在方法上 就是有问题出现时的一个回滚