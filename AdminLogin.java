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

public class AdminLogin extends JFrame {

    private Container c;
    private ImageIcon icon;
    private JLabel label1, imgLabel;
    private Font f1, f2, f3, f4, f5, f6;
    private JTextField tf1;
    private JButton btn1, btn2, btn3, nBtn;
    private JPasswordField tf2;
    private Cursor cursor;

    AdminLogin() {
         // Frame Layout
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setTitle("HomeTutor Admin Login");
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
        f1 = new Font("Segoe UI Black", Font.BOLD, 60);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);
        f3 = new Font("Segoe UI Semibold", Font.PLAIN, 35);
        f4 = new Font("Segoe UI", Font.PLAIN, 30);
        f5 = new Font("Segoe UI", Font.PLAIN, 22);
        f6 = new Font("Segoe UI", Font.PLAIN, 25);

         // Title
         label1 = new JLabel();
         label1.setText("Admin Login");
         label1.setBounds(210, 50, 500, 90);
         label1.setFont(f1);
         c.add(label1);
 
         // User ID
         label1 = new JLabel();
         label1.setText("Admin ID");
         label1.setBounds(248, 145, 500, 50);
         label1.setFont(f4);
         c.add(label1);
 
         tf1 = new JTextField();
         tf1.setBounds(255, 200, 340, 35);
         tf1.setFont(f5);
         c.add(tf1);
 
         // Password
         label1 = new JLabel();
         label1.setText("Password");
         label1.setBounds(248, 240, 500, 50);
         label1.setFont(f4);
         c.add(label1);
 
         tf2 = new JPasswordField();
         tf2.setBounds(255, 290, 340, 35);
         tf2.setFont(f2);
         tf2.setEchoChar('*');
         c.add(tf2);
 
        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // JButtons
        btn1 = new JButton("Exit");
        btn1.setBounds(90, 425, 215, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#C00000"));
        c.add(btn1);

        btn2 = new JButton("Back");
        btn2.setBounds(340, 425, 215, 50);
        btn2.setFont(f2);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#2E75B6"));
        c.add(btn2);

        btn3 = new JButton("Login");
        btn3.setBounds(590, 425, 215, 50);
        btn3.setFont(f2);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#2E75B6"));
        c.add(btn3);

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

        // Login Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String textField1 = tf1.getText().toLowerCase(); // Admin Name
                String textField2 = tf2.getText(); // Password

                if (textField1.isEmpty() || textField2.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {

                    try {

                        String userNameS = "Name : " + textField1;
                        String passwordS = "Password : " + textField2;
                        BufferedReader reader = new BufferedReader(new FileReader(".\\Data\\admin_data.txt"));

                        int totalLines = 0;
                        while (reader.readLine() != null)
                            totalLines++;
                        reader.close();

                        for (int i = 0; i <= totalLines; i++) {
                            String line = Files.readAllLines(Paths.get(".\\Data\\admin_data.txt")).get(i);
                            if (line.equals(userNameS)) {
                                String line2 = Files.readAllLines(Paths.get(".\\Data\\admin_data.txt")).get((i + 1));
                                if (line2.equals(passwordS)) {
                                    JOptionPane.showMessageDialog(null, "Admin Login Successful.", "HomeTutor Admin Panel",
                                            JOptionPane.WARNING_MESSAGE);

                                    setVisible(false);
                                    Admin frame = new Admin();
                                    frame.setVisible(true);
                                    break;
                                }
                            }
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Invalid Name or Password!", "Cannot log you in!",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
    }

    public static void main(String[] args) {

        AdminLogin frame = new AdminLogin();
        frame.setVisible(true);
    }
}