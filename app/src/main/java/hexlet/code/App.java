package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "checkDiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {
//    @Option(names = {"-V", "--version"}, description = "Print version information and exit.")
//    String version = "1.0";
//    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this welldone message and exit.")
//    private boolean helpRequsted = false;
    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]", defaultValue = "stylish")
    String format;

    @Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    String filepath1;
    @Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    String filepath2;

    @Override
    public Integer call() throws Exception {
        System.out.println(Differ.generate(filepath1,filepath2));
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
        System.out.println("Hello World");
    }
}
