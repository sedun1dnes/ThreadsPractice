package MFC;

import java.util.List;
import java.util.Random;

public enum ClientType {
    YOUNG("Молодые"),
    OLD("Пожилые"),
    BUSINESSMAN("Бизнесмены"),
    ANY("Любой");

    String name;
    ClientType(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        return this.name;
    }
    public static String getRandom(){
        String[] pool = {"YOUNG", "OLD", "BUSINESSMAN"};
        return pool[new Random().nextInt(3)];
    }
}
