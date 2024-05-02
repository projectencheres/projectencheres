package fr.eni.projet_encheres.dal;

import fr.eni.projet_encheres.bo.Retrait;
import fr.eni.projet_encheres.dal.RowMappers.RetraitRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RetraitRepositoryImpl implements RetraitRepository {
    private JdbcTemplate jdbcTemplate;

    public RetraitRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Retrait> findAllRetraits() {
        String sql = "SELECT no_retrait, rue, code_postal, ville FROM retraits";

        return jdbcTemplate.query(sql, new RetraitRowMapper());
    }

    @Override
    public Optional<Retrait> findById(int noRetrait) {
        String sql = "SELECT no_retrait, rue, code_postal, ville FROM retraits WHERE no_retrait = ?";

        Optional<Retrait> optionalRetrait;

        try {
            Retrait retrait = jdbcTemplate.queryForObject(sql, new RetraitRowMapper(), noRetrait);
            assert retrait != null;
            optionalRetrait = Optional.of(retrait);
        } catch (EmptyResultDataAccessException exc) {
            optionalRetrait = Optional.empty();
        }

        return optionalRetrait;
    }

    @Override
    public Optional<Retrait> findByExactField(Retrait _retrait) {
        String sql = "SELECT * FROM retraits WHERE rue = ? AND code_postal = ? AND ville = ?";

        Optional<Retrait> optionalRetrait;

        try {
            Retrait retrait = jdbcTemplate.queryForObject(sql, new RetraitRowMapper(), _retrait.getRue(),
                    _retrait.getCodePostal(), _retrait.getVille());
            assert retrait != null;
            optionalRetrait = Optional.of(retrait);
        } catch (EmptyResultDataAccessException exc) {
            optionalRetrait = Optional.empty();
        }

        return optionalRetrait;
    }

    @Override
    public Retrait saveOnNotFound(Retrait _retrait) {
        Optional<Retrait> optRetrait = findByExactField(_retrait);

        if (!optRetrait.isPresent())
            onlySave(_retrait);

        Optional<Retrait> optRetraitVerified = findByExactField(_retrait);
        Retrait retrait = optRetraitVerified.get();
        return retrait;
    }

    @Override
    public void onlySave(Retrait retrait) {
        String sql = "INSERT INTO retraits (rue, code_postal, ville) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, retrait.getRue(), retrait.getCodePostal(), retrait.getVille());
    }

    @Override
    public void save(Retrait retrait) {

        if (retrait.getNoRetrait() == 0) {
            String sql = "INSERT INTO retraits (no_retrait, rue, code_postal, ville) VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(sql, retrait.getNoRetrait(), retrait.getRue(), retrait.getCodePostal(),
                    retrait.getVille());

        } else {
            String sql = "Update retraits SET rue = ?, code_postal = ?, ville = ? WHERE no_retrait = ?";
            jdbcTemplate.update(sql, retrait.getRue(), retrait.getCodePostal(), retrait.getVille(),
                    retrait.getNoRetrait());
        }

    }

}
