public class Bewohner extends NPC
{
  private String punchline;
  
  public Bewohner(int pId, String pName, int x, int y, int direction, int pSpeed, String line) {
      super(pId, pName, x, y, direction, pSpeed);
      punchline = line;
  }
  
  public String getPunchline(){
    return punchline;
  }
}
