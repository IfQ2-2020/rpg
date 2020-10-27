public class Bewohner extends NPC
{
  private String punchline;
  
  public Bewohner(int pId, int p_TextureID, String pName, int x, int y, int direction, int pSpeed, String line) {
      super(pId, p_TextureID, pName, x, y, direction, pSpeed);
      punchline = line;
  }
  
  public String getPunchline(){
    return punchline;
  }
}
