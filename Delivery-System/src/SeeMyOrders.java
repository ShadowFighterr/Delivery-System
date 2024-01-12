public class SeeMyOrders
{
    MakeAnOrder mObj = new MakeAnOrder();
    ReportIssue rObj = new ReportIssue();
    InvestMoney iObj = new InvestMoney();
    public void dataAccess()
    {
        System.out.println("Here is your all data:\n");
        System.out.println("Your balance is: " + iObj.getMoney() + "$\n");
        if(mObj.total_orders != 0) {
            System.out.println("Total amount of orders: " + mObj.total_orders + "\nYour orders list:\n");
            for (int i = 0; i < mObj.total_orders; i++) {
                System.out.println("Order #" + i + "\nStart coordinates: ");
                System.out.println(mObj.coords[(i * 4)] + "N " + mObj.coords[(i * 4) + 1] + "W\n End coordinates: ");
                System.out.println(mObj.coords[(i * 4) + 2] + "N " + mObj.coords[(i * 4) + 3] + "W\n");
                System.out.println("Your product's size is: " + mObj.product_size[i]);
                System.out.println("The transport you chose to deliver the product: " + mObj.transport[i]);
                System.out.println("Total money spent to transport the product: " + mObj.total_money[i] + "\n");
            }
        }
        else System.out.println("You did not make any orders!");
        if(rObj.idxcounter != 0)
        {
            System.out.println("The issues which were provided by you:\n");
            rObj.issues_list();
        }
        else
            System.out.println("You have not made any doubt!\n");
    }
}
