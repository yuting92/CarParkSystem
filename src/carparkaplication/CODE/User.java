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
public abstract class User {
    public abstract Boolean login(String user_number,String password);
    public abstract Boolean exit(String user_number);
    public CarPark_Control theCarPark_Control;
    public JFrame theMainFrame;
    
    public User(JFrame mainFrame){
        theCarPark_Control=new CarPark_Control(mainFrame);
        theMainFrame=mainFrame;
    }
}
