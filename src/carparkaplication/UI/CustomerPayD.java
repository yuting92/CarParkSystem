/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CustomerPayD.java
 *
 * Created on 2012-4-26, 0:28:48
 */
package carparkaplication.UI;

import carparkaplication.CODE.Customer;
import org.jdesktop.application.Action;

/**
 *
 * @author Administrator
 */
public class CustomerPayD extends javax.swing.JDialog {

    private Main theMainFrame;

    /** Creates new form CustomerPayD */
    public CustomerPayD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        theMainFrame = (Main) parent;
        initComponents();
        theMainFrame.theUser=new Customer(theMainFrame);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ticket_number_text = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(carparkaplication.CarParkAplicationApp.class).getContext().getResourceMap(CustomerPayD.class);
        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        ticket_number_text.setText(resourceMap.getString("ticket_number_text.text")); // NOI18N
        ticket_number_text.setName("ticket_number_text"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(carparkaplication.CarParkAplicationApp.class).getContext().getActionMap(CustomerPayD.class, this);
        jButton1.setAction(actionMap.get("pay_ok_clicked")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(ticket_number_text, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ticket_number_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                CustomerPayD dialog = new CustomerPayD(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    @Action
    public void pay_ok_clicked() {
        String ticket_numberString = ticket_number_text.getText().toString().trim();
        if (ticket_numberString.trim().equals("")) {
            MessageDialog theMessageDialog = new MessageDialog(theMainFrame, rootPaneCheckingEnabled);
            theMessageDialog.setMessage("Ticket Number can't be empty !");
            theMessageDialog.setVisible(true);
        } else {
            if (((Customer) theMainFrame.theUser).payBill(ticket_numberString)) {
                ((Customer) theMainFrame.theUser).setTicket_number(ticket_numberString);
                this.dispose();
                PaymentStationD mypPaymentStationD=new PaymentStationD(theMainFrame, rootPaneCheckingEnabled);
                mypPaymentStationD.setVisible(true);
            } else {
                MessageDialog theMessageDialog = new MessageDialog(theMainFrame, rootPaneCheckingEnabled);
                theMessageDialog.setMessage("Ticket Number is not available !");
                theMessageDialog.setVisible(true);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField ticket_number_text;
    // End of variables declaration//GEN-END:variables
}
