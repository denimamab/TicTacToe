package struct;

import org.junit.Test;

import java.awt.*;

import static junit.framework.TestCase.assertEquals;

public class BoardAlphaBetaTest {


    @Test
    public void testXWinDiag() {
        Board b = new Board(3);
        b.move(new Point(0,0), Player.PLAYER_X);
        b.move(new Point(1,1), Player.PLAYER_X);
        Action m =  b.moveOAIAlphaBeta();
        assertEquals(new Point(2,2), m.getP());
    }

    @Test
    public void testXWinDiag2() {
        Board b = new Board(3);
        b.move(new Point(0,2), Player.PLAYER_X);
        b.move(new Point(1,1), Player.PLAYER_X);
        Action m =  b.moveOAIAlphaBeta();
        assertEquals(new Point(2,0), m.getP());
    }

    @Test
    public void testXWinLine() {
        Board b = new Board(3);
        b.move(new Point(0,0), Player.PLAYER_X);
        b.move(new Point(0,1), Player.PLAYER_X);
        Action m =  b.moveOAIAlphaBeta();
        assertEquals(new Point(0,2), m.getP());
    }

    @Test
    public void testXWinCol() {
        Board b = new Board(3);
        b.move(new Point(0,0), Player.PLAYER_X);
        b.move(new Point(1,0), Player.PLAYER_X);
        Action m =  b.moveOAIAlphaBeta();
        assertEquals(new Point(2,0), m.getP());
    }
}