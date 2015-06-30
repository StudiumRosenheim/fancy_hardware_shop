package Models;

public class Graka extends Equipment {
    protected String size, ram_type, b_size;

    public String klass() {
      return "Grafikkarte";
    }

    public static void register() {
      subclasses.put("Grafikkarte", Graka.class);
    }

    public void init(String[] values) {
      defaultValues(values);
      ram_type = values[5];
      size = values[6];
      b_size = values[7];
    }

    public String saveString() {
      return super.saveString() + "," + ram_type +
        "," + size + "," + b_size;
    }

    @Override
    public int compareTo(Object t) {
      return super.compareTo((Equipment)t);
    }
}
