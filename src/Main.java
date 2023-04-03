import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

 class SafeInput {
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "0";  // Set this to zero length. Loop runs until it isn’t
        do {
            System.out.print("\n " + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;

    }

    public static int getRangedInt(Scanner pipe, String enterYourYearOfBirth, int i, int i1) {
        return i;
    }

    public class Pipe
    {

        //method to read integer from console
        public static int getInt(Scanner pipe, String prompt) {
            int input = -1;
            //prompt to user
            System.out.println(prompt + "int:");
            //if user insert integer
            if (pipe.hasNextInt()) {
                //read input
                input = pipe.nextInt();
            }
            //reset pipe
            pipe.reset();
            //if not int return -1
            return input;
        }//end of getInt();

        //method to read double
        public static double getDouble(Scanner pipe, String prompt) {
            double input = -1.0;
            //prompt to user
            System.out.println(prompt + "double:");

            //if user insert double
            if (pipe.hasNextDouble()) {
                //read input double
                input = pipe.nextDouble();
            }
            //reset pipe of type Scanner
            pipe.reset();
            //if input is not a double return -1.0
            return input;
        }//end of getDouble();

        //method to read int between range
        public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
            int input = -1;
            //prompt to user
            System.out.println(prompt + "int[" + low + "-" + high + "]:");
            //if user insert int
            if (pipe.hasNextInt()) {
                //read input int
                input = pipe.nextInt();

                //check is Int in given range
                if (input > low && input < high) {
                    //reset pipe
                    pipe.reset();

                    //if input in given range return input integer
                    return input;
                }
                //reset pipe
                pipe.reset();
                //if input is not in range return -1
                return -1;
            }
            //reset pipe
            pipe.reset();
            //if input is not an int return -1
            return -1;
        }//getRangedInt();

        //method to read double in given ranged
        public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
            double input = -1;
            //prompt to user
            System.out.println(prompt + "double[" + low + "-" + high + "]:");
            //if user insert a double
            if (pipe.hasNextDouble()) {
                //read input double
                input = pipe.nextDouble();

                //check is input in a range
                if (input > low && input < high) {
                    pipe.reset();
                    return input;
                }
                pipe.reset();
                //if not in range return -
                return -1.0;
            }
            pipe.reset();
            //if not a double return -1
            return -1.0;
        }//getRangedDouble();

        //method to read Yes or No
        public static boolean getYNConfirm(Scanner pipe, String prompt) {
            char input;
            int repeat = 0;
            do {
                //prompt to user
                System.out.println(prompt + "Yes or No[Y/N]:");
                //read first char
                input = pipe.next().charAt(0);
                //if its Y or y
                if (input == 'y' || input == 'Y') {
                    pipe.reset();
                    //return true if yes
                    return true;
                }
                //if it is N or n
                else if (input == 'n' || input == 'N') {
                    pipe.reset();
                    //return false if input n or N
                    return false;
                } else {
                    pipe.reset();
                    repeat = 1;
                }

            } while (repeat != 0);//repeat if input is not as expected

            pipe.reset();
            return false;
        }//getYNConfirm();

        //method to return String which matches to given regEx
        public static String getRegExString(Scanner pipe, String prompt, String regEx) {
            String input;
            //prompt to user
            System.out.println(prompt + "String that Matches " + regEx + ":");
            //if input string matches the pattern regEx
            if (pipe.hasNext()) {
                //then read String input
                input = pipe.next();
                pipe.reset();
                if (Pattern.matches(regEx, input)) {
                    return input;
                }
                return null;
            }
            pipe.reset();
            return null;//if not matches return null;
        }//end of getRegExString()


        public static void main(String[] args) {
            int input_Int;
            String input_String;
            double input_double;

            //Scanner object to read input from console
            Scanner pipe = new Scanner(System.in);
            //prompt to enter input
            String prompt = "Please Insert Input?as a ";

            //test getInt method;
            input_Int = getInt(pipe, prompt);
            if (input_Int != -1) {
                System.out.println("getInt():-" + input_Int);
            } else {
                System.out.println("input is not an integer!");
            }


            //test getDouble() method
            input_double = getDouble(pipe, prompt);
            if (input_double != -1.0) {
                System.out.println("getDouble():-" + input_double);
            } else {
                System.out.println("input is not a double!");
            }

            //test getRangedInt() method
            input_Int = getRangedInt(pipe, prompt, 10, 20);
            if (input_Int != -1) {
                System.out.println("getRangedInt():-" + input_Int);
            } else {
                System.out.println("input does not comply the instructions!");
            }

            //test getRangedDouble() method
            input_double = getRangedDouble(pipe, prompt, 10.0, 20.00);
            if (input_double != -1.0) {
                System.out.println("getRangedDouble():-" + input_double);
            } else {
                System.out.println("input does not comply the instructions!");
            }

            //test getYNConfirm()
            boolean inp = getYNConfirm(pipe, prompt);
            System.out.println("getYNConfirm():-" + inp);

            //test getRegExString() method
            String regEx = "[a-zA-Z0-9]{6}";//string length should be 6
            input_String = getRegExString(pipe, prompt, regEx);
            if (input_String != null) {
                System.out.println("getRegExString():-" + input_String);
            } else {
                System.out.println("input does not matches the regex!");
            }


            class SafeInputs {
                // A utility method to get an integer input within a range
                public static int getRangedInt(Scanner input, String message, int min, int max) {
                    int value;
                    do {
                        System.out.print(message);
                        while (!input.hasNextInt()) {
                            System.out.println("Invalid input. Please enter an integer.");
                            input.next();
                        }
                        value = input.nextInt();
                        input.nextLine();  // Consume the newline character
                    } while (value < min || value > max);
                    return value;
                }

                // A utility method to get a double input within a range
                public static double getRangedDouble(Scanner input, String message, double min, double max) {
                    double value;
                    do {
                        System.out.print(message);
                        while (!input.hasNextDouble()) {
                            System.out.println("Invalid input. Please enter a number.");
                            input.next();
                        }
                        value = input.nextDouble();
                        input.nextLine();  // Consume the newline character
                    } while (value < min || value > max);
                    return value;
                }

                // A utility method to get a Yes/No confirmation from the user
                public static boolean getYNConfirm(Scanner input, String message) {
                    String confirm;
                    do {
                        System.out.print(message);
                        confirm = input.nextLine();
                    } while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N"));
                    return confirm.equalsIgnoreCase("Y");
                }

                // A utility method to create a pretty header with a message centered

                public static void prettyHeader(String msg) {
                    int starCount=60;
                    while(starCount!=0)
                    {System.out.print("*");
                        starCount--;
                    }
                    System.out.println();
                    int starsonLeft=(60-msg.length())/2;
                    int left=1;
                    while(left<=starsonLeft)
                    {
                        System.out.print("*");
                        left++;
                        //applies starts in appropriate spots
                    }
                    System.out.print(msg);
                    int right=0;
                    while(right<=starsonLeft)
                    {
                        System.out.print("*");
                        right++;
                    }
                    System.out.println();
                    starCount=60;
                    while(starCount!=0)
                    {
                        System.out.print("*");
                        starCount--;
                    }
                }
            }


        }

    }
}
public class Main {
    public static void main(String[] args) {


         class MenuDrivenList {

            private static ArrayList<String> itemList = new ArrayList<>();

            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                String userInput;

                do {
                    displayMenu();
                    //This is where the user makes their choice
                    userInput = SafeInput.Pipe.getRegExString(scanner, "Enter choice: ", "[AaDdPpQq]");
                    switch (userInput.toUpperCase()) {
                        case "A":
                            addItem(scanner);
                            break;
                        case "D":
                            deleteItem(scanner);
                            break;
                        case "P":
                            printList();
                            break;
                        case "Q":
                            //When choosing Qq they can quit the system
                            if (getYNConfirm(scanner, "Are you sure you want to quit? (Y/N): ")) {
                                System.out.println("Goodbye!");
                                System.exit(0);
                            }
                            break;
                        default:
                            //This option pops up when invalid response is chosen
                            System.out.println("Invalid choice, please try again.");
                    }
                } while (true);
            }

            private static void displayMenu() {
                System.out.println("=== MENU ===");
                System.out.println("A - Add an item to the list");
                System.out.println("D - Delete an item from the list");
                System.out.println("P - Print the list");
                System.out.println("Q - Quit");
                System.out.println();
                System.out.println("Current list: " + itemList);
                System.out.println();
                //Meaning behind every letter
            }

            private static void addItem(Scanner scanner) {
                //This allows you to add an item
                String item = SafeInput.getNonZeroLenString(scanner, "Enter item to add: ");
                itemList.add(item);
                System.out.println("Item added to the list.");
            }

            private static void deleteItem(Scanner scanner) {
                if (itemList.isEmpty()) {
                    //prompt for an empty list
                    System.out.println("The list is empty, nothing to delete.");
                    return;
                }

                int itemIndex = SafeInput.getRangedInt(scanner, "Enter item number to delete (1-" + itemList.size() + "): ", 1, itemList.size());
                String item = itemList.remove(itemIndex - 1);
                //prompt when list is deleted
                System.out.println("Item \"" + item + "\" deleted from the list.");
            }

            private static void printList() {
                if (itemList.isEmpty()) {
                    System.out.println("The list is empty.");
                } else {
                    System.out.println("=== LIST ===");
                    for (int i = 0; i < itemList.size(); i++) {
                        System.out.println((i + 1) + ". " + itemList.get(i));
                    }
                }
            }

            private static boolean getYNConfirm(Scanner scanner, String prompt) {
                //The Yes or No confirmation
                String userInput = SafeInput.Pipe.getRegExString(scanner, prompt, "[YyNn]");
                return userInput.equalsIgnoreCase("Y");
            }
        }

    }
}