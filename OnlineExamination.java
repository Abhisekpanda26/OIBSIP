import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

class Login extends JFrame implements ActionListener {
    JButton b1;
    JPanel newPanel;
    JLabel userLabel, passLabel;
    final JTextField textField1, textField2;

    Login() {
        userLabel = new JLabel();
        userLabel.setText("    Username :");
        textField1 = new JTextField(15);
        passLabel = new JLabel();
        passLabel.setText("    Password :");
        textField2 = new JPasswordField(8);
        b1 = new JButton("   Submit   ");
        newPanel = new JPanel(new GridLayout(3, 1));
        newPanel.add(userLabel);
        newPanel.add(textField1);
        newPanel.add(passLabel);
        newPanel.add(textField2);
        newPanel.add(b1);
        add(newPanel, BorderLayout.CENTER);
        b1.addActionListener(this);
        setTitle("Login");
    }

    public void actionPerformed(ActionEvent ae) {
        String userValue = textField1.getText();
        String passValue = textField2.getText();
        if (!passValue.equals(""))
            new OnlineTestBegin(userValue);
        else {
            textField2.setText("Enter Password");
            actionPerformed(ae);
        }
    }
}

class OnlineTestBegin extends JFrame implements ActionListener {
    JLabel l;
    JLabel l1;
    JRadioButton jb[] = new JRadioButton[4];
    JButton b1, b2;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];
    Timer timer;

    OnlineTestBegin(String s) {
        super(s);
        l = new JLabel();
        l1 = new JLabel();
        add(l);
        add(l1);
        bg = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            jb[i] = new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1 = new JButton("Save and Next");
        b2 = new JButton("Save for later");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);
        add(b2);
        set();
        l.setBounds(30, 40, 450, 20);
        l1.setBounds(20, 20, 450, 20);
        jb[0].setBounds(50, 80, 200, 20);
        jb[1].setBounds(50, 110, 200, 20);
        jb[2].setBounds(50, 140, 200, 20);
        jb[3].setBounds(50, 170, 200, 20);
        b1.setBounds(95, 240, 140, 30);
        b2.setBounds(270, 240, 150, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int i = 600;

            public void run() {
                l1.setText("Time left: " + i);
                i--;
                if (i < 0) {
                    timer.cancel();
                    l1.setText("Time Out");
                }
            }
        }, 0, 1000);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (check())
                count = count + 1;
            current++;
            set();
            if (current == 9) {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }
        if (e.getActionCommand().equals("Save for later")) {
            JButton bk = new JButton("Review" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 9)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Review" + y)) {
                if (check())
                    count = count + 1;
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }
        if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            current++;
            JOptionPane.showMessageDialog(this, "Score =" + count);
            System.exit(0);
        }
    }

    void set() {
        jb[0].setSelected(true);
        if (current == 0) {
            l.setText("Que1: Which keyword is used to prevent method overriding in Java?");
            jb[0].setText("final");
            jb[1].setText("abstract");
            jb[2].setText("static");
            jb[3].setText("private");
        }
        if (current == 1) {
            l.setText("Que2: What does JVM stand for?");
            jb[0].setText("Java Virtual Method");
            jb[1].setText(" Java Verified Machine");
            jb[2].setText(" Java Virtual Machine");
            jb[3].setText("java virtual mobile");
        }
        if (current == 2) {
            l.setText("Que3: Which of the following is not a valid Java identifier?");
            jb[0].setText(" _variableName");
            jb[1].setText("$variableName");
            jb[2].setText("123variableName");
            jb[3].setText("variableName123");
        }
        if (current == 3) {
            l.setText("Que4:What is the default value of a boolean variable in Java?");
            jb[0].setText("true");
            jb[1].setText("false");
            jb[2].setText("null");
            jb[3].setText("0");
        }
        if (current == 4) {
            l.setText("Que5: Among the following which is not a database management software?");
            jb[0].setText("Oracle");
            jb[1].setText("COBOL");
            jb[2].setText("My SQL");
            jb[3].setText(" Sybase");
        }
        if (current == 5) {
            l.setText("Que6: Total number of layers in OSI model is _____?");
            jb[0].setText("7");
            jb[1].setText("4");
            jb[2].setText("9");
            jb[3].setText("2");
        }
        if (current == 6) {
            l.setText("Que7: Which collection class allows null as a key?");
            jb[0].setText("HashSet");
            jb[1].setText("TreeMap");
            jb[2].setText("LinkedHashMap");
            jb[3].setText("HashMap");
        }
        if (current == 7) {
            l.setText("Que8: Why is a firewall used in a computer?");
            jb[0].setText("Security");
            jb[1].setText("Monitoring");
            jb[2].setText("Data Transmission");
            jb[3].setText("Authentication");
        }
        
        }
               
      
    

    boolean check() {
        if (current == 0)
            return (jb[0].isSelected());
        if (current == 1)
            return (jb[3].isSelected()); 
        if(current==2)  
            return(jb[2].isSelected());  
        if(current==3)  
            return(jb[1].isSelected());  
        if(current==4)  
            return(jb[1].isSelected());  
        if(current==5)  
            return(jb[0].isSelected());  
        if(current==6)  
            return(jb[3].isSelected());  
        if(current==7)  
            return(jb[0].isSelected());  
              
        return false;  
       
    }
}

public class OnlineExamination {
    public static void main(String args[]) {
        try {
            Login form = new Login();
            form.setSize(400, 150);
            form.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
