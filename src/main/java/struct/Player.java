package struct;

public enum Player {
    PLAYER_X, //User
    PLAYER_O, //Computer
    PLAYER_EMPTY;

    public static Player opponent(Player p) {
        return p == PLAYER_X  ? PLAYER_O : PLAYER_X;
    }
}
