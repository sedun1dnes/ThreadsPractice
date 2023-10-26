package MFC;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Window {
    ClientType type;
    boolean busy;

    public Window(String type){
        this.type = ClientType.valueOf(type);
        busy = false;
    }
    public synchronized void admitPerson(Person person) throws InterruptedException {
        if (!busy){
            busy = true;
            Thread.sleep(new Random().nextInt(2000));
            person.setStatus("Обслужен");
            System.out.println("Клиент " + person.id + " теперь имеет статус: " + person.status);
            busy = false;
        }
        else if (person.isThereAvailableWindows()){
            System.out.println("Клиент " + person.id + " пытается в другое окно");
            person.windowIsNotAvailable(this);
            person.getNextWindow().admitPerson(person);
        }
        else {
            person.windowIsNotAvailable(this);
            person.setStatus("Уходит");
            System.out.println("Клиент " + person.id + " теперь имеет статус: " + person.status);
        }
    }
}


