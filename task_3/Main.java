package Netology.Java_Core.Files.task_3;

import Netology.Java_Core.Files.task_2.GameProgress;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {
    public static void main(String[] args) {

        openZip("D:/Games/savegames/zip_saves.zip", "D:/Games/savegames");

        openProgress("D:/Games/savegames/save2.dat");
    }

    public static void openZip(String pathToFile, String pathToUnzip) {
        try (ZipInputStream zin = new ZipInputStream(
                new FileInputStream(pathToFile))) {
            ZipEntry entry;
            String name;
            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName(); // получаем название файла
                // распаковка
                FileOutputStream fout = new FileOutputStream(pathToUnzip + "/" + name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void openProgress(String path) {
        GameProgress gameProgress = null;

        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            gameProgress = (GameProgress) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(gameProgress);
    }
}