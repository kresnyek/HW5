package edu.xavier.csci260.kresnyek.dal;

import edu.xavier.csci260.kresnyek.domain.WordsStats;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 * Created by Cassie on 3/21/2017.
 */
public interface WordTrackerDAO {
    void wordUpdate(String word, String conversion);
    Optional<List<WordsStats>> find(String word);
    void createWord(String word, String conversion);
    public Optional<List<WordsStats>> findAll();
}
