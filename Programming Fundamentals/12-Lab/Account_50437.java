public class Account_50437 {

  int id;
  String name;
  int balance = 0;

  Account_50437(int id, String name, int balance) {
    this.id = id;
    this.name = name;
    this.balance = balance;
  }

  int getID() {
    return id;
  }

  String getName() {
    return name;
  }

  int getBalance() {
    return balance;
  }

  int credit(int amount) {
    if (amount > 0) {
      balance += amount;
    }
    return balance;
  }

  int debit(int amount) {
    if (amount <= balance) {
      balance -= amount;
    } else {
      System.out.println("Amount exceeded balance");
    }
    return balance;
  }

  int transferTo(Account_50437 acct, int amount) {
    if (amount <= balance) {
      balance -= amount;
      acct.balance += amount;
    } else {
      System.out.println("Amount exceeded balance");
    }
    return balance;
  }

  public String toString() {
    return String.format("Account[%d] %s balance is %d", id, name, balance);
  }
}
