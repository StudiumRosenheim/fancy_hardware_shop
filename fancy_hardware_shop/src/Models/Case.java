package Models;

public class Case extends Equipment {

    public String klass() {
      return "Gehäuse";
    }

    public static void register() {
      subclasses.put("Gehäuse", Case.class);
    }

    public void init(String[] values) {
      this.defaultValues(values);
    } 

    public String saveString() {
      return super.saveString();
    }

    @Override
    public int compareTo(Object t) {
      return super.compareTo((Equipment)t);
    }
}
