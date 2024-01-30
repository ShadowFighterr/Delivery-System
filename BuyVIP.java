import java.util.ArrayList;

class BuyVIP
{
    protected String ss = "You are VIP! Means for free.";
    public void Hor()
    {
        System.out.println("Hoooray!");
    }
}

class VIPuser extends BuyVIP
{
    BuyVIP v = new BuyVIP();
    public void maker(ArrayList<Integer> mg, int tot)
    {
        for(int i = 0; i < tot; i++)
        {
            mg.set(i, 0);
            v.Hor();
            System.out.println(v.ss);
        }
    }

}
