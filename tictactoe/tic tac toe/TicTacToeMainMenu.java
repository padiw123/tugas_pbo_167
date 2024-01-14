import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeMainMenu extends JFrame implements ActionListener {
    public TicTacToeMainMenu() {
        super("Tic Tac Toe");

        JLabel titleLabel = new JLabel("Tic Tac Toe");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(100, 50, 200, 50);
        add(titleLabel);

        JButton playNowButton = new JButton("Main Sekarang");
        playNowButton.setBounds(100, 150, 150, 30);
        playNowButton.addActionListener(this);
        add(playNowButton);

        setLayout(null);
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(41, 110, 110));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Main Sekarang")) {
            new TTT1();
            dispose();
        }
    }

    public static void main(String[] args) {
        new TicTacToeMainMenu();
    }
}

