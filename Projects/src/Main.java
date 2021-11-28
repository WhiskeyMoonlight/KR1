import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {



        Scanner sc = new Scanner(System.in);
        Company Apple = new Company();
        boolean running = true;
        String command;
        List<String> candidates = new ArrayList();
        List<String> employees = new ArrayList();
        System.out.println("\n_______________Итак, начнём работу!_______________");
        System.out.println("Введите одну из следующих команд для работы со списком кандидатов:");
        System.out.println("\tADD - добавить кандидата - Введите его имя");
        System.out.println("\tREMOVE - убрать кандидата - Введите его номер в списке");
        System.out.println("\tLIST - вывести список кандидатов");
        System.out.println("\tSTOP -  завершить работу со списком кандидатов");
        System.out.println("А дальше - будем трудоустраивать и увольнять");

        do {
            command = sc.next();

            switch (command) {

                case "ADD":

                    candidates.add(sc.next());

                    break;


                case "REMOVE":

                    int index;

                    do {
                        index = sc.nextInt() - 1;

                        if (index >= 0 && index < candidates.size()) {
                            System.out.println("Вы удалили кандидата " + candidates.get(index));
                            candidates.remove(index);
                        } else {
                            System.out.println("Кандидата с таким номером нет");
                        }

                    } while ((index >= 0 && index < candidates.size()));


                    break;

                    case "LIST":

                    if (!candidates.isEmpty()) {
                        for (int i = 0; i < candidates.size(); i++) {
                            System.out.println(i + 1 + ". " + candidates.get(i));
                        }
                    } else {
                        System.out.println("Список кандидатов пуст");
                    }

                    break;

                case "STOP":
                    running = false;
                    break;

                default:
                    System.out.println("Вы где-то ошиблись, такой команды нет");
            }
        }while (running);


       System.out.println("_________________________________________________");

        if(!candidates.isEmpty()){
            System.out.println("\n\tЗдорово, Вы закончили работу с кандидатами, вот они:\n");
            for (int i = 0; i < candidates.size(); i++) {
                System.out.println(i + 1 + ". " + candidates.get(i));
            }
            System.out.println("\n\tВыберите действие:");
            System.out.println("HIRE - нанять одного кандидата");
            System.out.println("HIREALL- нанять всех");
            System.out.println("FIRE - уволить работника");
            System.out.println("INCOME - вывести доход компании");
            System.out.println("STOP - завершение работы");
            String com;
            running = true;
            int id, money, n;
            String name;
            do {
                com = sc.next();
                switch (com) {
                    case "HIRE":
                        System.out.println("Введите номер работника из списка");
                            id = sc.nextInt()-1;
                            name = candidates.get(id);
                            Apple.hire(name);
                            candidates.remove(id);
                        System.out.println("Вы наняли " + name);
                        System.out.println("Теперь список кандидатов выглядит так:");
                        if (!candidates.isEmpty()) {
                            for (int i = 0; i < candidates.size(); i++) {
                                System.out.println(i + 1 + ". " + candidates.get(i));
                            }
                        } else {
                            System.out.println("Список кандидатов пуст");
                        }
                        break;

                    case "HIREALL":
                        if (!candidates.isEmpty()) {
                               Apple.hireAll(candidates);
                            System.out.println("Вы трудоустроили всех кандидатов");
                        } else {
                            System.out.println("Список кандидатов пуст");
                        }
                        break;

                    case "FIRE":
                        if (!Apple.workers.isEmpty()) {
                            System.out.println("Введите номер рабочего, которого хотите уволить");
                            id = sc.nextInt() - 1;
                            name = Apple.workers.get(id);
                            System.out.println("Вы удалили работника " + name);
                            Apple.fire(name);
                        } else System.out.println("Вам некого увольнять!");

                        break;

                    case "GETINCOME":
                        System.out.println("Сколько зарабатывает один сотрудник?");
                        money = sc.nextInt();
                        n = Apple.getIncome(money);
                        System.out.println("Вы заработаете " +n + " на данном этапе");
                        break;

                    case "STOP":
                            running = false;
                    break;

                    default:
                        System.out.println("Такой команды нет");
                }
            } while(running);


        } else{
            System.out.println("Список кандидатов пуст - видимо, никто не подошёл");
            System.out.println("Чтож, тогда увидимся в следующий раз!");

        }
        System.out.println("Итак, вот штат сотрудников:");
        if (!Apple.workers.isEmpty()) {
            for (int i = 0; i < Apple.workers.size(); i++) {
                System.out.println(i + 1 + ". " + Apple.workers.get(i));
            }
        } else {
            System.out.println("Пусто, вы никого не устроили");
        }
        System.out.println("\nРабота программы завершена");
    }
}
