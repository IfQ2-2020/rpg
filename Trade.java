public class Trade
{

  private int[] ware = new int[2];
  
  public Trade(int ware1, int ware2){
     ware[0] = ware1;
     ware[1] = ware2;
  }
  public void setWare(int ware1, int ware2){
     ware[0] = ware1;
     ware[1] = ware2;
  }
  public int[] getWare(){
         return ware;
  }
  public int getWare1(){
      return ware[0];
  }
    
  public int getWare2(){
      return ware[1];
  }
    
   
  
  
}