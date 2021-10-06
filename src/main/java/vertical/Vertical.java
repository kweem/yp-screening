package vertical;

import fizzbuzz.logger.Loggable;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Vertical {

    private final Loggable logger;

    public Vertical(Loggable logger) {
        this.logger = logger;
    }

    public void printSentencesVertically(List<String> sentences) {
        if (sentences == null) {
            return;
        }

        final List<String[]> filteredSentences = filterInput(sentences);
        final int wordsOfLongestSentence = getAmountOfWordsOfLongestSentence(filteredSentences);

        for (int wordIndex = 0; wordIndex < wordsOfLongestSentence; wordIndex++) {
            printSentenceWithGivenWordIndex(filteredSentences, wordIndex);
        }
    }

    private void printSentenceWithGivenWordIndex(List<String[]> filteredSentences, int wordIndex) {
        String newSentence = "";
        for (int sentenceIndex = 0; sentenceIndex < filteredSentences.size(); sentenceIndex++) {
            final String[] currentSentence = filteredSentences.get(sentenceIndex);
            if (currentSentence.length > wordIndex) {
                newSentence += currentSentence[wordIndex] + " ";
            }
        }
        logger.print(newSentence.trim());
    }

    private int getAmountOfWordsOfLongestSentence(List<String[]> filteredSentences) {
        return filteredSentences.stream()
                .max(Comparator.comparing(wordArray -> wordArray.length))
                .orElse(new String[0])
                .length;
    }

    private List<String[]> filterInput(List<String> sentences) {
        return sentences.stream()
                .filter(Objects::nonNull)
                .filter(sentence -> !sentence.isBlank())
                .map(PunctuationRemover::removePunctuation)
                .map(sentence -> sentence.split(" "))
                .collect(Collectors.toList());
    }
}
