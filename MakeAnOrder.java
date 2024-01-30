import java.util.ArrayList;
public class MakeAnOrder {
    public final int MAXN = 100000;
    private float Start_N, Start_W, End_N, End_W;
    public String[] product_size = new String[MAXN];
    public String[] transport = new String[MAXN];

    public long[]   zz = new long[MAXN];

    public int total_orders;
    public ArrayList<Integer> total_money = new ArrayList<Integer>(MAXN);
    public int[] coords = new int[MAXN];
    MakeAnOrder()
    {
        this.Start_N = 0;
        this.Start_W = 0;
        this.End_N = 0;
        this.End_W = 0;
        product_size[0] = "Undefined";
        total_orders = 0;
    }

    public int met(int gg) {
//        if(int gg, )
//        {
//        for(int i = x; i < j; i++)
//        {
//            zz[i] = zz[i+1];
//            pp[i] = pp[i+1];
//            m[(i*4)] = m[(i*4)+4];
//            m[(i*4)+1] = m[(i*4)+4];
//            m[(i*4)+2] = m[(i*4)+5];
//            m[(i*4)+3] = m[(i*4)+6];
//        }
//        }
        gg--;
        return gg;
    }
    public void setCoordinates(int[] coordss, int i)
    {
        this.Start_N = coordss[i];
        this.Start_W = coordss[i+1];
        this.End_N = coordss[i+2];
        this.End_W = coordss[i+3];
    }
}
