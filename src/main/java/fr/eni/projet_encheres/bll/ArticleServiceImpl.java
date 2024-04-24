package fr.eni.projet_encheres.bll;

import java.util.List;
import java.util.Optional;

import fr.eni.projet_encheres.bo.Article;
import fr.eni.projet_encheres.dal.ArticleRepository;
import fr.eni.projet_encheres.exceptions.ArticleNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository ArticleRepository;
	
	public ArticleServiceImpl(ArticleRepository ArticleRepository) {
		this.ArticleRepository = ArticleRepository;
	}

	@Override
	public List<Article> findAll() {
		return ArticleRepository.findAll();
	}

	@Override
	public Article findById(int noArticle)  throws ArticleNotFoundException {
		
		Optional<Article> optArticle = ArticleRepository.findById(noArticle);
		
		if(optArticle.isEmpty()) {
			throw new ArticleNotFoundException(noArticle);
		}
		
		return optArticle.get();
	}

	@Override
	public void save(Article Article) {
		ArticleRepository.save(Article);
	}
	@Override
	public void update(Article Article) {
		ArticleRepository.update(Article);
	}
	@Override
	public void delete(int _id) {
		ArticleRepository.deleteById(_id);
	}
	
}
