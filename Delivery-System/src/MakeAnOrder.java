public class MakeAnOrder {
    public final int MAXN = 100000;
    private float Start_N, Start_W, End_N, End_W;
    public String[] product_size = new String[MAXN];
    public String[] transport = new String[MAXN];
    public int total_orders;
    public long[] total_money= new long[MAXN];
    public int[] coords = new int[MAXN];
    MakeAnOrder()
    {
        this.Start_N = 0;
        this.Start_W = 0;
        this.End_N = 0;
        this.End_W = 0;
        product_size[0] = "Undefined";
        total_orders = 0;
        transport[0] = "Undefined";
    }


    public void setCoordinates(int[] coordss, int i)
    {
        this.Start_N = coordss[i];
        this.Start_W = coordss[i+1];
        this.End_N = coordss[i+2];
        this.End_W = coordss[i+3];
    }
}
