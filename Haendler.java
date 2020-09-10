public class Haendler extends NPC
{
  private Trade[] trades = new Trade[3];
  private boolean noMoreTrades = false;
  private Trade mTrade;
  
  public Haendler(int pID, int[] position, String name) {
         super(pID, position, name);
         for(int i = 0; i < 3; i++){
           trades[i] = new Trade(0,1);
         }            
  }
  
  public void changeTradeState(){
         noMoreTrades = !noMoreTrades;
  }
}