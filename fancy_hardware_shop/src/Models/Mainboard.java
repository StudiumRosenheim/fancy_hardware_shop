package Models;

public class Mainboard extends Equipment {
    protected String takt_frq, sockel_typ, intf;

    public String klass() {
      return "Motherboard";
    }

    public static void register(){
        subclasses.put("Motherboard", HDD.class);
    }

    public void init(String[] values) {
      this.defaultValues(values);
      takt_frq = values[5];
      sockel_typ = values[6];
      intf = values[7];
    }

    public String saveString() {
      return super.saveString() + "," + takt_frq +
        "," + sockel_typ + "," + intf;
    }

    @Override
    public int compareTo(Object t) {
      return super.compareTo((Equipment)t);
    }
}
