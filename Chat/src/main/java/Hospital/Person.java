package Hospital;

public class Person implements Runnable{
    boolean flag;
    int id;
    Cabinet cab1, cab2;

    public Person(int id) {
        flag = false;
        this.id = id;
    }
    public void cabReady(Cabinet cab){
        flag = true;
        System.out.println("Пациент " + id + " прошел " + cab.name);
    }
    public void appointment(Cabinet cab1, Cabinet cab2){
        this.cab1 = cab1;
        cab1.personInQueue(this);
        this.cab2 = cab2;
        cab2.personInQueue(this);
    }
    @Override
    public void run(){
        cab1.admitPerson(this);
        if (flag) cab2.admitPerson(this);
    }
}
