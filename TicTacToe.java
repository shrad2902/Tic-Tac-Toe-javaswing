import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener{

    JMenuBar menuBar;
    JMenu Refresh, About;
    JMenuItem Start, AbtHelp;
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel topPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel text = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean firstPlayer;


    TicTacToe(){

        menuBar = new JMenuBar();
        Refresh = new JMenu("Refresh");
        Start = new JMenuItem("Start");
        Start.addActionListener(this);
        Refresh.add(Start);
        menuBar.add(Refresh);
        About = new JMenu("About");
        AbtHelp = new JMenuItem("About Creator");
        AbtHelp.addActionListener(this);
        About.add(AbtHelp);
        menuBar.add(About);


        frame.setTitle("Tic-Tac-To by Shraddha");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,600);
        frame.getContentPane().setBackground(new Color(241,187,196));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        text.setBackground(new Color(252,236,239));
        text.setForeground(new Color(92,86,86));
        text.setFont(new Font("Ink Free",Font.BOLD,50));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setText("Tic-Tac-Toe");
        text.setOpaque(true);

        topPanel.setLayout(new BorderLayout());
        topPanel.setBounds(0,0,800,100);

        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(241,187,196));

        for(int i=0; i<9;i++){
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setBackground(new Color(241,187,196));
            buttons[i].setFont(new Font("Ink Free",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        topPanel.add(text);
        frame.add(topPanel,BorderLayout.NORTH);
        frame.add(buttonPanel);

        frame.setJMenuBar(menuBar);
        frame.setVisible(true);

        randomfirstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==Start) {
            for(int i=0; i<9;i++){
                buttons[i].setText("");
                buttons[i].setBackground(new Color(241,187,196));
                buttons[i].setEnabled(true);
            }
            randomfirstTurn();
        }
        if(e.getSource()==AbtHelp) {
            String detail = "This Was Created By SICSR BCA (Sem - III) Student \n Name:  Shraddha Singh \n PRN:  20030121106";
            JOptionPane.showMessageDialog(frame,detail);
        }

        for(int i=0;i<9;i++) {
            if(e.getSource()==buttons[i]) {
                if(firstPlayer) {
                    if(buttons[i].getText()=="") {
                        buttons[i].setForeground(new Color(252,236,239));
                        buttons[i].setText("X");
                        firstPlayer=false;
                        text.setForeground(new Color(255,105,97));
                        text.setText("O turn");
                        check();
                    }
                }
                else {
                    if(buttons[i].getText()=="") {
                        buttons[i].setForeground(new Color(92,86,86));
                        buttons[i].setText("O");
                        firstPlayer=true;
                        text.setForeground(new Color(46,139,192));
                        text.setText("X turn");
                        check();
                    }
                }
            }
        }

    }

    public void randomfirstTurn(){

        if(random.nextInt(2)==0) {
            firstPlayer=true;
            text.setText("X turn");
        }
        else {
            firstPlayer=false;
            text.setText("O turn");
        }

    }

    public void check() {

        if(
                (buttons[0].getText()=="X") &&
                        (buttons[1].getText()=="X") &&
                        (buttons[2].getText()=="X")
        ) {
            ifXwins(0,1,2);
        }
        if(
                (buttons[3].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[5].getText()=="X")
        ) {
            ifXwins(3,4,5);
        }
        if(
                (buttons[6].getText()=="X") &&
                        (buttons[7].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ) {
            ifXwins(6,7,8);
        }
        if(
                (buttons[0].getText()=="X") &&
                        (buttons[3].getText()=="X") &&
                        (buttons[6].getText()=="X")
        ) {
            ifXwins(0,3,6);
        }
        if(
                (buttons[1].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[7].getText()=="X")
        ) {
            ifXwins(1,4,7);
        }
        if(
                (buttons[2].getText()=="X") &&
                        (buttons[5].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ) {
            ifXwins(2,5,8);
        }
        if(
                (buttons[0].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ) {
            ifXwins(0,4,8);
        }
        if(
                (buttons[2].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[6].getText()=="X")
        ) {
            ifXwins(2,4,6);
        }
        //check O win conditions
        if(
                (buttons[0].getText()=="O") &&
                        (buttons[1].getText()=="O") &&
                        (buttons[2].getText()=="O")
        ) {
            ifOwins(0,1,2);
        }
        if(
                (buttons[3].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[5].getText()=="O")
        ) {
            ifOwins(3,4,5);
        }
        if(
                (buttons[6].getText()=="O") &&
                        (buttons[7].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ) {
            ifOwins(6,7,8);
        }
        if(
                (buttons[0].getText()=="O") &&
                        (buttons[3].getText()=="O") &&
                        (buttons[6].getText()=="O")
        ) {
            ifOwins(0,3,6);
        }
        if(
                (buttons[1].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[7].getText()=="O")
        ) {
            ifOwins(1,4,7);
        }
        if(
                (buttons[2].getText()=="O") &&
                        (buttons[5].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ) {
            ifOwins(2,5,8);
        }
        if(
                (buttons[0].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ) {
            ifOwins(0,4,8);
        }
        if(
                (buttons[2].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[6].getText()=="O")
        ) {
            ifOwins(2,4,6);
        }

    }

    public void ifXwins(int a, int b, int c) {

        buttons[a].setBackground(new Color(118,185,71));
        buttons[b].setBackground(new Color(118,185,71));
        buttons[c].setBackground(new Color(118,185,71));

        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }
        text.setText("X wins");


    }

    public void ifOwins(int a, int b, int c) {

        buttons[a].setBackground(new Color(118,185,71));
        buttons[b].setBackground(new Color(118,185,71));
        buttons[c].setBackground(new Color(118,185,71));

        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }
        text.setText("O wins");

    }

    public static void main(String[] args) {
        new TicTacToe();
    }

}
