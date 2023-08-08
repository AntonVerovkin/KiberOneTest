import java.io.IOException;
import java.util.Scanner;

import com.google.common.math.Quantiles;
import org.example.commonfilemethods.CommonFileMethods;
import userpackage.User;

public class IOStreamtest {

    public static void main(String[] args) throws IOException {
        String filePath = "src/main/resources/dataFile.txt";
        Scanner scanner = new Scanner(System.in);
        System.out.println("vvedite");
        String name = scanner.nextLine();
        String age = scanner.nextLine();
        String hobby = scanner.nextLine();
        User user = new User(name, age, hobby);


        CommonFileMethods.serialize(user, filePath);


        User deserializedUser = CommonFileMethods.deserialize(filePath);
        if (deserializedUser != null) {
            System.out.println("Десериализованный пользователь:");
            System.out.println("Имя: " + deserializedUser.getName());
            System.out.println("Возраст: " + deserializedUser.getAge());
            System.out.println("Хобби: " + deserializedUser.getHobby());
        }
    }
}
