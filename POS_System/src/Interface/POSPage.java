package Interface;

import Connection.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

public class POSPage extends javax.swing.JFrame {
    
    public POSPage() {
        initComponents();
    }
    
    public static Object listTable(){
        
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("Product Name");
        model.addColumn("Quantity");
        model.addColumn("Price");
        
        try {
            
            Connection conn = DBConnection.getConnection();
            
            String Query = "SELECT name, description, type, wholesale_price, "
                         + "retail_price, quantity_type, expiration_date, creation_date, "
                         + "stock_remaining, date_updated FROM pos_system.products;";
            
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(Query);
            
            while (resultSet.next()) {
                Object[] row = new Object[3];
                row[0] = resultSet.getString("name");
                row[1] = resultSet.getString("quantity_type");
                row[2] = resultSet.getDouble("wholesale_price");
                model.addRow(row);
            }
            
            listOfProduct.setModel(model);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return model;
    }
    
    public static void refreshTotal(){
        
        double sum = 0;
        double currentValue = 0;
                
            for (int i = 0; i < basketOfItems.getRowCount(); i++) {
                    
                Object currentObject = basketOfItems.getValueAt(i, 4); //getting total amount
                    
                if (currentObject != null) { //if row is not null then add it to sum
                        
                  currentValue = Double.parseDouble(currentObject.toString());
                    sum += currentValue;
                        
                }
                    
            }
                
        lTotalAmount.setText(Double.toString(sum));
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackground = new javax.swing.JPanel();
        panelTop = new javax.swing.JPanel();
        lPOSSystemNote = new javax.swing.JLabel();
        panelSearchitem = new javax.swing.JPanel();
        lPOSSystemNote1 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        panelSearchTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listOfProduct = new javax.swing.JTable();
        lPOSSystemNote4 = new javax.swing.JLabel();
        panelBasket = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        basketOfItems = new javax.swing.JTable();
        lTotalAmount = new javax.swing.JLabel();
        btnCheckout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1620, 800));
        setMinimumSize(new java.awt.Dimension(1620, 800));
        setPreferredSize(new java.awt.Dimension(1620, 800));
        getContentPane().setLayout(null);

        panelBackground.setBackground(new java.awt.Color(255, 255, 255));

        panelTop.setBackground(new java.awt.Color(204, 204, 204));

        lPOSSystemNote.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lPOSSystemNote.setForeground(new java.awt.Color(0, 0, 0));
        lPOSSystemNote.setText("POS SYSTEM");

        javax.swing.GroupLayout panelTopLayout = new javax.swing.GroupLayout(panelTop);
        panelTop.setLayout(panelTopLayout);
        panelTopLayout.setHorizontalGroup(
            panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lPOSSystemNote)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTopLayout.setVerticalGroup(
            panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lPOSSystemNote)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelSearchitem.setBackground(new java.awt.Color(204, 204, 204));

        lPOSSystemNote1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lPOSSystemNote1.setForeground(new java.awt.Color(0, 0, 0));
        lPOSSystemNote1.setText("Search Item:");

