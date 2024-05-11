//******************American International University-Bangladesh (AIUB) */
//******************Object Oriented Programming 1 (JAVA) GUI Project - Group 5 | Date: 09/05/2024 */
//******************** Developed by Arfan Rahman Tonmoy (23-51598-2) (arfanrahman12@gmail.com) */
//*********************Group Members :Arfan Rahman (23-51598-2), TANMAY ROY RONY (23-51745-2), Swarna sikder (23-51779-2), Sanjida Affrin Bristi (23-51788-2) */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TeacherSelect extends JFrame {

    private Container c;
    private ImageIcon icon;
    private JLabel label1, imgLabel;
    private Font f1, f2, f3;
    private ImageIcon logo;
    private JButton btn1, btn2, btn3, nBtn;
    private Cursor cursor;
    private JRadioButton defPacks, selfChosenPacks;
    private ButtonGroup jButtonGroup;
    private int pack = 0;

    TeacherSelect() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Welcome Back - HomeTutor");
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
        f1 = new Font("Segoe UI Black", Font.PLAIN, 40);
        f2 = new Font("Segoe UI Semibold", Font.PLAIN, 30);
        f3 = new Font("Segoe UI Black", Font.PLAIN, 25);

        // Cursor for JButtons and Radio Buttons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // Title
        label1 = new JLabel();
        label1.setText("Welcome back, Student!");
        label1.setBounds(40, 40, 500, 50);
        label1.setFont(f1);
        c.add(label1);

        label1 = new JLabel();
        label1.setText("Want a teacher?");
        label1.setBounds(40, 90, 500, 50);
        label1.setFont(f1);
        c.add(label1);

        defPacks = new JRadioButton("I want a best tutor reccomanded by HomeTutor.");
        defPacks.setBounds(30, 200, 800, 100);
        defPacks.setFont(f2);
        defPacks.setCursor(cursor);
        defPacks.setBackground(Color.decode("#F2F2F2"));
        c.add(defPacks);

        selfChosenPacks = new JRadioButton("I want to pick Tutors myself from HomeTutor.");
        selfChosenPacks.setBounds(30, 300, 800, 50);
        selfChosenPacks.setFont(f2);
        selfChosenPacks.setCursor(cursor);
        selfChosenPacks.setBackground(Color.decode("#F2F2F2"));
        c.add(selfChosenPacks);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);
        jButtonGroup = new ButtonGroup();
        jButtonGroup.add(defPacks);
        jButtonGroup.add(selfChosenPacks);

        btn1 = new JButton("Log out");
        btn1.setBounds(90, 450, 215, 50);
        btn1.setFont(f3);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#C00000"));
        c.add(btn1);

        btn2 = new JButton("Support");
        btn2.setBounds(340, 450, 215, 50);
        btn2.setFont(f3);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#2E75B6"));
        c.add(btn2);

        btn3 = new JButton("Next");
        btn3.setBounds(590, 450, 215, 50);
        btn3.setFont(f3);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#2E75B6"));
        c.add(btn3);
        
        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        Handler handler = new Handler();
        defPacks.addActionListener(handler);
        selfChosenPacks.addActionListener(handler);

        // Logout Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Support Button
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(true);
                Support frame = new Support();
                frame.setVisible(true);
            }
        });

        // Next Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (pack == 1) {
                    setVisible(false);
                    TeacherbyHomeTutor frame = new TeacherbyHomeTutor();
                    frame.setVisible(true);
                } else if (pack == 2) {
                    setVisible(false);
                    TeacherList frame = new TeacherList();
                    frame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Choose a option otherwise we cannot show anything your needs.", "No option selected!",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == defPacks) {
                pack = 1;
            } else if (e.getSource() == selfChosenPacks) {
                pack = 2;
            }
        }
    }

    public static void main(String[] args) {

        TeacherSelect frame = new TeacherSelect();
        frame.setVisible(true);
    }
}