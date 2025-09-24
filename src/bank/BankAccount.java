package bank;
//CODE REVIEWER: KYLE ANGEL RAMIREZ
//NO CHECKSTYLE VIOLATIONS. ALL REQUIRED METHODS ARE PRESENT.

public interface BankAccount {
  /**
   * Deposit amount to bank account.
   * @param amount
   * @throws Exception
   */
  void deposit(double amount);
  /**
   * Withdraw amount from bank account.
   * @param amount
   */
  void withdraw(double amount);
  /**
   * Return the balance of the account.
   * @return balance
   */
  double getBalance();
  /**
   * Returns true if account is frozen.
   * @return isFrozen
   */
  boolean isFrozen();
}

