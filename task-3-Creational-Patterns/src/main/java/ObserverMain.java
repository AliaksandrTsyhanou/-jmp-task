import by.epam.jmp.observer.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by Alexandr on 14.12.2015.
 */
public class ObserverMain {

    public static void main(String[] args) throws URISyntaxException, IOException {
        String fileName = "ObserverFile.txt";
        URI uri = ClassLoader.getSystemClassLoader().getResource(fileName).toURI();

        Stream<String> lines = Files.lines(Paths.get(uri));

        NumberCounterObserver numberCounterObserver = new NumberCounterObserver();
        WordCounterObserver wordCounterObserver = new WordCounterObserver();
        LongestWordObserver longestWordObserver = new LongestWordObserver();
        ReverseWordObserver reverseWordObserver = new ReverseWordObserver();
        WordReader wordReader = new WordReader();
        wordReader.registerObserver(numberCounterObserver);
        wordReader.registerObserver(wordCounterObserver);
        wordReader.registerObserver(longestWordObserver);
        wordReader.registerObserver(reverseWordObserver);

        lines.flatMap(line -> Stream.of(line.split(" "))).forEach(wordReader::addWord);

        System.out.println("lines = ");
        Files.lines(Paths.get(uri)).forEach(System.out::println);
        System.out.println("words = " + wordReader.getWords());
        System.out.println("NumberCount = " + numberCounterObserver.getNumberCount());
        System.out.println("WordCount = " + wordCounterObserver.getWordCount());
        System.out.println("LongestWord = " + longestWordObserver.getLongestWord());
        System.out.println("ReversedWords = " + reverseWordObserver.getReversedWords());
    }

}
