package org.example;

import org.example.component.Column;
import org.example.component.Row;
import org.example.component.Table;
import org.example.component.column.CharColumn;
import org.example.component.column.ColumnType;
import org.example.component.column.IntegerColumn;
import org.example.component.column.MoneyColumn;
import org.example.component.column.MoneyInvlColumn;
import org.example.component.column.RealColumn;
import org.example.component.column.StringColumn;

public class DBManager {

  private static DBManager instance;

  private DBManager() {
  }

  public static DBManager getInstance() {
    if (instance == null) {
      instance = new DBManager();
    }
    return instance;
  }

  public static Table table;

  public static void populateTable() {
    table = new Table("testTable");
    table.addColumn(new IntegerColumn("column1"));
    table.addColumn(new RealColumn("column2"));
    table.addColumn(new StringColumn("column3"));
    table.addColumn(new CharColumn("column4"));
    table.addColumn(new MoneyColumn("column5"));
    table.addColumn(new MoneyInvlColumn("column6","0","1000"));
    Row row1 = new Row();
    row1.values.add("10");
    row1.values.add("10.0");
    row1.values.add("Test1");
    row1.values.add("a");
    row1.values.add("10.00");
    row1.values.add("10.00");
    table.addRow(row1);
    Row row2 = new Row();
    row2.values.add("15");
    row2.values.add("15.0");
    row2.values.add("Test2");
    row2.values.add("b");
    row2.values.add("15.00");
    row2.values.add("15.00");
    table.addRow(row2);
    Row row3 = new Row();
    row3.values.add("20");
    row3.values.add("20.0");
    row3.values.add("Test3");
    row3.values.add("c");
    row3.values.add("20.00");
    row3.values.add("20.00");
    table.addRow(row3);
    Row row4 = new Row();
    row4.values.add("25");
    row4.values.add("25.0");
    row4.values.add("Test4");
    row4.values.add("d");
    row4.values.add("25.00");
    row4.values.add("25.00");
    table.addRow(row4);
  }

