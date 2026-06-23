public class Day15ex1 {
    static String[] items = {"Dosa!","Idly!","Vada!"};

    public static int nextOrderIndex = 0;

    public static final Object Lock = new Object();

    static void pickOrder(){
        String order;
        while (true) {
            synchronized(Lock){
                if(nextOrderIndex>=items.length){
                    return;
                }
                order = items[nextOrderIndex];
                nextOrderIndex++;
            }
            System.out.println(Thread.currentThread().getName()+" is preparing : "+order);
        }
    }
    static void main() throws InterruptedException {
        Thread chefOne = new Thread(() ->pickOrder(), "chef-one");
        Thread chefTwo = new Thread(() -> pickOrder(), "chef-two");

        chefOne.start();
        chefTwo.start();

        chefOne.join();
        chefTwo.join();
    }
}