public class trade
{
  private int[] ware = new int[2];
  public trade(int ware1, int ware2){
     ware[0] = ware1;
     ware[1] = ware2;
  }
  public int[] getWare(){
         return ware;
  }
}