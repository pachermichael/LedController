package at.edu.c02.ledcontroller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /**
     * This is the main program entry point. TODO: add new commands when implementing additional features.
     */
    public static void main(String[] args) throws IOException {
        LedController ledController = new LedControllerImpl(new ApiServiceImpl());

        String input = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (!input.equalsIgnoreCase("exit")) {
            System.out.println("=== LED Controller ===");
            System.out.println("Enter 'demo' to send a demo request");
            System.out.println("Enter 'exit' to exit the program");
            System.out.println("Enter 'setlight' to exit the program");
            input = reader.readLine();


            switch (input.toLowerCase()) {
                case "demo":
                    ledController.demo();
                    break;
                case "groupstatus":
                    ledController.getGroupStatus();
                    break;
                case "status": {
                    System.out.println("Plese specify light ID:");
                    input = reader.readLine();
                    ledController.getLightStatus(Integer.parseInt(input));
                }
                case "setlight":{
                    System.out.println("=== Set Lights Controller ===");
                    System.out.println("Enter the LED ID");
                    String id = reader.readLine();
                    System.out.println("Enter the color in HEX");
                    String color = reader.readLine();
                    System.out.println("Enter true or false, for activate the LED");
                    String state = reader.readLine();
                    ledController.demo2(Integer.parseInt(id),color, Boolean.parseBoolean(state));
                }
                case "exit":
                    break;
                default:
                    System.out.println("Command doesn't exist.");
            }
        }
    }
}
