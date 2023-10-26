package Hospital;

import java.util.*;

public class Hospital {
    public static void main(String[] args) throws InterruptedException {

        Cabinet checkUp = new Cabinet("чек-ап у терапевта");
        Cabinet mrt = new Cabinet("МРТ");

        int id = 0;
        while (true){
            Person person = new Person(id++);
            person.appointment(checkUp, mrt);
            Thread thread = new Thread(person);
            thread.start();
            Thread.sleep(new Random().nextInt(2000));
        }
    }
}
