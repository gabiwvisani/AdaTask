package Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public interface ConsoleInputValidator {
    final Scanner scanner = new Scanner(System.in);

    public default String validateStringInput(String prompt, String errorMessage) {
        String userInput = "";
        while (userInput.isEmpty()) {
            System.out.print(prompt);
            userInput = scanner.nextLine();
            if (userInput.isEmpty()) {
                System.out.println(errorMessage);
            }
        }
        return userInput;
    }

    public default int validatePositiveIntegerInput(String prompt, String errorMessage) {
        int userInput = -1;
        while (userInput < 0) {
            try {
                System.out.print(prompt);
                userInput = Integer.parseInt(scanner.nextLine());
                if (userInput < 0) {
                    System.out.println(errorMessage);
                }
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
            }
        }
        return userInput;
    }

    public default LocalDateTime validateDateTimeInput(String prompt, String errorMessage) {
        LocalDateTime dateTime = LocalDateTime.now().minusDays(1);
        while (dateTime.isBefore(LocalDateTime.now())) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                dateTime = LocalDateTime.parse(input, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
                if (dateTime.isBefore(LocalDateTime.now())) {
                    System.out.println(errorMessage);
                }
            } catch (Exception e) {
                System.out.println(errorMessage);
            }
        }
        return dateTime;
    }


    public default boolean validateYesNoInput(String prompt, String errorMessage) {
        String userInput = "";
        while (!userInput.equalsIgnoreCase("sim") && !userInput.equalsIgnoreCase("não")) {
            System.out.print(prompt);
            userInput = scanner.nextLine();
            if (!userInput.equalsIgnoreCase("sim") && !userInput.equalsIgnoreCase("não")) {
                System.out.println(errorMessage);
            }
        }
        return userInput.equalsIgnoreCase("sim");
    }
    public default String validateStringPrioridadeInput(String prompt, String errorMessage) {
        String userInput = "";
        while (userInput.isEmpty()) {
            System.out.print(prompt);
            userInput = scanner.nextLine();
            if (userInput.isEmpty()||!(userInput.toLowerCase().trim().equals("alta")||userInput.toLowerCase().trim().equals("média")||userInput.toLowerCase().trim().equals("baixa"))){
                System.out.println(errorMessage);
            }
        }
        return userInput;
    }

}

