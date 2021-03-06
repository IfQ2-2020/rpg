public class Vector2
{
    private int x;
    private int y;

    public Vector2(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    public int getArea() {
        return x * y;
    }

    public boolean equals(Vector2 b) {
        return this.getX() == b.getX() && this.getY() == b.getY();
    }

    public Vector2 add(Vector2 b) {
        return new Vector2(this.getX() + b.getX(),
            this.getY() + b.getY());
    }

    public Vector2 subtract(Vector2 b) {
        return new Vector2(this.getX() - b.getX(),
            this.getY() - b.getY());
    }
    
    public Vector2 divBy(int divisor) {
        return new Vector2(this.getX() / divisor,
            this.getY() / divisor);
    }
    
    public Vector2 multX(int a){
        return new Vector2(this.getX()*a,this.getY());
    }
}
