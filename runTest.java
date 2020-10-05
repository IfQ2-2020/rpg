public class runTest
{
    World world;
    Gamemode game;
    GameContainer cont;
    public runTest(int seed){
        world = new World(seed);
        cont = new GameContainer();
        game = new Game(cont,world);
        cont.changeMode(game);
    }
}
