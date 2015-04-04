/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carparkaplication.CODE;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import javax.swing.JFrame;

/**
 *
 * @author Administrator
 */
public class CarPark_Control {

    public JFrame theMainFrame;

    public CarPark_Control(JFrame mainFrame) {
        theMainFrame = mainFrame;
    }

    public int getPorCount() {
        return 1;
    }
    //check Admin

    public Boolean checkAdmin(String user_number, String password) {
        return Xml.checkAdmin(user_number, password);
    }
    public Boolean chanePas(String name_Number,String password){
        return Xml.changeAdmin(name_Number, password);
    }

    //check staff log in

    public Boolean checkStaff(String user_number, String password) {
        return Xml.checkPass(user_number, password);
    }
    //log on

    public Boolean addStaff(String user_number, String password) {
        return Xml.addStaff(user_number, password);
    }
    //set plate

    public Boolean setplage(String number, String dep, String plate_number) {
        return Xml.setPlate(number, dep, plate_number);
    }
    //get status

    public String getStaffStatus(String staff_number) {
        String result = Xml.getStaffStatue(staff_number);
        String returS;
        if (result.equals("0")) {
            returS = "Your application for registration has been denied.";
        } else if (result.equals("2")) {
            returS = "Your application for registration has been approved.";
        } else {
            returS = "Your application for registration has been sent.";
        }
        return returS;
    }
    //get record month bill by staff

    public String getMonthBillbyStaff(String staff_number, String month) {
        List theresult = Xml.getRecordByStaff(staff_number, month);
        return String.valueOf(theresult.size());
    }
    //staff change password

    public Boolean changeStaff(String number, String password) {
        return Xml.changeStaff(number, password);
    }

    //make plate
    public void makePlate(String staffnumber,String plate,boolean  tag)
    {
        Xml.makePlate(staffnumber, plate, tag);
    }
    //getallstaff
    public List getAllStaff(){
        return Xml.getAllStuff();
    }
    //getrecordbystaff
    public List<Record> getRecordByStaff(String staff_number)
    {
        return Xml.getRecordByStaff(staff_number);
    }
    //get staff not pass yet
    public List<StaffObj> getUnStaff(){
            return Xml.getUnStaff();
    }

    //getalldate
    public List<String> getDate(){
        return Xml.getDate();
    }
    public List<Ticket> getTicketByDate(String date)
    {
        return Xml.getTicketByDate(date);
    }

    //get allentrace info to show for all
    public String getAllEntraceWelcome_info() {
        String title = "Welcome to QMUL car park!\n";
        String time = gettimeanddate() + "\n";
        String publicopenString = "Public use:" + checkis_open() + "\n";
        String space = "Empty Space:" + Xml.getPortCount() + "\n";
        return title + time + publicopenString + space;
    }
    //check is open

    public Boolean checkis_open() {
        return Xml.checkIsOpen();
    }
    //get entershowdialog info for staff

    public String getEnterShowDialogInfo(String staff_number) {
        String title = "Welcome Back !\n";
        String staffnumber = "Staff Number: " + staff_number + "\n";
        String platenumber = "Plate Number: " + Xml.checkStaff(staff_number) + "\n";
        String time = "Time: " + gettimeanddate();
        return title + staffnumber + platenumber + time;
    }
    //get customer entershowdialog info for customer

    public String getCustomerEnterShowDialogInfo(String ticket_number) {
        String title = "Please get your ticket for entering!\n";
        String ticketnumber = "Ticket Number: " + ticket_number + "\n";
        String platenumber = "Plate Number: " + "NULL\n";
        String time = "Time:" + gettimeanddate();
        return title + ticketnumber + platenumber + time;
    }
    //get time and date

    public String gettimeanddate() {
        Date date = new Date();

        SimpleDateFormat df = new SimpleDateFormat("E yyyy-MM-dd HH:mm:ss", Locale.US);
        return df.format(date);
    }
    //enter record

    public void enter_record(String staffnumber) {
        Xml.enter_record(staffnumber);
    }

    public Boolean end_record(String staffnumber)
    {

        return  Xml.end_record(staffnumber);
    }
    //enter ticket

    public void enter_ticket(String ticket_number) {
        Xml.enter_ticket(ticket_number);
    }
    public void end_ticket(Ticket theTicket)
    {
        Xml.end_ticket(theTicket);
    }
    //customer
    public Boolean customerleave(String ticket_number)
    {
       return  Xml.customer_leave(ticket_number);
    }
    //generate ticket

    public static String generateTicket(int length) {
        String base = "0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
    //payBill

    public Boolean checkTicket(String ticket_number){
        //System.out.println("check:"+Xml.checkTicket(ticket_number));
        return Xml.checkTicket(ticket_number);
    }
    public Ticket pay(String ticket_number) {
        return Xml.pay(ticket_number);
    }

    //set open
    public void setopenMonth(List theMonthlist) {
        Xml.setOpenMonth(theMonthlist);
    }
    public void setopenDay(List theOpenDaylist)
    {
        Xml.setOpenDay(theOpenDaylist);
    }

    //now car park cars infomation
    public List<Record> getNow(){
        return Xml.getNow();
    }
}
