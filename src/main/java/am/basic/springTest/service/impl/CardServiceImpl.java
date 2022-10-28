package am.basic.springTest.service.impl;

import am.basic.springTest.model.Card;
import am.basic.springTest.repository.CardReposytory;
import am.basic.springTest.repository.CommentRepository;
import am.basic.springTest.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardReposytory cardReposytory;

    @Override
    public List<Card> getByUserId(int userId) {
        return cardReposytory.getByUserId(userId);    }

    @Override
    public void add(Card card) {
        cardReposytory.save(card);

    }

    @Override
    public void delete(int id) {
        cardReposytory.deleteById(id);

    }

    @Override
    public List<Card> search(Card sample) {
        return cardReposytory.findAll(Example.of(sample));
    }
}
