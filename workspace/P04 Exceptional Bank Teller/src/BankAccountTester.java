//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Exceptional Bank Teller
// Files: BankAccount.java, BankAccountTester.java, BankTeller.java, BankTellerTester.java
// Course: CS300 Fall 2019
//
// Author: Hyeon Jun Jeong
// Email: hjeong44@wisc.edu
// Lecturer's Name: Mouna Ayari Ben Hadj Kacem
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.zip.DataFormatException;

public class BankAccountTester {

  public static void main(String[] args) {
    System.out.println("Bank Account Test Start");
    System.out.println("testBankAccountConstructorValidInitialBalance: "
        + testBankAccountConstructorValidInitialBalance());
    System.out.println("testBankAccountConstructorNotValidInitialBalance: "
        + testBankAccountConstructorNotValidInitialBalance());
    System.out.println("testBankAccountEquals: " + testBankAccountEquals());
    System.out
        .println("testBankAccountWithdrawInvalidAmount: " + testBankAccountWithdrawInvalidAmount());
    System.out.println("testBankAccountWithdrawLargerOfBalanceAmount: "
        + testBankAccountWithdrawLargerOfBalanceAmount());
    System.out
        .println("testBankAccountWithdrawValidAmount: " + testBankAccountWithdrawValidAmount());
    System.out
        .println("testBankAccountDepositNegativeAmount: " + testBankAccountDepositNegativeAmount());
    System.out.println("Test Done");
  }

  public static boolean testBankAccountConstructorValidInitialBalance() {
    String ID = "test";
    int Init = 20;
    BankAccount account = new BankAccount(ID, Init);
    if(account.getID().equals(ID) && account.getBalance() == Init)
      return true;
    else return false;
  }

  public static boolean testBankAccountConstructorNotValidInitialBalance() {
    try {
      new BankAccount("test", 0);
    }
    catch(IllegalArgumentException e) {
      return true;
    }
    return false;
  }

  public static boolean testBankAccountEquals() {
    String ID = "test";
    int Init = 20;
    BankAccount account1 = new BankAccount(ID, Init);
    BankAccount account2 = new BankAccount(ID, Init);
    return account1.equals(account2);
  }

  public static boolean testBankAccountWithdrawInvalidAmount() {
    BankAccount account = new BankAccount("test", 20);
    try {
      account.withdraw(-10);
    }
    catch(DataFormatException e) {
      System.out.print("test negative: true, test not a multiply of 10: ");
      try {
        account.withdraw(15);
      }
      catch(DataFormatException e2) {
        return true;
      }
    }
    return false;
  }

  public static boolean testBankAccountWithdrawLargerOfBalanceAmount() {
    BankAccount account = new BankAccount("test", 20);
    try {
      account.withdraw(30);
    }
    catch(IllegalStateException e) {
      return true;
    } catch (DataFormatException e) {
      return false;
    }
    return false;
  }

  public static boolean testBankAccountWithdrawValidAmount() {
    BankAccount account = new BankAccount("test", 20);
    try {
      account.withdraw(10);
    } catch (DataFormatException e) {
      return false;
    }
    if(account.getBalance() == 10) {
      return true;
    }
    else return false;
  }

  public static boolean testBankAccountDepositNegativeAmount() {
    BankAccount account = new BankAccount("test", 20);
    try {
      account.deposit(-20);
    }
    catch (IllegalArgumentException e) {
      return true;
    }
    return false;
  }
}
