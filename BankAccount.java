import java.util.Random;

public class BankAccount {

  Random gen = new Random();
  protected int accountNumber;
  protected int routingNumber;
  protected double accountBalance;
  private String type;

  public BankAccount(){
    accountNumber = (int)(1000000 + gen.nextDouble() * 9000000);
    routingNumber = (int)(1000000 + gen.nextDouble() * 9000000);
    accountBalance = 0;
  }

  public BankAccount(int accountNum, int routingNum, double accountBal){
    accountNumber = accountNum;
    routingNumber = routingNum;
    accountBalance = accountBal;
  }

  public int getAccountNumber() {
    return accountNumber;
  }

  public int getRoutingNumber() {
    return routingNumber;
  }

  public double getAccountBalance() {
    return accountBalance;
  }

  public String getType() {
    return type;
  }

  public boolean deposit(double amount) {
    if(amount <= 0) {
      System.out.println("Cannot deposit negative amount");
      return false;
    }
    else{
      accountBalance += amount;
      System.out.println("Your account balance is now $" + accountBalance);
      return true;
    }
  }

  public boolean withdraw(double amount){
    if(amount > accountBalance){
      System.out.println("Cannot withdraw more than account balance");
      return false;
    }
    else{
      accountBalance -= amount;
      System.out.println("Your account balance is now $" + accountBalance);
      return true;
    }
  }

}
