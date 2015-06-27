import Models.*;
import Views.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FancyHardwareShop {
    private ArrayList<Equipment> products = new ArrayList();

    private void readFromCSV(String path) {
      String line;
      try {
        BufferedReader csvBr = new BufferedReader(new FileReader(path));
	while((line = csvBr.readLine()) != null) {
	  addProductFromCSVValues(line.split(","));
	}
      } catch(FileNotFoundException e){
	e.printStackTrace();
      } catch(IOException e) {
	e.printStackTrace();
      }
    }

    private void saveToCSV(String path) {
      try {
        PrintWriter out = new PrintWriter(path);
	for(Equipment eqp: products) {
	  out.append(eqp.saveString());
        }
	out.flush();
	out.close();
      } catch (FileNotFoundException ex) {
        Runtime.getRuntime().exit(17);
      }
    }

    private boolean addProductFromCSVValues(String[] values){
      double price = Double.parseDouble(values[1]); 
      int article_nr = Integer.parseInt(values[2]);
      return addProduct(values[0], price, article_nr, values[3]);
    }

    private boolean
      addProduct(String type, double price, int article_nr, String pname) {

      Equipment equip = Equipment.getEquipmentfromString(type);
      equip.init(price, article_nr, pname);
      return products.add(equip);
    }

    public static void main(String[] args) {
    }
}