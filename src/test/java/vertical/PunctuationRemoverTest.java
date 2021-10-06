package vertical;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PunctuationRemoverTest {

    @Test
    void givenText_whenRemovePunctuation_thenTextIsReturnedWithoutPunctuation() {
        String text = "Tes't, punct!uation.";
        final String result = PunctuationRemover.removePunctuation(text);

        assertEquals("Test punctuation", result);
    }

    @Test
    void givenNull_whenRemovePunctuation_thenEmptyStringIsReturned() {
        final String result = PunctuationRemover.removePunctuation(null);

        assertEquals("", result);
    }

}
