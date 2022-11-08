import java.util.ArrayList;

public class AcctList_50437 {

  ArrayList<Account_50437> acctList = new ArrayList<Account_50437>();

  AcctList_50437() {
    acctList = new ArrayList<>();
    acctList.add(new Account_50437(1, "Cactus", 1000));
    acctList.add(new Account_50437(2, "Celsia", 500));
    acctList.add(new Account_50437(3, "Clove pink", 1500));
    acctList.add(new Account_50437(4, "Crown Imperial", 900));
    acctList.add(new Account_50437(5, "Daffodil", 1200));
    acctList.add(new Account_50437(6, "Daisy", 1700));
    acctList.add(new Account_50437(7, "Dandelion", 500));
    acctList.add(new Account_50437(8, "Dittany", 600));
  }

  ArrayList<Account_50437> filterName(String name) {
    ArrayList<Account_50437> result = new ArrayList<>();
    for (Account_50437 acct : acctList) {
      if (acct.getName().startsWith(name, 0)) {
        result.add(acct);
      }
    }
    return result;
  }

  ArrayList<Account_50437> balanceLessThan(int balance) {
    ArrayList<Account_50437> result = new ArrayList<>();
    for (Account_50437 acct : acctList) {
      if (acct.getBalance() < balance) {
        result.add(acct);
      }
    }
    return result;
  }
}
