package Models;

import java.util.HashMap;

public abstract class Equipment implements Comparable {
    private static int idCounter = 0;
    public static HashMap<String, Class<? extends Equipment>> subclasses = 
	    new HashMap();

    private int id = 0;
    protected String pname;
    protected double price;
    protected int click_frq, availability;
    protected String[] obj_val;

    public double getPrice() {
      return this.price;
    }

    public String getPname() {
      return this.pname;
    }

    public int getClickFrq() {
      return this.click_frq;
    }

    public int getAvailability() {
      return this.availability;
    }

    public int getId() {
      return this.id;
    }

    public void setClickFrq() {
      click_frq += 1;
    }

    public String klass() {
      return "";
    }

    public String secondCheckValue() {
      return "";
    }

    public static void registerElements() {
      HDD.register();
      CPU.register();
      Case.register();
      Mainboard.register();
      PowerSupply.register();
      Ram.register();
      Graka.register();
    }

    protected void defaultValues(String[] values) {
      if(this.id == 0) {
        idCounter++;
        id = idCounter;
      }
      pname = values[1];
      price = Double.parseDouble(values[2]);
      click_frq = Integer.parseInt(values[3]);
      availability = Integer.parseInt(values[4]);
    }

    public static Equipment getEquipmentfromString(String klass) {
      Equipment obj = null;
      try {
        obj = subclasses.get(klass).newInstance();
      } catch (Exception e) {
        Runtime.getRuntime().exit(17);
      }
      return obj;
    }

    public void init(String[] values) {
    }

    public String saveString() {
      String p = String.valueOf(price);
      String cf = String.valueOf(click_frq);
      String av = String.valueOf(availability);

      return klass() + "," + pname + "," + p + "," + cf + "," + av;
    }

    public int compareTo(Equipment eqp) {
      return this.click_frq-eqp.getClickFrq();
    } 
}
