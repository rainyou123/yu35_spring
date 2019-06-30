package web.transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Transactional(isolation = Isolation.REPEATABLE_READ , readOnly = false)
public class AccountService {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private TransactionTemplate transactionTemplate;
    public void transfer(int from , int to , double money){
        //减钱
        accountDao.reduceMoney(from , money);
        //int i = 1/0;
        //加钱
        accountDao.addMoney(to , money);
    }


    //用代码实现的代理
//    public void transfer(int from , int to , double money){
//        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
//                //减钱
//                accountDao.reduceMoney(from , money);
//                //int i = 1/0;
//                //加钱
//                accountDao.addMoney(to , money);
//            }
//        });
//    }
}
