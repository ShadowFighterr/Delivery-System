import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter item for order: ");
        String item = scanner.nextLine();

        System.out.print("Enter quantity for order: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline left by nextInt()

        Order order = new Order(item, quantity);

        System.out.print("Enter amount for investment: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left by nextDouble()

        System.out.print("Enter issue to report: ");
        String issue = scanner.nextLine();

        DeliverySystem deliverySystem = DeliverySystem.getInstance();

        deliverySystem.makeOrder(order);
        deliverySystem.investMoney(amount);
        deliverySystem.reportIssue(issue);

        System.out.println("All Orders: " + deliverySystem.getOrders());
        System.out.println("Total Investment: $" + deliverySystem.getTotalInvestment());
        System.out.println("Reported Issues: " + deliverySystem.getIssues());

        scanner.close();
    }
}
