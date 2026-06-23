import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CafeteriaSolution {
    enum FoodCategory {
        BEVERAGE, SNACK, MEAL, DESSERT
    }

    enum OrderStatus {
        CREATED, PREPARING, COMPLETED, CANCELLED, REJECTED
    }

    interface MenuComponent {
        String id();
        String name();
        double price();
    }

    record MenuItem(String id, String name, FoodCategory category, double price) implements MenuComponent {
    }

    static class MealCombo implements MenuComponent {
        private final String id;
        private final String name;
        private final List<MenuComponent> items = new ArrayList<>();

        MealCombo(String id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String id() {
            return id;
        }

        @Override
        public String name() {
            return name;
        }

        @Override
        public double price() {
            return items.stream().mapToDouble(MenuComponent::price).sum();
        }

        List<MenuComponent> getItems() {
            return items;
        }

        void addItem(MenuComponent item) {
            items.add(item);
        }
    }

    record OrderLine(String menuId, int quantity) {
    }

    static class Day15cafe {
        private final String orderId;
        private final String customerName;
        private final List<OrderLine> orderLines = new ArrayList<>();
        private OrderStatus status;

        CustomerOrder(String orderId, String customerName) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.status = OrderStatus.CREATED;
        }

        String getOrderId() {
            return orderId;
        }

        String getCustomerName() {
            return customerName;
        }

        List<OrderLine> getOrderLines() {
            return orderLines;
        }

        OrderStatus getStatus() {
            return status;
        }

        void setStatus(OrderStatus status) {
            this.status = status;
        }
    }

    static class InvalidOrderException extends RuntimeException {
        InvalidOrderException(String message) {
            super(message);
        }
    }

    static class CafeteriaManager {
        private final Map<String, MenuComponent> menuById = new HashMap<>();
        private final Map<String, CustomerOrder> ordersById = new HashMap<>();

        void addMenuComponent(MenuComponent component) {
            if (menuById.containsKey(component.id())) {
                throw new InvalidOrderException("Duplicate menu ID: " + component.id());
            }
            if (component.price() < 0) {
                throw new InvalidOrderException("Price cannot be negative");
            }
            menuById.put(component.id(), component);
        }

        void addOrder(CustomerOrder order) {
            if (ordersById.containsKey(order.getOrderId())) {
                throw new InvalidOrderException("Duplicate order ID: " + order.getOrderId());
            }
            if (order.getOrderLines().isEmpty()) {
                throw new InvalidOrderException("Order must contain at least one line");
            }
            for (OrderLine line : order.getOrderLines()) {
                if (!menuById.containsKey(line.menuId())) {
                    throw new InvalidOrderException("Menu item not found: " + line.menuId());
                }
                if (line.quantity() <= 0) {
                    throw new InvalidOrderException("Quantity must be positive");
                }
            }
            ordersById.put(order.getOrderId(), order);
        }

        double calculateBill(String orderId) {
            CustomerOrder order = getOrderOrThrow(orderId);
            return order.getOrderLines().stream()
                    .mapToDouble(line -> menuById.get(line.menuId()).price() * line.quantity())
                    .sum();
        }

        void updateOrderStatus(String orderId, OrderStatus status) {
            CustomerOrder order = getOrderOrThrow(orderId);
            if (order.getStatus() == OrderStatus.CANCELLED || order.getStatus() == OrderStatus.REJECTED) {
                throw new InvalidOrderException("Closed orders cannot move to another state");
            }
            order.setStatus(status);
        }

        List<CustomerOrder> findPendingOrders() {
            return ordersById.values().stream()
                    .filter(order -> order.getStatus() == OrderStatus.CREATED || order.getStatus() == OrderStatus.PREPARING)
                    .sorted(Comparator.comparing(CustomerOrder::getOrderId))
                    .toList();
        }

        Map<String, Long> countMenuUsage() {
            Map<String, Long> usage = new LinkedHashMap<>();
            for (CustomerOrder order : ordersById.values()) {
                for (OrderLine line : order.getOrderLines()) {
                    usage.merge(line.menuId(), (long) line.quantity(), Long::sum);
                }
            }
            return usage;
        }

        double totalSales() {
            return ordersById.values().stream()
                    .filter(order -> order.getStatus() != OrderStatus.CANCELLED && order.getStatus() != OrderStatus.REJECTED)
                    .mapToDouble(order -> calculateBill(order.getOrderId()))
                    .sum();
        }

        void saveData(Path directory) throws IOException {
            Files.createDirectories(directory);

            List<String> menuLines = new ArrayList<>();
            for (MenuComponent component : menuById.values()) {
                if (component instanceof MenuItem item) {
                    menuLines.add("ITEM," + item.id() + "," + item.name() + "," + item.category() + "," + item.price());
                } else if (component instanceof MealCombo combo) {
                    String childIds = combo.getItems().stream().map(MenuComponent::id).collect(Collectors.joining(">"));
                    menuLines.add("COMBO," + combo.id() + "," + combo.name() + "," + combo.price() + "," + childIds);
                }
            }
            Files.write(directory.resolve("menu.csv"), menuLines);

            List<String> orderLines = new ArrayList<>();
            for (CustomerOrder order : ordersById.values()) {
                String lineItems = order.getOrderLines().stream()
                        .map(line -> line.menuId() + ":" + line.quantity())
                        .collect(Collectors.joining(">"));
                orderLines.add(order.getOrderId() + "," + order.getCustomerName() + "," + order.getStatus() + "," + lineItems);
            }
            Files.write(directory.resolve("orders.csv"), orderLines);
        }

        void loadData(Path directory) throws IOException {
            menuById.clear();
            ordersById.clear();

            Path menuFile = directory.resolve("menu.csv");
            Map<String, String[]> deferredCombos = new HashMap<>();
            if (Files.exists(menuFile)) {
                for (String line : Files.readAllLines(menuFile)) {
                    String[] parts = line.split(",", 5);
                    if (parts.length < 5) {
                        continue;
                    }

                    if ("ITEM".equals(parts[0])) {
                        addMenuComponent(new MenuItem(parts[1], parts[2], FoodCategory.valueOf(parts[3]),
                                Double.parseDouble(parts[4])));
                    } else if ("COMBO".equals(parts[0])) {
                        deferredCombos.put(parts[1], parts);
                    }
                }
            }

            for (String[] parts : deferredCombos.values()) {
                MealCombo combo = new MealCombo(parts[1], parts[2]);
                for (String childId : parts[4].split(">")) {
                    MenuComponent child = menuById.get(childId);
                    if (child != null) {
                        combo.addItem(child);
                    }
                }
                addMenuComponent(combo);
            }

            Path orderFile = directory.resolve("orders.csv");
            if (Files.exists(orderFile)) {
                for (String line : Files.readAllLines(orderFile)) {
                    String[] parts = line.split(",", 4);
                    if (parts.length != 4) {
                        continue;
                    }
                    CustomerOrder order = new CustomerOrder(parts[0], parts[1]);
                    order.setStatus(OrderStatus.valueOf(parts[2]));
                    if (!parts[3].isBlank()) {
                        for (String token : parts[3].split(">")) {
                            String[] lineParts = token.split(":");
                            if (lineParts.length == 2) {
                                order.getOrderLines().add(new OrderLine(lineParts[0], Integer.parseInt(lineParts[1])));
                            }
                        }
                    }
                    ordersById.put(order.getOrderId(), order);
                }
            }
        }

        private CustomerOrder getOrderOrThrow(String orderId) {
            CustomerOrder order = ordersById.get(orderId);
            if (order == null) {
                throw new InvalidOrderException("Order not found: " + orderId);
            }
            return order;
        }
    }

    public static void main(String[] args) throws Exception {
        CafeteriaManager manager = new CafeteriaManager();

        MenuItem tea = new MenuItem("I001", "Tea", FoodCategory.BEVERAGE, 12.0);
        MenuItem sandwich = new MenuItem("I002", "Sandwich", FoodCategory.SNACK, 35.0);
        MenuItem brownie = new MenuItem("I003", "Brownie", FoodCategory.DESSERT, 28.0);
        MenuItem riceBowl = new MenuItem("I004", "Rice Bowl", FoodCategory.MEAL, 65.0);

        manager.addMenuComponent(tea);
        manager.addMenuComponent(sandwich);
        manager.addMenuComponent(brownie);
        manager.addMenuComponent(riceBowl);

        MealCombo combo = new MealCombo("C001", "Tea and Snack Combo");
        combo.addItem(tea);
        combo.addItem(sandwich);
        manager.addMenuComponent(combo);

        CustomerOrder order1 = new CustomerOrder("O001", "Asha");
        order1.getOrderLines().add(new OrderLine("C001", 1));
        order1.getOrderLines().add(new OrderLine("I003", 2));
        manager.addOrder(order1);

        CustomerOrder order2 = new CustomerOrder("O002", "Bharath");
        order2.getOrderLines().add(new OrderLine("I004", 1));
        order2.getOrderLines().add(new OrderLine("I001", 1));
        manager.addOrder(order2);

        manager.updateOrderStatus("O001", OrderStatus.PREPARING);
        manager.updateOrderStatus("O002", OrderStatus.COMPLETED);

        System.out.println("Bills:");
        System.out.println("O001 -> " + manager.calculateBill("O001"));
        System.out.println("O002 -> " + manager.calculateBill("O002"));

        System.out.println("\nPending orders:");
        for (CustomerOrder order : manager.findPendingOrders()) {
            System.out.println(order.getOrderId() + " -> " + order.getStatus());
        }

        System.out.println("\nMenu usage summary:");
        manager.countMenuUsage().forEach((menuId, count) ->
                System.out.println(menuId + " -> " + count));

        System.out.println("\nTotal sales:");
        System.out.println(manager.totalSales());

        Path outputDir = Path.of("capstone", "generated_cafeteria_data");
        manager.saveData(outputDir);

        CafeteriaManager reloaded = new CafeteriaManager();
        reloaded.loadData(outputDir);

        System.out.println("\nReloaded total sales:");
        System.out.println(reloaded.totalSales());
    }
}