/*public class Day7{
     class Request {
         String name;
         String date;
         String reason;
        Request(String name, String date, String reason) {
            this.name = name;
            this.date = date;
            this.reason = reason;
        }
        void displayDetails() {
            System.out.println("Name   : " + name);
            System.out.println("Date   : " + date);
            System.out.println("Reason : " + reason);
        }
        void approve() {
            System.out.println("Request Approved");
        }
        void reject() {
            System.out.println("Request Rejected");
        }
    }
     class LeaveRequest extends Request {
        LeaveRequest(String name, String date, String reason) {
            super(name, date, reason);
        }
        void applyLeave() {
            System.out.println("Leave Request");
        }
    }
     class OnDutyRequest extends Request {
        OnDutyRequest(String name, String date, String reason) {
            super(name, date, reason);
        }
        void applyOnDuty() {
            System.out.println("On-Duty Request");
        }
    }
    public  void main(String[] args) {
        LeaveRequest leave = new LeaveRequest(
                "Srinithi","12-06-2026","Fever");
        leave.applyLeave();
        leave.displayDetails();
        leave.approve();
        System.out.println();
        OnDutyRequest onDuty = new OnDutyRequest("Srinithi","15-06-2026","College Seminar");
        onDuty.applyOnDuty();
        onDuty.displayDetails();
        onDuty.reject();
    }
}*/
public class Day7 {
    class Payment {
        void transfer(double amount) {
            System.out.println("Processing payment" + amount);
        }
    }
    class UPIPayment extends Payment {
        void transfer(double amount) {
            System.out.println("UPI Payment: " + amount);
        }
    }
    class CardPayment extends Payment {
        void transfer(double amount) {
            System.out.println("Card Payment: " + amount);
        }
    }
    class NBPayment extends Payment {
        void transfer(double amount) {
            System.out.println("Net Banking Payment: " + amount);
        }
    }
    public void main(String[] args) {
        UPIPayment upi = new UPIPayment();
        upi.transfer(5000);
        CardPayment card = new CardPayment();
        card.transfer(2500);
        NBPayment nb = new NBPayment();
        nb.transfer(10000);
    }
}