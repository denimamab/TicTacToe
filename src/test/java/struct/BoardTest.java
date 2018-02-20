package struct;

import org.junit.Test;

import java.awt.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class BoardTest {
    @Test
    public void testTimeElapsedForSameSituation() {

        Board b = new Board(4);
        b.move(new Point(0,2), Player.PLAYER_X);
        b.move(new Point(1,1), Player.PLAYER_X);
        Action minimax =  b.moveOAIMinMax();
        assertEquals(new Point(2,0), minimax.getP());

        b = new Board(4);
        b.move(new Point(0,2), Player.PLAYER_X);
        b.move(new Point(1,1), Player.PLAYER_X);
        Action alphabeta =  b.moveOAIAlphaBeta();
        assertEquals(new Point(2,0), alphabeta.getP());

        assertTrue(alphabeta.getTime() <= minimax.getTime());
    }
}
