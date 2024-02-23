package ru.practicum.dinner;

import java.util.*;

public class DinnerConstructor {

    private final Map<String, List<String>> menu;

    public DinnerConstructor() {
        menu = new HashMap<>();
    }

    public boolean isDishTypeExist(String dishType) {
        return menu.containsKey(dishType);
    }

    public boolean addNewDish(String dishType, String dishName) {
        List<String> dishes;
        if (menu.containsKey(dishType)) {
            dishes = menu.get(dishType);
        } else {
            dishes = new ArrayList<>();
            menu.put(dishType, dishes);
        }

        if (dishes.contains(dishName)) {
            return false;
        } else {
            dishes.add(dishName);
            return true;
        }
    }

    public List<List<String>> generateDishCombo(int numberOfCombos, List<String> comboDishTypes) {
        List<List<String>> combos = new ArrayList<>(numberOfCombos);

        Random random = new Random();
        for (int i = 0; i < numberOfCombos; i++) {
            List<String> comboContent = new ArrayList<>();
            for (String dishType : comboDishTypes) {
                List<String> availableDishes = menu.get(dishType);
                int randomDishPosition = random.nextInt(availableDishes.size());
                comboContent.add(availableDishes.get(randomDishPosition));
            }
            combos.add(comboContent);
        }

        return combos;
    }
}
