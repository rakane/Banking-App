/**
 * File: CheckingsAccount.java
 * @author: Ryan Kane
 * @email: rakane@syr.edu
 **/

public class CheckingsAccount extends BankAccount {

  private static String type = "Checking";

  /**
  *  Constructs a valid SavingsAccount
  *  postcondition
  *   A valid SavingsAccount has been initialized
  **/
  public CheckingsAccount() {
    super();
  }

  /**
  *  Constructs a valid CheckinhsAccount
  *  @param accountNum
  *   the 7 digit account number
  *  @param routingNum
  *   the 7 digit routing number
  *  @param accountBal
  *   the account balance
  *  postcondition
  *   A valid CheckingsAccount has been initialized
  **/
  public CheckingsAccount(int accountNum, int routingNum, double accountBal) {
    super(accountNum, routingNum, accountBal);
  }

  /**
  *  @return the account type
  **/
  public String getType() {
    return type;
  }

}
