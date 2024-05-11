//******************American International University-Bangladesh (AIUB) */
//******************Object Oriented Programming 1 (JAVA) GUI Project - Group 5 | Date: 09/05/2024 */
//******************** Developed by Arfan Rahman Tonmoy (23-51598-2) (arfanrahman12@gmail.com) */
//*********************Group Members :Arfan Rahman (23-51598-2), TANMAY ROY RONY (23-51745-2), Swarna sikder (23-51779-2), Sanjida Affrin Bristi (23-51788-2) */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.*;

public class TeacherbyHomeTutor extends JFrame {

    private Container c;
    private ImageIcon icon;
    private JLabel label1, label2, label3, imgLabel;
    private Font f1, f2, f3, f4, f5, f6;
    private ImageIcon logo, img1, img2;
    private JTextField tf1, tf2, tf3, tf4, tf5;
    private JButton btn1, btn2, btn3, nBtn;
    private Cursor cursor;

    TeacherbyHomeTutor() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("HomeTutor - Give your needs.");
        this.setSize(900, 600);
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
        f2 = new Font("Segoe UI Semibold", Font.PLAIN, 25);
        f3 = new Font("Segoe UI", Font.PLAIN, 20);
        f4 = new Font("Segoe UI", Font.PLAIN, 15);
        f5 = new Font("Segoe UI Black", Font.PLAIN, 15);
        f6 = new Font("Segoe UI Black", Font.PLAIN, 25);

        // Title
        label1 = new JLabel();
        label1.setText("Tell us your need");
        label1.setBounds(40, 20, 500, 50);
        label1.setFont(f1);
        c.add(label1);

        label2 = new JLabel("We will try to provide best home tutor.");
        label2.setBounds(140, 65, 500, 50);
        label2.setFont(f2);
        c.add(label2);

        label2 = new JLabel("Teacher Qualification");
        label2.setBounds(130, 120, 500, 50);
        label2.setFont(f2);
        c.add(label2);

        // Degree / University
        label3 = new JLabel("Degree/ University");
        label3.setBounds(130, 155, 500, 50);
        label3.setFont(f3);
        c.add(label3);

        tf1 = new JTextField();
        tf1.setBounds(315, 170, 335, 30);
        tf1.setFont(f4);
        c.add(tf1);

        // Student Class
        label3 = new JLabel("Teacher Experience");
        label3.setBounds(130, 200, 500, 50);
        label3.setFont(f3);
        c.add(label3);

        tf2 = new JTextField();
        tf2.setBounds(315, 210, 335, 30);
        tf2.setFont(f4);
        c.add(tf2);

        label2 = new JLabel("Your Information");
        label2.setBounds(130, 240, 500, 50);
        label2.setFont(f2);
        c.add(label2);

        // Student Class
        label3 = new JLabel("Your Class");
        label3.setBounds(130, 280, 500, 50);
        label3.setFont(f3);
        c.add(label3);

        tf3 = new JTextField();
        tf3.setBounds(315, 290, 335, 30);
        tf3.setFont(f4);
        c.add(tf3);

        // Student Medium
        label3 = new JLabel("Your Phone");
        label3.setBounds(130, 320, 500, 50);
        label3.setFont(f3);
        c.add(label3);

        tf4 = new JTextField();
        tf4.setBounds(315, 330, 335, 30);
        tf4.setFont(f4);
        c.add(tf4);

        //Student Loc
        label3 = new JLabel("Your Address");
        label3.setBounds(130, 360, 500, 50);
        label3.setFont(f3);
        c.add(label3);

        tf5 = new JTextField();
        tf5.setBounds(315, 375, 335, 30);
        tf5.setFont(f4);
        c.add(tf5);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // JButtons
        btn1 = new JButton("Log out");
        btn1.setBounds(75, 450, 190, 50);
        btn1.setFont(f6);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#C00000"));
        c.add(btn1);

        btn2 = new JButton("Back");
        btn2.setBounds(300, 450, 190, 50);
        btn2.setFont(f6);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#2E75B6"));
        btn2.setEnabled (true);
        c.add(btn2);

        btn3 = new JButton("Submit");
        btn3.setBounds(524, 450, 300, 50);
        btn3.setFont(f6);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#2E75B6"));
        c.add(btn3);
        
        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);


        // Logout Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
        // Back
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                TeacherSelect frame = new TeacherSelect();
                frame.setVisible(true);
            }
        });

        // Submit
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String TeacherDe = tf1.getText();
                String TeacherQu = tf2.getText();
                String StuClass = tf3.getText();
                String StuPho = tf4.getText();
                String StuLoc = tf5.getText();
                
                
                if (TeacherDe.isEmpty() || TeacherQu.isEmpty() || StuClass.isEmpty() | StuPho.isEmpty() | StuLoc.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Cannot submit!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        File file = new File(".\\Data\\stu_req.txt");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        FileWriter fw = new FileWriter(file, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);
                        LocalDateTime myDateObj = LocalDateTime.now();
                        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");

                        String timeAndDate = myDateObj.format(myFormatObj);

                        pw.println("TeacherDegree : " + TeacherDe);
                        pw.println("Qyalification : " + TeacherQu);
                        pw.println("StudentClass : " + StuClass);
                        pw.println("StudentPhone : " + StuPho);
                        pw.println("StudentLocation : " + StuLoc);
                        pw.println("Time & Date : " + timeAndDate);
                        pw.println("===============================================");
                        pw.close();

                    } catch (Exception ex) {
                        System.out.print(ex);
                    }

                    JOptionPane.showMessageDialog(null, "Form Submitted", "Submitted!",
                            JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    Confirmation frame = new Confirmation();
                    frame.setVisible(true);
                }
            }
        });
    }

    public static void main(String[] args) {

        TeacherbyHomeTutor frame = new TeacherbyHomeTutor();
        frame.setVisible(true);
    }
}
