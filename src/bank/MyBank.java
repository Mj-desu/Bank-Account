package bank;

final class MyBank {
  // Private constructor to prevent instantiation
  private MyBank() {
    throw new UnsupportedOperationException(
        "Utility class should not be instantiated.");
  }

  /**
   * Entry point.
   * @param args
   * @throws Exception
   */
  public static void main(final String[] args) throws Exception {
    final int initialDeposit = 1000;
    final int withdrawAmount = 500;
    SavingsAccount myAccount = new SavingsAccount("MJ");
    System.out.println(myAccount.getOwnerName());

    myAccount.deposit(initialDeposit);

    myAccount.withdraw(withdrawAmount);
  }

}
