import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Puppy dog = enterPuppy();

        dog.showName();
        dog.barkPuppy();
        dog.bitePuppy();
        dog.jumpPuppy();
        dog.runBall();
    }
    public static Puppy enterPuppy(){
        Scanner scan = new Scanner(System.in);
        String name, breed, color;
        int age;

        try {
            System.out.print("Введите имя собаки: ");
            while (!scan.hasNextLine() && !scan.next().isEmpty()) {
                System.out.println("Повторите ввод");
                scan.next();
            }
            name = scan.nextLine();

            System.out.print("Введите породу собаки: ");
            while (!scan.hasNextLine() && !scan.hasNext("")) {
                System.out.println("Повторите ввод");
                scan.next();
            }
            breed = scan.nextLine();

            System.out.print("Введите цвет собаки: ");
            while (!scan.hasNextLine() && !scan.next().isEmpty()) {
                System.out.println("Повторите ввод");
                scan.next();
            }
            color = scan.nextLine();

            System.out.print("Введите возраст щенка: ");
            while (!scan.hasNextInt()) {
                System.out.println("Повторите ввод");
                scan.next();
            }
            age = scan.nextInt();
            Puppy spyke = new Puppy(name, age, breed, color);
            return spyke;
        } catch (InputMismatchException e){
            System.out.println("Ошибка: " + e + "\n Перезапустите программу");
        }
        return null;
    }
}

class Animal{
    String name = "empty";
    int age = 0;


    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void showName (){
        System.out.println("Имя животного: " + name + "\nВозраст животного: " + age);
    }
}

class Puppy extends Animal {
    String breed = "empty";
    String color = "empty";

    public Puppy(String name, int age, String breed, String color) {
        super(name, age);

        this.breed = breed;
        this.color = color;
    }

    public void showName(){
        System.out.println("Щенка зовут: " + name + "\nЕго возраст: " + age + "мес." + "\nПорода щенка: " + breed);
    }

    public void runBall(){
        System.out.println("Щенок " + name + " побежал за мячиком");
    }
    public void barkPuppy(){
        System.out.println("Щенок " + name + " пискляво лаит");
    }
    public void jumpPuppy(){
        System.out.println("Щенок " + name + " разбежавшись, прыгнул за палкой ");
    }
    public void bitePuppy(){
        System.out.println("Щенок " + name + " начал кусать тапки");
    }
}
