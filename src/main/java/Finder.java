import java.io.*;
import java.util.ArrayList;

class Finder {

    private static ArrayList<File> allFiles = new ArrayList<>();

    static ArrayList<File> find(File directoryName, boolean otherDirectories, String fileName) {
        allFiles.clear();
        return find2(directoryName, otherDirectories, fileName);
    }

    private static ArrayList<File> find2(File directoryName, boolean otherDirectories, String fileName) {
        File[] listFiles = directoryName.listFiles();
        assert listFiles != null;
        for (File dir : listFiles) {
            if (otherDirectories) {
                if (dir.isDirectory()) {
                    find2(dir, true, fileName);
                } else {
                    if (dir.getName().equals(fileName))
                        allFiles.add(dir);
                }
            } else {
                for (File dir2 : listFiles) {
                    if (dir2.getName().equals(fileName))
                        allFiles.add(dir);
                }
            }
        }
        return allFiles;
    }
}