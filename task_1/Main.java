package Netology.Java_Core.Files.task_1;

public class Main {
    public static void main(String[] args) {
        FileManager installer = new FileManager();

        // Этап 1:
        installer.createDir("D:/Games/src");
        installer.createDir("D:/Games/res");
        installer.createDir("D:/Games/savegames");
        installer.createDir("D:/Games/temp");

        // Этап 2:
        installer.createDir("D:/Games/src/main");
        installer.createDir("D:/Games/src/test");

        // Этап 3:
        installer.createFile("D:/Games/src/main", "Main.java");
        installer.createFile("D:/Games/src/main", "Utils.java");

        // Этап 4:
        installer.createDir("D:/Games/res/drawables");
        installer.createDir("D:/Games/res/vectors");
        installer.createDir("D:/Games/res/icons");

        // Этап 5:
        installer.createFile("D:/Games/temp", "temp.txt");

        installer.writeLog();
    }
}