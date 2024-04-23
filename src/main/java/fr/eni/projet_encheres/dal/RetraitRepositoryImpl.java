package fr.eni.projet_encheres.dal;

import fr.eni.projet_encheres.bo.Retrait;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public class RetraitRepositoryImpl implements RetraitRepository {
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Retrait> findAllRetraits() {
        return null;
    }

    @Override
    public Optional<Retrait> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Retrait retrait) {

    }

    @Override
    public void deleteById(int id) {

    }
}
