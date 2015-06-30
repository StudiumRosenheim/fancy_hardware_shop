package Models;

import java.util.ArrayList;

public class Basket {
  private ArrayList<Equipment> basket = new ArrayList();
  private double price = 0;
   
  public void add(Equipment eqp) {
    basket.add(eqp);
    price += eqp.getPrice();
  }

  public void remove(Equipment eqp) {
    if(basket.contains(eqp)) {
      basket.remove(eqp);
      price -= eqp.getPrice();
    }
  }

  public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = Math.round(value);
    return (double) tmp / factor;
  }

  public double getPrice() {
    return round(this.price, 2);
  }

  public ArrayList<Equipment> getBasket() {
    return this.basket;
  }
}