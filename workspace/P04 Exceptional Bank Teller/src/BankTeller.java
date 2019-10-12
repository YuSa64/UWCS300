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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class BankTeller {

  private ArrayList<BankAccount> accounts;

  public BankTeller() {
    accounts = new ArrayList<BankAccount>();
  }

  public void addBankAccount(BankAccount newAccount) {
    if (newAccount == null)
      throw new IllegalArgumentException("Null account cannot be added!");
    for (BankAccount ba : accounts) {
      if (ba.equals(newAccount))
        throw new IllegalStateException("This account already exists!");
    }
    accounts.add(newAccount);
  }

  public void addTransaction(String transaction, BankAccount account)
      throws java.util.zip.DataFormatException {
    if (account == null)
      throw new NullPointerException("Account is null!");
    String[] tran = transaction.trim().split(" ");
    try {
      int type = Integer.parseInt(tran[0]);
      int amount = Integer.parseInt(tran[1]);
      if (tran.length != 2 || type != 0 || type != 1)
        throw new DataFormatException("Transaction format is not correct!");
      if (type == 0)
        account.withdraw(amount);
      else
        account.deposit(amount);
    } catch (NumberFormatException e) {
      throw new DataFormatException("Transaction format is not correct!");
    }
  }

  public BankAccount findAccount(String id) throws java.util.NoSuchElementException {
    BankAccount temp = new BankAccount(id, 10);
    for (BankAccount ba : accounts) {
      if (ba.equals(temp))
        return ba;
    }
    throw new NoSuchElementException("There's no such account in this BankTeller's accounts list!");
  }

  public void loadTransactions(File file, BankAccount account)
      throws java.io.FileNotFoundException {
    if (account == null)
      throw new NullPointerException("Account is null!");
    if (file == null)
      throw new FileNotFoundException("");

    Scanner scn = new Scanner(file);
    while (scn.hasNextLine()) {
      try {
        addTransaction(scn.nextLine(), account);
      } catch (DataFormatException e) {
        continue;
      }
    }
    scn.close();
  }

  public int getAccountsCount() {
    return accounts.size();
  }
}
