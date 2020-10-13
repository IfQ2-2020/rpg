import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

/**
 * Der Spieler unseres RPG-Projektes
 */
public class Spieler
{
    private String name;
    private Vector2 position;
    private int direction;
    private int id;
    private BufferedImage texture;
    //inventar ist 4*9 Felder groß, anfangs leer, inventarCount definiert die Anzahl 'stackbaren' Items
    private Item[] inventar;
    private int[] inventarCount;
    private int ausgewaehlt;

    /// Stats
    private int speed;
    //private Verbesserungen;
    //Für den Spieler wird saettigung als auf(!)gerundeter int-Wert angegeben
    private double saettigung;
    private int health;
    //long auf Wunsch von Julius
    private long money;
    private World world;
    
    /**
    * Erstellen des Spielers, der Name wird vom Spieler mitgegeben,
    * inventar und inventarCount initialisiert.
    * health, hunger, money und speed werden auf Standartwert gesetzt.
    * id, position und textureId werden vom Server generiert.
    */
    public Spieler(String pName, int pId, int pPositionX, int pPositionY, int pDirection, int pTextureId, World pWorld)
    {
        name = pName;
        id = pId;
        position = new Vector2(pPositionX, pPositionY);
        direction = pDirection;
        texture = Textures.loadFile("./textures/player/" + pTextureId + ".png");
        inventar = new Item[36];
        inventarCount = new int[36];
        //speed steht als multiplier der Fortbewegung Standartmäßig auf 1
        speed = 1;
        saettigung = 10;
        health = 10;
        money = 10;
        //ausgewaehlt definiert, welches Item derzeit ausgewählt ist und somit benutzt werden kann
        //kann eine Zahl von 0 bis 35 sein
        ausgewaehlt = 0;
        world = pWorld;
    }
    
    public void keyPressed (int pKeyCode)
    {
        switch (pKeyCode) {
            case 37: //Left
            laufen(3);
            break;
            case 38: //Up
            laufen(0);
            break;
            case 39: //Right
            laufen(1);
            break;
            case 40: //Down
            laufen(2);
            break;
            case 45: //-
            openInventory();
            break;
            case 65: //A
            laufen(3);
            break;
            case 68: //D
            laufen(1);
            break;
            case 69: //E
            openInventory();
            break;
            case 81: //Q
            handeln();
            break;
            case 83: //S
            laufen(2);
            break;
            case 87: //W
            laufen(0);
            break;
            case 97: //NumPad1
            handeln();
            break;
        }
    }
    
    /**
    * Spieler wird in Richtung pDirection um speed fortbewegt
    */
    public void laufen(int pDirection)
    {
        if(pDirection <= 4 && pDirection >= 0){
            direction = pDirection;
            switch (direction) {
                // Pfeil nach oben / w
                case 2:
                if(!world.checkObstacle(position.add(new Vector2(0, -speed))))
                {
                    //System.out.println(0);  
                    position=position.subtract(new Vector2(0, speed));
                }
                break;
                //Pfeil nach  rechts/ d
                case 3: 
                if(!world.checkObstacle(position.add(new Vector2(speed, 0))))
                {
                    position=position.add(new Vector2(speed, 0)); 
                }
                break;
                //Pfeil nach unten / s
                case 0:
                if(!world.checkObstacle(position.subtract(new Vector2(0, speed))))
                {
                    position=position.add(new Vector2(0, speed));
                }
                break;
                //Pfeil nach links / a
                case 1:
                if(!world.checkObstacle(position.subtract(new Vector2(speed, 0))))
                {
                    position=position.subtract(new Vector2(speed, 0));
                }
                break;
            } // end of switch
            saettigung -= 0.1;
            restoreHealth();
          
        }
        //System.out.println(position.getX()+ ","+  position.getY());  
    }
  
    //aktiviert durch linke Maustaste
    public void toolBenutzen(){
        if(inventar[ausgewaehlt] != null){
            if(inventar[ausgewaehlt].getClass() == CombatItem.class)
            {
                CombatItem tempCombat = (CombatItem) inventar[ausgewaehlt];
                if(tempCombat.getDurability() <=1){
                    inventar[ausgewaehlt] = null;
                    inventarCount[ausgewaehlt] = 0;
                }
                else{
                    tempCombat.setDurability(tempCombat.getDurability()-1);
                    inventar[ausgewaehlt] = (Item) tempCombat;
                }
            }
            else if(inventar[ausgewaehlt].getClass() == FoodItem.class){
                FoodItem tempFood = (FoodItem) inventar[ausgewaehlt];
                if(this.saettigung < 10){
                    if(inventarCount[ausgewaehlt] == 1){
                        inventar[ausgewaehlt]=null;
                        inventarCount[ausgewaehlt]=0;
                        saettigung += tempFood.getNaehrwert();                    
                    }
                    else{
                        inventarCount[ausgewaehlt] -= 1;
                        saettigung +=tempFood.getNaehrwert();
                    }
                    this.restoreHealth();
                }
            }
        }
    }
  
    public void handeln(){
        //ausgelöst NumPad1/q oder Maus?
        
    }
    
    public void openInventory(){
        //ausgelöst durch e/-
    }
       
    public void restoreHealth(){
        if(saettigung >=8 && health <= 8){
            saettigung -= 0.75;
            health += 1;
        }
    }
  
    //get-Methoden  
  
    public String getName()
    {return name;}
  
    public int getId()
    {return id;}
  
    public BufferedImage getTexture() 
    {return texture;}
  
    public Vector2 getPosition()
    {return position;}
  
    public int getPositionX()
    {return position.getX();}
  
    public int getPositionY()
    {return position.getY();}
  
    public int getDirection()
    {return direction;}
  
    public Item[] getInventar()
    {return inventar;}  
  
    public Item getInventar(int position){
        if (position<= 36 && position >= 0) {
            return inventar[position];
        }
        else{
            return null;
        }
    }

    public int[] getInventarCount()
    {
        return inventarCount;
    }
  
    public int getInventarCount(int position){
        if (position <= 36 && position >= 0) {
            return inventarCount[position];
        }
        else{
            return 0;
        }
    }
  
    public int getSpeed()
    {return speed;}
  
    public int getHealth()
    {return health;}
  
    public double getSaettigung()
    {return saettigung;}
  
    public long getMoney()
    {return money;}
  
    public int getAusgewaehlt()
    {return ausgewaehlt;}
  
    //set-Methoden
  
    public void setName(String pName)
    {name=pName;}
  
    public void setPosition(Vector2 pPosition)
    {position=pPosition;}
  
    public void setPositionX(int pPositionX)
    {position=new Vector2(pPositionX, position.getY());}
  
    public void setPositionY(int pPositionY)
    {position=new Vector2(position.getX(), pPositionY);}
  
    public void setDirection(int pDirection){
        if (pDirection<=3 && pDirection>=0){
            direction=pDirection;
        }
    }
  
    public void setSpeed(int pSpeed)
    {speed=pSpeed;}
  
    public void setHealth(int pHealth)
    {health=pHealth;}
  
    public void setMoney(long pMoney)
    {money=pMoney;}
  
    public void setAusgewaehlt(int pAusgewaehlt)
    {ausgewaehlt=pAusgewaehlt;}
}
