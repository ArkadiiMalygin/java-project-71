package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "checkDiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App {
//    @Option(names = {"-V", "--version"}, description = "Print version information and exit.")
//    String version = "1.0";
//    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this welldone message and exit.")
//    private boolean helpRequsted = false;


    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
        System.out.println("Hello World");
    }
}
