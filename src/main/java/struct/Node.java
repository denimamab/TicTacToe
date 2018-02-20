package struct;

import java.awt.*;

public class Node {
    public Point p;
    private Player player;

    public Node(int x, int y, Player player) {
        this.p = new Point(x,y);
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
