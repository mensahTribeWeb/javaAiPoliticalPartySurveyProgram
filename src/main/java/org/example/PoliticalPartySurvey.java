package org.example;

import java.util.HashMap;
        import java.util.Map;
        import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class PoliticalPartySurvey {

    public static void main(String[] args) {
        // Define the questions
        String[] questions = {
                "What should the government do to help the poor?",
                "What should be done to improve the education system?",
                "What is your opinion on immigration?",
                "What should the government do to address climate change?",
                "What is your stance on gun control?",
                "What is your stance on abortion?",
                "What is your opinion on same-sex marriage?",
                "What is your view on the role of government in the economy?",
                "What is your view on national security and surveillance?",
                "What is your opinion on foreign policy and international relations?"
        };

        // Define the answer options for each question
        String[][] answerOptions = {
                {"A. Make it easier to apply for assistance.", "B. Allow parents to use education funds for charter schools.", "C. Create welfare to work programs.", "D. Nothing."},
                {"A. Increase funding for public schools.", "B. Encourage private investment in education.", "C. Provide more vocational training.", "D. Eliminate the Department of Education."},
                {"A. Increase border security and deport illegal immigrants.", "B. Provide a path to citizenship for illegal immigrants already in the country.", "C. Allow more legal immigration.", "D. Ban all immigration."},
                {"A. Enact strict regulations on carbon emissions.", "B. Promote the development of renewable energy.", "C. Take a market-based approach like a carbon tax.", "D. Take no action."},
                {"A. Implement stricter background checks and gun control measures.", "B. Support the Second Amendment and oppose gun control.", "C. Allow some gun control measures, but not too strict.", "D. Ban all guns except for military and law enforcement."},
                {"A. Women should have the right to choose whether or not to have an abortion.", "B. Abortion should only be allowed in cases of rape, incest, or danger to the mother's health.", "C. Abortion should be illegal in all cases.", "D. Abortion should be legal only in the first trimester."},
                {"A. Support same-sex marriage and equal rights for LGBTQ+ individuals.", "B. Oppose same-sex marriage and believe marriage should be between one man and one woman.", "C. Support civil unions, but not same-sex marriage.", "D. Believe marriage is a state issue, not a federal one."},
                {"A. Government should play a larger role in the economy, such as providing universal healthcare and increasing taxes on the wealthy.", "B. Government should have a smaller role in the economy and promote free market capitalism.", "C. Government should regulate certain industries and provide a social safety net.", "D. Government should be abolished and the market should be completely free."},
                {"A. Support increased surveillance to prevent terrorism and protect national security.", "B. Oppose surveillance and support individual privacy rights.", "C. Support targeted surveillance in specific cases, such as when there is evidence of a crime or threat to national security.", "D. Believe surveillance is necessary, but there should be more oversight and transparency."},
                {"A. Support diplomacy and international cooperation to promote peace.", "B. Support a strong military and a more aggressive foreign policy.", "C. Support non-interventionism and reducing America's global presence.", "D. Believe each situation is unique and requires a case-by-case approach."}
        };

        // Define the mapping between answer options and parties
        Map<String, String> answerPartyMap = new HashMap<>();
        answerPartyMap.put("A", "1"); // Democrat
        answerPartyMap.put("B", "2"); // Republican
        answerPartyMap.put("C", "3"); // Independent
        answerPartyMap.put("D", "4"); // Other

// Get user input for each question and update party counts accordingly
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> partyCounts = new HashMap<>();
        String topParty = null;
        for (int i = 0; i < questions.length; i++) {

            System.out.println(questions[i]);
            for (int j = 0; j < answerOptions[i].length; j++) {
                System.out.println(answerOptions[i][j]);
            }

            String answer = scanner.nextLine().toUpperCase();
            // Update party counts based on answer
            String partyString = answerPartyMap.get(answer);
            if (partyString != null) {
                int party = parseInt(partyString);
                partyCounts.put(Integer.toString(party), partyCounts.getOrDefault(Integer.toString(party), 0) + 1);

            } else {
                System.out.println("Invalid answer: " + answer);
            }

// Determine the party with the highest count and print it out
            topParty = "Other";
            int topCount = 0;
            for (Map.Entry<String, String> entry : answerPartyMap.entrySet()) {
                int count = parseInt(entry.getValue());
                if (count > topCount) {
                    topCount = count;
                    topParty = entry.getKey();
                }
            }
        }
        System.out.println("You are most likely a " + topParty + " based on your answers.");

    }}