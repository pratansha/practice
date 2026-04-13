package all.tech.practice.java11;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java11Syntax {
    public static void doesStringContainVisibleCharacters(String input) {
        boolean olderJava8Approach = !input.trim().equals("");
        boolean newerJava11Approach = !input.isBlank();
        System.out.println("olderJava8Approach : " + olderJava8Approach + " , newerJava11Approach : " + newerJava11Approach);
    }

    public static void splitToLines(String input) {
        String[] linesOfArray = input.split("\n");
        List<String> olderJava8Approach = Arrays.stream(linesOfArray).collect(Collectors.toList());
        List<String> newerJava11Approach = input.lines().collect(Collectors.toList());
        System.out.println("olderJava8Approach : " + olderJava8Approach + " , newerJava11Approach : " + newerJava11Approach);
    }

    public static void trimUnicodeString(String input) {
        String olderJava8Approach = input.trim();
        String newerJava11Approach = input.strip();
        System.out.println("olderJava8Approach : " + olderJava8Approach + " , newerJava11Approach : " + newerJava11Approach);
    }

    public static void trimLeft(String input) {
        String olderJava8Approach = input.replaceAll("^\\s*", "");
        String newerJava11Approach = input.stripLeading();
        System.out.println("olderJava8Approach : " + olderJava8Approach + " , newerJava11Approach : " + newerJava11Approach);
    }

    public static void trimRight(String input) {
        String olderJava8Approach = input.replaceAll("\\s*", "");
        String newerJava11Approach = input.stripTrailing();
        System.out.println("olderJava8Approach : " + olderJava8Approach + " , newerJava11Approach : " + newerJava11Approach);
    }

    public static void repeatStringFiveTimes(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) sb.append(input);
        String olderJava8Approach = sb.toString();

        String newerJava11Approach = input.repeat(5);
        System.out.println("olderJava8Approach : " + olderJava8Approach + " , newerJava11Approach : " + newerJava11Approach);
    }

    public static void saveStringInFile(String fileContents, String filename) throws Exception {
        Path file = Paths.get(filename);
        Files.writeString(file, fileContents);
    }

    public String readFileContents(String filename) throws Exception {
        Path file = Paths.get(filename);
        return Files.readString(file);
    }

    public static void filterOutEmptyStrings(List<String> input) {
        List<String> olderJava8Approach = input.stream().filter(s -> !"".equals(s)).collect(Collectors.toList());
        List<String> newerJava11Approach = input.stream().filter(Predicate.not(String::isEmpty)).collect(Collectors.toList());
        System.out.println("olderJava8Approach : " + olderJava8Approach + " , newerJava11Approach : " + newerJava11Approach);
    }

    public static void main(String[] args) {
        doesStringContainVisibleCharacters(" hello ");
        splitToLines("hello \n Prashant \n how \n are \n you ?");
        trimUnicodeString(" hello ");
        trimLeft(" hello ");
        trimRight(" hello ");
        repeatStringFiveTimes("Test");
        filterOutEmptyStrings(List.of("hello","how","","are","you"));
    }
}