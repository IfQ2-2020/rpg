public class Haendler extends NPC
{
  private Trade[] trades = new Trade[3];
  private boolean notmore = false;
  
  public Haendler(int pID, int[] position, String name) {
         super(pID, position, name);
         for(int i = 0; i < 3; i++){
           trades[i] = new Trade(0,1);
         }            
  }
  
  public void changeNotmore(){
         notmore = !notmore;
  }
}