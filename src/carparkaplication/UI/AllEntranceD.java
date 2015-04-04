/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AllEntranceD.java
 *
 * Created on 2012-4-25, 18:56:56
 */
package carparkaplication.UI;

import carparkaplication.CODE.Customer;
import carparkaplication.CODE.Staff;
import org.jdesktop.application.Action;

/**
 *
 * @author Administrator
 */
public class AllEntranceD extends javax.swing.JDialog {

    private Main theMainFrame;

    /** Creates new form AllEntranceD */
    public AllEntranceD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        theMainFrame = (Main) parent;
        initComponents();
        staff_login_panel.setVisible(false);
        theMainFrame.theUser = new Customer(theMainFrame);
        info_text.setText(((Customer) theMainFrame.theUser).theCarPark_Control.getAllEntraceWelcome_info());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        staff_button = new javax.swing.JButton();
        staff_login_panel = new javax.swing.JPanel();
        enter_button = new javax.swing.JButton();
        staffnumber_text = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        info_text = new javax.swing.JTextArea();
        customer_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(carparkaplication.CarParkAplicationApp.class).getContext().getActionMap(AllEntranceD.class, this);
        staff_button.setAction(actionMap.get("show_staff_login_panel")); // NOI18N
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(carparkaplication.CarParkAplicationApp.class).getContext().getResourceMap(AllEntranceD.class);
        staff_button.setText(resourceMap.getString("staff_button.text")); // NOI18N
        staff_button.setName("staff_button"); // NOI18N

        staff_login_panel.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("staff_login_panel.border.lineColor"))); // NOI18N
        staff_login_panel.setName("staff_login_panel"); // NOI18N

        enter_button.setAction(actionMap.get("enter_button_clicked")); // NOI18N
        enter_button.setText(resourceMap.getString("enter_button.text")); // NOI18N
        enter_button.setName("enter_button"); // NOI18N

        staffnumber_text.setName("staffnumber_text"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.GroupLayout staff_login_panelLayout = new javax.swing.GroupLayout(staff_login_panel);
        staff_login_panel.setLayout(staff_login_panelLayout);
        staff_login_panelLayout.setHorizontalGroup(
            staff_login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staff_login_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(staff_login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(staffnumber_text, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(enter_button))
                .addContainerGap())
        );
        staff_login_panelLayout.setVerticalGroup(
            staff_login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staff_login_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(staffnumber_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(enter_button)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        info_text.setColumns(20);
        info_text.setFont(resourceMap.getFont("info_text.font")); // NOI18N
        info_text.setRows(5);
        info_text.setName("info_text"); // NOI18N
        jScrollPane1.setViewportView(info_text);

        customer_button.setAction(actionMap.get("customer_btn_clicked")); // NOI18N
        customer_button.setText(resourceMap.getString("customer_button.text")); // NOI18N
        customer_button.setName("customer_button"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(staff_button, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(staff_login_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customer_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(staff_button, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(staff_login_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(customer_button, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                AllEntranceD dialog = new AllEntranceD(new javax.swing.JFrame(), true);
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
    public void show_staff_login_panel() {
        staff_login_panel.setVisible(true);
    }

    @Action
    public void enter_button_clicked() {
        theMainFrame.theUser = new Staff(theMainFrame);
        String staffString = staffnumber_text.getText().toString();
        if (staffString.trim().equals("")) {
            MessageDialog newMessageDialog = new MessageDialog(theMainFrame, rootPaneCheckingEnabled);
            newMessageDialog.setMessage("The staff number can't be empty!");
            newMessageDialog.setVisible(true);
        } else {
            if (((Staff) theMainFrame.theUser).checkstaff(staffString)) {
                //ok
                ((Staff) theMainFrame.theUser).setStaff_number(staffString);
                //((Staff) theMainFrame.theUser).enter_record(staffString);
                if (((Staff) theMainFrame.theUser).theCarPark_Control.getPorCount() <= 0) {
                    this.dispose();
                    MessageDialog newMessageDialog = new MessageDialog(theMainFrame, rootPaneCheckingEnabled);
                    newMessageDialog.setMessage("No empty park place!");
                    newMessageDialog.setVisible(true);
                } else {
                    this.dispose();
                    EnterShowDialog myEnterShowDialog = new EnterShowDialog(theMainFrame, rootPaneCheckingEnabled);
                    myEnterShowDialog.setVisible(true);
                }
            } else {
                //wrong
                MessageDialog newMessageDialog = new MessageDialog(theMainFrame, rootPaneCheckingEnabled);
                newMessageDialog.setMessage("The staff number isn't available");
                newMessageDialog.setVisible(true);
            }
        }
    }

    @Action
    public void customer_btn_clicked() {
        theMainFrame.theUser = new Customer(theMainFrame);
        if ((((Customer) theMainFrame.theUser).theCarPark_Control.getPorCount() <= 0) || !(((Customer) theMainFrame.theUser).theCarPark_Control.checkis_open())) {
           this.dispose();
            MessageDialog newMessageDialog = new MessageDialog(theMainFrame, rootPaneCheckingEnabled);
            newMessageDialog.setMessage("The park is not available");
            newMessageDialog.setVisible(true);
        }else{
            this.dispose();
            String geneTick=((Customer)theMainFrame.theUser).theCarPark_Control.generateTicket(6);
            ((Customer)theMainFrame.theUser).setTicket_number(geneTick);
            CustomerEnterShowDialog myCustomerEnterShowDialog=new CustomerEnterShowDialog(theMainFrame, rootPaneCheckingEnabled);
            myCustomerEnterShowDialog.setVisible(true);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton customer_button;
    private javax.swing.JButton enter_button;
    private javax.swing.JTextArea info_text;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton staff_button;
    private javax.swing.JPanel staff_login_panel;
    private javax.swing.JTextField staffnumber_text;
    // End of variables declaration//GEN-END:variables
}