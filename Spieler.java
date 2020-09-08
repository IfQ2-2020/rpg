import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Der Spieler unseres RPG-Projektes
 */
public class Spieler
{
  private int[] position;
  private int id;
  private String name;
  //private texture texture;
  private Items[][] inventar;
  private int[][] inventarCount;
  private int speed;
  //private Verbesserungen;
  private int hunger;
  private int health;
  //long auf Wunsch von Julius
  private long money;
  
  /**
  * Erstellen des Spielers, der Name wird vom Spieler mitgegeben,
  * inventar und inventarCount initialisiert.
  * health, hunger, money und speed werden auf Standartwert gesetzt.
  * id und position werden vom Server generiert.
  */
  public Spieler(String pName, int pId, int pPositionX, int pPositionY, int pDirection)
  {
    name = pName;
    id = pId;
    //position[X;Y;Direction (0 oben, 1 rechts, 2 unten, 3 links)]
    position = new int[3];
    position[0] = pPositionX;
    position[1] = pPositionY;
    position[2] = pDirection;
    //inventar ist 4*9 Felder groß, anfangs leer, inventarCout definiert die Anzahl 'stackbaren' Items
    inventar = new Items[4][9];
    inventarCount = new int[4][9];
    //speed steht als multiplier der Fortbewegung standartmäßig auf 1
    speed = 1;
    hunger = 10;
    health = 10;
    money = 10;
  }
  
  public void laufen()
  {
    switch (position[2]) {
      case 0: 
      position[1] += speed;    
      break;
      case 1: 
      position[0] += speed; 
      break;
      case 2:
      position[1] -= speed;
      break;
      case 3:
      position[0] -= speed;
      break;
      default: 
      
    } // end of switch
  }
  
  public String getName()
  {return name;}
  
  public int getId()
  {return id;}
  
  public int[] getPosition()
  {return position;}
  
  public int getPositionX()
  {return position[0];}
  
  public int getPositionY()
  {return position[1];}
  
  public int getDirection()
  {return position[2];}
  
  public Items[][] getInventar()
  {return inventar;}  
  
  public Items getInventar(int position1, int position2)  
  {
    if (position1 <= 4 && position1 >= 0 && position2 <= 9 && position2 >=0) {
      return inventar[position1][position2];
    }
    else{
      return null;
    }}
  
  public int[][] getInventarCount()
  {
    return inventarCount;
  }
  
  public int getInventarCount(int position1, int position2)
  {
    if (position1 <= 4 && position1 >= 0 && position2 <= 9 && position2 >=0) {
      return inventarCount[position1][position2];
    }
    else{
      return null;
    }}
  
  public int getSpeed()
  {return speed;}
  
  public int getHealth()
  {return health;}
  
  public int getHunger()
  {return hunger;}
  
  public long getMoney()
  {return money;}
  
  public void setName(String pName)
  {name=pName;}
  
  public void setPosition(int[] pPosition)
  {position=pPosition;}
  
  public void setPositionX(int pPositionX)
  {position[0]=pPositionX;}
  
  public void setPositionY(int pPositionY)
  {position[1]=pPositionY;}
  
  public void setDirection(int pDirection)
  {
    if (pDirection<=3 && pDirection>=0) {
      position[2]=pDirection;
    }
  }
  
  public void setSpeed(int pSpeed)
  {speed=pSpeed;}
  
  public void setHealth(int pHealth)
  {health=pHealth;}
  
  public void setMoney(long pMoney)
  {money=pMoney;}
}
