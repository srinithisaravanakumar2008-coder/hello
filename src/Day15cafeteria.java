import java.util.*;

public class Day15cafe {

    static class MenuItem {
        String id;
        String name;
        double price;

        MenuItem(String id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }

    static class Order {
        String orderId;
        String customerName;
        String menuId;
        int quantity;
        String status;

        Order(String orderId, String customerName, String menuId, int quantity) {

            this.orderId = orderId;
            this.customerName = customerName;
            this.menuId = menuId;
            this.quantity = quantity;
            this.status = "CREATED";
        }
    }

    public static void main() {

        Scanner sc = new Scanner(System.in);

        HashMap<String, MenuItem> menu = new HashMap<>();
        HashMap<String, Order> orders = new HashMap<>();

        // Sample menu items
        menu.put("M1",new MenuItem("M1", "Candidate Starter Kit", 500));

        menu.put("M2",new MenuItem("M2", "Banner Promotion Pack",300));

        // Combo item
        menu.put("C1",new MenuItem("C1","Campaign Bundle",800));

        while (true) {
            System.out.println("\n MENU ");
            System.out.println("1. Add Order");
            System.out.println("2. Calculate Bill");
            System.out.println("3. Update Status");
            System.out.println("4. Pending Orders");
            System.out.println("5. Total Sales");
            System.out.println("6. Exit");

            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    sc.nextLine();

                    System.out.print("Order ID: ");
                    String orderId = sc.nextLine();

                    if (orders.containsKey(orderId)) {
                        System.out.println("Duplicate Order ID");
                        break;
                    }

                    System.out.print("Coordinator Name: ");
                    String customer = sc.nextLine();

                    System.out.print("Menu ID (M1/M2/C1): ");
                    String menuId = sc.nextLine();

                    if (!menu.containsKey(menuId)) {
                        System.out.println("Invalid Menu ID");
                        break;
                    }

                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();

                    if (qty <= 0) {System.out.println("Invalid Quantity");
                        break;
                    }

                    Order order = new Order(orderId,customer,menuId,qty);
                    orders.put(orderId, order);

                    System.out.println("Order Added");
                    break;

                case 2:

                    sc.nextLine();

                    System.out.print("Order ID: ");
                    String oid = sc.nextLine();

                    if (!orders.containsKey(oid)) {
                        System.out.println("Order Not Found");
                        break;
                    }

                    Order o = orders.get(oid);
                    double bill = menu.get(o.menuId).price * o.quantity;

                    System.out.println("Bill = ₹" + bill);
                    break;
                case 3:
                    sc.nextLine();
                    System.out.print("Order ID: ");
                    String id = sc.nextLine();
                    if (!orders.containsKey(id)) {
                        System.out.println("Order Not Found");
                        break;
                    }
                    System.out.print("New Status: ");
                    String status = sc.nextLine();
                    orders.get(id).status = status;
                    System.out.println("Status Updated");
                    break;
                case 4:
                    System.out.println("\nPending Orders");
                    for (Order ord : orders.values()) {
                        if (!ord.status.equalsIgnoreCase("COMPLETED")) {
                            System.out.println(ord.orderId + " - " + ord.customerName + " - " + ord.status);
                        }
                    }
                    break;
                case 5:
                    double totalSales = 0;
                    for (Order ord : orders.values()) {
                        if (ord.status.equalsIgnoreCase("COMPLETED")) {
                            totalSales += menu.get(ord.menuId).price * ord.quantity;
                        }
                    }
                    System.out.println("Total Sales = ₹" + totalSales);
                    break;
                case 6:
                    System.out.println("Program Ended");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}*