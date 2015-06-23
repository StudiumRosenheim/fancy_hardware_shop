package Models;

public class Equipment {
    protected double price;
    protected int click_frequence = 0;
    protected int article_nr;
    protected String pname;

    public Equipment(double price, int article_nr, String pname) {
      this.price = price;
      this.article_nr = article_nr;
      this.pname = pname;
    }
}
