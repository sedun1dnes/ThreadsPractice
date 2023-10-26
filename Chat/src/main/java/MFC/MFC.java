package MFC;

import java.util.Random;

public class MFC {
    public static void main(String[] args) throws InterruptedException {

        Window w1 = new Window("ANY");
        Window w2 = new Window("OLD");
        Window w3 = new Window("BUSINESSMAN");

        int id = 0;
        while (true){
            Person person = new Person(id++, ClientType.getRandom());
            System.out.println("Пришел клиент " + person.id + " из касты " + person.type);
            person.checkCompatibility(w1);
            person.checkCompatibility(w2);
            person.checkCompatibility(w3);
            Thread thread = new Thread(person);
            thread.start();
            Thread.sleep(new Random().nextInt(500));
        }
    }

}
