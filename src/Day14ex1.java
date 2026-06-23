public class Day14ex1 {
    interface  Notification{
        void send(String to,String message);
    }
    class EmailNotification implements Notification{

        @Override
        public void send(String to, String message) {
            System.out.println("Sending Email: "+message +", to "+to);
        }
    }
    class WhatsappNotification implements Notification{

        @Override
        public void send(String to, String message) {
             System.out.println("Sending Whatsapp: "+message +", to "+to);
        }
    }
    static Notification getNotification(Day14ex1 sms,String type){
        return switch (type){
            case "Email"-> sms.new EmailNotification();
            case "Whatsapp"->sms.new WhatsappNotification();
            default ->throw new IllegalArgumentException("Invalid notification type: "+type);
        };
    }
    static void main() {
        Day14ex1 sms = new Day14ex1();

        String type = "Whatsapp";
        getNotification(sms, type).send("9876543210","How are you ?");
    }
}
