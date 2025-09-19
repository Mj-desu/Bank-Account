package bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SavingsAccountTest {
  /**
   * Test account variable initialization.
   */
  private SavingsAccount testAccount;

  @BeforeEach
  void setup() {
    testAccount = new SavingsAccount("Test");
  }

  @Test
  void testShouldReturnOwnerName() {
    String expectedOutput = "Test";
    String actualOutput = testAccount.getOwnerName();
    assertEquals(expectedOutput, actualOutput,
        () -> "Expected: " + expectedOutput + ", but got: " + actualOutput);
  }

  @Test
  @Tag("deposit")
  void testShouldReturnDepositedAmount() throws Exception {
    final double expectedOutput = 1000.0;
    double actualOutput;
    testAccount.deposit(expectedOutput);
    actualOutput = testAccount.getBalance();
    assertEquals(expectedOutput, actualOutput,
        () -> "Expected: " + expectedOutput + ", but got: " + actualOutput);
  }

  @Test
  @Tag("deposit")
  void testShouldReturnErrorIfAmountIsZero() throws Exception {
    final double zero = 0;
    Exception e = assertThrows(IllegalArgumentException.class, () -> {
      testAccount.deposit(zero);
    });
    assertEquals("The deposit amount must be positive.", e.getMessage());
  }

  @Test
  @Tag("deposit")
  void testShouldReturnErrorIfAmountIsNegative() throws Exception {
    final double negVal = -500;
    Exception e = assertThrows(IllegalArgumentException.class, () -> {
      testAccount.deposit(negVal);
    });
    assertEquals("The deposit amount must be positive.", e.getMessage());
  }

  @Test
  @Tag("withdraw")
  void testWithdrawValidAmount() throws Exception {
    final double depositAmount = 1000.0;
    final double withdrawAmount = 500;
    final double expectedOutput = 500;
    final double actualOutput;
    testAccount.deposit(depositAmount);
    testAccount.withdraw(withdrawAmount);
    actualOutput = testAccount.getBalance();
    assertEquals(expectedOutput, expectedOutput,
        () -> "Expected: " + expectedOutput + ", but got: " + actualOutput);
  }

  @Test
  @Tag("withdraw")
  void testWithdrawInsufficientAmount() throws Exception {
    final double depositAmount = 1000.0;
    final double withdrawAmount = 1500.0;
    testAccount.deposit(depositAmount);
    Exception e = assertThrows(IllegalArgumentException.class, () -> {
      testAccount.withdraw(withdrawAmount);
    });
    assertEquals("Insufficient balance.", e.getMessage());
  }

  @Test
  @Tag("withdraw")
  void testWithdrawNegativeAmount() throws Exception {
    final double depositAmount = 1000.0;
    final double withdrawAmount = -1500.0;
    testAccount.deposit(depositAmount);
    Exception e = assertThrows(IllegalArgumentException.class, () -> {
      testAccount.withdraw(withdrawAmount);
    });
    assertEquals("The withdrawn amount must be positive.", e.getMessage());
  }
}