        tfSearch.setBackground(new java.awt.Color(204, 204, 204));
        tfSearch.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout panelSearchitemLayout = new javax.swing.GroupLayout(panelSearchitem);
        panelSearchitem.setLayout(panelSearchitemLayout);
        panelSearchitemLayout.setHorizontalGroup(
            panelSearchitemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchitemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lPOSSystemNote1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelSearchitemLayout.setVerticalGroup(
            panelSearchitemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSearchitemLayout.createSequentialGroup()
                .addGap(0, 3, Short.MAX_VALUE)
                .addGroup(panelSearchitemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lPOSSystemNote1)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panelSearchTable.setBackground(new java.awt.Color(204, 204, 204));

        listOfProduct.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        listOfProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listOfProduct.setRowHeight(25);
        jScrollPane1.setViewportView(listOfProduct);

        javax.swing.GroupLayout panelSearchTableLayout = new javax.swing.GroupLayout(panelSearchTable);
        panelSearchTable.setLayout(panelSearchTableLayout);
        panelSearchTableLayout.setHorizontalGroup(
            panelSearchTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSearchTableLayout.setVerticalGroup(
            panelSearchTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSearchTableLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        lPOSSystemNote4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lPOSSystemNote4.setForeground(new java.awt.Color(0, 0, 0));
        lPOSSystemNote4.setText("CURRENT ITEM(S) TOTAL:");

        panelBasket.setBackground(new java.awt.Color(204, 204, 204));

        basketOfItems.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        basketOfItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Unit", "Name", "Price", "Quantity", "Total"
            }
        ));
        basketOfItems.setRowHeight(25);
        jScrollPane3.setViewportView(basketOfItems);
        if (basketOfItems.getColumnModel().getColumnCount() > 0) {
            basketOfItems.getColumnModel().getColumn(0).setMinWidth(75);
            basketOfItems.getColumnModel().getColumn(0).setPreferredWidth(10);
            basketOfItems.getColumnModel().getColumn(0).setMaxWidth(75);
            basketOfItems.getColumnModel().getColumn(1).setMinWidth(275);
            basketOfItems.getColumnModel().getColumn(1).setMaxWidth(275);
            basketOfItems.getColumnModel().getColumn(2).setMinWidth(75);
            basketOfItems.getColumnModel().getColumn(2).setMaxWidth(75);
            basketOfItems.getColumnModel().getColumn(3).setMinWidth(75);
            basketOfItems.getColumnModel().getColumn(3).setMaxWidth(75);
        }

        javax.swing.GroupLayout panelBasketLayout = new javax.swing.GroupLayout(panelBasket);
        panelBasket.setLayout(panelBasketLayout);
        panelBasketLayout.setHorizontalGroup(
            panelBasketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBasketLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        panelBasketLayout.setVerticalGroup(
            panelBasketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBasketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                .addContainerGap())
        );

        lTotalAmount.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lTotalAmount.setForeground(new java.awt.Color(51, 255, 0));
        lTotalAmount.setText("00.00");

        btnCheckout.setBackground(new java.awt.Color(204, 204, 204));
        btnCheckout.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        btnCheckout.setForeground(new java.awt.Color(0, 0, 0));
        btnCheckout.setText("Checkout");
        btnCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBackgroundLayout = new javax.swing.GroupLayout(panelBackground);
        panelBackground.setLayout(panelBackgroundLayout);
        panelBackgroundLayout.setHorizontalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelSearchTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSearchitem, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBackgroundLayout.createSequentialGroup()
                        .addComponent(lPOSSystemNote4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnCheckout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelBasket, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(434, 434, 434))
        );
        panelBackgroundLayout.setVerticalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgroundLayout.createSequentialGroup()
                .addComponent(panelTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lPOSSystemNote4)
                    .addComponent(lTotalAmount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBackgroundLayout.createSequentialGroup()
                        .addComponent(panelSearchitem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelSearchTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(panelBasket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        getContentPane().add(panelBackground);
        panelBackground.setBounds(0, 0, 1920, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCheckoutActionPerformed


    // ----------- Generated code above via NetBeans -----------
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                POSPage page = new POSPage();
                page.setExtendedState(POSPage.MAXIMIZED_BOTH);
                page.setVisible(true);
                
                refreshTotal();
                listTable();
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTable basketOfItems;
    private javax.swing.JButton btnCheckout;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lPOSSystemNote;
    private javax.swing.JLabel lPOSSystemNote1;
    private javax.swing.JLabel lPOSSystemNote4;
    private static javax.swing.JLabel lTotalAmount;
    private static javax.swing.JTable listOfProduct;
    private javax.swing.JPanel panelBackground;
    private javax.swing.JPanel panelBasket;
    private javax.swing.JPanel panelSearchTable;
    private javax.swing.JPanel panelSearchitem;
    private javax.swing.JPanel panelTop;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
