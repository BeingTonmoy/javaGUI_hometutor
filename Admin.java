//******************American International University-Bangladesh (AIUB) */
//******************Object Oriented Programming 1 (JAVA) GUI Project - Group 5 | Date: 09/05/2024 */
//******************** Developed by Arfan Rahman Tonmoy (23-51598-2) (arfanrahman12@gmail.com) */
//*********************Group Members :Arfan Rahman (23-51598-2), TANMAY ROY RONY (23-51745-2), Swarna sikder (23-51779-2), Sanjida Affrin Bristi (23-51788-2) */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Admin extends JFrame {

    private Container c;
    private ImageIcon icon, logo;
    private JLabel label1, imgLabel;
    private Font f1, f2;
    private JButton btn1, btn2, btn3, btn4, nBtn, btnt, btnti, btntq;
    private Cursor cursor;

    Admin() {
       // Frame Layout
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setTitle("HomeTutor Admin Panel");
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
        f1 = new Font("Tahoma", Font.BOLD, 60);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);

        // Title
        label1 = new JLabel();
        label1.setText("Admin Panel");
        label1.setBounds(250, 20, 433, 50);
        label1.setFont(f1);
        c.add(label1);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // JButtons
        btn1 = new JButton("Student Info");
        btn1.setBounds(620, 150, 207, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#2E75B6"));
        c.add(btn1);

        btnt = new JButton("Teachers Add");
        btnt.setBounds(620, 210, 207, 50);
        btnt.setFont(f2);
        btnt.setCursor(cursor);
        btnt.setForeground(Color.WHITE);
        btnt.setBackground(Color.decode("#2E75B6"));
        c.add(btnt);

        btnti = new JButton("Teacher Info");
        btnti.setBounds(620, 270, 207, 50);
        btnti.setFont(f2);
        btnti.setCursor(cursor);
        btnti.setForeground(Color.WHITE);
        btnti.setBackground(Color.decode("#2E75B6"));
        c.add(btnti);


        btn2 = new JButton("Back");
        btn2.setBounds(20, 440, 207, 50);
        btn2.setFont(f2);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#2E75B6"));
        c.add(btn2);

        btn3 = new JButton("Log out");
        btn3.setBounds(20, 500, 207, 50);
        btn3.setFont(f2);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#C00000"));
        c.add(btn3);

        btn4 = new JButton("Change Pass");
        btn4.setBounds(620, 330, 207, 50);
        btn4.setFont(f2);
        btn4.setCursor(cursor);
        btn4.setForeground(Color.WHITE);
        btn4.setBackground(Color.decode("#2E75B6"));
        c.add(btn4);

        btntq = new JButton("Requests");
        btntq.setBounds(620, 390, 207, 50);
        btntq.setFont(f2);
        btntq.setCursor(cursor);
        btntq.setForeground(Color.WHITE);
        btntq.setBackground(Color.decode("#2E75B6"));
        c.add(btntq);
        
        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        // Student Data
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                StudentInfo frame = new StudentInfo();
                frame.setVisible(true);
            }
        });

        // Exit Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Back
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                
                setVisible(false);
                Home frame = new Home();
                frame.setVisible(true);
            }
        });

         // Teacher Add
         btnt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                
                setVisible(true);
                TeacherAdd frame = new TeacherAdd();
                frame.setVisible(true);
            }
        });

        // Teacher Info
        btnti.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                
                setVisible(false);
                TeacherInfo frame = new TeacherInfo();
                frame.setVisible(true);
            }
        });

        // Admin Password
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                AdminPassword frame = new AdminPassword();
                frame.setVisible(true);
            }
        });

        //Student Req Response
        btntq.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                AdminReq frame = new AdminReq();
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {

        Admin frame = new Admin();
        frame.setVisible(true);
    }
}
