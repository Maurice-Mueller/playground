package moepad.playground.derby;


import moepad.playground.derby.common.MyResultSet;
import moepad.playground.derby.common.PreparedStatementParameters;
import moepad.playground.derby.derby.DerbyHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Main {

  private static final DerbyHandler derbyHandler = new DerbyHandler("exampleDB");
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    initDB();
    addNewEntriesByUser();
    printUserEntries();
    cleanDB();
  }

  private static void initDB() {
    derbyHandler.execute("create table users(age int, firstname varchar(40), surname varchar(40))");
    derbyHandler.execute("insert into users values (28, 'Max', 'Muster')");
  }

  private static void addNewEntriesByUser() {
    System.out.println("Please enter the data for a new entry.");
    boolean addNewEntry = true;
    List<PreparedStatementParameters> parametersList = readPreparedStatementParameters(addNewEntry);
    derbyHandler.executePreparedStatement("insert into users values (?,?,?)", parametersList);
  }

  private static List<PreparedStatementParameters> readPreparedStatementParameters(boolean addNewEntry) {
    List<PreparedStatementParameters> parametersList = new ArrayList<>();
    while(addNewEntry == true) {
      PreparedStatementParameters parameters = new PreparedStatementParameters();
      parametersList.add(parameters);
      System.out.print("Enter age: ");
      parameters.append(scanner.nextInt());
      System.out.print("Enter first name: ");
      parameters.append(scanner.next());
      System.out.print("Enter surname: ");
      parameters.append(scanner.next());
      System.out.print("Do you want to add a new entry to the DB? (y/n): ");
      if("n".equalsIgnoreCase(scanner.next())) {
        addNewEntry = false;
      }
    }
    return parametersList;
  }

  private static void printUserEntries() {
    MyResultSet resultSet = derbyHandler.query("select * from users");
    resultSet.stream().forEach(results -> {
      System.out.print("Name: " + results.get(1));
      System.out.print(" " + results.get(2));
      System.out.println("  Alter: " + results.get(0));
    });
  }

  private static void cleanDB() {
    derbyHandler.execute("drop table users");
  }
}