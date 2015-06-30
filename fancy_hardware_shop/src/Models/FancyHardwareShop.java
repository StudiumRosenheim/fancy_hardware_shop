package Models;
import Views.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class FancyHardwareShop {
    private ArrayList<Equipment> products = new ArrayList();
    private String path = ".\\dummys.txt";

    public FancyHardwareShop(){
      Equipment.registerElements();
      this.load();
    }

    //Erwartet ein String Array mit den Attributen des zugehoerigen Equipemnt
    //um dieses zu veraendern. String[] siehe Blatt
    public void changeEquipmentAttributes(Equipment eqp, String[] values) {

    }

    //gibt das Equipment Object mit dem zugehoerigen Namen zuruech
    public Equipment getEquipmentByName(String Name) {
      for(Equipment eqp: products) {
        if((eqp.getPname().compareTo(Name)) == 0)
          return eqp;
      }
      return null;
    }

    public boolean removeProduct(Equipment eqp) {
      return products.remove(eqp);
    }
    
    //checked ob der gegebene Name verfuegbaer ist oder ob es schon ein objekt
    //damit gibt
    public boolean hasEquipmentWithName(String type, String Name) {
      ArrayList<Equipment> eqps = this.getTypeArray(type, "");
      for(Equipment eqp: eqps) {
        if((eqp.getPname().toLowerCase().compareTo(Name.toLowerCase()) == 0))
          return true;
      }
      return false;
    }

    private void load() {
      String line;
      try {
        BufferedReader csvBr = new BufferedReader(new FileReader(path));
	while((line = csvBr.readLine()) != null) {
	  addProduct(line.split(","));
	}
      } catch(FileNotFoundException e){
      } catch(IOException e) {
      }
    }

    private void save() {
      try {
        PrintWriter out = new PrintWriter(path);
	for(Equipment eqp: products) {
	  out.append(eqp.saveString());
	  out.append(System.lineSeparator());
        }
	out.flush();
	out.close();
      } catch (FileNotFoundException ex) {
        Runtime.getRuntime().exit(17);
      }
    }

    public ArrayList<Equipment> getArrayList() {
      Collections.sort(products);
      return products;
    }

    public ArrayList<Equipment> getTypeArray(String type, String stype) {
      ArrayList<Equipment> typeArray = new ArrayList();
      for(Equipment eqp: products) {
        boolean firstCheck = (eqp.klass().compareTo(type) == 0);
        boolean secondCheck = (eqp.secondCheckValue().compareTo(stype) == 0);

        if(!type.isEmpty() && !stype.isEmpty()) {
          if(firstCheck && secondCheck){
            typeArray.add(eqp);
	  }
	} else if(firstCheck) {
          typeArray.add(eqp);
	}
      }
      return typeArray;
    }

    private boolean addProduct(String[] values) {
      if(!hasEquipmentWithName(values[0], values[1])) {
        Equipment equip = Equipment.getEquipmentfromString(values[0]);
        equip.init(values);
        return products.add(equip);
      }
      return false;
    }
}