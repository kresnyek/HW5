package edu.xavier.csci260.kresnyek.service;

import edu.xavier.csci260.kresnyek.domain.WordsStats;

import java.util.List;

/**
 * Created by Cassie on 3/21/2017.
 */
public interface WordsStatsService {
    void update(WordsStats word);
    List<WordsStats> find();
    List<WordsStats> find(String word);
}
