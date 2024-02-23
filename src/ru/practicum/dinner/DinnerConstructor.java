package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DinnerConstructor {

    private final Map<String, List<String>> menu;

    public DinnerConstructor() {
        menu = new HashMap<>();
    }

    public boolean isDishTypeExist(String dishType){
        return menu.containsKey(dishType);
    }

    public boolean addNewDish(String dishType, String dishName) {
        List<String> dishes;
        if (menu.containsKey(dishType)){
            dishes = menu.get(dishType);
        } else {
            dishes = new ArrayList<>();
            menu.put(dishType, dishes);
        }

        if (dishes.contains(dishName)){
            return false;
        } else {
            dishes.add(dishName);
            return true;
        }
    }
}
