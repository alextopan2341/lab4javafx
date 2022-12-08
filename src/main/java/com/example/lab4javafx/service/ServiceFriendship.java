package com.example.lab4javafx.service;


import com.example.lab4javafx.domain.Friendship;
import com.example.lab4javafx.domain.Validator.ValidationException;
import com.example.lab4javafx.domain.Validator.Validator;
import com.example.lab4javafx.repository.Repository;

public class ServiceFriendship extends Service<Friendship>{

    public ServiceFriendship(Repository<Friendship> elem, Validator<Friendship> friendshipValidator) {
        super(elem);
        eValidator = friendshipValidator;
    }

    @Override
    public void addElem(Friendship friendship) {
        eValidator.validate(friendship);
        for(Friendship friendship1: repository.findAll()){
            if((friendship1.getId() == friendship.getId() || (friendship1.getIdUser1() == friendship.getIdUser1() && friendship1.getIdUser2()==friendship.getIdUser2()) || (friendship1.getIdUser1() == friendship.getIdUser2() && friendship1.getIdUser2()==friendship.getIdUser1()))){
                throw new ValidationException("Aceasta prietenie exista deja!");
            }
        }
        repository.save(friendship);
    }

    public Friendship getById(int id){
        for(Friendship friendship: repository.findAll()){
            if(friendship.getId() == id)
                return friendship;
        }
        throw new ValidationException("Nu exista astfel de prietenie cu id-ul dat");
    }
}
