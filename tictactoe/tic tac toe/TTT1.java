import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TTT1 extends JFrame implements ItemListener, ActionListener {
    int i, j, ii, jj, x, y, yesnull;
    int a[][] = { { 10, 1, 2, 3, 4, 11 }, { 10, 5, 6, 7, 8, 11 }, { 10, 9, 10, 11, 12, 11 }, { 10, 13, 14, 15, 16, 11 },
            { 10, 1, 5, 9, 13, 11 }, { 10, 2, 6, 10, 14, 11 }, { 10, 3, 7, 11, 15, 11 }, { 10, 4, 8, 12, 16, 11 } };

    int a1[][] = { { 10, 1, 2, 3, 4, 11 }, { 10, 5, 6, 7, 8, 11 }, { 10, 9, 10, 11, 12, 11 }, { 10, 13, 14, 15, 16, 11 },
            { 10, 1, 5, 9, 13, 11 }, { 10, 2, 6, 10, 14, 11 }, { 10, 3, 7, 11, 15, 11 }, { 10, 4, 8, 12, 16, 11 } };

    boolean state, type, set;

    int skorUser = 0;

    JLabel skorLabel;
    Icon ic1, ic2, icon, ic11, ic22;
    Checkbox c1, c2;
    JButton b[] = new JButton[16];
    JButton reset;
    JButton backToMenu;

    public void showButton() {
        x = 10;
        y = 10;
        j = 0;
        for (i = 0; i <= 15; i++, x += 75, j++) {
            b[i] = new JButton();
            if (j == 4) {
                j = 0;
                y += 75;
                x = 10;
            }
            b[i].setBounds(x, y, 75, 75);
            add(b[i]);
            b[i].addActionListener(this);
        }

        reset = new JButton("RESET");
        reset.setBounds(150, 400, 100, 50);
        add(reset);
        reset.addActionListener(this);

        backToMenu = new JButton("Back to Menu");
        backToMenu.setBounds(10, 400, 120, 50);
        add(backToMenu);
        backToMenu.addActionListener(this);
    }

    public void check(int num1) {
        for (ii = 0; ii <= 7; ii++) {
            for (jj = 1; jj <= 4; jj++) {
                if (a[ii][jj] == num1) {
                    a[ii][5] = 11;
                }
            }
        }
    }

    public void complogic(int num) {
        for (i = 0; i <= 7; i++) {
            set = true;
            if (a[i][5] == 10) {
                int count = 0;
                for (j = 1; j <= 4; j++) {
                    if (b[(a[i][j] - 1)].getIcon() != null) {
                        count++;
                    } else {
                        yesnull = a[i][j];
                    }
                }
                if (count == 4) {
                    b[yesnull - 1].setIcon(ic2);
                    this.check(yesnull);
                    set = false;
                    break;
                }
            } else if (a[i][0] == 10) {
                for (j = 1; j <= 4; j++) {
                    if (b[(a[i][j] - 1)].getIcon() == null) {
                        b[(a[i][j] - 1)].setIcon(ic2);
                        this.check(a[i][j]);
                        set = false;
                        break;
                    }
                }
                if (!set)
                    break;
            }
            if (!set)
                break;
        }
    }

    TTT1() {
        super("Tic Tac Toe");

        skorLabel = new JLabel("Skor: 0");

        JLabel titleLabel = new JLabel("Pilih Lawan");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(100, 50, 200, 50);
        add(titleLabel);

        CheckboxGroup cbg = new CheckboxGroup();
        c1 = new Checkbox("vs computer", cbg, false);
        c2 = new Checkbox("vs friend", cbg, false);
        c1.setBounds(120, 120, 80, 40);
        c2.setBounds(120, 150, 80, 40);
        add(c1);
        add(c2);
        c1.addItemListener(this);
        c2.addItemListener(this);

        state = true;
        type = true;
        set = true;
        ic1 = new ImageIcon("ic1.jpg");
        ic2 = new ImageIcon("ic2.jpg");
        ic11 = new ImageIcon("ic11.jpg");
        ic22 = new ImageIcon("ic22.jpg");

        setLayout(null);
        setSize(330, 550);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(41, 110, 110));
    }

    public void itemStateChanged(ItemEvent e) {
        if (c1.getState()) {
            type = false;
        } else if (c2.getState()) {
            type = true;
        }
        remove(c1);
        remove(c2);
        repaint(0, 0, 330, 550);
        showButton();
    }

    public void actionPerformed(ActionEvent e) {
        if (type) {
            if (e.getSource() == reset) {
                for (i = 0; i <= 15; i++) {
                    b[i].setIcon(null);
                }
            } else if (e.getSource() == backToMenu) {
                remove(backToMenu);
                remove(reset);
                for (i = 0; i <= 15; i++) {
                    remove(b[i]);
                }
                showMenu(); // Menampilkan menu utama
            } else {
                for (i = 0; i <= 15; i++) {
                    if (e.getSource() == b[i]) {
                        if (b[i].getIcon() == null) {
                            if (state) {
                                icon = ic2;
                                state = false;
                            } else {
                                icon = ic1;
                                state = true;
                            }
                            b[i].setIcon(icon);
                        }
                    }
                }
            }
        } else {
            if (e.getSource() == reset) {
                for (i = 0; i <= 15; i++) {
                    b[i].setIcon(null);
                }
                for (i = 0; i <= 7; i++)
                    for (j = 0; j <= 5; j++)
                        a[i][j] = a1[i][j];
            } else if (e.getSource() == backToMenu) {
                remove(backToMenu);
                remove(reset);
                for (i = 0; i <= 15; i++) {
                    remove(b[i]);
                }
                showMenu(); // Menampilkan menu utama
            } else {
                for (i = 0; i <= 15; i++) {
                    if (e.getSource() == b[i]) {
                        if (b[i].getIcon() == null) {
                            b[i].setIcon(ic1);
                            if (b[8].getIcon() == null) {
                                b[8].setIcon(ic2);
                                this.check(9);
                            } else {
                                this.complogic(i);
                            }
                        }
                    }
                }
            }
        }

        for (i = 0; i <= 7; i++) {
            Icon icon1 = b[(a[i][1] - 1)].getIcon();
            Icon icon2 = b[(a[i][2] - 1)].getIcon();
            Icon icon3 = b[(a[i][3] - 1)].getIcon();
            Icon icon4 = b[(a[i][4] - 1)].getIcon();
            if ((icon1 == icon2) && (icon2 == icon3) && (icon3 == icon4) && (icon1 != null)) {
                if (icon1 == ic1) {
                    b[(a[i][1] - 1)].setIcon(ic11);
                    b[(a[i][2] - 1)].setIcon(ic11);
                    b[(a[i][3] - 1)].setIcon(ic11);
                    b[(a[i][4] - 1)].setIcon(ic11);
                    skorUser += 10;
                    JOptionPane.showMessageDialog(TTT1.this, "!!!YOU won!!! Skor: " + skorUser + " Click reset");
                    break;
                } else if (icon1 == ic2) {
                    b[(a[i][1] - 1)].setIcon(ic22);
                    b[(a[i][2] - 1)].setIcon(ic22);
                    b[(a[i][3] - 1)].setIcon(ic22);
                    b[(a[i][4] - 1)].setIcon(ic22);
                    JOptionPane.showMessageDialog(TTT1.this, "!!!AWK (COMPUTER) won!!! Skor: " + skorUser + "click reset");
                    break;
                }
            }
        }
    }

    // Metode untuk menampilkan menu utama
    public void showMenu() {
        CheckboxGroup cbg = new CheckboxGroup();
        c1 = new Checkbox("vs computer", cbg, false);
        c2 = new Checkbox("vs friend", cbg, false);
        c1.setBounds(120, 120, 80, 40);
        c2.setBounds(120, 150, 80, 40);
        add(c1);
        add(c2);
        c1.addItemListener(this);
        c2.addItemListener(this);
    }

    public static void main(String[] args) {
        new TTT1();
    }
}
