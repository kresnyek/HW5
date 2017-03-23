package edu.xavier.csci260.kresnyek.dal;

import edu.xavier.csci260.kresnyek.domain.WordsStats;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by Cassie on 3/22/2017.
 */
@Component
public class WordTrackerDAOImpl extends Exception implements WordTrackerDAO {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    WordTrackerDAOImpl(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override

    public void wordUpdate(String word, String conversion) throws NullPointerException {
        String sql = "SELECT word, conversion FROM word_stats WHERE word = " + word;
        List<WordsStats> query1 = jdbcTemplate.query(sql, new Object[]{word},
                (rs, rowNum) -> new WordsStats(rs.getString("word"),
                        rs.getString("conversion"),
                        rs.getInt("timesSeen"))
        );
        //if something returned
        if (query1.size() > 0)
        {
            if(query1.get(0).getConversion() == conversion)
            {
                //all good then
                query1.get(0).setTimesSeen(query1.get(0).getTimesSeen()+1);
                sql = "UPDATE word_stats SET timesseen = "
                        + Integer.toString(query1.get(0).getTimesSeen())
                        + "WHERE word = " + word;
                jdbcTemplate.execute(sql);
            }
            //else error occured
            else {
                org.slf4j.Logger logger = LoggerFactory.getLogger("WordTracker");
                logger.info("We found a mismatch for "
                        + word + ".\n\tstored: " + query1.get(0).getConversion()
                        + "\nargument: " + conversion);
                throw new NullPointerException();
            }
        }


    }

    @Override
    public Optional<List<WordsStats>> find(String word) {
        String sql = "SELECT word, conversion FROM word_stats WHERE word = \"" + word + "\"";
        return Optional.of(jdbcTemplate.query(sql, new Object[]{word},
                (rs, rowNum) -> new WordsStats(rs.getString("word"),
                        rs.getString("conversion"),
                        rs.getInt("timesSeen"))
        ));
    }

    @Override
    public void createWord(String word, String conversion) {
        String sql = "INSERT INTO words_stats (word, conversion, timesSeen)" +
                " VALUES (" + word + ", " + conversion + " 1)";
        jdbcTemplate.execute(sql);


    }

    @Override
    public Optional<List<WordsStats>> findAll() {
        String sql = "SELECT * FROM words_stats";
        return Optional.of(jdbcTemplate.query(sql, new Object[]{},
                (rs, rowNum) -> new WordsStats(rs.getString("word"),
                        rs.getString("conversion"),
                        rs.getInt("timesSeen"))));
    }
}
