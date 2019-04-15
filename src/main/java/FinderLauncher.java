import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.*;

public class FinderLauncher {

    @Option(name = "-r", usage = "Find inside this directory")
    private boolean otherDirectories;

    @Option(name = "-d", usage = "Directory")
    private String directoryName;

    @Argument(required = true, usage = "Input file name")
    private String fileName;

    public static void main(String[] args) {
        new FinderLauncher().launch(args);
    }

    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        }
        catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("find [-r] [-d directory] filename.txt");
            parser.printUsage(System.err);
        }

        Finder finder = new Finder();
        System.out.println(finder.find(new File(directoryName), otherDirectories, fileName));
    }
}