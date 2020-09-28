public class runTest
{
    World world;
    Gamemode game;
    GameContainer cont;
    public runTest(){
        world = new World();
        cont = new GameContainer();
        game = new Game(cont,world);
        cont.changeMode(game);
    }
}
