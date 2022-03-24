import java.io.*;

public class Main {
    static String rootDirectory = "C:/Game/";
    static StringBuilder logCreateDirsAndFiles = new StringBuilder();

    public static void main(String[] args) {
        createDirectory("src");
        createDirectory("src/main");
        createFile("src/main/Main.java");
        createFile("src/main/Utils.java");
        createDirectory("src/test");
        createDirectory("res");
        createDirectory("res/drawables");
        createDirectory("res/vectors");
        createDirectory("res/icons");
        createDirectory("savegames");
        createDirectory("temp");
        createFile("temp/temp.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rootDirectory + "temp/temp.txt"))) {
            writer.write(logCreateDirsAndFiles.toString());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    static String logResult(Boolean done, File tipe, String name) {
        if (tipe.isDirectory()) {
            return done ? "Каталог " + name + " создан" : "Каталог " + name + " не создан";
        } else {
            return done ? "Файл " + name + " создан" : "Файл " + name + " не создан";
        }
    }

    static void createDirectory(String name) {
        File dir = new File(rootDirectory + name);
        logCreateDirsAndFiles.append(logResult(dir.mkdir(), dir, name)).append("\n");
    }

    static void createFile(String name) {
        File file = new File(rootDirectory + name);
        try {
            logCreateDirsAndFiles.append(logResult(file.createNewFile(), file, name)).append("\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
