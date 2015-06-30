package Models;

public class PowerSupply extends Equipment {
    protected String wattage, intf;

    public String klass() {
      return "Netzteil";
    }

    public static void register() {
      subclasses.put("Netzteil", PowerSupply.class);
    }

    public void init(String[] values) {
      this.defaultValues(values);
      wattage = values[5];
      intf = values[6];
   }

    public String saveString() {
      return super.saveString() + "," + wattage + "," + intf;
    }

    @Override
    public int compareTo(Object t) {
      return super.compareTo((Equipment)t);
    }
}
