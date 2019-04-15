import java.io.*;
import java.util.ArrayList;

class Finder {

    private static ArrayList<File> allFiles = new ArrayList<>();

    static ArrayList<File> find(File directoryName, boolean otherDirectories, String fileName) {
        allFiles.clear();

        if (otherDirectories) return findRecursive(directoryName, fileName);
        else return findNotRecursive(directoryName, fileName);
    }

    private static ArrayList<File> findRecursive(File directoryName, String fileName) {
        File[] listFiles = directoryName.listFiles();

        assert listFiles != null;
        for (File dir : listFiles) {
            if (dir.isDirectory()) {
                findRecursive(dir, fileName);
            } else {
                if (dir.getName().equals(fileName))
                    allFiles.add(dir);
            }
        }

        return allFiles;
    }

    private static ArrayList<File> findNotRecursive(File directoryName, String fileName) {
        File[] listFiles = directoryName.listFiles();

        assert listFiles != null;
        for (File dir : listFiles) {
            if (dir.getName().equals(fileName))
                allFiles.add(dir);
        }

        return allFiles;
    }
}