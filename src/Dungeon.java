import java.util.Scanner;

public class Dungeon {
    private static int levels;
    private static Box [] boxes;
    private static int numOfLevels;
    private static int startingBox;
    private static Box theCurrentBox;

    public static void DungeonHelper(int N) {
        numOfLevels = N;
        boxes = new Box[N];
        
        // Creates N number of boxes
        for(int i = 0; i < N; i++) {
            boxes[i] = new Box("["+i+"]");
            // System.out.println(boxes[i].data);
        }
        // sets the last box.next = first box
        boxes[N-1].next = boxes[0];
        // sets all next boxes
        for(int j = 0; j < N; j++) {
            if(!boxes[j].hasNext()) {
                boxes[j].next = boxes[j+1];
            }
           
            // System.out.println(boxes[j].next.data);
        }
        // sets the first box.next = last box
        boxes[0].previous = boxes[N-1];
        // sets all previous boxes
        for(int k = 0; k < N; k++) {
            if(!boxes[k].hasPrevious()) {
                boxes[k].previous = boxes[k-1];
            }
            // System.out.println(boxes[k].previous.data);
        }
        
         startGame();
        
    }
    public static void startGame() {
        startingBox = (int) Math.floor(numOfLevels/2);
        theCurrentBox = boxes[startingBox];
        theCurrentBox.current = true;
        theCurrentBox.dataHolder = theCurrentBox.data;
        theCurrentBox.data = "[X]";
        commandMenu();
        
    }
    public static void commandMenu() {
                System.out.println();
                System.out.println("Enter A Command:");
                System.out.println("PRINT | UP | DOWN | ATTACK | RUN | QUIT");
            
                try (Scanner myObj = new Scanner(System.in)) {
                    String command = myObj.nextLine();
         
                    if(command.equalsIgnoreCase("PRINT")) {
                        // just just prints current for now
                        printDungeon("current");
                    }
                    else if(command.equalsIgnoreCase("up")) {
                        moveUp(theCurrentBox);
                    }
                    else if(command.equalsIgnoreCase("down")) {
                        moveDown(theCurrentBox);
                    }
                    else if(command.equalsIgnoreCase("attack")) {
                        attack(theCurrentBox);
                    } 
                    else if(command.equalsIgnoreCase("run")) {
                        run(theCurrentBox);
                    }
                    else if(command.equalsIgnoreCase("quit")) {
                        System.exit(0);
                    }
                    else if(command.equalsIgnoreCase("test")) {
                        delete(theCurrentBox);
                    }
                    else {
                        System.out.println("Invalid Input . . .");
                        commandMenu();
                    }
                }
                catch(Exception e) {
                    //  Block of code to handle errors
                }
    }
    private static void run(Box currentBox) {
        Encounter.player1.setHealth(50);
        System.out.println(Encounter.player1.getHealth());
    }
    private static void attack(Box currentBox) {
        currentBox.fight.fight();
        commandMenu();
    }
    static void delete(Box currentBox) {
        currentBox.data = null;
        commandMenu();
    }
    // moves the current box to .next
    private static void moveUp(Box currentBox) {
        currentBox.current = false;
        currentBox.data = currentBox.dataHolder;
        //
        currentBox.next.dataHolder = currentBox.next.data;
        currentBox.next.current = true;
        currentBox.next.data = "[X]";
        
        theCurrentBox = currentBox.next;
        commandMenu();

    }
    // COMBINE INTO ONE METHOD????
    // moves the current box to .previous
    private static void moveDown(Box currentBox) {
        currentBox.current = false;
        currentBox.data = currentBox.dataHolder;
        //
        currentBox.previous.dataHolder = currentBox.previous.data;
        currentBox.previous.current = true;
        currentBox.previous.data = "[X]";
        
        theCurrentBox = currentBox.previous;
        commandMenu();
    }
    private static void printDungeon(String printWhat) {
        // prints list normally
        if(printWhat.equalsIgnoreCase("current")) {
            for(int i = 0; i < numOfLevels; i++) {  
                if(boxes[i].data != null) {
                    System.out.println(boxes[i].data);
                }
            }
        }// prints all next 
        commandMenu();
    }
    private static void startMenu() {
        try (Scanner myObj = new Scanner(System.in)) {
            // easy has 5 levels, medium has 10, and hard has 30?
            System.out.println();
            System.out.println("Select Difficulty:");
            System.out.println("EASY | MEDIUM | HARD | CUSTOM");
            
            String difficulty = myObj.nextLine();
            System.out.println();
            
            if(difficulty.equalsIgnoreCase("easy")) {
                levels = 5;
            }
            else if(difficulty.equalsIgnoreCase("medium")) {
                levels = 15;
            }
            else if(difficulty.equalsIgnoreCase("hard")) {
                levels = 30;
            }
            else if(difficulty.equalsIgnoreCase("custom")) {
                System.out.println("Enter Desired Number Of Levels: ");
                levels = myObj.nextInt();
            }
            else {
                // if input is invalid just restart the program
                System.out.println("Invalid Input . . .");
                startMenu();
                
            }
            System.out.println("Difficulty Chosen: " + difficulty.toUpperCase() + " ");
            DungeonHelper(levels);
        }
        catch(Exception e) {
            //  Block of code to handle errors
        }
    }
    public static void main(String[] args) {
        // startMenu();
        DungeonHelper(10);
        // USED FOR TESTING
    }



}
