package Models;

public class Ram extends Equipment {
    protected String takt_frq, size, ddr_type;

    public String klass() {
      return "RAM";
    }

    public String secondCheckValue() {
	    return ddr_type;
    }

    public static void register() {
      subclasses.put("RAM", Ram.class);
    }

    public void init(String[] values) {
      defaultValues(values);
      takt_frq = values[5];
      size = values[6];
      ddr_type = values[7];
    }

    public String saveString() {
      return super.saveString() + "," + takt_frq +
        "," + size + "," + ddr_type;
    }

    @Override
    public int compareTo(Object t) {
      return super.compareTo((Equipment)t);
    }
}
