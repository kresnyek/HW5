package edu.xavier.csci260.kresnyek.controller;

import edu.xavier.csci260.kresnyek.domain.WordsStats;
import edu.xavier.csci260.kresnyek.service.WordsStatsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by Cassie on 3/21/2017.
 */
@Controller
public class WordsStatsController
{
    private WordsStatsService wordsStatsService;
    public WordsStatsController(WordsStatsService wordsStatsService)
    {
        this.wordsStatsService = wordsStatsService;
    }

    @RequestMapping(value = "/words/index", method = RequestMethod.GET)
    public String indexForm(Model model)
    {
        model.addAttribute("wordStat", new WordsStats());
        return "index";
    }

    @RequestMapping(value = "/words/index", method = RequestMethod.POST)
    @ResponseBody
    public String indexSubmit(@ModelAttribute WordsStats wordStat)
    {
        //wordsStatsService.update(word);
        return wordStat.toString();
    }

    @RequestMapping(value = "/words/stats/{word}", method = RequestMethod.GET)
    @ResponseBody
    public List<WordsStats> getWordStats(@PathVariable("word") String word)
    {
        return wordsStatsService.find(word);

    }

    @RequestMapping(value = "/words/all", method = RequestMethod.GET)
    @ResponseBody
    public List<WordsStats> getAllWords()
    {
        return wordsStatsService.find();
    }

    @RequestMapping(value = "/words/update", method = RequestMethod.POST)
    @ResponseBody
    public void update()
    {
        wordsStatsService.update(new WordsStats("cat", "at cay", 1));
    }
}
