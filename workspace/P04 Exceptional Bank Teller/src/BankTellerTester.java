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
import java.io.FileNotFoundException;

public class BankTellerTester {
  public static void main(String[] args) {
    System.out.println("Bank Teller Test Start");
    System.out.println("testBankTellerConstructor: " + testBankTellerConstructor());
    System.out.println("testBankTellerAddBankAccountUsedIdentifier: "
        + testBankTellerAddBankAccountUsedIdentifier());
    System.out.println("testBankTellerLoadTransactionsFileNotFound: "
        + testBankTellerLoadTransactionsFileNotFound());
    System.out.println("Test Done");
  }

  public static boolean testBankTellerConstructor() {
    BankTeller teller = new BankTeller();
    if(teller.getAccountsCount() == 0)
      return true;
    else return false;
  }

  public static boolean testBankTellerAddBankAccountUsedIdentifier() {
    BankTeller teller = new BankTeller();
    teller.addBankAccount(new BankAccount("test", 20));
    try {
      teller.addBankAccount(new BankAccount("test", 20));
    }
    catch(IllegalStateException e) {
      return true;
    }
    return false;
  }

  public static boolean testBankTellerLoadTransactionsFileNotFound() {
    BankTeller teller = new BankTeller();
    try {
      teller.loadTransactions(null, new BankAccount("test", 20));
    }
    catch(FileNotFoundException e) {
      return true;
    }
    return false;
  }
}
