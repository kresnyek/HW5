package edu.xavier.csci260.kresnyek.domain;

/**
 * Created by Cassie on 3/21/2017.
 */
public class WordsStats {

    String word;
    String conversion;
    Integer timesSeen;

    public WordsStats() {
    }

    public WordsStats(String word, String conversion, Integer timesSeen) {
        this.word = word;
        this.conversion = conversion;
        this.timesSeen = timesSeen;
    }

    @Override
    public String toString() {
        return "WordsStats{" +
                "word='" + word + '\'' +
                ", conversion='" + conversion + '\'' +
                ", timesSeen=" + timesSeen +
                '}';
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getConversion() {
        return conversion;
    }

    public void setConversion(String conversion) {
        this.conversion = conversion;
    }

    public Integer getTimesSeen() {
        return timesSeen;
    }

    public void setTimesSeen(Integer timesSeen) {
        this.timesSeen = timesSeen;
    }
}
