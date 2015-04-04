package carparkaplication.CODE;

import java.io.File;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Xml {

    static String records_path = "src/carparkaplication/CODE/records.txt";
    static String user_path = "src/carparkaplication/CODE/user.txt";
    static String ticket_path = "src/carparkaplication/CODE/ticket.txt";
    public static int portCount = 0;
    public static int num = 0;
    static String config_path = "src/carparkaplication/CODE/config.txt";
    static String dateString = "";

    
    static {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        dateString = df.format(new Date());
        insertDate(records_path);
        insertDate(ticket_path);
        SAXReader reader = new SAXReader();
        Document document = null;
        try {

            document = reader.read(new File(config_path));

            Element staff = (Element) document.selectSingleNode("/root/port[1]");
            portCount = Integer.parseInt(staff.elementText("count"));
            num = portCount;
            System.out.println(portCount);


        } catch (Exception e) {
            // TODO Auto-generated catch block
            portCount = 0;
        }
    }


    public static int getPortCount() {
        return portCount;
    }

    /**
     *
     * get the current numbers of car existing in the car park
     * @return
     */
    public static List<Record> getNow() {

        SAXReader reader = new SAXReader();//creat reader
        Document document = null;//creat files

        List<Record> record_list = new ArrayList<Record>();
        try {
            document = reader.read(new File(records_path));//read file

            List<?> staff = document.selectNodes("/root/date[@value=\"" + dateString.replace("-0", "-") + "\"]/staff_bill[end_time='']");
            System.out.println(staff + "11111111");

            // Element root = document.getRootElement();//get the root of XML
            //Iterator temp=staff.elementIterator();
            for (Object o : staff) {

                Element e = (Element) o;
                Record record = new Record();
                record.setStaff_number(e.attributeValue("staff"));
                record.setBeginTime(e.elementText("begin_time"));
                record.setPlate(e.elementText("plate"));
                record_list.add(record);
            }
            System.out.println(record_list.size());
            document = reader.read(new File(ticket_path));//read file
            staff = document.selectNodes("/root/date[@value=\"" + dateString.replace("-0", "-") + "\"]/ticket[end_time='']");
            for (Object o : staff) {
                Element e = (Element) o;
                Record record = new Record();
                record.setStaff_number(e.attributeValue("id"));
                record.setBeginTime(e.elementText("begin_time"));
                record.setPlate(e.elementText("none"));
                record_list.add(record);
            }
            System.out.println(record_list.size());
        } catch (Exception e) {
            return null;
        }
        return record_list;
    }

    /**
     * Check whether it is the openning for customer
     * @return
     */
    public static boolean checkIsOpen() {

        SAXReader reader = new SAXReader();//create reader ��������
        Document document = null;//create file�
        // boolean flag=false;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        try {

            document = reader.read(new File(config_path));//read files�

            Element isopen = (Element) document.selectSingleNode("/root/port[1]");
            Iterator<?> temp = isopen.element("openMonth").elementIterator();
            while (temp.hasNext()) {
                Element e = (Element) temp.next();
                if (e.getText().equals(String.valueOf(calendar.get(Calendar.MONTH) + 1))) {
                    //flag=true;
                    return true;
                }
            }
            temp = isopen.element("openDay").elementIterator();
            while (temp.hasNext()) {
                Element e = (Element) temp.next();
                //System.out.println(e.getText()+String.valueOf(calendar.get(Calendar.DAY_OF_WEEK)-1));
                int day = calendar.get(Calendar.DAY_OF_WEEK) - 1;
                day = (day - 1) == 0 ? 7 : day - 1;
                if (e.getText().equals(String.valueOf(day))) {
                    //flag=true;
                    return true;
                }
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            return false;
        }//����
        return false;
    }

    /**
     *
     * Check administrator login details
     * @param name
     * @param pass
     * @return
     */
    public static boolean checkAdmin(String name, String pass) {
        SAXReader reader = new SAXReader();//create reader
        Document document = null;//create file
        try {

            document = reader.read(new File(config_path));//read files

            Element admin = (Element) document.selectSingleNode("/root/admin[1]");

            String name1 = admin.elementText("name");
            String pass1 = admin.elementText("pass");
            System.out.println(name1);
            if (pass1.endsWith(pass) && name1.endsWith(name)) {
                System.out.println("ok");
                return true;
            } else {
                System.out.println("wrong ,no admin");


                return false;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            return false;
        }//
    }

    /**
     *Staff can check its registered status after login
     * @param staffnumber
     * @return
     */
    public static String getStaffStatue(String staffnumber) {
        SAXReader reader = new SAXReader();//create reader
        Document document = null;//creat file
        try {

            document = reader.read(new File(user_path));//read file

            Element staff = (Element) document.selectSingleNode("/root/staff[staff_number=\"" + staffnumber + "\"]");

            String statue = staff.element("palte_number").elementText("plate_pass");
            System.out.println(statue);
            return statue;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            return null;
        }//

    }

    /**
     * check staff's password when staff log into the system
     * @param staffnumber
     * @param pass
     * @return
     */
    public static boolean checkPass(String staffnumber, String pass) {
        SAXReader reader = new SAXReader();//create reader
        Document document = null;//create file
        try {

            document = reader.read(new File(user_path));//read file

            Element staff = (Element) document.selectSingleNode("/root/staff[staff_number=\"" + staffnumber + "\"][pass=\"" + pass + "\"]");
            //String temp=staff.element("palte_number").elementText("plate_pass");
            if (staff == null) {
                System.out.println("wrong ,no staff");
                return false;
            } else {
                System.out.println("ok");

                return true;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            return false;
        }//
    }

    /**
     *
     *check the staff's registered status at entrance
     * ���
     * @param staffnumber
     * @return
     */
    public static String checkStaff(String staffnumber) {
        SAXReader reader = new SAXReader();//create reader��������
        Document document = null;//create file�
        try {

            document = reader.read(new File(user_path));//read file�

            Element staff = (Element) document.selectSingleNode("/root/staff[staff_number=\"" + staffnumber + "\"]");
            String temp = staff.element("palte_number").elementText("plate_pass");

            if (temp.equals("2")) {
                System.out.println("ok");

                return staff.element("palte_number").attributeValue("id");
            } else {
                System.out.println("wrong ,no staff");

                return "";
            }
        } catch (Exception e) {
            System.out.println("wrong ,no staff");

            // TODO Auto-generated catch block
            return "";
        }//����
    }

    /**
     *
     * check ticketid
     * @param ticketid
     * @return
     */
    public static boolean checkTicket(String ticketid) {
        SAXReader reader = new SAXReader();//create reader����������
        Document document = null;
        try {

            document = reader.read(new File(ticket_path));//read file�

            Element ticket = (Element) document.selectSingleNode("/root/date/ticket[@id=\"" + ticketid + "\"]");

            if (ticket != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("wrong ,no staff");

            // TODO Auto-generated catch block
            return false;
        }//����

    }

    /**
     *create paid ticket
     * @param ticketid
     * @return
     */
    public static Ticket pay(String ticketid) {// input ticketid��
        SAXReader reader = new SAXReader();//�create reader���������
        Document document = null;//create file
        Ticket ticket = new Ticket();
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// create simple date format
            document = reader.read(new File(ticket_path));//create file

            Element customer = (Element) document.selectSingleNode("/root/date[@value=\"" + dateString.replace("-0", "-") + "\"]/ticket[@id=\"" + ticketid + "\"]");
            System.out.println(customer);


            if (customer != null) {
                ticket.setBeginTime(customer.elementText("begin_time"));
                ticket.setEndTime(df.format(new Date()));
                String price = money(ticket.getBeginTime(), ticket.getEndTime());
                ticket.setPrice(price);
                return ticket;
            } else {
                return null;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }//����
    }

    /**
     * balance this parking for customer
     * @param beginTime
     * @param endTime
     * @return
     */
    private static String money(String beginTime, String endTime) {
        // TODO Auto-generated method stub
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar s = Calendar.getInstance();
        try {
            s.setTime(df.parse(beginTime));
            int hour1 = s.get(Calendar.HOUR_OF_DAY);// get begin  time

            s.setTime(df.parse(endTime));
            int hour2 = s.get(Calendar.HOUR_OF_DAY);//get end time


            int hour = hour2 - hour1;
            if (hour <= 2) {
                return "0.5";
            } else if (hour > 2 && hour <= 4) {
                return "1";
            } else if (hour > 4 && hour <= 8) {
                return "2";
            } else if (hour > 8 && hour <= 12) {
                return "3";
            } else {
                return "5";
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }


    }

    /**
     * record ticket details about entering
     * @param ticketid
     */
    public static void enter_ticket(String ticketid) { 
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            document = reader.read(new File(ticket_path));

            Element customer = (Element) document.selectSingleNode("/root/date[@value=\"" + dateString.replace("-0", "-") + "\"]");
            System.out.println(customer);
            Element ticket = customer.addElement("ticket");
            ticket.addAttribute("id", ticketid);
            ticket.addElement("begin_time").setText(df.format(new Date()));
            ticket.addElement("end_time");
            ticket.addElement("price");
            ticket.addElement("paid");
            XMLWriter writer = new XMLWriter(new FileWriter(ticket_path));
            writer.write(document);
            writer.close();
            portCount--;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }//����
    }

    /**
     * record ticket details about payment ��
     * @param temp
     */
    public static void end_ticket(Ticket temp) { 


        SAXReader reader = new SAXReader();//create reader�������
        Document document = null;//creat file
        try {
            document = reader.read(new File(ticket_path));//read file
            Element ticket = (Element) document.selectSingleNode("/root/date[@value=\"" + dateString.replace("-0", "-") + "\"]/ticket[@id=\"" + temp.getId() + "\"]");

            //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//set date format�������ڸ�ʽ
            ticket.element("end_time").setText(temp.getEndTime());
            ticket.element("price").setText(temp.getPrice());
            ticket.element("paid").setText(temp.getId() + "1");
            XMLWriter writer = new XMLWriter(new FileWriter(ticket_path));
            writer.write(document);
            writer.close();

        } catch (Exception e) {
        }
    }

    /**
     * check whether the customer has paid at exit
     * @param ticketid
     * @return
     */
    public static boolean customer_leave(String ticketid) {
        SAXReader reader = new SAXReader();//create reader���������
        Document document = null;//create file
        try {
            document = reader.read(new File(ticket_path));//read file�

            Element ticket = (Element) document.selectSingleNode("/root/date[@value=\"" + dateString.replace("-0", "-") + "\"]/ticket[@id=\"" + ticketid.substring(0, ticketid.length() - 1) + "\"]");

            if (ticket.elementText("paid").equals(ticketid)) {
                portCount++;
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }


    }

    /**
     * add staff details into registered record �������
     * @param staffnumber
     * @param pass
     */
    public static boolean addStaff(String staffnumber, String pass) {
        SAXReader reader = new SAXReader();//create reader
        Document document = null;//create file
        try {
            document = reader.read(new File(user_path));//read file�
            Element root = document.getRootElement();//get root of Element
            Element staff = DocumentHelper.createElement("staff");
            staff.addElement("staff_number").setText(staffnumber);//display staff numberԱ����
            staff.addElement("pass").setText(pass);//display staff password
            Element plate = staff.addElement("palte_number");//set plate number
            plate.addAttribute("id", "");// set id root to XML root
            plate.addElement("plate_pass").setText("1");//add XML root called plate_pass and set 1
            //staff.addElement("staff_pass").setText("1");//
            staff.addElement("department");//set department

            root.add(staff);
            XMLWriter writer = new XMLWriter(new FileWriter(user_path));
            writer.write(document);
            writer.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * set staff plate number
     *
     */
    public static boolean setPlate(String staffnumber, String dep, String plate) {

        SAXReader reader = new SAXReader();//create reader�������
        Document document = null;//create file
        try {
            document = reader.read(new File(user_path));//read file
            Element staff = (Element) document.selectSingleNode("/root/staff[staff_number=\"" + staffnumber + "\"]");
            staff.element("department").setText(dep);
            staff.element("palte_number").attribute("id").setText(plate);
            XMLWriter writer = new XMLWriter(new FileWriter(user_path));
            writer.write(document);
            writer.close();
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    /**
     * remove registered staff
     *
     */
    public static void delStaff(String staffnumber) {
        SAXReader reader = new SAXReader();//create reader���������
        Document document = null;//create file
        try {
            document = reader.read(new File(user_path));//read file
            Element staff = (Element) document.selectSingleNode("/root/staff[staff_number=\"" + staffnumber + "\"]");
            staff.getParent().remove(staff);
            XMLWriter writer = new XMLWriter(new FileWriter(user_path));
            writer.write(document);
            writer.close();
        } catch (Exception e) {
        }
    }
    /**
     * delete relative registered staff record
     *
     */
    public static void delRecord(String staffnumber) {
        SAXReader reader = new SAXReader();//create reader����������
        Document document = null;//create file
        try {
            document = reader.read(new File(records_path));//read file�
            List<?> record = document.selectNodes("//staff_bill[@staff=\"" + staffnumber + "\"]");
            // Element root = document.getRootElement();//
            //Iterator temp=staff.elementIterator();
            for (Object o : record) {
                Element e = (Element) o;


                // System.out.println(e.getParent());
                e.getParent().remove(e);

            }
            XMLWriter writer = new XMLWriter(new FileWriter(records_path));
            writer.write(document);
            writer.close();
        } catch (Exception e) {
        }
    }

    public static List<String> getAllStuff() {//get all registered staff
        SAXReader reader = new SAXReader();//create reader
        Document document = null;//create file
        List<String> temp = new ArrayList<String>();
        try {
            document = reader.read(new File(user_path));//read file
            List staff = document.selectNodes("/root/staff/palte_number[plate_pass='2']");
            for (Object o : staff) {
                Element e = (Element) o;

                temp.add(e.getParent().elementText("staff_number"));

            }
            System.out.println(temp.size());
            return temp;

        } catch (Exception e) {
            return null;

        }
    }

    public static boolean makePlate(String staffnumber, String plate, boolean tag) {
        SAXReader reader = new SAXReader();//create reader
        Document document = null;//create file
        try {
            document = reader.read(new File(user_path));//read file�
            Element staff = (Element) document.selectSingleNode("/root/staff[staff_number=\"" + staffnumber + "\"]/palte_number[@id=\"" + plate + "\"]");
            if (tag) {
                staff.element("plate_pass").setText("2");//add plate_pass note and set 2�
            } else {
                staff.element("plate_pass").setText("0");// add plate_pass note and set 0
            }
            XMLWriter writer = new XMLWriter(new FileWriter(user_path));
            writer.write(document);
            writer.close();

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void enter_record(String staffnumber) {
        SAXReader reader = new SAXReader();//create reader
        Document document = null;//create file
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            document = reader.read(new File(records_path));//read file

            Element staff = (Element) document.selectSingleNode("/root/date[@value=\"" + dateString.replace("-0", "-") + "\"]");
            System.out.println(staff);
            Element staffbill = staff.addElement("staff_bill");
            staffbill.addAttribute("staff", staffnumber);
            staffbill.addElement("begin_time").setText(df.format(new Date()));
            staffbill.addElement("end_time");
            staffbill.addElement("month").setText(dateString.substring(5, 7).replace("0", ""));
            staffbill.addElement("plate");
            XMLWriter writer = new XMLWriter(new FileWriter(records_path));
            writer.write(document);
            writer.close();
            portCount--;
        } catch (Exception e) {
        }

    }
    /**
     * insert date into file
     *
     */
    public static void insertDate(String filename) {
        SAXReader reader = new SAXReader();//create reader���������
        Document document = null;//create file
        try {
            document = reader.read(new File(filename));//read file
            Element test = (Element) document.selectSingleNode("/root/date[@value=\"" + dateString.replace("-0", "-") + "\"]");//����Ƿ��Ѿ����ڽ���ļ�¼��date

            //System.out.println();
            if (test == null) {
                Element root = document.getRootElement();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                dateString = df.format(new Date());
                Element date = DocumentHelper.createElement("date");
                date.addAttribute("value", dateString.replace("-0", "-"));
                root.add(date);
                XMLWriter writer = new XMLWriter(new FileWriter(filename));
                writer.write(document);
                writer.close();
            } else {
                System.out.println("fdsfdsfdsfdsfds");
            }

        } catch (Exception e) {
        }
    }
    /**
     * edit staff exit time and check whether staff number is correct
     *
     */
    public static boolean end_record(String staffnumber) {
        SAXReader reader = new SAXReader();//create reader
        Document document = null;//create file
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//set date format
        try {
            document = reader.read(new File(records_path));//read file
            Element staff = (Element) document.selectSingleNode("/root/date[@value=\"" + dateString.replace("-0", "-") + "\"]/staff_bill[@staff=\"" + staffnumber + "\"][last()]");

            if (staff != null) {
                staff.element("end_time").setText(df.format(new Date()));
                XMLWriter writer = new XMLWriter(new FileWriter(records_path));
                writer.write(document);
                writer.close();
                portCount++;
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * get record according to staff number and month
     *
     */
    public static List<Record> getRecordByStaff(String staffnumber, String month) {
        SAXReader reader = new SAXReader();//create reader
        Document document = null;//create file
        List<Record> record_list = new ArrayList<Record>();
        try {
            document = reader.read(new File(records_path));//read file
            List<?> staff = document.selectNodes("//staff_bill[@staff=\"" + staffnumber + "\"][month=\"" + month + "\"]");
            // Element root = document.getRootElement();//get root of XML
            //Iterator temp=staff.elementIterator();
            for (Object o : staff) {

                Element e = (Element) o;
                Record record = new Record();
                record.setStaff_number(staffnumber);
                record.setBeginTime(e.elementText("begin_time"));
                record.setEndTime(e.elementText("end_time"));
                record.setPlate(e.elementText("plate"));
                record_list.add(record);
            }
            System.out.println(record_list.size());

        } catch (Exception e) {
        }
        return record_list;
    }

    public static List<Record> getRecordByStaff(String staffnumber) {//get record according to staff number
        SAXReader reader = new SAXReader();//create reader
        Document document = null;//create file
        List<Record> record_list = new ArrayList<Record>();
        try {
            document = reader.read(new File(records_path));//read file
            List<?> staff = document.selectNodes("//staff_bill[@staff=\"" + staffnumber + "\"]");
            // Element root = document.getRootElement();//create root of XML
            //Iterator temp=staff.elementIterator();
            for (Object o : staff) {

                Element e = (Element) o;
                Record record = new Record();
                record.setStaff_number(staffnumber);
                record.setBeginTime(e.elementText("begin_time"));
                record.setEndTime(e.elementText("end_time"));
                record.setPlate(e.elementText("plate"));
                record_list.add(record);
            }
            System.out.println(record_list.size());

        } catch (Exception e) {
        }
        return record_list;
    }

    public static List<Record> getRecordByDate(String date) {//get record according to date
        SAXReader reader = new SAXReader();//create reader������
        Document document = null;//create file
        List<Record> record_list = new ArrayList<Record>();
        try {
            document = reader.read(new File(records_path));//read file
            List<?> staff = document.selectNodes("/root/date[@value=\"" + date + "\"]/staff_bill");
            // Element root = document.getRootElement();//get root of XML
            //Iterator temp=staff.elementIterator();
            for (Object o : staff) {

                Element e = (Element) o;
                Record record = new Record();
                record.setStaff_number(e.attributeValue("staff"));
                record.setBeginTime(e.elementText("begin_time"));
                record.setEndTime(e.elementText("end_time"));
                record.setPlate(e.elementText("plate"));
                record_list.add(record);
            }
            System.out.println(record_list.size());

        } catch (Exception e) {
        }
        return record_list;
    }

    ;/**
	 * get unregistetred staff
	 * @return
	 */
	public static List<StaffObj> getUnStaff(){
		SAXReader reader = new SAXReader();//create reader
        Document document = null;//create file
        List<StaffObj> temp=new ArrayList<StaffObj>();
		try {
			document = reader.read(new File(user_path));//read file
			List staff=document.selectNodes("/root/staff/palte_number[plate_pass!='2']");

			for(Object o:staff){
			      Element e = ((Element) o).getParent();
			      StaffObj sta=new StaffObj();
			      sta.setDepartment(e.elementText("department"));
			      sta.setPassword(e.elementText("pass"));

			      sta.setPlate(e.element("palte_number").attributeValue("id"));
			      sta.setStaff_number(e.elementText("staff_number"));


			      temp.add(sta);

	        }
			System.out.println(temp.size());
			return temp;

		}catch(Exception e){
			return null;

		}
	}

    public static List<Ticket> getTicketByDate(String date) {//get ticket according to date
        SAXReader reader = new SAXReader();//create reader��������
        Document document = null;//create file
        List<Ticket> ticket_list = new ArrayList<Ticket>();
        try {
            document = reader.read(new File(ticket_path));//read file
            List<?> staff = document.selectNodes("/root/date[@value=\"" + date + "\"]/ticket");
            // Element root = document.getRootElement();//get root of XML
            //Iterator temp=staff.elementIterator();
            for (Object o : staff) {

                Element e = (Element) o;
                Ticket ticket = new Ticket();
                ticket.setId(e.attributeValue("id"));
                ticket.setBeginTime(e.elementText("begin_time"));
                ticket.setEndTime(e.elementText("end_time"));
                ticket.setPrice(e.elementText("price"));
                ticket_list.add(ticket);
            }
            System.out.println(ticket_list.size());

        } catch (Exception e) {
        }
        return ticket_list;
    }

    ;

    public static boolean setLeft() {//set
        SAXReader reader = new SAXReader();//create reader�������
        Document document = null;//create file
        try {
            document = reader.read(new File(config_path));//read file

            Element port = (Element) document.selectSingleNode("/root/port[1]");
            port.element("count").setText(String.valueOf(portCount));
            XMLWriter writer = new XMLWriter(new FileWriter(config_path));
            writer.write(document);
            writer.close();
        } catch (Exception e) {
        }

        return true;
    }

    /**

     * change staff password
     */
    public static boolean changeStaff(String staffnumber, String newpass) {
        SAXReader reader = new SAXReader();//create reader����������
        Document document = null;//create file
        try {
            document = reader.read(new File(user_path));//read file �

            Element staff = (Element) document.selectSingleNode("/root/staff[staff_number=\"" + staffnumber + "\"]");
            staff.element("pass").setText(newpass);
            XMLWriter writer = new XMLWriter(new FileWriter(user_path));
            writer.write(document);
            writer.close();
        } catch (Exception e) {
        }

        return true;

    }

    public static boolean changeAdmin(String staffnumber, String newpass) {//change administrator password
        SAXReader reader = new SAXReader();//create reader
        Document document = null;//create file
        try {
            document = reader.read(new File(config_path));//read file

            Element admin = (Element) document.selectSingleNode("/root/admin[1]");
            admin.element("pass").setText(newpass);
            XMLWriter writer = new XMLWriter(new FileWriter(config_path));
            writer.write(document);
            writer.close();
        } catch (Exception e) {
        }

        return true;

    }

    /**
     *
     * set opening months for customer
     * @param arg
     */
    public static boolean setOpenMonth(List temp) {
        SAXReader reader = new SAXReader();//create reader���������
        Document document = null;//create file
        try {
            document = reader.read(new File(config_path));

//			List<?> month=document.selectNodes("/root/port[1]/openMonth/month");
//			for(Object o:month){     
//                
//                Element e = (Element) o;
//                e.getParent().remove(e);
//            } 
            Element openMonth = (Element) document.selectSingleNode("/root/port[1]/openMonth");
            openMonth.clearContent();
            for (Object o : temp) {
                String e = (String) o;
                openMonth.addElement("month").setText(e);
            }
            XMLWriter writer = new XMLWriter(new FileWriter(config_path));
            writer.write(document);
            writer.close();
        } catch (Exception e) {
        }

        return true;
    }

    /**
     *get opening months for customer
     *��ȡ�����·�
     */
    public static List<String> getOpenMonth() {
        SAXReader reader = new SAXReader();//create reader���������
        Document document = null;//create file
        List<String> monthopen = new ArrayList<String>();
        try {
            document = reader.read(new File(config_path));//read file

            List<?> month = document.selectNodes("/root/port[1]/openMonth/month");
            for (Object o : month) {

                Element e = (Element) o;
                monthopen.add(e.getText());
            }
            System.out.println(monthopen.size());
//			Element openMonth=(Element)document.selectSingleNode("/root/port[1]/openMonth");
//			openMonth.clearContent();
//			for(Object o:temp){
//				String e=(String)o;
//				openMonth.addElement("month").setText(e);
//			}
//			XMLWriter writer = new XMLWriter(new FileWriter(config_path));//���µ�������  
//	        writer.write( document );  
//	        writer.close();  
        } catch (Exception e) {
            return null;
        }

        return monthopen;
    }

    /**
     * set opening days for customer�����
     * @param temp
     * @return
     */
    public static boolean setOpenDay(List temp) {
        SAXReader reader = new SAXReader();//create reader���������
        Document document = null;//create file
        try {
            document = reader.read(new File(config_path));//read file

//			List<?> month=document.selectNodes("/root/port[1]/openDay/day");
//			for(Object o:month){     
//                
//                Element e = (Element) o;
//                e.getParent().c.remove(e);
//            } 
            Element openDay = (Element) document.selectSingleNode("/root/port[1]/openDay");
            openDay.clearContent();
            for (Object o : temp) {
                String e = (String) o;
                openDay.addElement("day").setText(e);
            }
            XMLWriter writer = new XMLWriter(new FileWriter(config_path));
            writer.write(document);
            writer.close();
        } catch (Exception e) {
        }

        return true;
    }
/**
     * get opening days for customer
     *
     */
    public static List<String> getOpenDay() {
        SAXReader reader = new SAXReader();//create reader��������
        Document document = null;//create file
        List<String> dayopen = new ArrayList<String>();
        try {
            document = reader.read(new File(config_path));

            List<?> day = document.selectNodes("/root/port[1]/openDay/day");
            for (Object o : day) {

                Element e = (Element) o;
                dayopen.add(e.getText());
            }
            System.out.println(dayopen.size());
//			Element openMonth=(Element)document.selectSingleNode("/root/port[1]/openMonth");
//			openMonth.clearContent();
//			for(Object o:temp){
//				String e=(String)o;
//				openMonth.addElement("month").setText(e);
//			}
//			XMLWriter writer = new XMLWriter(new FileWriter(config_path));//���µ�������  
//	        writer.write( document );  
//	        writer.close();  
        } catch (Exception e) {
            return null;
        }

        return dayopen;
    }
    /**
	 *get all tickets which have been issued in the past dates
	 *
	 */
	public static List<String> getDate(){
		SAXReader reader = new SAXReader();//create reader
        Document document = null;//create file
        List<String> temp=new ArrayList<String>();
		try {
			document = reader.read(new File(ticket_path));//read file
			List staff=document.selectNodes("/root/date");
			for(Object o:staff){
			      Element e = (Element) o;

			      temp.add(e.attributeValue("value"));

	        }
			System.out.println(temp.size());
			return temp;

		}catch(Exception e){
			return null;

		}
	}

//public static void main(String[] arg){
//	try {
////		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
////		System.out.println(portCount);
////		Calendar temp=Calendar.getInstance();
////		temp.setTime(df.parse("2012-4-22"));
////	
////		System.out.println(temp.get(Calendar.DAY_OF_WEEK));
//		Xml.changeAdmin("admin", "456");
//		//String s="fdsfds";
//		//s=s.substring(0, s.length()-1);
//		//System.out.println(s);
//		//List temp=new ArrayList();
//		//temp.add("11");
//		//temp.add("12");
//		//SimpleDateFormat df = new SimpleDateFormat("E yyyy-MM-dd HH:mm:ss",Locale.US);//�������ڸ�ʽ
//		//dateString=df.format(new Date());
//		 
//		//System.out.println(Xml.checkIsOpen());	
//		//System.out.println(df.format(date));
////   str_date1=str_date1.replace('-0','-');
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//}
}