  public static void updateTable(int columnIndex, String value, String operator){
    Column column = table.columns.get(columnIndex);
    switch (ColumnType.valueOf(column.type)){
      case INT -> {
        int i = 0;
        while (i < table.rows.size()){
          switch (operator) {
            case ("<"):
              if (Integer.parseInt(table.rows.get(i).getAt(columnIndex)) < Integer.parseInt(value)) {
                i++;
              }
              else {
                table.deleteRow(i);
              }
              break;
            case ("<="):
            case ("=<"):
              if (Integer.parseInt(table.rows.get(i).getAt(columnIndex)) <= Integer.parseInt(value)) {
                i++;
              }
              else {
                table.deleteRow(i);
              }
              break;
            case ("=="):
              if (Integer.parseInt(table.rows.get(i).getAt(columnIndex)) == Integer.parseInt(value)) {
                i++;
              }
              else {
                table.deleteRow(i);
              }
              break;
            case (">="):
            case ("=>"):
              if (Integer.parseInt(table.rows.get(i).getAt(columnIndex)) >= Integer.parseInt(value)) {
                i++;
              }
              else {
                table.deleteRow(i);
              }
              break;
            case (">"):
              if (Integer.parseInt(table.rows.get(i).getAt(columnIndex)) > Integer.parseInt(value)) {
                i++;
              }
              else {
                table.deleteRow(i);
              }
              break;
          }
        }
      }
      case REAL -> {
        int i = 0;
        while (i < table.rows.size()){
          switch (operator) {
            case ("<"):
              if (Double.parseDouble(table.rows.get(i).getAt(columnIndex)) < Double.parseDouble(value)){
                i++;
              }
              else {
                table.deleteRow(i);
              }
              break;
            case ("<="):
            case ("=<"):
              if (Double.parseDouble(table.rows.get(i).getAt(columnIndex)) <= Double.parseDouble(value)){
                i++;
              }
              else {
                table.deleteRow(i);
              }
              break;
            case ("=="):
              if (Double.parseDouble(table.rows.get(i).getAt(columnIndex)) == Double.parseDouble(
                  value)){
                i++;
              }
              else {
                table.deleteRow(i);
              }
              break;
            case (">="):
            case ("=>"):
              if (Double.parseDouble(table.rows.get(i).getAt(columnIndex)) >= Double.parseDouble(value)){
                i++;
              }
              else {
                table.deleteRow(i);
              }
              break;
            case (">"):
              if (Double.parseDouble(table.rows.get(i).getAt(columnIndex)) > Double.parseDouble(value)){
                i++;
              }
              else {
                table.deleteRow(i);
              }
              break;
          }
        }
      }
      case STRING -> {
        int i = 0;
        while (i < table.rows.size()){
          switch (operator) {
            case ("<"):
              if (table.rows.get(i).getAt(columnIndex).length() < value.length()){
                i++;
              }
              else {
                table.deleteRow(i);
              }
              break;
            case ("<="):
            case ("=<"):
              if (table.rows.get(i).getAt(columnIndex).length() <= value.length()){
                i++;
              }
              else {
                table.deleteRow(i);
              }
              break;
            case ("=="):
              if (table.rows.get(i).getAt(columnIndex).length() == value.length()){
                i++;
              }
              else {
                table.deleteRow(i);
              }
            case (">="):
            case ("=>"):
              if (table.rows.get(i).getAt(columnIndex).length() >= value.length()){
                i++;
              }
              else {
                table.deleteRow(i);
              }
              break;
            case (">"):
              if (table.rows.get(i).getAt(columnIndex).length() > value.length()){
                i++;
              }
              else {
                table.deleteRow(i);
              }
              break;
          }
        }
      }
      case CHAR -> {
        int i = 0;
        while (i < table.rows.size()){
          switch (operator) {
            case ("<"):
              if (Character.getNumericValue(table.rows.get(i).getAt(columnIndex).charAt(0)) < Character.getNumericValue(value.charAt(0))){
                i++;
              }
              else {
                table.deleteRow(i);
              }
              break;
            case ("<="):
            case ("=<"):
              if (Character.getNumericValue(table.rows.get(i).getAt(columnIndex).charAt(0)) <= Character.getNumericValue(value.charAt(0))){
                i++;
              }
              else {
                table.deleteRow(i);
              }
              break;
            case ("=="):
              if (Character.getNumericValue(table.rows.get(i).getAt(columnIndex).charAt(0)) == Character.getNumericValue(value.charAt(0))){
                i++;
              }
              else {
                table.deleteRow(i);
              }
              break;
            case (">="):
            case ("=>"):
              if (Character.getNumericValue(table.rows.get(i).getAt(columnIndex).charAt(0)) >= Character.getNumericValue(value.charAt(0))){
                i++;
              }
              else {
                table.deleteRow(i);
              }
              break;
            case (">"):
              if (Character.getNumericValue(table.rows.get(i).getAt(columnIndex).charAt(0)) > Character.getNumericValue(value.charAt(0))){
                i++;
              }
              else {
                table.deleteRow(i);
              }
              break;
          }
        }
      }
      case MONEY, MONEY_INVL -> {
        int i = 0;
        while (i < table.rows.size()){
          switch (operator) {
            case ("<"):
              if (MoneyColumn.toDouble(table.rows.get(i).getAt(columnIndex)) < MoneyColumn.toDouble(value)){
                i++;
              }
              else {
                table.deleteRow(i);
              }
              break;
            case ("<="):
            case ("=<"):
              if (MoneyColumn.toDouble(table.rows.get(i).getAt(columnIndex)) <= MoneyColumn.toDouble(value)){
                i++;
              }
              else {
                table.deleteRow(i);
              }
              break;
            case ("=="):
              if (MoneyColumn.toDouble(table.rows.get(i).getAt(columnIndex)) == MoneyColumn.toDouble(value)){
                i++;
              }
              else {
                table.deleteRow(i);
              }
              break;
            case (">="):
            case ("=>"):
              if (MoneyColumn.toDouble(table.rows.get(i).getAt(columnIndex)) >= MoneyColumn.toDouble(value)){
                i++;
              }
              else {
                table.deleteRow(i);
              }
              break;
            case (">"):
              if (MoneyColumn.toDouble(table.rows.get(i).getAt(columnIndex)) > MoneyColumn.toDouble(value)){
                i++;
              }
              else {
                table.deleteRow(i);
              }
              break;
          }
        }
      }
    }
  }
}
