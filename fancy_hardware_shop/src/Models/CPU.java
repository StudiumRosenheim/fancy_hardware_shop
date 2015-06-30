package Models;

public class CPU extends Equipment {
    protected String takt_frq, sockel_typ, cores;

    public String klass() {
      return "Prozessor";
    }

    public String secondCheckValue() {
	    return cores;
    }

    public static void register() {
      subclasses.put("Prozessor", CPU.class);
    }

    public void init(String[] values) {
      defaultValues(values);
      takt_frq = values[5];
      sockel_typ = values[6];
      cores = values[7];
    }

    public String saveString() {
      return super.saveString() + "," + takt_frq +
        "," + sockel_typ + "," + cores;
    }

    @Override
    public int compareTo(Object t) {
      return super.compareTo((Equipment)t);
    }
}
