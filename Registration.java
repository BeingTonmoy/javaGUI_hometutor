//******************American International University-Bangladesh (AIUB) */
//******************Object Oriented Programming 1 (JAVA) GUI Project - Group 5 | Date: 09/05/2024 */
//******************** Developed by Arfan Rahman Tonmoy (23-51598-2) (arfanrahman12@gmail.com) */
//*********************Group Members :Arfan Rahman (23-51598-2), TANMAY ROY RONY (23-51745-2), Swarna sikder (23-51779-2), Sanjida Affrin Bristi (23-51788-2) */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.*;

public class Registration extends JFrame {

    private Container c;
    private ImageIcon icon, logo;
    private JLabel label1, imgLabel;
    private Font f1, f2, f3, f4, f5, f6; // font
    private JTextField tf1, tf2, tf4, tf5; // textfield
    private JComboBox securityQsn; //City
    private JButton btn1, btn2, btn3, btn4, nBtn; //button
    private JPasswordField tf3; //password field
    private Cursor cursor;
    private int a, b; //captcha int

    Registration() {
         // Frame Layout
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setTitle("HomeTutor - Registration");
         this.setSize(900, 660);
         this.setLocationRelativeTo(null);
         this.setResizable(false);
 
         c = this.getContentPane();
         c.setLayout(null);
         c.setBackground(Color.decode("#F2F2F2"));
 
          // Icon
        icon = new ImageIcon(getClass().getResource("/images/Icon.png"));
        this.setIconImage(icon.getImage());

        
         // Fonts
         f1 = new Font("Segoe UI Black", Font.PLAIN, 35);
         f2 = new Font("Segoe UI Black", Font.PLAIN, 25);
         f3 = new Font("Segoe UI Semibold", Font.PLAIN, 35);
         f4 = new Font("Segoe UI", Font.PLAIN, 25);
         f5 = new Font("Segoe UI", Font.PLAIN, 19);
         f6 = new Font("Segoe UI", Font.PLAIN, 25);
 
         // Title
         label1 = new JLabel();
         label1.setText("Register your student account now!");
         label1.setBounds(30, 25, 680, 50);
         label1.setFont(f1);
         c.add(label1);
 
         // User Name
         label1 = new JLabel();
         label1.setText("Student ID");
         label1.setBounds(248, 75, 500, 50); 
         label1.setFont(f4);
         c.add(label1);
 
         tf1 = new JTextField();
         tf1.setBounds(260, 120, 260, 30);
         tf1.setFont(f5);
         c.add(tf1);
 
         //hint1
         label1 = new JLabel();
         label1.setText("Enter unique ID (eg. Arfan02)");
         label1.setBounds(550, 110, 500, 50);
         label1.setFont(f5);
         c.add(label1);
 
         // Email
         label1 = new JLabel();
         label1.setText("Email");
         label1.setBounds(248, 145, 500, 50);
         label1.setFont(f4);
         c.add(label1);
 
         tf2 = new JTextField();
         tf2.setBounds(260, 187, 260, 30);
         tf2.setFont(f5);
         c.add(tf2);
 
         // Password
         label1 = new JLabel();
         label1.setText("Password");
         label1.setBounds(248, 210, 500, 50); 
         label1.setFont(f4);
         c.add(label1);
 
         tf3 = new JPasswordField();
         tf3.setBounds(260, 257, 260, 30);
         tf3.setFont(f2);
         tf3.setEchoChar('*');
         c.add(tf3);
 
         // Question
         label1 = new JLabel();
         label1.setText("Enter your city");
         label1.setBounds(248, 280, 500, 50);
         label1.setFont(f4);
         c.add(label1);
 
         String[] secQsn = { "Which city do you live?", "Dhaka", "Sylhet",
                 "Barisal", "Rajshahi" };
         securityQsn = new JComboBox(secQsn);
         securityQsn.setBounds(260, 325, 259, 30);
         securityQsn.setSelectedIndex(0);
         securityQsn.setFont(f5);
         securityQsn.setBackground(Color.white);
         c.add(securityQsn);
 
         // Answer
         label1 = new JLabel();
         label1.setText("Phone Number");
         label1.setBounds(248, 350, 500, 50);
         label1.setFont(f4);
         c.add(label1);
 
         tf4 = new JTextField();
         tf4.setBounds(260, 395, 260, 30);
         tf4.setFont(f5);
         c.add(tf4);
 
         label1 = new JLabel();
         label1.setText("Security Captcha");
         label1.setBounds(248, 423, 500, 50);
         label1.setFont(f4);
         c.add(label1);

         tf5 = new JTextField();
         tf5.setBounds(350, 468, 115, 30);
         tf5.setFont(f5);
         c.add(tf5);
 
         // To get a random number for captcha, takes random num for int a and b less than 10
         Random rand = new Random();
         int a = rand.nextInt(10);
         int b = rand.nextInt(10);
 
         // Captcha
         label1 = new JLabel();
         label1.setText(" " + a + " + " + b + " ");
         label1.setBounds(260, 468, 85, 30);
         label1.setFont(f4);
         label1.setForeground(Color.black);
         label1.setBackground(Color.decode("#FFFFFF"));
         label1.setOpaque(true);
         c.add(label1);
 
         // Cursor for JButtons
         cursor = new Cursor(Cursor.HAND_CURSOR);
 
         // JButtons
         btn1 = new JButton("Exit");
         btn1.setBounds(53, 540, 183, 50);
         btn1.setFont(f2);
         btn1.setCursor(cursor);
         btn1.setForeground(Color.WHITE);
         btn1.setBackground(Color.decode("#C00000"));
         c.add(btn1);
 
         btn2 = new JButton("Back");
         btn2.setBounds(251, 540, 183, 50);
         btn2.setFont(f2);
         btn2.setCursor(cursor);
         btn2.setForeground(Color.WHITE);
         btn2.setBackground(Color.decode("#2E75B6"));
         c.add(btn2);
 
         btn3 = new JButton("Reset");
         btn3.setBounds(450, 540, 183, 50);
         btn3.setFont(f2);
         btn3.setCursor(cursor);
         btn3.setForeground(Color.WHITE);
         btn3.setBackground(Color.decode("#2E75B6"));
         c.add(btn3);
 
         btn4 = new JButton("Register");
         btn4.setBounds(649, 540, 183, 50);
         btn4.setFont(f2);
         btn4.setCursor(cursor);
         btn4.setForeground(Color.WHITE);
         btn4.setBackground(Color.decode("#2E75B6"));
         c.add(btn4);
 
         nBtn = new JButton("");
         nBtn.setBounds(0, 0, 0, 0);
         c.add(nBtn);
 
         // Exit Button
         btn1.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent ae) {
                 System.exit(0);
             }
         });
 
         // Back Button
         btn2.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent ae) {
 
                 setVisible(false);
                 Home frame = new Home();
                 frame.setVisible(true);
             }
         });

        // Reset Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                Registration frame = new Registration();
                frame.setVisible(true);
            }
        });

        // Register Button
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String textField1 = tf1.getText().toLowerCase(); // User Name
                String textField2 = tf2.getText(); // Email
                String textField3 = tf3.getText(); // Password
                String textField4 = tf4.getText(); // Security Question Answer
                String textField5 = tf5.getText(); // Captcha
                String secQsn = String.valueOf(securityQsn.getSelectedItem()); // Security Question
                int result = 0;
                  
                //if user leave a field blank it will print this msg
                if (textField5.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    result = Integer.parseInt(tf5.getText());
                    if (textField1.isEmpty() || textField2.isEmpty() || textField3.isEmpty() || textField4.isEmpty()
                            || textField5.isEmpty() || ((securityQsn.getSelectedIndex()) == 0)) {
                        JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (result != (a + b)) {  //checks if user answered correct capcha.
                        JOptionPane.showMessageDialog(null, "Wrong Captcha.", "Warning!", JOptionPane.WARNING_MESSAGE); // if answer is wrong
                    } else { //it will follow registratio steps

                        try {
                            File file = new File(".\\Data\\user_data.txt"); //creates user_data.txt file if does not exist owtherwise it will print on txt.
                            if (!file.exists()) {
                                file.createNewFile();
                            }
                            FileWriter fw = new FileWriter(file, true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            PrintWriter pw = new PrintWriter(bw);

                            LocalDateTime myDateObj = LocalDateTime.now();
                            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy"); //Date and Time capture.

                            String timeAndDate = myDateObj.format(myFormatObj);
                            
                            //Prints this user data into txt file
                            pw.println("User Name : " + textField1);
                            pw.println("Password : " + textField3);
                            pw.println("Email : " + textField2);
                            pw.println("Security Question : " + secQsn);
                            pw.println("Answer : " + textField4);
                            pw.println("Time & Date : " + timeAndDate);
                            pw.println("===============================================");
                            pw.close();

                        } catch (Exception ex) {
                            System.out.print(ex);
                        }

                        JOptionPane.showMessageDialog(null, "Registration Successfully Completed.",
                                "Registration Complete", JOptionPane.WARNING_MESSAGE);
                        setVisible(false);
                        Home frame = new Home();
                        frame.setVisible(true);
                    }
                }
            }
        });
    }

    public static void main(String[] args) {

        Registration frame = new Registration();
        frame.setVisible(true);
    }
}