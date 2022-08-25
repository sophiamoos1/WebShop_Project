package com.example.demo.CardPackage;

import com.example.demo.ProductsPackage.Product;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.util.*;

@Service
public class CardService {
    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }


    public List<Card> findAll(){
        List<Card> list = new ArrayList<>();
        Iterable<Card> cards = cardRepository.findAll();
        cards.forEach(list::add);
        return list;
    }

    public Optional<Card> find(Integer orderId) throws InstanceNotFoundException{
        return cardRepository.findById(orderId);
    }

    public Optional<Card> update(Integer orderId, Product product){
        if(cardRepository.existsById(orderId)){
            return cardRepository.findById(orderId)
                    .map(oldCard -> {
                        Set<Product> products = new HashSet<Product>();
                        products.add(product);
                        oldCard.setProducts(products);
                        oldCard.setUser(oldCard.getUser());
                        return cardRepository.save(oldCard);
                    });
        }else{
            return null;
        }
    }

}
