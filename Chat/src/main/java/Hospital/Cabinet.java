package Hospital;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Cabinet {
    String name;
    Semaphore semaphore = new Semaphore(1);
    List<Person> queue;
    public Cabinet(String name){
        this.name = name;
        queue = new ArrayList<>();
    }
    public void personInQueue(Person person){
        queue.add(person);
        System.out.println("Размер очереди на " + this.name + ": " + this.queue.size());
    }
    public synchronized void admitPerson(Person person){
        try {
            semaphore.acquire();
            Thread.sleep(new Random().nextInt(2000));
            person.cabReady(this);
            semaphore.release();
            queue.remove(person);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
