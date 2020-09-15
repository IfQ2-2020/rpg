public class Bewohner extends NPC
{
  private String punchline;
  
  public Bewohner(String _line,int pSpeed , int pID, int[] position, String name) {
         super(pSpeed, pID, position[0], position[1], position[2], name);
         punchline = _line;
  }
  
  public String getPunchline(){
    return punchline;
  }
}
