package Netology.Java_Core.Files.task_2;

import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        GameSaver gameSaver = new GameSaver();

        // 1. Создание сериализованных объектов:
        GameProgress save1 = new GameProgress(100, 1, 1, 0);
        GameProgress save2 = new GameProgress(90, 2, 2, 100);
        GameProgress save3 = new GameProgress(70, 3, 3, 200);

        // 2. Сохранение объектов на жёсткий диск:
        gameSaver.saveGame("D:/Games/savegames/save1.dat", save1);
        gameSaver.saveGame("D:/Games/savegames/save2.dat", save2);
        gameSaver.saveGame("D:/Games/savegames/save3.dat", save3);

        // 3. Архивация файлов:
        gameSaver.zipFiles("D:/Games/savegames/zip_saves.zip", gameSaver.saveGamesPaths);

        // 4. Удаление файлов вне архива:
        for (String file : gameSaver.saveGamesPaths) {
            gameSaver.delete(file);
        }
    }
}