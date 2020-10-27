public class Haendler extends NPC
{
  private Trade[] trades = new Trade[3];
  private boolean noMoreTrades = false;
  
  public Haendler(int pId, int p_TextureID, String pName, int x, int y, int direction, int pSpeed) {
      super(pId, p_TextureID, pName, x, y, direction, pSpeed);
      for(int i = 0; i < 3; i++){
          trades[i] = new Trade(0,1);
      }   
  }
  
  public void changeTradeState(){
         noMoreTrades = !noMoreTrades;
  }
  public void zerlegen(){
      
    }
}


