package edu.xavier.csci260.kresnyek.service;

import edu.xavier.csci260.kresnyek.dal.WordTrackerDAO;
import edu.xavier.csci260.kresnyek.domain.WordsStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by Cassie on 3/22/2017.
 */
@Component
public class WordsStatsServiceImpl implements WordsStatsService{

    private WordTrackerDAO wordTrackerDAO;
    @Autowired
    public WordsStatsServiceImpl(WordTrackerDAO wordTrackerDAO)
    {
        this.wordTrackerDAO = wordTrackerDAO;
    }
    @Override
    public void update(WordsStats word)
    {
        Optional<List<WordsStats>> words = wordTrackerDAO.find(word.getWord());
        if (words.get().size() > 0)
        {
            wordTrackerDAO.wordUpdate(word.getWord(), word.getConversion());
        }
        else
        {
            wordTrackerDAO.createWord(word.getWord(), word.getConversion());
        }

    }

    @Override
    public List<WordsStats> find() {
        return wordTrackerDAO.findAll().get();
    }

    @Override
    public List<WordsStats> find(String word)
    {
        return wordTrackerDAO.find(word).get();
    }
}
