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
import java.util.ArrayList;
import java.util.zip.DataFormatException;

public class BankAccount {
  private String accountID;
  private int balance;
  private ArrayList<String> transactions;

  public BankAccount(String accountID, int initialBalance) {
    if (initialBalance < 10)
      throw new IllegalArgumentException("Initial balance cannot be less than 10!");
    transactions = new ArrayList<String>();
    this.accountID = accountID;
    deposit(initialBalance);
  }

  public void deposit(int depositAmount) {
    if (depositAmount < 0)
      throw new IllegalArgumentException("Deposit amount cannot be less than 0!");
    balance += depositAmount;
    transactions.add("1 " + depositAmount);
  }

  public boolean equals(BankAccount other) {
    if (other.getID() == this.accountID)
      return true;
    else
      return false;
  }

  public int getBalance() {
    return balance;
  }

  public String getID() {
    return this.accountID;
  }

  public String[] getMostRecentTransactions() {
    String[] output = new String[5];
    for (int i = 0; i < output.length; i++) {
      output[i] = transactions.get(transactions.size() - 1 - i);
      if (transactions.size() - 1 - i == 0)
        break;
    }
    return output;
  }

  public int getTransactionsCount() {
    return transactions.size();
  }

  public void withdraw(int withdrawAmount) throws java.util.zip.DataFormatException {
    if (withdrawAmount > balance)
      throw new IllegalStateException("Withdrawal amount cannot be larger than current balance!");
    if (withdrawAmount < 0 || withdrawAmount % 10 != 0)
      throw new DataFormatException(
          "Withdrawal amount cannot be less than 0 or not a multiple of 10!");
    balance -= withdrawAmount;
    transactions.add("0 " + withdrawAmount);
  }
}
