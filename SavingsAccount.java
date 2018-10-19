/**
 * File: SavingsAccount.java
 * @author: Ryan Kane
 * @email: rakane@syr.edu
 **/

public class SavingsAccount extends BankAccount{

  private static String type = "Savings";
  private static double interestRate = 0.2;

  /**
  *  Constructs a valid SavingsAccount
  *  postcondition
  *  A valid SavingsAccount has been initialized
  **/
  public SavingsAccount() {
    super();
  }

  /**
  *  Constructs a valid SavingsAccount
  *  @param accountNum
  *   the 7 digit account number
  *  @param routingNum
  *   the 7 digit routing number
  *  @param accountBal
  *   the account balance
  *  postcondition
  *   A valid SavingsAccount has been initialized
  **/
  public SavingsAccount(int accountNum, int routingNum, double accountBal) {
    super(accountNum, routingNum, accountBal);
  }

  /**
  *  @return the account type
  **/
  public String getType() {
    return type;
  }

}
