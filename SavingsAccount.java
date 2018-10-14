import java.time.*;
import java.util.Scanner;

public class SavingsAccount extends BankAccount{

  private static String type = "Saving";
  private static double interestRate = 0.2;

  public SavingsAccount() {
    super();
  }

  public SavingsAccount(int accountNum, int routingNum, double accountBal) {
    super(accountNum, routingNum, accountBal);
  }

}
