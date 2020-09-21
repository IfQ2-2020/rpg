public class World
{
    private NPC[] npcs;
    private Spieler[] spieler;
    private Chunk[] loadedChunks;
    private boolean isRiver[][];
    private int width = 1600, height = 1600; 
    
    public World()
    {
        npcs = new NPC[32];
        spieler = new Spieler[8];
        loadedChunks = new Chunk[5];
        loadFirstChunks();
        flussGeneration();
    }
    
    private void loadFirstChunks(){
        loadedChunks[0] = new Chunk(null,new int[]{0,0}, true);
        loadedChunks[1] = new Chunk(new Chunk[]{null,null,null,loadedChunks[0]},
                                    new int[]{0,16}, false);
        loadedChunks[2] = new Chunk(new Chunk[]{null,null,loadedChunks[0],null},
                                    new int[]{-16,0}, false);
        loadedChunks[3] = new Chunk(new Chunk[]{null,loadedChunks[0],null,null},
                                    new int[]{16,0}, false); 
        loadedChunks[4] = new Chunk(new Chunk[]{loadedChunks[0],null,null,null},
                                    new int[]{0,-16}, false);                            
    }
    
    private boolean[][] flussGeneration(){
        boolean[][] ret = new boolean[height][width];
        
        for(int i = 0; i < height; ++i) {     // y
            for(int j = 0; j < width; ++j) {  // x
                double x = (double)j/((double)width);
                double y = (double)i/((double)height);
    
                // Typical Perlin noise
                double n = ImprovedNoise.noise(10 * x, 10 * y, 1);
                // Wood like structure
                n = n - Math.floor(n);
    
                if(n > 0.3 + 0.4 * distance_squared(i,j)){
                        ret[i][j] = false;        
                        //System.out.print(0);
                }else{
                        double a = ImprovedNoise.noise(10 * (x), 10 * (y-1/(double)width), 1);
                        double b = ImprovedNoise.noise(10 * (x-1/(double)width), 10 * (y), 1);
                        double c = ImprovedNoise.noise(10 * (x+1/(double)width), 10 * (y), 1);
                        double d = ImprovedNoise.noise(10 * (x), 10 * (y+1/(double)width), 1);
                        a = a - Math.floor(a); 
                        b = b - Math.floor(b); 
                        c = c - Math.floor(c); 
                        d = d - Math.floor(d); 
                              
                        if((a > 0.3 + 0.4 * distance_squared(i,j) && y != 0 )||
                              (b > 0.3 + 0.4 * distance_squared(i,j) && x != 0) ||
                              (c > 0.3 + 0.4 * distance_squared(i,j) && x != width-1 )||
                              (d > 0.3 + 0.4 * distance_squared(i,j) && y != height - 1))
                               {
                                   //System.out.print(1);
                                   ret[i][j] = true; }
                                else{
                                    ret[i][j] = false; 
                                    //System.out.print(0);
                                }
                        }
            }
            //System.out.println();
        }
        return ret;
    }
    
    public  float distance_squared(int x, int y){
        float dx = 2 * x / width - 1;
        float dy = 2 * y / height - 1;
        //at this point 0 <= dx <= 1 and 0 <= dy <= 1
        return dx*dx + dy*dy;
    } 
    
    public void drawWorld(){
        int[] position = spieler[0].getPosition();
        
        for(int i = 0; i< loadedChunks.length; i++){
            loadedChunks[i].drawChunk();
        }
    }
}
