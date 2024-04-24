package fr.eni.projet_encheres.dal;

import fr.eni.projet_encheres.bo.Categorie;
import fr.eni.projet_encheres.dal.RowMappers.CategorieRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategorieRepositoryImpl implements CategorieRepository{

    private JdbcTemplate jdbcTemplate;

    public CategorieRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Categorie> findAllCategories() {
        String sql = "SELECT * FROM categories";
        return jdbcTemplate.query(sql, new CategorieRowMapper());
    }

    @Override
    public Optional<Categorie> findById(int no_categorie) {
        String sql = "SELECT * FROM categories WHERE no_categorie = ?";
        Optional<Categorie> optionalCategorie;
        try {
            Categorie categorie = jdbcTemplate.queryForObject(sql, new CategorieRowMapper(), no_categorie);
            assert categorie != null;
            optionalCategorie = Optional.of(categorie);

        } catch (EmptyResultDataAccessException e) {
            optionalCategorie = Optional.empty();
        }
        return optionalCategorie;
    }
}
