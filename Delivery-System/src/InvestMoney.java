public class InvestMoney {
    private long balance;
    InvestMoney()
    {
        this.balance = 0;
    }
    public long getMoney()
    {
        return this.balance;
    }
    public void setMoney(long money_amount)
    {
        this.balance+= money_amount;
    }

}
