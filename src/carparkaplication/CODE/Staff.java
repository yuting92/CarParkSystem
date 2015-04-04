/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carparkaplication.CODE;

import javax.swing.JFrame;

/**
 *
 * @author Administrator
 */
public class Staff extends User implements ChangePasswordInterface, PayInterface {

    private String staff_number;
    private String password;
    private String plate;


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
    private String department;

    public Staff(JFrame mainFrame) {
        super(mainFrame);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStaff_number() {
        return staff_number;
    }

    public void setStaff_number(String staff_number) {
        this.staff_number = staff_number;
    }

    //public method
    public Boolean regist(String staff_number, String password) {
        return theCarPark_Control.addStaff(staff_number, password);
    }

    public Boolean checkstaff(String staffnumber) {
        String result=Xml.checkStaff(staffnumber);
        if(result.equals(""))
            return false;
        else{
            return true;
        }
    }

    public void enter_record(String staffnumber) {
        theCarPark_Control.enter_record(staffnumber);
    }

    public Boolean setPlate(String number, String dep, String platenumber) {
        return theCarPark_Control.setplage(number, dep, platenumber);
    }

    @Override
    public Boolean login(String user_number, String password) {
        return theCarPark_Control.checkStaff(user_number, password);
    }

    @Override
    public Boolean exit(String user_number) {
        payBill(user_number);
        return theCarPark_Control.end_record(user_number);
    }

    public Boolean changepassword(String number, String new_password) {
        return theCarPark_Control.changeStaff(number, new_password);
    }

    public Boolean payBill(String user_number) {
        return true;
    }
}
