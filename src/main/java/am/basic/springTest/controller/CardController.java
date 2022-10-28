package am.basic.springTest.controller;

import am.basic.springTest.model.Card;
import am.basic.springTest.model.Comment;
import am.basic.springTest.model.User;
import am.basic.springTest.service.CardService;
import am.basic.springTest.util.ValidationMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolationException;
import java.util.List;

import static am.basic.springTest.util.constants.Messages.INTERNAL_ERROR_MESSAGE;
import static am.basic.springTest.util.constants.Pages.CARD_PAGE;
import static am.basic.springTest.util.constants.Pages.COMMENT_PAGE;
import static am.basic.springTest.util.constants.ParameterKeys.MESSAGE_ATTRIBUTE_KEY;

@Controller
@RequestMapping("/secure")
public class CardController {

    @Autowired
    private CardService cardService;


    @GetMapping("/comments")
    public ModelAndView getCardPage(@SessionAttribute("user") User user) {
        try {
            List<Card> cards = cardService.getByUserId(user.getId());
            return new ModelAndView(CARD_PAGE, "cards", cards);
        } catch (RuntimeException exception) {
            return new ModelAndView(CARD_PAGE, MESSAGE_ATTRIBUTE_KEY, INTERNAL_ERROR_MESSAGE);
        }
    }

    @PostMapping("/cards/add")
    public ModelAndView add(@SessionAttribute("user") User user,
                            @RequestParam String name,
                            @RequestParam Integer number,
                            @RequestParam Integer cvv) {
        try {
            Card card = new Card();
            card.setName(name);
            card.setNumber(number);
            card.setCvv(cvv);
            card.setUserId(user.getId());
            cardService.add(card);

            return getCardPage(user);
        } catch (ConstraintViolationException exception) {
            List<Card> cards = cardService.getByUserId(user.getId());

            ModelAndView modelAndView = new ModelAndView(CARD_PAGE);
            modelAndView.addObject("cards", cards);
            modelAndView.addObject(MESSAGE_ATTRIBUTE_KEY, ValidationMessageConverter.getMessage(exception));
            return modelAndView;

        } catch (RuntimeException exception) {
            return new ModelAndView(CARD_PAGE, MESSAGE_ATTRIBUTE_KEY, INTERNAL_ERROR_MESSAGE);
        }
    }


    @PostMapping("/cards/edit")
    public ModelAndView delete(@SessionAttribute("user") User user,
                               @RequestParam Integer id,
                               @RequestParam String name,
                               @RequestParam Integer number,
                               @RequestParam Integer cvv,
                               @RequestParam String submit) {
        try {
            if (submit.equalsIgnoreCase("DELETE")) {
                cardService.delete(id);
            } else {
                Card card = new Card();
                card.setName(name);
                card.setNumber(number);
                card.setCvv(cvv);
                card.setUserId(user.getId());
                cardService.add(card);
            }

            return getCardPage(user);
        } catch (RuntimeException exception) {
            return new ModelAndView(CARD_PAGE, MESSAGE_ATTRIBUTE_KEY, INTERNAL_ERROR_MESSAGE);
        }
    }
}
