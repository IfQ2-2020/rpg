public class Tiles {
    // Im Moment nur boolean ueberwindbar
    public static boolean getTileMeta(int tileId) {
        return true;
    }

    public static Tile createTileAt(int tileId, int x, int y) {
        Tile t = new Tile(tileId, x, y);
        t.setUeberwindbar(getTileMeta(tileId));
        return t;
    }
}