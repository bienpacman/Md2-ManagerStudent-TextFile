import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ManagerStudent {
    ReaderAndWrite readerAndWrite = new ReaderAndWrite();
    List<Student> studentList = new ArrayList<>();
    List<ClassCG> classCGList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);


    ManagerStudent() {
        classCGList.add(new ClassCG("C097i7", new Date(), " Java", 28));
        classCGList.add(new ClassCG("C111i2", new Date(), "PHP", 21));
        studentList = readerAndWrite.reader((ArrayList<ClassCG>) classCGList);
    }

    public void menu() {
        System.out.println("_______Menu_______");
        System.out.println("1. Thêm học viên");
        System.out.println("2. Hiển thị học viên");
        System.out.println("3. Hiển thị học viên theo class");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                add();
                break;
            case 2:
                showAll();
                break;
            case 3:
                findAllByClass();
                break;

        }

    }


    public void add() {
        System.out.println("Nhập tên:");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số điện thoại");
        String numberPhone = scanner.nextLine();
        System.out.println("Nhập địa chỉ");
        String address = scanner.nextLine();

        System.out.println("Chọn lớp cho học viên :");
        for (int i = 0; i < classCGList.size(); i++) {
            System.out.println("     " + (i + 1) + " : " + classCGList.get(i).getName() + "-" + classCGList.get(i).getCourse());
        }
        int choice = Integer.parseInt(scanner.nextLine());
        Student student = new Student(name, age, numberPhone, address, classCGList.get(choice - 1));
        studentList.add(student);
        readerAndWrite.write((ArrayList<Student>) studentList);
    }

    public void showAll() {
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    public void findAllByClass() {
        System.out.println("Nhâp tên lớp muốn hiển thị :");
        String name = scanner.nextLine();
        for (Student s : studentList) {
            if (s.getClassCG().getName().equalsIgnoreCase(name)) {
                System.out.println(s);
            }
        }
    }
}
