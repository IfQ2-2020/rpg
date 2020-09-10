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
  private Item[] inventar;
  private int[] inventarCount;
  private int speed;
  //private Verbesserungen1234;
  private int hunger;
  private int health;
  //long auf Wunsch von Julius
  private long money;
  private int ausgewaehlt;
  
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
    inventar = new Item[36];
    inventarCount = new int[36];
    //speed steht als multiplier der Fortbewegung Standartmäßig auf 1
    speed = 1;
    hunger = 10;
    health = 10;
    money = 10;
    //ausgewaehlt definiert, welches Item derzeit ausgewählt ist und somit benutzt werden kann
    //kann eine Zahl von 0 bis [VAR] sein
    ausgewaehlt = 0;
  }
  
  /**
   * Spieler wird in Richtung pDirection um speed fortbewegt
   */
  public void laufen(int pDirection)
  {
    if(pDirection >= 0 && pDirection<=4)
    {
        position[2] = pDirection;
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
            break;
        } // end of switch
    }
  }
  
  public void tool_benutzen()
  {
    if(inventar[ausgewaehlt] != null)
    {
<<<<<<< HEAD
        if(inventar[ausgewaehlt].getClass() == Combats.class)
        {
            
        }
        else if(inventar[ausgewaehlt].getClass() == Food.class)
=======
        if(inventar[ausgewaehlt].getClass() == CombatItem.class)
        {
            if(inventar[ausgewaehlt].getDurability() <=1)
            {
                inventar[ausgewaehlt] = null;
                inventarCount[ausgewaehlt] = 0;
            }
            else
            {
                inventar[ausgewaehlt].setDurability(1);
            }
        }
        else if(inventar[ausgewaehlt].getClass() == FoodItem.class)
>>>>>>> c53a284cb585314712af23c1dbab4921ca916c31
        {
            
        }
    }
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
  
  public Item[] getInventar()
  {return inventar;}  
  
  public Item getInventar(int position)  
  {
    if (position<= 36 && position >= 0) {
      return inventar[position];
    }
    else{
      return null;
    }}

  //get-Methoden  
  public int[] getInventarCount()
  {
    return inventarCount;
  }
  
  public int getInventarCount(int position)
  {
    if (position <= 36 && position >= 0) {
      return inventarCount[position];
    }
    else{
      return 0;
    }}
  
  public int getSpeed()
  {return speed;}
  
  public int getHealth()
  {return health;}
  
  public int getHunger()
  {return hunger;}
  
  public long getMoney()
  {return money;}
  
  //set-Methoden
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
