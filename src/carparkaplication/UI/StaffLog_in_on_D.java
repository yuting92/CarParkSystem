/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StaffLog_in_on_D.java
 *
 * Created on 2012-4-25, 19:10:23
 */
package carparkaplication.UI;

import carparkaplication.CODE.Staff;
import org.jdesktop.application.Action;

/**
 *
 * @author Administrator
 */
public class StaffLog_in_on_D extends javax.swing.JDialog {

    public Main theMainFrame;

    /** Creates new form StaffLog_in_on_D */
    public StaffLog_in_on_D(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        theMainFrame = (Main) parent;
        confirmlabel.setVisible(false);
        confirm_text.setVisible(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        password_text = new javax.swing.JPasswordField();
        confirm_text = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        confirmlabel = new javax.swing.JLabel();
        staff_number_text = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(carparkaplication.CarParkAplicationApp.class).getContext().getResourceMap(StaffLog_in_on_D.class);
        jCheckBox1.setText(resourceMap.getString("jCheckBox1.text")); // NOI18N
        jCheckBox1.setName("jCheckBox1"); // NOI18N
        jCheckBox1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox1StateChanged(evt);
            }
        });

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(carparkaplication.CarParkAplicationApp.class).getContext().getActionMap(StaffLog_in_on_D.class, this);
        jButton1.setAction(actionMap.get("loginoron_clicked")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        password_text.setName("password_text"); // NOI18N

        confirm_text.setName("confirm_text"); // NOI18N

        jLabel3.setFont(resourceMap.getFont("jLabel3.font")); // NOI18N
        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jButton2.setAction(actionMap.get("resetbutton_clicked")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N

        confirmlabel.setText(resourceMap.getString("confirmlabel.text")); // NOI18N
        confirmlabel.setName("confirmlabel"); // NOI18N

        staff_number_text.setName("staff_number_text"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(32, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(confirmlabel)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(confirm_text, 0, 0, Short.MAX_VALUE)
                                .addComponent(password_text, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                .addComponent(staff_number_text, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCheckBox1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel3)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staff_number_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirm_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmlabel))
                .addGap(11, 11, 11)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox1StateChanged
        // TODO add your handling code here:
        if (jCheckBox1.isSelected()) {
            confirmlabel.setVisible(true);
            confirm_text.setVisible(true);
        } else {
            confirmlabel.setVisible(false);
            confirm_text.setVisible(false);
        }
}//GEN-LAST:event_jCheckBox1StateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                StaffLog_in_on_D dialog = new StaffLog_in_on_D(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    @Action
    public void loginoron_clicked() {
        String staff_number = staff_number_text.getText().toString();
        String passwordString = String.valueOf(password_text.getPassword());

        if (staff_number.trim().equals("") || passwordString.trim().equals("")) {
            MessageDialog theMessageDialog = new MessageDialog(theMainFrame, rootPaneCheckingEnabled);
            theMessageDialog.setMessage("Staff number or password can't be empty!");
            theMessageDialog.setVisible(true);
        }
        if (jCheckBox1.isSelected()) {
            //log on
            String passconfirmString = String.valueOf(confirm_text.getPassword());
            if (!passwordString.equals(passconfirmString)) {
                MessageDialog theMessageDialog = new MessageDialog(theMainFrame, rootPaneCheckingEnabled);
                theMessageDialog.setMessage("Confirm password should be same with password!");
                theMessageDialog.setVisible(true);
            } else {
                theMainFrame.theUser = new Staff(theMainFrame);
                if (((Staff) theMainFrame.theUser).regist(staff_number, passwordString)) {
                    ((Staff) theMainFrame.theUser).setStaff_number(staff_number);
                    ((Staff) theMainFrame.theUser).setPassword(passwordString);
                    StaffManageStationD myStaffManageStationD = new StaffManageStationD(theMainFrame, rootPaneCheckingEnabled);
                    this.dispose();
                    myStaffManageStationD.setVisible(true);
                } else {
                    MessageDialog newMessageDialog = new MessageDialog(theMainFrame, rootPaneCheckingEnabled);
                    newMessageDialog.setMessage("Logon Failed!");
                    newMessageDialog.setVisible(true);
                }
            }
        } else {
            //log in
            theMainFrame.theUser = new Staff(theMainFrame);
            if (((Staff) theMainFrame.theUser).login(staff_number, passwordString)) {
                //success
                ((Staff) theMainFrame.theUser).setStaff_number(staff_number);
                ((Staff) theMainFrame.theUser).setPassword(passwordString);
                StaffManageStationD myStaffManageStationD = new StaffManageStationD(theMainFrame, rootPaneCheckingEnabled);
                this.dispose();
                myStaffManageStationD.setVisible(true);

            } else {
                MessageDialog newMessageDialog = new MessageDialog(theMainFrame, rootPaneCheckingEnabled);
                newMessageDialog.setMessage("Login Failed!");
                newMessageDialog.setVisible(true);
            }
        }
    }

    @Action
    public void resetbutton_clicked() {
        staff_number_text.setText("");
        password_text.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirm_text;
    private javax.swing.JLabel confirmlabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField password_text;
    private javax.swing.JTextField staff_number_text;
    // End of variables declaration//GEN-END:variables
}