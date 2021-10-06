package vertical;

public class PunctuationRemover {

    private static final String PUNCTUATION_REMOVAL_REGEX = "[,'.!;]";

    public static String removePunctuation(String word) {
        if (word == null) {
            return "";
        }

        return word.replaceAll(PUNCTUATION_REMOVAL_REGEX, "");
    }
}
