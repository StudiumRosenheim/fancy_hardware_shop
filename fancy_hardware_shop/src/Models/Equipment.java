package Models;

import java.util.HashMap;


public abstract class Equipment {
    protected double price;
    protected int click_frequence, article_nr;
    protected String pname;
    public static HashMap<String, Class<? extends Equipment>> subclasses = 
	    new HashMap();

    public static void registerElements() {
      HDD.register();
      CPU.register();
      Case.register();
      Mainboard.register();
      PowerSupply.register();
      Ram.register();
    }

    public String saveString() {
      return this.getClass().getSimpleName() + "," + 
	price + "," + article_nr + "," + pname + "\n";
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

    public void init(double price, int article_nr, String pname) {
      this.price = price;
      this.article_nr = article_nr;
      this.pname = pname;
    }
}
