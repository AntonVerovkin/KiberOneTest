package org.example.commonfilemethods;

import userpackage.User;

import java.io.*;

public class CommonFileMethods {

    public static void serialize(User user, String filePath) throws IOException {
        File outputFile = new File(filePath);
        if (!outputFile.exists()){
            outputFile.createNewFile();
        }

        BufferedWriter filterWriter = new BufferedWriter(new FileWriter(outputFile));

        filterWriter.write("Name: " + user.getName());
        filterWriter.newLine();
        filterWriter.write("Возраст: " + user.getAge());
        filterWriter.newLine();
        filterWriter.write("Хобби: " + user.getHobby());

        filterWriter.flush();
        filterWriter.close();
    }

    public static User deserialize(String filePath) throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            BufferedReader fileReader = new BufferedReader(new FileReader(file));

            String name = null;
            String age = null;
            String hobby = null;

            String line;
            while ((line = fileReader.readLine()) != null) {
                if (line.startsWith("Name: ")) {
                    name = line.substring("Name: ".length());
                } else if (line.startsWith("Возраст: ")) {
                    age = line.substring("Возраст: ".length());
                } else if (line.startsWith("Хобби: ")) {
                    hobby = line.substring("Хобби: ".length());
                }
            }

            fileReader.close();

            if (name != null && hobby != null) {
                return new User(name, age, hobby);
            }
        }

        return null;
    }


}
