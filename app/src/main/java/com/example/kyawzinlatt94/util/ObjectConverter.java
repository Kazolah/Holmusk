package com.example.kyawzinlatt94.util;

import com.example.kyawzinlatt94.model.Element;
import com.example.kyawzinlatt94.model.Extra;
import com.example.kyawzinlatt94.model.Important;
import com.example.kyawzinlatt94.model.Nutrients;
import com.example.kyawzinlatt94.model.NutritionFact;
import com.example.kyawzinlatt94.model.Portion;
import com.example.kyawzinlatt94.realmObjects.FoodNutrients;

/**
 * Created by kyawzinlatt94 on 8/1/15.
 */
public class ObjectConverter {

    public static FoodNutrients convertToFoodNutrition(NutritionFact nutritionFact, int portionIndex){
        FoodNutrients foodNutrition = new FoodNutrients();
        foodNutrition.setId(nutritionFact.getId());
        foodNutrition.setName(nutritionFact.getName());

        Portion portion = nutritionFact.getPortions().get(portionIndex);
        foodNutrition.setPortion(portion.getName());

        Nutrients nutrients = portion.getNutrients();

        Important importantFacts = nutrients.getImportant();
        foodNutrition.setDietaryFibre(convertElementToString(importantFacts.getDietaryFibre()));
        foodNutrition.setSaturated(convertElementToString(importantFacts.getSaturated()));
        foodNutrition.setTotalCarbs(convertElementToString(importantFacts.getTotalCarbs()));
        foodNutrition.setSodium(convertElementToString(importantFacts.getSodium()));
        foodNutrition.setPotassium(convertElementToString(importantFacts.getPotassium()));
        foodNutrition.setPolyunsaturated(convertElementToString(importantFacts.getPolyunsaturated()));
        foodNutrition.setCalories(convertElementToString(importantFacts.getCalories()));
        foodNutrition.setSugar(convertElementToString(importantFacts.getSugar()));
        foodNutrition.setTotalFats(convertElementToString(importantFacts.getTotalFats()));
        foodNutrition.setMonounsaturated(convertElementToString(importantFacts.getMonounsaturated()));
        foodNutrition.setCholesterol(convertElementToString(importantFacts.getCholesterol()));
        foodNutrition.setProtein(convertElementToString(importantFacts.getProtein()));

        Extra extraFacts = nutrients.getExtra();
        foodNutrition.setVitaminA(convertElementToString(extraFacts.getVitaminA()));
        foodNutrition.setRetinol(convertElementToString(extraFacts.getRetinol()));
        foodNutrition.setbCarotene(convertElementToString(extraFacts.getBCarotene()));
        foodNutrition.setIron(convertElementToString(extraFacts.getIron()));
        foodNutrition.setNitrogen(convertElementToString(extraFacts.getNitrogen()));
        foodNutrition.setVitaminC(convertElementToString(extraFacts.getVitaminC()));
        foodNutrition.setStarch(convertElementToString(extraFacts.getStarch()));
        foodNutrition.setbCarotene(convertElementToString(extraFacts.getBCarotene()));
        foodNutrition.setCalcium(convertElementToString(extraFacts.getCalcium()));

        return foodNutrition;
    }
    public static String convertElementToString(Element element){
        String record;
        try {
            record = element.getValue() + " " + element.getUnit();
        }catch(NullPointerException e){
            record = "0 g";
        }

        return record;
    }
}
