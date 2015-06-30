package Models;

public class HDD extends Equipment {
    protected String size, hType, intf;

    public String klass() {
      return "Festplatte";
    }

    public String secondCheckValue() {
	    return hType;
    }

    public static void register(){
        subclasses.put("Festplatte", HDD.class);
    }

    public void init(String[] values) {
      this.defaultValues(values);
      size = values[5];
      hType = values[6];
      intf = values[7];
    }

    public String saveString() {
      return super.saveString() + "," + size + "," + hType + "," + intf;
    }

    @Override
    public int compareTo(Object t) {
      return super.compareTo((Equipment)t);
    }
}
