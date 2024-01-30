import java.util.*;
import static java.lang.Math.abs;

public class ClientBase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MakeAnOrder mObj = new MakeAnOrder();
        ReportIssue rObj = new ReportIssue();
        InvestMoney iObj = new InvestMoney();
        while(true) {
            System.out.println("Enter the needed option by its index.");
            System.out.println("1.My account details.\n" + "2.Make an order.\n" + "3.Report issue.\n" +
                    "4.Fill my cash\n5.Turn off the system\n7.Buy VIP pass");
            short choice = sc.nextShort();
            switch (choice) {
                case 1:
                        System.out.println("Here is all your data:\n");
                        System.out.println("Your balance is: " + iObj.getMoney() + "$\n");
                        if(mObj.total_orders != 0) {
                            System.out.println("Total amount of orders: " + mObj.total_orders + "\n");
                            for(int i = 0; i < mObj.total_orders; i++) {
                                System.out.println("Order #" + (i) + "\nStart coordinates: ");
                                    System.out.println(mObj.coords[(i* 4)] + "N " + mObj.coords[(i * 4) + 1] + "W\n End coordinates: ");
                                    System.out.println(mObj.coords[(i * 4) + 2] + "N " + mObj.coords[(i * 4) + 3] + "W\n");
                                    System.out.println("Your product's size is: " + mObj.product_size[i]);
                                    System.out.println("The transport you chose to deliver the product: " + mObj.transport[i]);
                                    System.out.println("Total money spent to transport the product: " + mObj.total_money.get(i) + "\n");
                            }}
                        else System.out.println("You did not make any orders!");
                        if(rObj.idxcounter != 0)
                        {
                            System.out.println("The issues which were provided by you:\n");
                            rObj.issues_list();
                        }
                        else
                            System.out.println("You have not made any doubt!\n");
                    break;
                case 2:
                    System.out.println("Enter the start coordinates where the product must be " +
                            "taken and the end coordinates where it must be delivered.");
                    Scanner s = new Scanner(System.in);
                    for(int i = mObj.total_orders*4; i < (mObj.total_orders*4)+4; i++) mObj.coords[i] = s.nextInt();
                    System.out.println("Choose the size of your product measuring in meters per square: " +
                            "1.Short.(< 2 m^2.)" + "2.Middle.(>= 2 and < 4 m^2)" + "3.Large(>= 4 and <= 5 m^2)");
                    mObj.product_size[mObj.total_orders] = s.next();
                    long total_cost = 0;
                    if(mObj.product_size[mObj.total_orders] == "Short") total_cost+=5;
                    else if(mObj.product_size[mObj.total_orders] == "Middle") total_cost+=15;
                    else total_cost+=30;
                    System.out.println("Choose one of 3 transports by which " +
                            "your product will be transported: Car, Ship or Plane");
                    mObj.transport[mObj.total_orders] = s.next();
                    double distance;
                    distance = abs((mObj.coords[mObj.total_orders*4] + mObj.coords[(mObj.total_orders*4)+1] + mObj.coords[(mObj.total_orders*4)+2] + mObj.coords[(mObj.total_orders*4)+3]));
                    if(mObj.transport[mObj.total_orders] == "Car" || mObj.transport[mObj.total_orders] == "Ship")
                        total_cost+=((distance+1)*3);
                    else total_cost+=((distance+1)*5);
                    if(iObj.getMoney() - total_cost < 0)
                        System.out.println("The transaction is impossible, you don't have enough money in your balance");
                    else
                    {
                        System.out.println("The transaction has been made successfully!\n");
                        mObj.total_money.add((int) total_cost); mObj.total_orders++; mObj.setCoordinates(mObj.coords, mObj.total_orders);
                    }
                    break;
                case 3:
                    rObj.make_doubt();
                    break;
                case 4:
                    System.out.println("Enter the amount of money you want to fill your cash:");
                    long x = sc.nextLong();
                    iObj.setMoney(x);
                    System.out.println("Now your total amount of money is: " + iObj.getMoney() + "\n");
                    break;
                case 5:
                    return;
                case 7:
                    VIPuser vObj = new VIPuser();
                    vObj.maker(mObj.total_money, mObj.total_orders);
            }
            System.out.println("You can still see menu.\n");
        }
    }
}