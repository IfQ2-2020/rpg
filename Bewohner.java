public class Bewohner extends NPC
{
  private String punchline;
  
  public Bewohner(String _line, int pID, int[] position, String name) {
         super(pID, position, name);
         punchline = _line;
  }
  
  public String getPunchline(){
    return punchline;
  }
}
