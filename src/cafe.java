import java.util.*;
public class cafe {

    static class MenuItem {
        String id;
        String name;
        double price;

        MenuItem(String id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        static class Order {
            String orderId;
            String customerName;
            String menuId;
            int quantity;
            Stringn status;

            Order(String orderId, String customerName, String menuId, int quantity) {
                this.orderId = orderId;
                this.customerName = customerName;
                this.menuId = menuId;
                this.quantity = "CREATED";
            }
        }

        public static void main() {

            Scanner sc = new Scanner(System.in);

            HashMap<String, MenuItem> menu = new HashMap<>();
            HashMap<String, Order> orders = new HashMap<>();

            // Sample menu items
            menu.put("M1", new MenuItem("M1", "Snacks", 500));

            menu.put("M2", new MenuItem("M2", "Meals", 300));

            // Combo item
            menu.put("C1", new MenuItem("C1", "Dessrt", 800));

            while (true) {
                System.out.println("    MENU   ");
                System.out.println("1. Add Order");
                System.out.println("2. Calculate Bill");
                System.out.println("3. Update Status");
                System.out.println("4. Pending Orders");
                System.out.println("5. Total Sales");
                System.out.println("6. Exit");

                System.out.println("Choice");
                int choice = sc.nextInt();

                switch (choice){
                    case 1:
                        sc.nextInt(;

                        System.out.print("Order Id:");
                        String orderId = sc.nextLine();
                }
            }
        }
    }
}