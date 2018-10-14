public class BankAccount {

  protected int accountNumber;
  protected int routingNumber;
  protected double accountBalance;

  public BankAccount(){
    accountNumber = 0000000;
    routingNumber = 0000000;
    accountBalance = 0;
  }

  public BankAccount(int accountNum, int routingNum, double accountBal){
    accountNumber = accountNum;
    routingNumber = routingNum;
    accountBalance = 0;
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

  public void deposit(int amount) {
    if(amount <= 0) {
      System.out.println("Cannot deposit $" + amount);
    }
    else{
      accountBalance += amount;
      System.out.println("Your account balance is now $" + accountBalance);
    }
  }

  public void withdraw(int amount){
    if(amount > accountBalance){
      System.out.println("Cannot withdraw more than account balance");
    }
    else{
      accountBalance -= amount;
      System.out.println("Your account balance is now $" + accountBalance);
    }
  }

}
