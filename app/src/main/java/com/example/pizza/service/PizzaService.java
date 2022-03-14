package com.example.pizza.service;

import com.example.pizza.beans.Pizza;
import com.example.pizza.dao.IDao;

import java.util.ArrayList;
import java.util.List;


public class PizzaService implements IDao<Pizza> {
    private List <Pizza> pizzas;
    private static PizzaService instance;

    private PizzaService() {
        this.pizzas = new ArrayList<>();
    }

    public static PizzaService getInstance() {
        if(instance == null)
            instance =  new PizzaService();
        return instance;
    }

    @Override
    public boolean create(Pizza o) {
        return pizzas.add(o);
    }

    @Override
    public boolean update(int id,Pizza o) {
        Pizza pizza=pizzas.get(id);
        pizza.setNom(o.getNom());
        pizza.setDesc(o.getDesc());
        pizza.settime(o.gettime());
        return true;
    }

    @Override
    public boolean delete(Pizza o) {
        return pizzas.remove(o);
    }

    @Override
    public Pizza findById(int id) {
        for(Pizza f : pizzas){
            if(f.getId() == id)
                return f;
        }
        return null;
    }

    @Override
    public List<Pizza> findAll() {
        return pizzas;
    }
}
