package com.example.springboot.DatabaseManagement;

import java.util.ArrayList;

public class PermutationsGenerator {
    public static ArrayList<String> generatePermutations(String charactersInName) {
        ArrayList<String> permutations = new ArrayList<>(); 
        buildPermutations("", charactersInName, permutations);

        return permutations;
    }

    private static void buildPermutations(String prefix, String charactersInName, ArrayList<String> resultsArray) {
        if (charactersInName.length() == 0) {
            resultsArray.add(prefix);
            return;
        }

        for (int i = 0; i < charactersInName.length(); i++) {
            char newCharacter= charactersInName.charAt(i);
            String remainingCharacters = charactersInName.replace(String.valueOf(newCharacter), "");

            buildPermutations(prefix + newCharacter, remainingCharacters, resultsArray);
        }
    }
}
