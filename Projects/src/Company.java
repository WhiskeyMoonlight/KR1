import java.util.ArrayList;
import java.util.List;

public class Company {
    private String employee;
    private int salary;
    private int num;
    List <String> workers = new ArrayList<>();
    public void hire(String name){
        workers.add(name);
        num++;
    }
    public void hireAll(List <String> candidates){
        workers.addAll(candidates);
        num = workers.size();
    }

    public void fire(String name){
        workers.remove(name);
        num--;
    }

    public int getIncome(int money){
        salary = money * num;
        return salary;
    }
}
