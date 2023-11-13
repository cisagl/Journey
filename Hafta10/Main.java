package Hafta10;

public class Main {
    public static void main(String[] args) {
      String query =  "SELECT title, description FROM film";
      String query2 =  "SELECT * FROM film WHERE length > 60 AND length < 75";
      String query3 =  "SELECT * FROM film WHERE rental_rate = 0.99 AND replacement_cost = 12.99 OR replacement_cost = 28.99";
      String query4 =  "SELECT first_name, last_name FROM customer WHERE first_name = 'Mary'";
      String query5 =  "SELECT * FROM film WHERE length < 50 AND rental_rate != 2.99 OR rental_rate != 4.99";
    }
}
