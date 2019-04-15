import java.io.*;
import java.util.ArrayList;

class Finder {

    private ArrayList<File> allFiles = new ArrayList<>();

    ArrayList<File> find(File directoryName, boolean otherDirectories, String fileName) {
        if (otherDirectories) return findRecursive(directoryName, fileName);
        else return findNotRecursive(directoryName, fileName);
    }

    private ArrayList<File> findRecursive(File directoryName, String fileName) {
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

    private ArrayList<File> findNotRecursive(File directoryName, String fileName) {
        File[] listFiles = directoryName.listFiles();

        assert listFiles != null;
        for (File dir : listFiles) {
            if (dir.getName().equals(fileName))
                allFiles.add(dir);
        }

        return allFiles;
    }
}