import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Date212 {
   //instance variables
   private int year;
   private int month;
   private int day;
   
   public Date212(String s) {  
      // constructor from string
      if (isValid(s) == false) throw new Date212Exception(s + " is an invalid date!");
      // method substring to separate the string into date, month and year
      year = Integer.parseInt(s.substring(0, 4));
      month = Integer.parseInt(s.substring(4,6));
      day = Integer.parseInt(s.substring(6, 8));
   } // close constructor
   
   public void setDate212(String s) {
      // set method to set a full string to a Date212 object
      year = Integer.parseInt(s.substring(0, 4));
      month = Integer.parseInt(s.substring(4,6));
      day = Integer.parseInt(s.substring(6, 8));
   } // close setDate212
   
   public String getDate212() {
      // method to get the the full Date212 object in a string
      // if the month or date is a single digit it will add a zero before the number
      String date = "" + year;
      if (month < 10) date += ("0" + month);
      else date += month;
      if (day < 10) date += ("0" + day);
      else date += day;
      return date;
   } // close getDate212
   
   public int getYear() {
      return year;
   } // close getYear
   
   public int getMonth() {
      return month;
   } //close getMonth
   
   public int getDay() {
      return day;
   } // close getDay
   
   public void setYear(int y) {
      year = y;
   } // close setYear
   
   public void setMonth(int m) {
      month = m;
   } // close setMonth
   
   public void setDay(int d) {
      day = d;
   } // close setDay
   
   public String toString(Date212 date) {
      // method that takes a Date212 object and 
      // assigns the correct name of the month, date, and year in a String
      String[] monthArray = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
      String result = monthArray[month - 1] + " " + day + ", " + year;
      return result;
   } // close toString
   
   public boolean equals(Object other) {
      //checks if this and other are equal
      return (other != null && 
              getClass() == other.getClass() &&
              getDate212().equals(((Date212) other).getDate212()));
   } // close equals
   
   public int compareTo(Date212 other) {
      // compares this and other by converting them both to strings
      String s = this.getDate212();
      return s.compareTo(other.getDate212());
   } // close compareTo
   
   public boolean isValid(String s) {
      // tests if a date is valid
      if (s.length() != 8) return false;
      if (Integer.parseInt(s.substring(4,6)) < 1 || Integer.parseInt(s.substring(4,6)) > 12) return false;
      int m = Integer.parseInt(s.substring(4,6));
      int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
      if (Integer.parseInt(s.substring(6, 8)) < 1 || Integer.parseInt(s.substring(6, 8)) > daysInMonth[m - 1]) return false;
      return true;
   }
   
} // close Date212
