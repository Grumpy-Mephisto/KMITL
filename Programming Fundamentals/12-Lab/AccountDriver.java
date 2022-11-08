public class AccountDriver {

  public static void main(String[] args) {
    testAccount();
    testAcctList();
  }

  static void testAcctList() {
    AcctList_50437 clients = new AcctList_50437();
    String startWith = "c";
    System.out.println(
      "List of account name start with " + startWith.toUpperCase()
    );
    System.out.println(clients.filterName(startWith.toUpperCase()));
    int bound = 1400;
    System.out.println("List of account balance less than " + bound);
    System.out.println(clients.balanceLessThan(bound));
  }

  static void testAccount() {
    Account_50437 acct1 = new Account_50437(1, "melon", 1500);
    Account_50437 acct2 = new Account_50437(2, "rose apple", 2200);
    System.out.println(acct1.credit(700)); // 2200
    System.out.println(acct2.debit(300)); // 1900
    System.out.println(acct1.transferTo(acct2, 1000)); // 1200
    System.out.println(acct1.credit(-50)); // 1200
    System.out.println(acct2.debit(-50)); // 2900
    System.out.println(acct1);
    System.out.println(acct2);
  }
}
