package gui;

import struct.Action;
import struct.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardGUI extends JPanel implements MouseListener {
    Board board;
    private GridBagConstraints gbc;
    private GridBagLayout gbl;
    NodeUI[][] grid;

    public BoardGUI(Board board) {
        this.board = board;
        Node[][] logGrid = board.getGrid();
        grid = new NodeUI[logGrid.length][logGrid.length];

        gbl = new GridBagLayout();
        setLayout(gbl);
        gbc = new GridBagConstraints();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = new NodeUI(new Point(i, j));
                gbc.gridx = j;
                gbc.gridy = i;
                Border border = null;

                if (i < grid.length - 1) {
                    if (j < grid.length - 1) {
                        border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
                    } else {
                        border = new MatteBorder(1, 1, 0, 1, Color.GRAY);
                    }
                } else {
                    if (j < grid.length - 1) {
                        border = new MatteBorder(1, 1, 1, 0, Color.GRAY);
                    } else {
                        border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
                    }
                }
                grid[i][j].setBorder(border);
                grid[i][j].addMouseListener(this);
                add(grid[i][j], gbc);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        GameState gameState = board.isGameOver();
        NodeUI n = (NodeUI) e.getSource();

        if (gameState == GameState.IN_PROGRESS) {
            if (n.isEnabled()) {
                n.setText("X");
                n.setEnabled(false);
                board.move(n.p, Player.PLAYER_X);
                gameState = board.isGameOver();
                if (gameState == GameState.IN_PROGRESS) {
                    Action m = null;
                    if (Dashboard.minimax.isSelected()) {
                        m = board.moveOAIMinMax();
                    } else if (Dashboard.alphabeta.isSelected()) {
                        m = board.moveOAIAlphaBeta();
                    }
                    if (m != null && m.getP() != null) {

                        Dashboard.resultsLab.setText("<html><body>State : IN PROGRESS<br>Elapsed time: <span style='color: red;'>" + m.elapsedTime() + "</span> nano seconds </body></html>");
    grid[m.getP().x][m.getP().y].setText("O");
    grid[m.getP().x][m.getP().y].setEnabled(false);
}
                }

                        gameState = board.isGameOver();
                        if (gameState == GameState.O_WON) {
                        Dashboard.resultsLab.setText("State : Computer WON");
                        } else if (gameState == GameState.X_WON) {
                        Dashboard.resultsLab.setText("State : YOU WIN");
                        } else if (gameState == GameState.DRAW) {
                        Dashboard.resultsLab.setText("State : DRAW");
                        }

                        }
                        }
                        }

@Override
public void mousePressed(MouseEvent e) {

        }

@Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
