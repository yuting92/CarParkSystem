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
public class Customer extends User implements PayInterface {

   
    private String ticket_number="";

    public String getPaid_ticket_number() {
        return paid_ticket_number;
    }

    public void setPaid_ticket_number(String paid_ticket_number) {
        this.paid_ticket_number = paid_ticket_number;
    }

    public String getTicket_number() {
        return ticket_number;
    }

    public void setTicket_number(String ticket_number) {
        this.ticket_number = ticket_number;
    }
    private String paid_ticket_number="";

    public Customer(JFrame mainFrame)
    {
         super(mainFrame);
     }
    @Override
    public Boolean login(String user_number, String password) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Boolean exit(String user_number) {
       return  theCarPark_Control.customerleave(user_number);
    }

    public Ticket do_pay(String user_number){
        return  null;
    }
    //check ticket !
    public Boolean payBill(String ticket_number) {
        //System.out.println("payBill:"+theCarPark_Control.checkTicket(ticket_number));
        return theCarPark_Control.checkTicket(ticket_number);
    }
    //enter_ticket
    public void enter_ticket(String ticket_number)
    {
        Xml.enter_ticket(ticket_number);
    }
    
}
