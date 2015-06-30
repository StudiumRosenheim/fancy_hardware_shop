package Views;

import Models.Equipment;
import Models.FancyHardwareShop;
import Models.Basket;
import javax.swing.*;
import java.util.ArrayList;
public class NewJFrame extends javax.swing.JFrame {

    private static ArrayList<Equipment> workplace = new ArrayList();
    private static JPanel[] panels = new JPanel[6];
    private static JLabel[] labels = new JLabel[24];
    private static JButton[] buttons = new JButton[12];
    private static String[] values = new String[5];
    private FancyHardwareShop fhs = new FancyHardwareShop();
    private Basket basket_obj = new Basket();
    private String indicator;
      
        
    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
        initArrays();
        initProduktansicht();
        getDynamics(fhs.getArrayList());
    }
    
    private void getDynamics(ArrayList<Equipment> List){
        String s;
        Equipment obj = List.get(0);
        s = obj.klass();
        title1.setText(obj.getPname());
        price1.setText(String.valueOf(obj.getPrice()));
        dynamicImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/" + s + ".jpg")));
        obj = List.get(1);
        s = obj.klass();
        title2.setText(obj.getPname());
        price2.setText(String.valueOf(obj.getPrice()));
        dynamicImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/" + s + ".jpg")));
        obj = List.get(2);
        s = obj.klass();
        title3.setText(obj.getPname());
        price3.setText(String.valueOf(obj.getPrice()));
        dynamicImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/" + s + ".jpg")));
        obj = List.get(3);
        s = obj.klass();
        title4.setText(obj.getPname());
        price4.setText(String.valueOf(obj.getPrice()));
        dynamicImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/" + s + ".jpg")));
    }
    public void initArrays()
    {
        for(int i = 0; i < 6; i ++){    
            panels[i] = new JPanel();
            panels[i].setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            labels[i] = new JLabel(); //title
            labels[i + 6] = new JLabel(); //productimage
            labels[i + 12] = new JLabel(); //availability
            labels[i + 18] = new JLabel(); //price
            buttons[i] = new JButton(); //Details
            buttons[i+6] = new JButton();} //In den Warenkorb
        
            buttons[0].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               detailPerformed1(evt);}});
            buttons[1].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               detailPerformed2(evt);}});
            buttons[2].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               detailPerformed3(evt);}});
            buttons[3].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               detailPerformed4(evt);}});
            buttons[4].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               detailPerformed5(evt);}});
            buttons[5].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               detailPerformed6(evt);}});
            buttons[6].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               addToBasket1(evt);}});
            buttons[7].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               addToBasket2(evt);}});
            buttons[8].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               addToBasket3(evt);}});
            buttons[9].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               addToBasket4(evt);}});
            buttons[10].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               addToBasket5(evt);}});
            buttons[11].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               addToBasket6(evt);}}); 
    }  
        
        
        
    //zeigt Startbildschirm
    public void homeScreen(){
        backEndDialog.setVisible(false);
        backEnd.setVisible(false);
        Einkauf.setVisible(false);
        topBar.setVisible(true);
        sideBar.setVisible(true);
        setLayers("Dynamic");
        getDynamics(fhs.getArrayList());
       
    }
    //zeigt dynamisch selectorPanels mit richtigem Bild und Text (als übergabe)
    public void select(String... args){
        //args: erste Werte für Buttons, danach Imageadress
        
        String s;
        konfigurator.setVisible(false);
        dynamicHouse.setVisible(false);
        if(args.length < 5)
        {
            dynamic3.setVisible(false);
            dynamic4.setVisible(false);
            selectorButton1.setText(args[0]);
            selectorButton2.setText(args[1]);
            s = ("/Images/"+ args[2]);
            imageCapture1.setIcon(new javax.swing.ImageIcon(getClass().getResource(s)));
            s = ("/Images/"+ args[3]);
            imageCapture2.setIcon(new javax.swing.ImageIcon(getClass().getResource(s)));
        }
        else
        {
            
            dynamic1.setVisible(true);
            dynamic2.setVisible(true);
            dynamic3.setVisible(true);
            dynamic4.setVisible(false);
            selectorButton1.setText(args[0]);
            selectorButton2.setText(args[1]);
            selectorButton3.setText(args[2]);
            s = ("/Images/"+ args[3]);
            imageCapture1.setIcon(new javax.swing.ImageIcon(getClass().getResource(s)));
            s = ("/Images/"+ args[4]);
            imageCapture2.setIcon(new javax.swing.ImageIcon(getClass().getResource(s)));
            s = ("/Images/"+ args[5]);
            imageCapture3.setIcon(new javax.swing.ImageIcon(getClass().getResource(s)));      
        }
    }
     
       public void showProducts1()
       {
            String s = selectorButton1.getText();
            switch(s)
            {
                case "DDR3":
                    workplace = fhs.getTypeArray("RAM","DDR3");
                    indicator = "RAM";
                    contentFill(workplace);
                    setLayers("Product");
                    break;
                case "HDD":
                    workplace = fhs.getTypeArray("Festplatte","HDD");
                    indicator = "Festplatte";
                    contentFill(workplace);
                    setLayers("Product");
                    break;
                case "DualCore":
                    workplace = fhs.getTypeArray("Prozessor","DualCore");
                    indicator = "Prozessor";
                    contentFill(workplace);
                    setLayers("Product");
                    break;
            }  
        }   
          public void showProducts2()
       {
            String s = selectorButton2.getText();
            switch(s)
            {
                case "DDR4":
                    workplace = fhs.getTypeArray("RAM","DDR4");
                    indicator = "RAM";
                    contentFill(workplace);
                    setLayers("Product");
                    break;
                case "SSD":
                    workplace = fhs.getTypeArray("Festplatte","SSD");
                    indicator = "Festplatte";
                    contentFill(workplace);
                    setLayers("Product");
                    break;
                case "QuadCore":
                    workplace = fhs.getTypeArray("Prozessor","QuadCore");
                    indicator = "Prozessor";
                    contentFill(workplace);
                    setLayers("Product");
                    break;
            }  
        }   
           public void showProducts3()
       {
            String s = selectorButton3.getText();
            switch(s)
            {
                case "MultiCore":
                    workplace = fhs.getTypeArray("Prozessor","MultiCore");
                    indicator = "Prozessor";
                    contentFill(workplace);
                    setLayers("Product");
                    break;
               
            }   
       }
           public void showProductsdefault(String s)
       {
            
            switch(s)
            {
                case "Grafikkarte":
                    workplace = fhs.getTypeArray("Grafikkarte","");
                    indicator = "Grafikkarte";
                    contentFill(workplace);
                    setLayers("Product");
                    break;
                case "Netzteil":
                    workplace = fhs.getTypeArray("Netzteil","");
                    indicator = "Netzteil";
                    contentFill(workplace);
                    setLayers("Product");
                    break;
                case "Gehäuse":
                    workplace = fhs.getTypeArray("Gehäuse","");
                    indicator = "Gehäuse";
                    contentFill(workplace);
                    setLayers("Product");
                    break;
                case "Motherboard":
                    workplace = fhs.getTypeArray("Motherboard","");
                    indicator = "Motherboard";
                    contentFill(workplace);
                    setLayers("Product");
                    break;
            }  
        }   
        
       public void contentFill(ArrayList<Equipment> workplace)
       {
        int x = Math.min(6, workplace.size());
        String s;
        if(x < 6){
            for(int i = 5; i >= x; i--)
                panels[i].setVisible(false);
        
        }
        for(int i = 0; i < x; i ++)
            {    
            
            Equipment obj = workplace.get(i);
            s = obj.klass();
            labels[i].setText(obj.getPname());
            labels[i + 6].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/" + s + ".jpg")));//productimage
            switch(obj.getAvailability())
                {
                case 0: labels[i + 12].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/outofstock.jpg")));
                        break;
                case 1: labels[i + 12].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/comingSoon.gif")));
                        break;
                case 2: labels[i + 12].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/availableIcon.png")));
                        break;
                } //availability*/
            labels[i + 18].setText(String.valueOf(obj.getPrice()));
            panels[i].setVisible(true);
                     
            }
       }
        public void initProduktansicht(){
       
        for(int i = 0; i < 6; i ++)
        {  
        buttons[i].setText("Details");
        buttons[i].setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18));
        buttons[i+6].setText("In den Warenkorb");
        buttons[i+6].setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18));
        labels[i].setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18));
        labels[i+18].setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18));
        labels[i+18].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labels[i+18].setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        
        
        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(panels[i]);
        panels[i].setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labels[i], javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labels[i+6], javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labels[i+12], javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(buttons[i])
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttons[i+6]))
                    .addComponent(labels[i+18], javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(labels[i], javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labels[i+6], javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(labels[i+18], javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buttons[i+6])
                                .addComponent(buttons[i]))))
                    .addComponent(labels[i+12], javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        
        Produktansicht.add(panels[i]);
                }
        
        }
        
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LogIn = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        pgenerate = new javax.swing.JDialog();
        jComboBox7 = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        pchange = new javax.swing.JDialog();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jButton25 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        pdelete = new javax.swing.JDialog();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jTextField13 = new javax.swing.JTextField();
        jButton26 = new javax.swing.JButton();
        backEndDialog = new javax.swing.JDialog();
        backEnd = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton20 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton21 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jButton22 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        Einkauf = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jButton30 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        topBar = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        sideBar = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        Produktansicht = new javax.swing.JPanel();
        detailAnsicht = new javax.swing.JPanel();
        detailImage = new javax.swing.JLabel();
        detailTitle = new javax.swing.JLabel();
        detail1 = new javax.swing.JLabel();
        detail2 = new javax.swing.JLabel();
        detail3 = new javax.swing.JLabel();
        detail4 = new javax.swing.JLabel();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        basket = new javax.swing.JPanel();
        detailTitle1 = new javax.swing.JLabel();
        detail5 = new javax.swing.JLabel();
        product1 = new javax.swing.JLabel();
        product2 = new javax.swing.JLabel();
        product3 = new javax.swing.JLabel();
        jButton31 = new javax.swing.JButton();
        product4 = new javax.swing.JLabel();
        product5 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        bprice1 = new javax.swing.JLabel();
        bprice2 = new javax.swing.JLabel();
        bprice3 = new javax.swing.JLabel();
        bprice4 = new javax.swing.JLabel();
        bprice5 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        gesamtPreis = new javax.swing.JLabel();
        removeButton1 = new javax.swing.JButton();
        removeButton2 = new javax.swing.JButton();
        removeButton3 = new javax.swing.JButton();
        removeButton4 = new javax.swing.JButton();
        removeButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        dynamicHouse = new javax.swing.JPanel();
        dynamicCount1 = new javax.swing.JPanel();
        title1 = new javax.swing.JLabel();
        dynamicButton1 = new javax.swing.JButton();
        dynamicImage1 = new javax.swing.JLabel();
        price1 = new javax.swing.JLabel();
        dynamicCount2 = new javax.swing.JPanel();
        title2 = new javax.swing.JLabel();
        dynamicButton2 = new javax.swing.JButton();
        dynamicImage2 = new javax.swing.JLabel();
        price2 = new javax.swing.JLabel();
        dynamicCount4 = new javax.swing.JPanel();
        title4 = new javax.swing.JLabel();
        dynamicButton4 = new javax.swing.JButton();
        dynamicImage4 = new javax.swing.JLabel();
        price4 = new javax.swing.JLabel();
        dynamicCount3 = new javax.swing.JPanel();
        title3 = new javax.swing.JLabel();
        dynamicButton3 = new javax.swing.JButton();
        dynamicImage3 = new javax.swing.JLabel();
        price3 = new javax.swing.JLabel();
        wareHouse = new javax.swing.JPanel();
        dynamic1 = new javax.swing.JPanel();
        imageCapture1 = new javax.swing.JLabel();
        selectorButton1 = new javax.swing.JButton();
        dynamic2 = new javax.swing.JPanel();
        imageCapture2 = new javax.swing.JLabel();
        selectorButton2 = new javax.swing.JButton();
        dynamic3 = new javax.swing.JPanel();
        imageCapture3 = new javax.swing.JLabel();
        selectorButton3 = new javax.swing.JButton();
        dynamic4 = new javax.swing.JPanel();
        imageCapture4 = new javax.swing.JLabel();
        selectorButton4 = new javax.swing.JButton();
        konfigurator = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jComboBox5 = new javax.swing.JComboBox();
        jComboBox6 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jComboBox13 = new javax.swing.JComboBox();
        jPanel8 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();

        LogIn.setBackground(new java.awt.Color(51, 51, 51));
        LogIn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LogIn.setMinimumSize(new java.awt.Dimension(503, 303));
        LogIn.setModal(true);
        LogIn.setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Benutzername:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Passwort:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton7.setText("Einloggen");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Abbrechen");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel26.setText("Benutzername oder Kennwort");
        jLabel26.setVisible(false);

        jLabel27.setText("falsch! Versuchen Sie es erneut!");
        jLabel27.setVisible(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout LogInLayout = new javax.swing.GroupLayout(LogIn.getContentPane());
        LogIn.getContentPane().setLayout(LogInLayout);
        LogInLayout.setHorizontalGroup(
            LogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogInLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        LogInLayout.setVerticalGroup(
            LogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogInLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pgenerate.setMinimumSize(new java.awt.Dimension(600, 500));
        pgenerate.setModal(true);

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Prozessor", "Grafikkarte", "RAM", "Festplatte", "Motherboard", "Gehäuse", "Netzteil" }));
        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel14.setText("Produktklasse:");

        jLabel15.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel15.setText("Preis:");

        jLabel16.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel16.setText("Produktbezeichnung:");

        jButton13.setText("OK");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton15.setText("Anlegen");

        jLabel34.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel34.setText("jLabel34:");

        jLabel35.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel35.setText("jLabel35:");

        jLabel36.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel36.setText("jLabel36.");

        javax.swing.GroupLayout pgenerateLayout = new javax.swing.GroupLayout(pgenerate.getContentPane());
        pgenerate.getContentPane().setLayout(pgenerateLayout);
        pgenerateLayout.setHorizontalGroup(
            pgenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pgenerateLayout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addGroup(pgenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pgenerateLayout.createSequentialGroup()
                        .addComponent(jButton13)
                        .addGap(18, 18, 18)
                        .addComponent(jButton15))
                    .addGroup(pgenerateLayout.createSequentialGroup()
                        .addGroup(pgenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36))
                        .addGap(79, 79, 79)
                        .addGroup(pgenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField10)
                            .addComponent(jTextField9)
                            .addComponent(jComboBox7, 0, 200, Short.MAX_VALUE)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3)
                            .addComponent(jTextField8))))
                .addGap(51, 51, 51))
        );
        pgenerateLayout.setVerticalGroup(
            pgenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pgenerateLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(pgenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pgenerateLayout.createSequentialGroup()
                        .addGroup(pgenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pgenerateLayout.createSequentialGroup()
                                .addGroup(pgenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGap(40, 40, 40)
                                .addComponent(jLabel16))
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pgenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pgenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34))
                        .addGap(18, 18, 18)
                        .addGroup(pgenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35))
                        .addGap(18, 18, 18)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(pgenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13)
                    .addComponent(jButton15))
                .addGap(34, 34, 34))
        );

        pchange.setMinimumSize(new java.awt.Dimension(600, 500));
        pchange.setModal(true);

        jLabel18.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel18.setText("Artikelbezeichnung:");

        jLabel20.setText("Artikel gefunden");

        jLabel21.setText("Artikel nicht gefunden");

        jButton16.setText("OK");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("Ändern");

        jButton25.setText("Suchen");

        jLabel17.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel17.setText("Preis:");

        jLabel32.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel32.setText("Artikelbezeichnung:");

        jLabel37.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel37.setText("jLabel37");

        jLabel19.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel19.setText("jLabel19");

        jLabel39.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel39.setText("jLabel39");

        javax.swing.GroupLayout pchangeLayout = new javax.swing.GroupLayout(pchange.getContentPane());
        pchange.getContentPane().setLayout(pchangeLayout);
        pchangeLayout.setHorizontalGroup(
            pchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pchangeLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(pchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(jLabel32)
                    .addGroup(pchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel39))
                .addGap(35, 35, 35)
                .addGroup(pchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pchangeLayout.createSequentialGroup()
                        .addComponent(jButton16)
                        .addGap(127, 127, 127)
                        .addComponent(jButton17))
                    .addGroup(pchangeLayout.createSequentialGroup()
                        .addGroup(pchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pchangeLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel21))
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pchangeLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField11)
                            .addComponent(jTextField5)
                            .addComponent(jTextField12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton25)))
                .addGap(34, 34, 34))
        );
        pchangeLayout.setVerticalGroup(
            pchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pchangeLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(pchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton25)
                    .addComponent(jLabel18)
                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(pchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addGap(18, 18, 18)
                .addGroup(pchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(pchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(pchangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton16)
                    .addComponent(jButton17))
                .addGap(34, 34, 34))
        );

        pdelete.setMinimumSize(new java.awt.Dimension(600, 500));
        pdelete.setModal(true);

        jLabel22.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel22.setText("Artikelbezeichnung:");

        jLabel23.setText("Artikel gefunden");

        jLabel24.setText("Artikel nicht gefunden");

        jButton18.setText("OK");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setText("Löschen");

        jButton26.setText("Suchen");

        javax.swing.GroupLayout pdeleteLayout = new javax.swing.GroupLayout(pdelete.getContentPane());
        pdelete.getContentPane().setLayout(pdeleteLayout);
        pdeleteLayout.setHorizontalGroup(
            pdeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pdeleteLayout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addGroup(pdeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pdeleteLayout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel24))
                    .addGroup(pdeleteLayout.createSequentialGroup()
                        .addComponent(jButton18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton19))
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton26)
                .addGap(83, 83, 83))
        );
        pdeleteLayout.setVerticalGroup(
            pdeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pdeleteLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(pdeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton26))
                .addGap(18, 18, 18)
                .addGroup(pdeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 329, Short.MAX_VALUE)
                .addGroup(pdeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton18)
                    .addComponent(jButton19))
                .addGap(34, 34, 34))
        );

        backEndDialog.setLocationByPlatform(true);
        backEndDialog.setMinimumSize(new java.awt.Dimension(899, 670));
        backEndDialog.setModal(true);

        backEnd.setBackground(new java.awt.Color(255, 255, 255));
        backEnd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backEnd.setMinimumSize(new java.awt.Dimension(899, 670));
        backEnd.setPreferredSize(new java.awt.Dimension(899, 670));

        jLabel13.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("Willkommen Admin!");

        jPanel4.setLayout(new java.awt.GridLayout(1, 3));

        jPanel5.setBackground(new java.awt.Color(51, 204, 0));
        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        jButton20.setBackground(new java.awt.Color(51, 204, 0));
        jButton20.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jButton20.setText("Produkt anlegen");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton20);

        jPanel4.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 153, 0));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jButton21.setBackground(new java.awt.Color(255, 153, 0));
        jButton21.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jButton21.setText("Produkt ändern");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton21);

        jPanel4.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 51, 51));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });
        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        jButton22.setBackground(new java.awt.Color(255, 51, 51));
        jButton22.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jButton22.setText("Produkt löschen");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton22);

        jPanel4.add(jPanel7);

        jButton11.setBackground(new java.awt.Color(255, 51, 51));
        jButton11.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jButton11.setText("Ausloggen");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backEndLayout = new javax.swing.GroupLayout(backEnd);
        backEnd.setLayout(backEndLayout);
        backEndLayout.setHorizontalGroup(
            backEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backEndLayout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(backEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(backEndLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        backEndLayout.setVerticalGroup(
            backEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backEndLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(backEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(145, 145, 145)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(163, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout backEndDialogLayout = new javax.swing.GroupLayout(backEndDialog.getContentPane());
        backEndDialog.getContentPane().setLayout(backEndDialogLayout);
        backEndDialogLayout.setHorizontalGroup(
            backEndDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 925, Short.MAX_VALUE)
            .addGroup(backEndDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(backEndDialogLayout.createSequentialGroup()
                    .addGap(0, 13, Short.MAX_VALUE)
                    .addComponent(backEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 13, Short.MAX_VALUE)))
        );
        backEndDialogLayout.setVerticalGroup(
            backEndDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 696, Short.MAX_VALUE)
            .addGroup(backEndDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(backEndDialogLayout.createSequentialGroup()
                    .addGap(0, 13, Short.MAX_VALUE)
                    .addComponent(backEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 13, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 202, Short.MAX_VALUE)
        );

        Einkauf.setMinimumSize(new java.awt.Dimension(400, 300));
        Einkauf.setModal(true);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/smileys.jpg"))); // NOI18N

        jLabel33.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Danke für Ihren Einkauf!");

        jButton30.setText("OK");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EinkaufLayout = new javax.swing.GroupLayout(Einkauf.getContentPane());
        Einkauf.getContentPane().setLayout(EinkaufLayout);
        EinkaufLayout.setHorizontalGroup(
            EinkaufLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EinkaufLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EinkaufLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(EinkaufLayout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton30)))
                .addContainerGap())
        );
        EinkaufLayout.setVerticalGroup(
            EinkaufLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EinkaufLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(EinkaufLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(132, 51, 51));
        setMaximumSize(new java.awt.Dimension(1920, 1040));
        setPreferredSize(new java.awt.Dimension(1920, 1040));

        jPanel2.setBackground(new java.awt.Color(132, 51, 51));
        jPanel2.setMinimumSize(new java.awt.Dimension(900, 624));
        jPanel2.setPreferredSize(new java.awt.Dimension(900, 1040));

        topBar.setBackground(new java.awt.Color(132, 51, 51));
        topBar.setLayout(new java.awt.GridLayout(1, 0));

        jButton12.setBackground(new java.awt.Color(255, 51, 51));
        jButton12.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jButton12.setText("Log In");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        topBar.add(jButton12);

        jButton14.setBackground(new java.awt.Color(255, 51, 51));
        jButton14.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jButton14.setText("Warenkorb");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        topBar.add(jButton14);

        sideBar.setBackground(new java.awt.Color(132, 51, 51));
        sideBar.setLayout(new java.awt.GridLayout(8, 0));

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jButton1.setText("Arbeitsspeicher");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        sideBar.add(jButton1);

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jButton2.setText("Grafikkarten");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        sideBar.add(jButton2);

        jButton3.setBackground(new java.awt.Color(255, 51, 51));
        jButton3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jButton3.setText("Prozessoren");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        sideBar.add(jButton3);

        jButton5.setBackground(new java.awt.Color(255, 51, 51));
        jButton5.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jButton5.setText("Netzteile");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        sideBar.add(jButton5);

        jButton4.setBackground(new java.awt.Color(255, 51, 51));
        jButton4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jButton4.setText("Gehäuse");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        sideBar.add(jButton4);

        jButton23.setBackground(new java.awt.Color(255, 51, 51));
        jButton23.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jButton23.setText("Festplatten");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        sideBar.add(jButton23);

        jButton24.setBackground(new java.awt.Color(255, 51, 51));
        jButton24.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jButton24.setText("Motherboards");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        sideBar.add(jButton24);

        jButton6.setBackground(new java.awt.Color(255, 51, 51));
        jButton6.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jButton6.setText("PC - Konfigurator");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        sideBar.add(jButton6);

        jButton27.setBackground(new java.awt.Color(132, 51, 51));
        jButton27.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 36)); // NOI18N
        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/puffle.png"))); // NOI18N
        jButton27.setText("FANCY HardwareShop");
        jButton27.setBorderPainted(false);
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        konfigurator.setVisible(false);
        Produktansicht.setBackground(new java.awt.Color(132, 51, 51));
        Produktansicht.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Produktansicht.setMinimumSize(new java.awt.Dimension(664, 415));
        Produktansicht.setPreferredSize(new java.awt.Dimension(664, 415));
        Produktansicht.setLayout(new java.awt.GridLayout(6, 0));
        Produktansicht.setVisible(false);

        konfigurator.setVisible(false);
        detailAnsicht.setBackground(new java.awt.Color(132, 51, 51));
        detailAnsicht.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        detailAnsicht.setMinimumSize(new java.awt.Dimension(664, 415));
        detailAnsicht.setPreferredSize(new java.awt.Dimension(664, 624));

        detailImage.setText("jLabel3");

        detailTitle.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        detailTitle.setText("jLabel3");

        detail1.setText("jLabel3");

        detail2.setText("jLabel4");

        detail3.setText("jLabel29");

        detail4.setText("jLabel33");

        jButton28.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jButton28.setText("In den Warenkorb");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton29.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jButton29.setText("Zurück");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        detailAnsicht.setVisible(false);

        javax.swing.GroupLayout detailAnsichtLayout = new javax.swing.GroupLayout(detailAnsicht);
        detailAnsicht.setLayout(detailAnsichtLayout);
        detailAnsichtLayout.setHorizontalGroup(
            detailAnsichtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailAnsichtLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(detailTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(352, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailAnsichtLayout.createSequentialGroup()
                .addGroup(detailAnsichtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(detailAnsichtLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton29))
                    .addGroup(detailAnsichtLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton28))
                    .addGroup(detailAnsichtLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(detailAnsichtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(detail4, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(detail2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(detail1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(detail3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(detailImage, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        detailAnsichtLayout.setVerticalGroup(
            detailAnsichtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailAnsichtLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(detailTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(detailAnsichtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(detailImage, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(detailAnsichtLayout.createSequentialGroup()
                        .addComponent(detail1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(detail2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(detail3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(detail4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(371, Short.MAX_VALUE))
        );

        konfigurator.setVisible(false);
        basket.setBackground(new java.awt.Color(132, 51, 51));
        basket.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        basket.setMinimumSize(new java.awt.Dimension(664, 415));

        detailTitle1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 24)); // NOI18N
        detailTitle1.setText("WARENKORB");

        detail5.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        detail5.setText("Produkte");

        product1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        product1.setText("jLabel4");

        product2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        product2.setText("jLabel29");

        product3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        product3.setText("jLabel33");

        jButton31.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jButton31.setText("Zur Kasse");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        product4.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        product4.setText("jLabel3");

        product5.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        product5.setText("jLabel4");

        jLabel29.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 18)); // NOI18N
        jLabel29.setText("Preis");

        bprice1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        bprice1.setText("jLabel33");

        bprice2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        bprice2.setText("jLabel34");

        bprice3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        bprice3.setText("jLabel35");

        bprice4.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        bprice4.setText("jLabel36");

        bprice5.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        bprice5.setText("jLabel37");

        jLabel38.setFont(new java.awt.Font("Tw Cen MT Condensed", 3, 24)); // NOI18N
        jLabel38.setText("Gesamtpreis:");

        gesamtPreis.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        gesamtPreis.setText("jLabel39");

        removeButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/x-icon.png"))); // NOI18N
        removeButton1.setBorderPainted(false);
        removeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButton1ActionPerformed(evt);
            }
        });

        removeButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/x-icon.png"))); // NOI18N
        removeButton2.setBorderPainted(false);
        removeButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButton2ActionPerformed(evt);
            }
        });

        removeButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/x-icon.png"))); // NOI18N
        removeButton3.setBorderPainted(false);
        removeButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButton3ActionPerformed(evt);
            }
        });

        removeButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/x-icon.png"))); // NOI18N
        removeButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButton4ActionPerformed(evt);
            }
        });

        removeButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/x-icon.png"))); // NOI18N
        removeButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButton5ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel3.setText("Warenkorb ist leer!");
        jLabel13.setVisible(false);

        basket.setVisible(false);

        javax.swing.GroupLayout basketLayout = new javax.swing.GroupLayout(basket);
        basket.setLayout(basketLayout);
        basketLayout.setHorizontalGroup(
            basketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basketLayout.createSequentialGroup()
                .addGroup(basketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(basketLayout.createSequentialGroup()
                        .addGroup(basketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(basketLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(detailTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(basketLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(basketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(basketLayout.createSequentialGroup()
                                        .addGroup(basketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(product3, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                            .addComponent(product1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(detail5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(product2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(product4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(product5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(basketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(basketLayout.createSequentialGroup()
                                                .addComponent(jLabel38)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                                .addComponent(gesamtPreis, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 12, Short.MAX_VALUE))
                                            .addGroup(basketLayout.createSequentialGroup()
                                                .addGroup(basketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(bprice5, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                                    .addComponent(bprice4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(bprice3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(bprice2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(bprice1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(basketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(removeButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                        .addComponent(removeButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                        .addComponent(removeButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                        .addComponent(removeButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(removeButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(9, 9, 9)))))))
                        .addGap(0, 290, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basketLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        basketLayout.setVerticalGroup(
            basketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basketLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(detailTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(basketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(detail5, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(basketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(basketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(product1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bprice1)))
                .addGap(18, 18, 18)
                .addGroup(basketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(basketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(product2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bprice2)))
                .addGap(18, 18, 18)
                .addGroup(basketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(basketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(product3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bprice3)))
                .addGap(18, 18, 18)
                .addGroup(basketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(basketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(product4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bprice4)))
                .addGap(18, 18, 18)
                .addGroup(basketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(basketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(product5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bprice5)))
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(basketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gesamtPreis, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
        );

        dynamicHouse.setBackground(new java.awt.Color(132, 51, 51));
        dynamicHouse.setMinimumSize(new java.awt.Dimension(664, 415));
        dynamicHouse.setPreferredSize(new java.awt.Dimension(664, 415));
        dynamicHouse.setLayout(new java.awt.GridLayout(2, 2));

        dynamicCount1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dynamicCount1.setMaximumSize(new java.awt.Dimension(332, 207));
        dynamicCount1.setMinimumSize(new java.awt.Dimension(332, 207));

        title1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        title1.setMaximumSize(new java.awt.Dimension(304, 126));
        title1.setMinimumSize(new java.awt.Dimension(304, 126));
        title1.setName(""); // NOI18N
        title1.setPreferredSize(new java.awt.Dimension(304, 126));

        dynamicButton1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        dynamicButton1.setText("Details");
        dynamicButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dynamicButton1ActionPerformed(evt);
            }
        });

        price1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 14)); // NOI18N

        javax.swing.GroupLayout dynamicCount1Layout = new javax.swing.GroupLayout(dynamicCount1);
        dynamicCount1.setLayout(dynamicCount1Layout);
        dynamicCount1Layout.setHorizontalGroup(
            dynamicCount1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dynamicCount1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dynamicCount1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(dynamicCount1Layout.createSequentialGroup()
                        .addComponent(dynamicImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dynamicCount1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(price1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dynamicButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        dynamicCount1Layout.setVerticalGroup(
            dynamicCount1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dynamicCount1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dynamicCount1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dynamicCount1Layout.createSequentialGroup()
                        .addComponent(price1, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dynamicButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dynamicImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        dynamicHouse.add(dynamicCount1);

        dynamicCount2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dynamicCount2.setMaximumSize(new java.awt.Dimension(332, 207));
        dynamicCount2.setMinimumSize(new java.awt.Dimension(332, 207));

        title2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        title2.setMaximumSize(new java.awt.Dimension(304, 126));
        title2.setMinimumSize(new java.awt.Dimension(304, 126));
        title2.setName(""); // NOI18N
        title2.setPreferredSize(new java.awt.Dimension(304, 126));

        dynamicButton2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        dynamicButton2.setText("Details");
        dynamicButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dynamicButton2ActionPerformed(evt);
            }
        });

        price2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 14)); // NOI18N

        javax.swing.GroupLayout dynamicCount2Layout = new javax.swing.GroupLayout(dynamicCount2);
        dynamicCount2.setLayout(dynamicCount2Layout);
        dynamicCount2Layout.setHorizontalGroup(
            dynamicCount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dynamicCount2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dynamicCount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title2, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addGroup(dynamicCount2Layout.createSequentialGroup()
                        .addComponent(dynamicImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dynamicCount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(price2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dynamicButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        dynamicCount2Layout.setVerticalGroup(
            dynamicCount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dynamicCount2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dynamicCount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dynamicCount2Layout.createSequentialGroup()
                        .addComponent(price2, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dynamicButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dynamicImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        dynamicHouse.add(dynamicCount2);

        dynamicCount4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dynamicCount4.setMaximumSize(new java.awt.Dimension(332, 207));
        dynamicCount4.setMinimumSize(new java.awt.Dimension(332, 207));

        title4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        title4.setMaximumSize(new java.awt.Dimension(304, 126));
        title4.setMinimumSize(new java.awt.Dimension(304, 126));
        title4.setName(""); // NOI18N
        title4.setPreferredSize(new java.awt.Dimension(304, 126));

        dynamicButton4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        dynamicButton4.setText("Details");
        dynamicButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dynamicButton4ActionPerformed(evt);
            }
        });

        price4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 14)); // NOI18N

        javax.swing.GroupLayout dynamicCount4Layout = new javax.swing.GroupLayout(dynamicCount4);
        dynamicCount4.setLayout(dynamicCount4Layout);
        dynamicCount4Layout.setHorizontalGroup(
            dynamicCount4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dynamicCount4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dynamicCount4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title4, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addGroup(dynamicCount4Layout.createSequentialGroup()
                        .addComponent(dynamicImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dynamicCount4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(price4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dynamicButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        dynamicCount4Layout.setVerticalGroup(
            dynamicCount4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dynamicCount4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dynamicCount4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dynamicCount4Layout.createSequentialGroup()
                        .addComponent(price4, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dynamicButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dynamicImage4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        dynamicHouse.add(dynamicCount4);

        dynamicCount3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dynamicCount3.setMaximumSize(new java.awt.Dimension(332, 207));
        dynamicCount3.setMinimumSize(new java.awt.Dimension(332, 207));

        title3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        title3.setMaximumSize(new java.awt.Dimension(304, 126));
        title3.setMinimumSize(new java.awt.Dimension(304, 126));
        title3.setName(""); // NOI18N
        title3.setPreferredSize(new java.awt.Dimension(304, 126));

        dynamicButton3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        dynamicButton3.setText("Details");
        dynamicButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dynamicButton3ActionPerformed(evt);
            }
        });

        price3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 14)); // NOI18N

        javax.swing.GroupLayout dynamicCount3Layout = new javax.swing.GroupLayout(dynamicCount3);
        dynamicCount3.setLayout(dynamicCount3Layout);
        dynamicCount3Layout.setHorizontalGroup(
            dynamicCount3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dynamicCount3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dynamicCount3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title3, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addGroup(dynamicCount3Layout.createSequentialGroup()
                        .addComponent(dynamicImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dynamicCount3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(price3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dynamicButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        dynamicCount3Layout.setVerticalGroup(
            dynamicCount3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dynamicCount3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dynamicCount3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dynamicCount3Layout.createSequentialGroup()
                        .addComponent(price3, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dynamicButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dynamicImage3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        dynamicHouse.add(dynamicCount3);

        wareHouse.setBackground(new java.awt.Color(132, 51, 51));
        wareHouse.setMinimumSize(new java.awt.Dimension(664, 415));
        wareHouse.setPreferredSize(new java.awt.Dimension(664, 415));
        wareHouse.setLayout(new java.awt.GridLayout(2, 2));
        wareHouse.setVisible(false);

        dynamic1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dynamic1.setMaximumSize(new java.awt.Dimension(332, 207));
        dynamic1.setMinimumSize(new java.awt.Dimension(332, 207));

        imageCapture1.setMaximumSize(new java.awt.Dimension(304, 126));
        imageCapture1.setMinimumSize(new java.awt.Dimension(304, 126));
        imageCapture1.setName(""); // NOI18N
        imageCapture1.setPreferredSize(new java.awt.Dimension(304, 126));

        selectorButton1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        selectorButton1.setText("jButton27");
        selectorButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectorButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dynamic1Layout = new javax.swing.GroupLayout(dynamic1);
        dynamic1.setLayout(dynamic1Layout);
        dynamic1Layout.setHorizontalGroup(
            dynamic1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dynamic1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dynamic1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectorButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imageCapture1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        dynamic1Layout.setVerticalGroup(
            dynamic1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dynamic1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageCapture1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectorButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        wareHouse.add(dynamic1);

        dynamic2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        imageCapture2.setMaximumSize(new java.awt.Dimension(304, 126));
        imageCapture2.setMinimumSize(new java.awt.Dimension(304, 126));
        imageCapture2.setPreferredSize(new java.awt.Dimension(304, 126));

        selectorButton2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        selectorButton2.setText("jButton28");
        selectorButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectorButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dynamic2Layout = new javax.swing.GroupLayout(dynamic2);
        dynamic2.setLayout(dynamic2Layout);
        dynamic2Layout.setHorizontalGroup(
            dynamic2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dynamic2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dynamic2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectorButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imageCapture2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        dynamic2Layout.setVerticalGroup(
            dynamic2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dynamic2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageCapture2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectorButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        wareHouse.add(dynamic2);

        dynamic3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        imageCapture3.setMaximumSize(new java.awt.Dimension(304, 126));
        imageCapture3.setMinimumSize(new java.awt.Dimension(304, 126));
        imageCapture3.setPreferredSize(new java.awt.Dimension(304, 126));

        selectorButton3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        selectorButton3.setText("jButton29");
        selectorButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectorButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dynamic3Layout = new javax.swing.GroupLayout(dynamic3);
        dynamic3.setLayout(dynamic3Layout);
        dynamic3Layout.setHorizontalGroup(
            dynamic3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dynamic3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dynamic3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectorButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imageCapture3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        dynamic3Layout.setVerticalGroup(
            dynamic3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dynamic3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageCapture3, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectorButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        wareHouse.add(dynamic3);

        dynamic4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        imageCapture4.setMaximumSize(new java.awt.Dimension(304, 126));
        imageCapture4.setMinimumSize(new java.awt.Dimension(304, 126));
        imageCapture4.setPreferredSize(new java.awt.Dimension(304, 126));

        selectorButton4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        selectorButton4.setText("jButton30");

        javax.swing.GroupLayout dynamic4Layout = new javax.swing.GroupLayout(dynamic4);
        dynamic4.setLayout(dynamic4Layout);
        dynamic4Layout.setHorizontalGroup(
            dynamic4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dynamic4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dynamic4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageCapture4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectorButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        dynamic4Layout.setVerticalGroup(
            dynamic4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dynamic4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageCapture4, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectorButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        wareHouse.add(dynamic4);

        konfigurator.setVisible(false);
        konfigurator.setBackground(new java.awt.Color(204, 204, 204));
        konfigurator.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        konfigurator.setMinimumSize(new java.awt.Dimension(664, 415));
        konfigurator.setPreferredSize(new java.awt.Dimension(664, 415));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel5.setText("Motherboard:");

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel6.setText("Prozessor:");

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel7.setText("Arbeitsspeicher:");

        jLabel8.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel8.setText("Netzteil:");

        jLabel9.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel9.setText("Festplatte:");

        jLabel10.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel10.setText("Gehäuse:");

        jButton9.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jButton9.setText("In den Warenkorb");

        jLabel11.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel11.setText("Preis:");

        jLabel12.setText("jLabel12");

        jButton10.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jButton10.setText("Reset");

        jLabel30.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 3, 18)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Grafikkarte:");

        jComboBox13.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout konfiguratorLayout = new javax.swing.GroupLayout(konfigurator);
        konfigurator.setLayout(konfiguratorLayout);
        konfiguratorLayout.setHorizontalGroup(
            konfiguratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, konfiguratorLayout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addGroup(konfiguratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, konfiguratorLayout.createSequentialGroup()
                        .addGroup(konfiguratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(125, 125, 125))
                    .addGroup(konfiguratorLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(150, 150, 150)))
                .addGroup(konfiguratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(konfiguratorLayout.createSequentialGroup()
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9))
                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox13, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(73, 73, 73))
        );
        konfiguratorLayout.setVerticalGroup(
            konfiguratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(konfiguratorLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(konfiguratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(konfiguratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(konfiguratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(konfiguratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(konfiguratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(konfiguratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(konfiguratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
                .addGroup(konfiguratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 717, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(dynamicHouse, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(wareHouse, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(konfigurator, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(dynamicHouse, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(wareHouse, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(konfigurator, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
        );
        jLayeredPane1.setLayer(dynamicHouse, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(wareHouse, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.setLayer(konfigurator, javax.swing.JLayeredPane.MODAL_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLayeredPane1))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(basket, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(detailAnsicht, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Produktansicht, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 833, Short.MAX_VALUE)
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 233, Short.MAX_VALUE)))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(basket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(detailAnsicht, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Produktansicht, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE))
        );
        jLayeredPane2.setLayer(Produktansicht, javax.swing.JLayeredPane.MODAL_LAYER);
        jLayeredPane2.setLayer(detailAnsicht, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane2.setLayer(basket, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLayeredPane1, javax.swing.JLayeredPane.POPUP_LAYER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLayeredPane2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129)
                        .addComponent(topBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(topBar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton27))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));

        jLabel31.setBackground(new java.awt.Color(0, 0, 0));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/nvidia_geforce_gtx_550_ti_4.jpg")));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/msi.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(450, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        jTextField1.setText("");
        jPasswordField1.setText("");
        LogIn.setVisible(true); 
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        showProductsdefault("Gehäuse");
        setLayers("Product");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        showProductsdefault("Netzteil");
        setLayers("Product");
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       setLayers("Konfigurator");
       
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        LogIn.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String s = jTextField1.getText();
        String p = jPasswordField1.getText();
        if(s.equals("admin")&& p.equals("admin")){
            jLabel26.setVisible(false);
            jLabel27.setVisible(false);
            LogIn.dispose();
            backEndDialog.setVisible(true);
            backEnd.setVisible(true);
            }
        else{
            jLabel26.setVisible(true);
            jLabel27.setVisible(true);}
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        homeScreen();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked

    }//GEN-LAST:event_jPanel7MouseClicked

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        pgenerate.setVisible(true);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        pchange.setVisible(true);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        pdelete.setVisible(true);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
       pgenerate.dispose();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        pchange.dispose();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        pdelete.dispose();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setLayers("Ware");
        select("DDR3","DDR4","DDR3.jpg", "DDR4.png");
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
       setLayers("Ware");
        select("HDD", "SSD", "HDD.jpg", "SSD.jpg");
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      setLayers("Ware");
        select("DualCore", "QuadCore", "MultiCore", "DualCore.jpg", "QuadCore.jpg", "MultiCore.jpg");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        displayBasket(basket_obj.getBasket());
    }//GEN-LAST:event_jButton14ActionPerformed

    private void selectorButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectorButton1ActionPerformed
        showProducts1();
    }//GEN-LAST:event_selectorButton1ActionPerformed

    private void dynamicButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dynamicButton1ActionPerformed
        dynamicDetailFill(fhs.getArrayList(),1);
        setLayers("Detail");
    }//GEN-LAST:event_dynamicButton1ActionPerformed

    private void dynamicButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dynamicButton2ActionPerformed
        dynamicDetailFill(fhs.getArrayList(),2);
        setLayers("Detail");
    }//GEN-LAST:event_dynamicButton2ActionPerformed

    private void dynamicButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dynamicButton3ActionPerformed
       dynamicDetailFill(fhs.getArrayList(),3); 
       setLayers("Detail");
    }//GEN-LAST:event_dynamicButton3ActionPerformed

    private void dynamicButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dynamicButton4ActionPerformed
        dynamicDetailFill(fhs.getArrayList(),4);
        setLayers("Detail");
    }//GEN-LAST:event_dynamicButton4ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
       homeScreen(); // TODO add your handling code here:
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
       String s = detailTitle.getText();
       Equipment obj = fhs.getEquipmentByName(s);
       basket_obj.add(obj);

    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
       detailAnsicht.setVisible(false);
       Produktansicht.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        Einkauf.setVisible(true);
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        showProductsdefault("Grafikkarte");
        setLayers("Product");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
       showProductsdefault("Motherboard");
        setLayers("Product");
    }//GEN-LAST:event_jButton24ActionPerformed

    private void selectorButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectorButton3ActionPerformed
       showProducts3(); // TODO add your handling code here:
    }//GEN-LAST:event_selectorButton3ActionPerformed

    private void selectorButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectorButton2ActionPerformed
       showProducts2(); // TODO add your handling code here:
    }//GEN-LAST:event_selectorButton2ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        homeScreen();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton30ActionPerformed

    private void removeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButton1ActionPerformed
        Equipment obj = fhs.getEquipmentByName(product1.getText());
        basket_obj.remove(obj);
        displayBasket(basket_obj.getBasket());
    }//GEN-LAST:event_removeButton1ActionPerformed

    private void removeButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButton2ActionPerformed
        Equipment obj = fhs.getEquipmentByName(product2.getText());
        basket_obj.remove(obj);
        displayBasket(basket_obj.getBasket());
    }//GEN-LAST:event_removeButton2ActionPerformed

    private void removeButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButton3ActionPerformed
        Equipment obj = fhs.getEquipmentByName(product3.getText());
        basket_obj.remove(obj);
        displayBasket(basket_obj.getBasket());
    }//GEN-LAST:event_removeButton3ActionPerformed

    private void removeButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButton4ActionPerformed
        Equipment obj = fhs.getEquipmentByName(product4.getText());
        basket_obj.remove(obj);
        displayBasket(basket_obj.getBasket());
    }//GEN-LAST:event_removeButton4ActionPerformed

    private void removeButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButton5ActionPerformed
        Equipment obj = fhs.getEquipmentByName(product5.getText());
        basket_obj.remove(obj);
        displayBasket(basket_obj.getBasket());
    }//GEN-LAST:event_removeButton5ActionPerformed
    private void setLayers(String ind){
        switch(ind)
        {
            case "Detail": 
                jLayeredPane1.setVisible(false);
                Produktansicht.setVisible(false);
                basket.setVisible(false);
                detailAnsicht.setVisible(true);
                break;
            case "Product":
                jLayeredPane1.setVisible(false);
                Produktansicht.setVisible(true);
                basket.setVisible(false);
                detailAnsicht.setVisible(false);
                break;
            case "Basket":
                jLayeredPane1.setVisible(false);
                Produktansicht.setVisible(false);
                basket.setVisible(true);
                detailAnsicht.setVisible(false);
                break;
            case "Dynamic":
                jLayeredPane1.setVisible(true);
                Produktansicht.setVisible(false);
                basket.setVisible(false);
                detailAnsicht.setVisible(false);
                wareHouse.setVisible(false);
                konfigurator.setVisible(false);
                dynamicHouse.setVisible(true);
                break;
            case "Ware": 
                jLayeredPane1.setVisible(true);
                Produktansicht.setVisible(false);
                basket.setVisible(false);
                detailAnsicht.setVisible(false);
                wareHouse.setVisible(true);
                konfigurator.setVisible(false);
                dynamicHouse.setVisible(false);
                break;
            case "Konfigurator":
                jLayeredPane1.setVisible(true);
                Produktansicht.setVisible(false);
                basket.setVisible(false);
                detailAnsicht.setVisible(false);
                wareHouse.setVisible(false);
                konfigurator.setVisible(true);
                dynamicHouse.setVisible(false);
                break;
        }
    }
    
    private void detailPerformed1(java.awt.event.ActionEvent evt){
        Equipment obj = fhs.getEquipmentByName(labels[0].getText());
        detailTitle.setText(labels[0].getText());
        detailImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/"+ indicator  +".jpg")));
        detail1.setText("Super fancy Detail!");
        detail2.setText("Super fancy Detail!");
        detail3.setText("Super fancy Detail!");
        detail4.setText("Super fancy Detail!");
        setLayers("Detail");
        obj.setClickFrq();
    } 
    
    private void detailPerformed2(java.awt.event.ActionEvent evt){
        Equipment obj = fhs.getEquipmentByName(labels[1].getText());
        detailTitle.setText(labels[1].getText());
        detailImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/"+ indicator  +".jpg")));
        detail1.setText("Super fancy Detail!");
        detail2.setText("Super fancy Detail!");
        detail3.setText("Super fancy Detail!");
        detail4.setText("Super fancy Detail!");
        setLayers("Detail");
        obj.setClickFrq();
    } 
    
    private void detailPerformed3(java.awt.event.ActionEvent evt){
        Equipment obj = fhs.getEquipmentByName(labels[2].getText());
        detailTitle.setText(labels[2].getText());
        detailImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/"+ indicator  +".jpg")));
        detail1.setText("Super fancy Detail!");
        detail2.setText("Super fancy Detail!");
        detail3.setText("Super fancy Detail!");
        detail4.setText("Super fancy Detail!");
        setLayers("Detail");
        obj.setClickFrq();
    } 
    
    private void detailPerformed4(java.awt.event.ActionEvent evt){
        Equipment obj = fhs.getEquipmentByName(labels[3].getText());
        detailTitle.setText(labels[3].getText());
        detailImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/"+ indicator  +".jpg")));
        detail1.setText("Super fancy Detail!");
        detail2.setText("Super fancy Detail!");
        detail3.setText("Super fancy Detail!");
        detail4.setText("Super fancy Detail!");
        setLayers("Detail");
        obj.setClickFrq();
    } 
    
    private void detailPerformed5(java.awt.event.ActionEvent evt){
        Equipment obj = fhs.getEquipmentByName(labels[4].getText());
        detailTitle.setText(labels[4].getText());
        detailImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/"+ indicator  +".jpg")));
        detail1.setText("Super fancy Detail!");
        detail2.setText("Super fancy Detail!");
        detail3.setText("Super fancy Detail!");
        detail4.setText("Super fancy Detail!");
        setLayers("Detail");
        obj.setClickFrq();
        
    } 
    
    private void detailPerformed6(java.awt.event.ActionEvent evt){
        Equipment obj = fhs.getEquipmentByName(labels[0].getText());
        detailTitle.setText(labels[5].getText());
        detailImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/"+ indicator  +".jpg")));
        detail1.setText("Super fancy Detail!");
        detail2.setText("Super fancy Detail!");
        detail3.setText("Super fancy Detail!");
        detail4.setText("Super fancy Detail!");
        setLayers("Detail");
        obj.setClickFrq();
    } 
      
    private void addToBasket1(java.awt.event.ActionEvent evt){
          String s = labels[0].getText();
          Equipment obj = fhs.getEquipmentByName(s);
          basket_obj.add(obj);
         }
      
    private void addToBasket2(java.awt.event.ActionEvent evt){
          String s = labels[1].getText();
          Equipment obj = fhs.getEquipmentByName(s);
          basket_obj.add(obj);
         }
       
    private void addToBasket3(java.awt.event.ActionEvent evt){
          String s = labels[2].getText();
          Equipment obj = fhs.getEquipmentByName(s);
          basket_obj.add(obj);
         }
        
    private void addToBasket4(java.awt.event.ActionEvent evt){
          String s = labels[3].getText();
          Equipment obj = fhs.getEquipmentByName(s);
          basket_obj.add(obj);
         }
         
    private void addToBasket5(java.awt.event.ActionEvent evt){
          String s = labels[4].getText();
          Equipment obj = fhs.getEquipmentByName(s);
          basket_obj.add(obj);
         }
          
    private void addToBasket6(java.awt.event.ActionEvent evt){
          String s = labels[5].getText();
          Equipment obj = fhs.getEquipmentByName(s);
          basket_obj.add(obj);
         }
     
    private void dynamicDetailFill(ArrayList<Equipment> list, int x){
        String s;
        Equipment obj = list.get(x);
        s = obj.klass();
        detailTitle.setText(obj.getPname());
        detailImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/" + s + ".jpg")));
        detail1.setText("Super fancy Detail!");
        detail2.setText("Super fancy Detail!");
        detail3.setText("Super fancy Detail!");
        detail4.setText("Super fancy Detail!");
        obj.setClickFrq();
    }
   
    private void displayBasket(ArrayList<Equipment> basket){
        int x = basket.size();
        if(basket.size() > 5)
            x = 5;
        Equipment obj;
        switch (x)
        {
            case 0: 
                jLabel13.setVisible(true);
                product1.setVisible(false);
                product2.setVisible(false);
                product3.setVisible(false);
                product4.setVisible(false);
                product5.setVisible(false);
                bprice1.setVisible(false);
                bprice2.setVisible(false);
                bprice3.setVisible(false);
                bprice4.setVisible(false);
                bprice5.setVisible(false);
                gesamtPreis.setVisible(false);
                removeButton1.setVisible(false);
                removeButton2.setVisible(false);
                removeButton3.setVisible(false);
                removeButton4.setVisible(false);
                removeButton5.setVisible(false);
                break;
            case 1: 
                jLabel13.setVisible(false);
                product1.setVisible(true);
                product2.setVisible(false);
                product3.setVisible(false);
                product4.setVisible(false);
                product5.setVisible(false);
                bprice1.setVisible(true);
                bprice2.setVisible(false);
                bprice3.setVisible(false);
                bprice4.setVisible(false);
                bprice5.setVisible(false);
                obj = basket.get(0);
                product1.setText(obj.getPname());
                bprice1.setText(String.valueOf(obj.getPrice()));
                gesamtPreis.setText(String.valueOf(basket_obj.getPrice()));
                removeButton1.setVisible(true);
                removeButton2.setVisible(false);
                removeButton3.setVisible(false);
                removeButton4.setVisible(false);
                removeButton5.setVisible(false);
            case 2:
                jLabel13.setVisible(false);
                product1.setVisible(true);
                product2.setVisible(true);
                product3.setVisible(false);
                product4.setVisible(false);
                product5.setVisible(false);
                bprice1.setVisible(true);
                bprice2.setVisible(true);
                bprice3.setVisible(false);
                bprice4.setVisible(false);
                bprice5.setVisible(false);
                obj = basket.get(0);
                product1.setText(obj.getPname());
                bprice1.setText(String.valueOf(obj.getPrice()));
                obj = basket.get(1);
                product2.setText(obj.getPname());
                bprice2.setText(String.valueOf(obj.getPrice()));
                gesamtPreis.setText(String.valueOf(basket_obj.getPrice()));
                removeButton1.setVisible(true);
                removeButton2.setVisible(true);
                removeButton3.setVisible(false);
                removeButton4.setVisible(false);
                removeButton5.setVisible(false);
            case 3:
                 jLabel13.setVisible(false);
                product1.setVisible(true);
                product2.setVisible(true);
                product3.setVisible(true);
                product4.setVisible(false);
                product5.setVisible(false);
                bprice1.setVisible(true);
                bprice2.setVisible(true);
                bprice3.setVisible(true);
                bprice4.setVisible(false);
                bprice5.setVisible(false);
                obj = basket.get(0);
                product1.setText(obj.getPname());
                bprice1.setText(String.valueOf(obj.getPrice()));
                obj = basket.get(1);
                product2.setText(obj.getPname());
                bprice2.setText(String.valueOf(obj.getPrice()));
                obj = basket.get(2);
                product3.setText(obj.getPname());
                bprice3.setText(String.valueOf(obj.getPrice()));
                gesamtPreis.setText(String.valueOf(basket_obj.getPrice()));
                removeButton1.setVisible(true);
                removeButton2.setVisible(true);
                removeButton3.setVisible(true);
                removeButton4.setVisible(false);
                removeButton5.setVisible(false);
            case 4:
                 jLabel13.setVisible(false);
                product1.setVisible(true);
                product2.setVisible(true);
                product3.setVisible(true);
                product4.setVisible(true);
                product5.setVisible(false);
                bprice1.setVisible(true);
                bprice2.setVisible(true);
                bprice3.setVisible(true);
                bprice4.setVisible(true);
                bprice5.setVisible(false);
                obj = basket.get(0);
                product1.setText(obj.getPname());
                bprice1.setText(String.valueOf(obj.getPrice()));
                obj = basket.get(1);
                product2.setText(obj.getPname());
                bprice2.setText(String.valueOf(obj.getPrice()));
                obj = basket.get(2);
                product3.setText(obj.getPname());
                bprice3.setText(String.valueOf(obj.getPrice()));
                obj = basket.get(3);
                product4.setText(obj.getPname());
                bprice4.setText(String.valueOf(obj.getPrice()));
                removeButton1.setVisible(true);
                removeButton2.setVisible(true);
                removeButton3.setVisible(true);
                removeButton4.setVisible(true);
                removeButton5.setVisible(false);
                gesamtPreis.setText(String.valueOf(basket_obj.getPrice()));
            case 5:
                 jLabel13.setVisible(false);
                product1.setVisible(true);
                product2.setVisible(true);
                product3.setVisible(true);
                product4.setVisible(true);
                product5.setVisible(true);
                bprice1.setVisible(true);
                bprice2.setVisible(true);
                bprice3.setVisible(true);
                bprice4.setVisible(true);
                bprice5.setVisible(true);
                obj = basket.get(0);
                product1.setText(obj.getPname());
                bprice1.setText(String.valueOf(obj.getPrice()));
                obj = basket.get(1);
                product2.setText(obj.getPname());
                bprice2.setText(String.valueOf(obj.getPrice()));
                obj = basket.get(2);
                product3.setText(obj.getPname());
                bprice3.setText(String.valueOf(obj.getPrice()));
                obj = basket.get(3);
                product4.setText(obj.getPname());
                bprice4.setText(String.valueOf(obj.getPrice()));
                obj = basket.get(4);
                product5.setText(obj.getPname());
                bprice5.setText(String.valueOf(obj.getPrice()));
                gesamtPreis.setText(String.valueOf(basket_obj.getPrice()));
                removeButton1.setVisible(true);
                removeButton2.setVisible(true);
                removeButton3.setVisible(true);
                removeButton4.setVisible(true);
                removeButton5.setVisible(true);
        }
        setLayers("Basket");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
                
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Einkauf;
    private javax.swing.JDialog LogIn;
    private javax.swing.JPanel Produktansicht;
    private javax.swing.JPanel backEnd;
    private javax.swing.JDialog backEndDialog;
    private javax.swing.JPanel basket;
    private javax.swing.JLabel bprice1;
    private javax.swing.JLabel bprice2;
    private javax.swing.JLabel bprice3;
    private javax.swing.JLabel bprice4;
    private javax.swing.JLabel bprice5;
    private javax.swing.JLabel detail1;
    private javax.swing.JLabel detail2;
    private javax.swing.JLabel detail3;
    private javax.swing.JLabel detail4;
    private javax.swing.JLabel detail5;
    private javax.swing.JPanel detailAnsicht;
    private javax.swing.JLabel detailImage;
    private javax.swing.JLabel detailTitle;
    private javax.swing.JLabel detailTitle1;
    private javax.swing.JPanel dynamic1;
    private javax.swing.JPanel dynamic2;
    private javax.swing.JPanel dynamic3;
    private javax.swing.JPanel dynamic4;
    private javax.swing.JButton dynamicButton1;
    private javax.swing.JButton dynamicButton2;
    private javax.swing.JButton dynamicButton3;
    private javax.swing.JButton dynamicButton4;
    private javax.swing.JPanel dynamicCount1;
    private javax.swing.JPanel dynamicCount2;
    private javax.swing.JPanel dynamicCount3;
    private javax.swing.JPanel dynamicCount4;
    private javax.swing.JPanel dynamicHouse;
    private javax.swing.JLabel dynamicImage1;
    private javax.swing.JLabel dynamicImage2;
    private javax.swing.JLabel dynamicImage3;
    private javax.swing.JLabel dynamicImage4;
    private javax.swing.JLabel gesamtPreis;
    private javax.swing.JLabel imageCapture1;
    private javax.swing.JLabel imageCapture2;
    private javax.swing.JLabel imageCapture3;
    private javax.swing.JLabel imageCapture4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox13;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel konfigurator;
    private javax.swing.JDialog pchange;
    private javax.swing.JDialog pdelete;
    private javax.swing.JDialog pgenerate;
    private javax.swing.JLabel price1;
    private javax.swing.JLabel price2;
    private javax.swing.JLabel price3;
    private javax.swing.JLabel price4;
    private javax.swing.JLabel product1;
    private javax.swing.JLabel product2;
    private javax.swing.JLabel product3;
    private javax.swing.JLabel product4;
    private javax.swing.JLabel product5;
    private javax.swing.JButton removeButton1;
    private javax.swing.JButton removeButton2;
    private javax.swing.JButton removeButton3;
    private javax.swing.JButton removeButton4;
    private javax.swing.JButton removeButton5;
    private javax.swing.JButton selectorButton1;
    private javax.swing.JButton selectorButton2;
    private javax.swing.JButton selectorButton3;
    private javax.swing.JButton selectorButton4;
    private javax.swing.JPanel sideBar;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel title3;
    private javax.swing.JLabel title4;
    private javax.swing.JPanel topBar;
    private javax.swing.JPanel wareHouse;
    // End of variables declaration//GEN-END:variables
}
