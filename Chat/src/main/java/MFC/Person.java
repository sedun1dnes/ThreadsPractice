package MFC;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person implements Runnable{
    ClientType type;
    int id;
    List<Window> availableWindows;
    String status;
    @Override
    public void run(){
        for (Window window:availableWindows) {
            if (!Objects.equals(status, "Обслужен") && !Objects.equals(status, "Уходит")){
                try {
                    window.admitPerson(this);
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else Thread.currentThread().interrupt();
        }
    }
    public void setStatus(String status){
        this.status = status;
    }
    public Person(int id, String type){
        this.id = id;
        this.type = ClientType.valueOf(type);
        status = "Только пришел";
        availableWindows = new ArrayList<>();
    }
    public void addAvailableWindow(Window window){
        availableWindows.add(window);
    }
    public void windowIsNotAvailable(Window window){
        availableWindows.remove(window);
    }
    public boolean isThereAvailableWindows(){
        return !availableWindows.isEmpty();
    }
    public Window getNextWindow(){
        if (availableWindows.isEmpty()) { return null; }
        else return availableWindows.getFirst();
    }
    public void checkCompatibility(Window window){
        if (window.type == this.type || window.type == ClientType.ANY) {
            this.addAvailableWindow(window);
        }
    }
}
