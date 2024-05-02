package fr.eni.projet_encheres.bll;

import java.util.List;
import java.util.Optional;

import fr.eni.projet_encheres.bo.Article;
import fr.eni.projet_encheres.bo.Retrait;
import fr.eni.projet_encheres.dal.ArticleRepository;
import fr.eni.projet_encheres.dal.RetraitRepository;
import fr.eni.projet_encheres.exceptions.ArticleNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

	private ArticleRepository articleRepository;
	private RetraitRepository retraitRepository;

	public ArticleServiceImpl(ArticleRepository articleRepository, RetraitRepository retraitRepository) {
		this.articleRepository = articleRepository;
		this.retraitRepository = retraitRepository;
	}

	@Override
	public List<Article> findAll() {
		return articleRepository.findAll();
	}

	@Override
	public Article findById(int noArticle) throws ArticleNotFoundException {

		Optional<Article> optArticle = articleRepository.findById(noArticle);

		if (optArticle.isEmpty()) {
			throw new ArticleNotFoundException(noArticle);
		}

		return optArticle.get();
	}

	@Override
	public void save(Article article) {
		Retrait retrait = retraitRepository.saveOnNotFound(article.getRetrait());
		article.setRetrait(retrait);
		articleRepository.save(article);
	}

	@Override
	public void update(Article Article) {
		articleRepository.update(Article);
	}

	@Override
	public void delete(int _id) {
		articleRepository.deleteById(_id);
	}

}
