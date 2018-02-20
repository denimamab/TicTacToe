package gui;

import struct.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    JPanel board, configuration, generate, Algorithm, results;
    JRadioButton JRB3x3, JRB4x4, JRB5x5;
    static JRadioButton minimax, alphabeta;
    JButton JBReset;
    static JLabel resultsLab;

    public Dashboard() {
        setLayout(new GridLayout(1, 2));
        setTitle("TicTacToe - MiniMax, AlphaBeta pruning");

        board = new JPanel();
        Board b = new Board(3);

        BoardGUI bb = new BoardGUI(b);
        board.add(bb);
        add(board);

        configuration = new JPanel();
        configuration.setLayout(new BoxLayout(configuration, BoxLayout.Y_AXIS));

        generate = new JPanel();
        generate.setLayout(new FlowLayout());
        generate.setBorder(BorderFactory.createTitledBorder("Generate new board"));

        JBReset = new JButton("Reset board");
        JBReset.addActionListener(this);
        ButtonGroup dim = new ButtonGroup();
        JRB3x3 = new JRadioButton("3x3");
        JRB4x4 = new JRadioButton("4x4");
        JRB5x5 = new JRadioButton("5x5");
        dim.add(JRB3x3);
        dim.add(JRB4x4);
        dim.add(JRB5x5);
        JRB3x3.setSelected(true);
        generate.add(JRB3x3);
        generate.add(JRB4x4);
        generate.add(JRB5x5);
        generate.add(JBReset);

        configuration.add(generate);

        Algorithm = new JPanel();
        Algorithm.setBorder(BorderFactory.createTitledBorder("Algorithm"));
        ButtonGroup algogroup = new ButtonGroup();
        minimax = new JRadioButton("Use MiniMax");
        alphabeta = new JRadioButton("Use MiniMax with Alpha-Beta pruning");
        minimax.setSelected(true);
        algogroup.add(minimax);
        algogroup.add(alphabeta);

        Algorithm.add(minimax);
        Algorithm.add(alphabeta);

        configuration.add(Algorithm);

        results = new JPanel();
        results.setBorder(BorderFactory.createTitledBorder("Results"));
        resultsLab = new JLabel("");
        results.add(resultsLab);

        configuration.add(results);

        add(configuration);

        setMinimumSize(new Dimension(600, 300));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Board b = new Board(3);

        if (JRB4x4.isSelected()) {
            b = new Board(4);
        }
        if (JRB5x5.isSelected()) {
            b = new Board(5);
        }
        BoardGUI bb = new BoardGUI(b);
        board.removeAll();
        board.revalidate();
        board.repaint();
        board.add(bb);
        board.repaint();

    }
}
