package Netology.Java_Core.Files.task_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameSaver {
    List<String> saveGamesPaths = new ArrayList<>();        // список строк путей к файлам сохранений

    public void saveGame(String path, GameProgress gameProgress) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameProgress);

            saveGamesPaths.add(path);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void zipFiles(String path, List<String> saveGamesPaths) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(path))) {
            for (String savedGame : saveGamesPaths) {
                // разбиваем строку на части по символу "/"
                String[] parts = savedGame.split("/");

                try (FileInputStream fis = new FileInputStream(savedGame)) {
                    ZipEntry entry = new ZipEntry(parts[parts.length - 1]);
                    zout.putNextEntry(entry);
                    // считываем содержимое файла в массив byte
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);

                    // добавляем содержимое к архиву
                    zout.write(buffer);
                    // закрываем текущую запись для новой записи
                    zout.closeEntry();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(String path) {
        try {
            File deletion = new File(path);
            if (deletion.delete())
                System.out.println("Файл " + deletion.getAbsolutePath() + " удалён");
            else
                System.out.println("Не получилось удалить " + deletion.getAbsolutePath());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}