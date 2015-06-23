import Models.*;
import Views.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class FancyHardwareShop {
    protected ArrayList products = new ArrayList();

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

    private boolean addProductFromCSVValues(String[] values){
          double price = Double.parseDouble(values[0]); 
	  int article_nr = Integer.parseInt(values[1]);
	  return addProduct(price, article_nr, values[2]);
    }

    private boolean addProduct(double price, int article_nr, String pname) {
	Equipment new_e = new Equipment(price, article_nr, pname);
	if(!products.contains(new_e))
          return products.add(new_e);
	return false;
    }

    public static void main(String[] args) {
    }
}