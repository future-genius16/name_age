import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class names_age {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать! Давайте я узнаю Ваш пол, пропишу ФИО инициалами и рассчитаю возраст!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фамилию на русском языке:");
        String lastname = scanner.nextLine();
        System.out.println("Введите имя на русском языке:");
        String name = scanner.nextLine();
        System.out.println("Введите отчество на русском языке:");
        String otches = scanner.nextLine();
        System.out.println("Введите дату рождения в формате ДД-ММ-ГГГГ:");
        String birthdatestr = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthdate = LocalDate.parse(birthdatestr, formatter);

        char genderch = otches.charAt(otches.length() - 1);
        String gender = (genderch == 'а') ? "женщина" : "мужчина";

        long age = ChronoUnit.YEARS.between(birthdate, LocalDate.now());
        String ageend;
        int last = (int) (age % 10);
        if (last == 1) {
            ageend = "год";
        } else if (last >= 2 && last <= 4) {
            ageend = "года";
        } else {
            ageend = "лет";
        }

        System.out.println("Фамилия и инициалы: " + lastname.substring(0,1).toUpperCase()+lastname.substring(1) + " " + Character.toUpperCase(name.charAt(0)) + ". " + Character.toUpperCase(otches.charAt(0)) + ".");
        System.out.println("Пол: " + gender);
        System.out.println("Возраст: " + age + " " + ageend);
        scanner.close();
    }
}
