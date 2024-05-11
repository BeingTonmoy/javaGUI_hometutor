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

public class StudentInfo extends JFrame {

    private Container c;
    private ImageIcon icon;
    private JLabel label1;
    private Font f1, f2, f3;
    private JScrollPane scroll;
    private JTable table;
    private DefaultTableModel model;
    private JButton btn1, btn2, btn3, btn4, btn5, nBtn;
    private Cursor cursor;

    private String[] column = { "Student ID", "Password", "Email", "City", "Phone", "Date and Time" };
    private String[] rows = new String[7];

    StudentInfo() {
       // Frame Layout
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setTitle("HomeTutor Admin Panel - Student Info");
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
       label1.setText("Student Data");
       label1.setBounds(200, 10, 500, 90);
       label1.setFont(f1);
       c.add(label1);

       // JButtons
       btn1 = new JButton("Reload");
       btn1.setBounds(660, 220, 184, 50);
       btn1.setFont(f2);
       btn1.setCursor(cursor);
       btn1.setForeground(Color.WHITE);
       btn1.setBackground(Color.decode("#2E75B6"));
       c.add(btn1);

       btn2 = new JButton("Remove");
       btn2.setBounds(660, 160, 184, 50);
       btn2.setFont(f2);
       btn2.setCursor(cursor);
       btn2.setForeground(Color.WHITE);
       btn2.setBackground(Color.decode("#2E75B6"));
       c.add(btn2);

       btn3 = new JButton("Add");
       btn3.setBounds(660, 100, 184, 50);
       btn3.setFont(f2);
       btn3.setCursor(cursor);
       btn3.setForeground(Color.WHITE);
       btn3.setBackground(Color.decode("#2E75B6"));
       c.add(btn3);

       btn4 = new JButton("Logout");
       btn4.setBounds(300, 480, 278, 50);
       btn4.setFont(f2);
       btn4.setCursor(cursor);
       btn4.setForeground(Color.WHITE);
       btn4.setBackground(Color.decode("#2E75B6"));
       c.add(btn4);

       btn5 = new JButton("Back");
       btn5.setBounds(660, 280, 184, 50);
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
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(300);
        table.getColumnModel().getColumn(3).setPreferredWidth(220);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);
        table.getColumnModel().getColumn(5).setPreferredWidth(220);

        scroll = new JScrollPane(table);
        scroll.setBounds(53, 96, 578, 300);
        scroll.setBackground(Color.WHITE);
        c.add(scroll);

        String file = ".\\Data\\user_data.txt";
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
                    rows[0] = Files.readAllLines(Paths.get(file)).get(i).substring(12); // Student Name
                    rows[1] = Files.readAllLines(Paths.get(file)).get((i + 1)).substring(11); // Password
                    rows[2] = Files.readAllLines(Paths.get(file)).get((i + 2)).substring(8); // Email
                    rows[3] = Files.readAllLines(Paths.get(file)).get((i + 3)).substring(20); // City
                    rows[4] = Files.readAllLines(Paths.get(file)).get((i + 4)).substring(9); // Phone
                    rows[5] = Files.readAllLines(Paths.get(file)).get((i + 5)).substring(14); // Date and Time
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
                StudentInfo frame = new StudentInfo();
                frame.setVisible(true);

            }
        });

        // Delete Button
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                if (table.getSelectionModel().isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select a student to delete", "No student selected!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    String removeUser = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();

                    File oldFile = new File(file);
                    File newFile = new File(temp);

                    int q = 0;

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
                                String userName = Files.readAllLines(Paths.get(file)).get(i);
                                if (userName.substring(12).equals(removeUser)) {
                                    q = i;
                                }
                            }
                        }
                    } catch (Exception ex) {
                        return;
                    }

                    try {

                        FileWriter fw = new FileWriter(temp, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);

                        FileReader fr = new FileReader(file);
                        BufferedReader br = new BufferedReader(fr);

                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        int totalLines = 0;
                        while (reader.readLine() != null)
                            totalLines++;
                        reader.close();

                        for (int j = 0; j < totalLines; j++) {
                            String line = Files.readAllLines(Paths.get(file)).get(j);
                            String x = line.substring(0, 4);

                            if (q != 0 && (j == q || j == (q + 1) || j == (q + 2) || j == (q + 3) || j == (q + 4) || j == (q + 5))) {
                                String userName = Files.readAllLines(Paths.get(file)).get(j);
                                pw.println("Student Removed! " + userName);
                            } else {
                                String userName = Files.readAllLines(Paths.get(file)).get(j);
                                pw.println(userName);
                            }
                        }
                        pw.flush();
                        pw.close();
                        fr.close();
                        br.close();
                        bw.close();
                        fw.close();

                    } catch (Exception ex) {
                        System.out.print(ex);
                    }

                    oldFile.delete();
                    File dump = new File(file);
                    newFile.renameTo(dump);

                    setVisible(false);
                    StudentInfo frame = new StudentInfo();
                    frame.setVisible(true);
                }

            }
        });

        // Add Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                StudentAdd frame = new StudentAdd();
                frame.setVisible(true);
            }
        });

        // Exit Button
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Back Button
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                Admin frame = new Admin();
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {

        StudentInfo frame = new StudentInfo();
        frame.setVisible(true);
    }
}
