//******************American International University-Bangladesh (AIUB) */
//******************Object Oriented Programming 1 (JAVA) GUI Project - Group 5 | Date: 09/05/2024 */
//******************** Developed by Arfan Rahman Tonmoy (23-51598-2) (arfanrahman12@gmail.com) */
//*********************Group Members :Arfan Rahman (23-51598-2), TANMAY ROY RONY (23-51745-2), Swarna sikder (23-51779-2), Sanjida Affrin Bristi (23-51788-2) */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.lang.*;

public class TeacherList extends JFrame {

    private Container c;
    private ImageIcon icon;
    private JLabel label1;
    private Font f1, f2, f3;
    private JScrollPane scroll;
    private JTable table;
    private DefaultTableModel model;
    private JButton btn1, btn3, btn4, btn5, nBtn;
    private Cursor cursor;

    private String[] column = { "Teacher Name", "Email", "Degree/University", "Phone"};
    private String[] rows = new String[7];

    TeacherList() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("HomeTutor- Teacher List");
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
        f3 = new Font("Segoe UI", Font.PLAIN, 20);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // Title
        label1 = new JLabel();
        label1.setText("Find your perfect tutor.");
        label1.setBounds(40, 10, 500, 90);
        label1.setFont(f2);
        c.add(label1);

        label1 = new JLabel();
        label1.setText("Here is our tutor list.");
        label1.setBounds(350, 30, 500, 90);
        label1.setFont(f3);
        c.add(label1);

        // JButtons
        btn1 = new JButton("Reload");
        btn1.setBounds(360, 450, 184, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#2E75B6"));
        c.add(btn1);


        btn3 = new JButton("Support");
        btn3.setBounds(80, 450, 184, 50);
        btn3.setFont(f2);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#2E75B6"));
        c.add(btn3);

        btn4 = new JButton("Logout");
        btn4.setBounds(300, 560, 278, 50);
        btn4.setFont(f2);
        btn4.setCursor(cursor);
        btn4.setForeground(Color.WHITE);
        btn4.setBackground(Color.decode("#C00000"));
        c.add(btn4);

        btn5 = new JButton("Back");
        btn5.setBounds(650, 450, 184, 50);
        btn5.setFont(f2);
        btn5.setCursor(cursor);
        btn5.setForeground(Color.WHITE);
        btn5.setBackground(Color.decode("#2E75B6"));
        c.add(btn5);

        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        // JTable Layout
        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(column);

        table.setModel(model);
        table.setFont(f3);
        table.setSelectionBackground(Color.decode("#8AC5FF"));
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(120);
        table.getColumnModel().getColumn(1).setPreferredWidth(300);
        table.getColumnModel().getColumn(2).setPreferredWidth(220);
        table.getColumnModel().getColumn(3).setPreferredWidth(200);
        

        scroll = new JScrollPane(table);
        scroll.setBounds(53, 96, 770, 300);
        scroll.setBackground(Color.WHITE);
        c.add(scroll);

        String file = ".\\Data\\teacher_data.txt";
        String temp = ".\\Data\\temp.txt";

        // To input data in the table
        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));
            int totalLines = 0;
            while (reader.readLine() != null)
                totalLines++;
            reader.close();

            for (int i = 0; i < totalLines; i++) {
                String line = Files.readAllLines(Paths.get(file)).get(i);
                String x = line.substring(0, 4);
                if (x.equals("User")) {
                    rows[0] = Files.readAllLines(Paths.get(file)).get(i).substring(12); // Teacher Name
                    rows[1] = Files.readAllLines(Paths.get(file)).get((i + 2)).substring(8); // Email
                    rows[2] = Files.readAllLines(Paths.get(file)).get((i + 3)).substring(20); // Degree
                    rows[3] = Files.readAllLines(Paths.get(file)).get((i + 4)).substring(9); // Phone
                    
                    model.addRow(rows);
                }
            }

        } catch (Exception ex) {
            return;
        }

        // Refresh Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                TeacherList frame = new TeacherList();
                frame.setVisible(true);

            }
        });

        // Support Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Support frame = new Support();
                frame.setVisible(true);
            }
        });

        // Logout Button
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Back Button
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                TeacherSelect frame = new TeacherSelect();
                frame.setVisible(true);   
            }
        });
    }

    public static void main(String[] args) {

        TeacherList frame = new TeacherList();
        frame.setVisible(true);
    }
}
