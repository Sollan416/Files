package Netology.Java_Core.Files.task_1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class FileManager {
    private String messageToLog;

    private final String logFilePath = "D:/Games/temp/temp.txt";

    private StringBuilder log = new StringBuilder();

    public void log() {
        log.append("#").append(LocalDateTime.now()).append(" ").append(messageToLog).append(" ").append("\n");
    }


    public void writeLog() {
        try (FileWriter writer = new FileWriter(logFilePath, true)) {

            writer.write(log.toString());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void createDir(String path) {
        File newDir = new File(path);

        if (newDir.mkdir())
            messageToLog = "Создана папка " + path;
        else
            messageToLog = "Не получилось создать папку " + path;

        log();
    }

    public void createFile(String path, String name) {
        File newFile = new File(path, name);

        try {
            if (newFile.createNewFile())
                messageToLog = "Cоздан файл " + name + " в " + path;
            else
                messageToLog = "Не получилось создать файл " + name + " в " + path;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        log();
    }
}