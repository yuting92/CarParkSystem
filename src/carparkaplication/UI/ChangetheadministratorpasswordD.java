/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ChangetheadministratorpasswordD.java
 *
 * Created on 2012-4-25, 18:54:28
 */

package carparkaplication.UI;

import carparkaplication.CODE.Administrator;
import org.jdesktop.application.Action;

/**
 *
 * @author Administrator
 */
public class ChangetheadministratorpasswordD extends javax.swing.JDialog {

    public Main theMainFrame;
    /** Creates new form ChangetheadministratorpasswordD */
    public ChangetheadministratorpasswordD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        theMainFrame=(Main)parent;
        initComponents();
        ok_button.setText("OK");
        reset_button.setText("Reset");
        account_number.setText(((Administrator) theMainFrame.theUser).getAccount_number());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ok_button = new javax.swing.JButton();
        reset_button = new javax.swing.JButton();
        confirm_pas_text = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        new_pas_text = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        account_number = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(carparkaplication.CarParkAplicationApp.class).getContext().getActionMap(ChangetheadministratorpasswordD.class, this);
        ok_button.setAction(actionMap.get("ok_btn_clicked")); // NOI18N
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(carparkaplication.CarParkAplicationApp.class).getContext().getResourceMap(ChangetheadministratorpasswordD.class);
        ok_button.setText(resourceMap.getString("ok_button.text")); // NOI18N
        ok_button.setName("ok_button"); // NOI18N

        reset_button.setAction(actionMap.get("reset_btn_clicked")); // NOI18N
        reset_button.setText(resourceMap.getString("reset_button.text")); // NOI18N
        reset_button.setName("reset_button"); // NOI18N

        confirm_pas_text.setName("confirm_pas_text"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        new_pas_text.setName("new_pas_text"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        account_number.setText(resourceMap.getString("account_number.text")); // NOI18N
        account_number.setName("account_number"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addComponent(ok_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reset_button))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(new_pas_text, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                    .addComponent(confirm_pas_text, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                    .addComponent(account_number))))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(account_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(new_pas_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirm_pas_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ok_button, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reset_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChangetheadministratorpasswordD dialog = new ChangetheadministratorpasswordD(new javax.swing.JFrame(), true);
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
    public void ok_btn_clicked() {
         String staf_number = account_number.getText().toString();
        String new_pas = String.valueOf(new_pas_text.getPassword());
        String confirm_pas = String.copyValueOf(confirm_pas_text.getPassword());
        if (new_pas.equals(confirm_pas)) {
            if (((Administrator) theMainFrame.theUser).changepassword(((Administrator) theMainFrame.theUser).getAccount_number(), new_pas)) {
                this.dispose();
                MessageDialog theMessageDialog = new MessageDialog(theMainFrame, rootPaneCheckingEnabled);
                theMessageDialog.setMessage("Success !");
                theMessageDialog.setVisible(true);
            }
        }
    }

    @Action
    public void reset_btn_clicked() {
         new_pas_text.setText("");
        confirm_pas_text.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField account_number;
    private javax.swing.JPasswordField confirm_pas_text;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField new_pas_text;
    private javax.swing.JButton ok_button;
    private javax.swing.JButton reset_button;
    // End of variables declaration//GEN-END:variables

}
