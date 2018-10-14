import java.util.ArrayList;

public class User {
  private String username;
  private String password;
  private ArrayList<BankAccount> accounts;

  public User(String usr, String pass) {
    username = usr;
    password = password;
  }

  public void addAccount(BankAccount act) {
    accounts.add(act);
  }

}
