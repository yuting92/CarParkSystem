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
public class Administrator extends User implements ChangePasswordInterface {

    private String account_number;

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    private String password;

    public Administrator(JFrame mainFrame) {
        super(mainFrame);
    }

    @Override
    public Boolean login(String user_number, String password) {
        return theCarPark_Control.checkAdmin(user_number, password);

    }

    @Override
    public Boolean exit(String user_number) {
        return true;
    }

    public Boolean changepassword(String number, String new_password) {
        return theCarPark_Control.chanePas(number, new_password);
    }
}
