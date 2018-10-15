public class CheckingsAccount extends BankAccount {

  private static String type = "Checking";

  public CheckingsAccount() {
    super();
  }

  public CheckingsAccount(int accountNum, int routingNum, double accountBal) {
    super(accountNum, routingNum, accountBal);
  }

  public String getType() {
    return type;
  }

}
