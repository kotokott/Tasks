
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class TestRunner {

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Usage: java TestRunner.java path/to/task10.java");
            return;
        }

        Path javaFile = Path.of(args[0]);
        //Path testsFile = Path.of(args[0].replace(".java", ".tests"));
        Path testsFile = Path.of(args[0].replaceAll("((\\S+)/)?src/(\\w+)\\.java", "$1tests/$3.tests"));

        if (!Files.exists(javaFile)) {
            System.out.println("File not found: " + javaFile);
            return;
        }
        if (!Files.exists(testsFile)) {
            System.out.println("Tests file not found: " + testsFile);
            return;
        }

        List<TestCase> tests = parseTests(Files.readString(testsFile));
        int passed = 0;

        for (TestCase test : tests) {
            String actual = runTest(javaFile.toString(), test.input);
            boolean ok = normalize(actual).equals(normalize(test.expected));
            if (ok) {
                System.out.println("✓ PASS — " + test.name);
                passed++;
            } else {
                System.out.println("✗ FAIL — " + test.name);
                System.out.println("  expected: " + normalize(test.expected));
                System.out.println("  actual:   " + normalize(actual));
            }
        }

        System.out.printf("%nResult: %d/%d passed%n", passed, tests.size());
    }

    static String runTest(String javaFile, String input) throws Exception {
        Process proc = new ProcessBuilder("java", javaFile)
                .redirectErrorStream(true).start();
        proc.getOutputStream().write(input.getBytes());
        proc.getOutputStream().close();
        String out = new String(proc.getInputStream().readAllBytes());
        proc.waitFor();
        return out;
    }

    static String normalize(String s) {
        return s.trim().replaceAll("\r\n", "\n").replaceAll(" +", " ");
    }

    static List<TestCase> parseTests(String content) {
        List<TestCase> result = new ArrayList<>();
        String[] blocks = content.split("===");
        for (String block : blocks) {
            block = block.strip();
            if (block.isEmpty()) continue;
            String name = "test";
            if (block.startsWith("TEST:")) {
                int nl = block.indexOf('\n');
                name = block.substring(5, nl).trim();
                block = block.substring(nl).strip();
            }
            int inputIdx = block.indexOf("INPUT");
            int outputIdx = block.indexOf("OUTPUT");
            if (inputIdx == -1 || outputIdx == -1) continue;

            String input = block.substring(inputIdx + 5, outputIdx).strip();
            String expected = block.substring(outputIdx + 6).strip();
            result.add(new TestCase(name, input, expected));
        }
        return result;
    }

    record TestCase(String name, String input, String expected) {}
}
