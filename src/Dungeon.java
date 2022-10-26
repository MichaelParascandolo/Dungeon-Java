import java.util.Scanner;
// DO NOT USE STATIC!
// PUBLIC VARIABLES MUST ALL BE PRIVATE
public class Dungeon {
    private int levels;
    private Box [] boxes;
    private int numOfLevels;
    private int startingBox;
    private Box theCurrentBox;

     public void DungeonHelper(int N) {
        numOfLevels = N;
        boxes = new Box[N];
        
        // Creates N number of boxes
        for(int i = 0; i < N; i++) {
            boxes[i] = new Box("["+i+"]");
            // System.out.println(boxes[i].getData());
        }
        // sets the last box.next = first box
        // boxes[N-1].next = boxes[0];
        boxes[N-1].setNext(boxes[0]);
        // sets all next boxes
        for(int j = 0; j < N; j++) {
            if(boxes[j].getNext() == null) {
                boxes[j].setNext(boxes[j+1]);
            }
            // System.out.println(boxes[j].getNext().getData());
        }
        // sets the first box.next = last box
        boxes[0].setPrevious(boxes[N-1]);
        // sets all previous boxes
        //
        for(int k = 0; k < N; k++) {
            if(boxes[k].getPrevious() == null) {
                boxes[k].setPrevious(boxes[k-1]);;
            }
            // System.out.println(boxes[k].getPrevious().getData());
        }
         startGame();
        
    }
    private void startGame() {
        // starts the game by starting the player in the middle
        startingBox = (int) Math.floor(numOfLevels/2);
        theCurrentBox = boxes[startingBox];
        // theCurrentBox.current = true;
        theCurrentBox.setCurrent(true);
        theCurrentBox.setDataHolder(theCurrentBox.getData());
        theCurrentBox.setData("" + theCurrentBox.getData() + " You Are Here");
        commandMenu();
        
    }
    private void commandMenu() {
                System.out.println();
                System.out.println("Enter Command:");
                System.out.println("PRINT | UP | DOWN | ATTACK |  QUIT");
            
                try (Scanner myObj = new Scanner(System.in)) {
                    String command = myObj.nextLine();
         
                    if(command.equalsIgnoreCase("PRINT")) {
                        // just just prints current for now
                        printDungeon();
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
                    // else if(command.equalsIgnoreCase("run")) {
                    //     run(theCurrentBox);
                    // }
                    else if(command.equalsIgnoreCase("quit")) {
                        System.exit(0);
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
    private void run(Box currentBox) {
        // player loses health if you run
        Encounter encounter1 = new Encounter();
        encounter1.getPlayer().setHealth(50);
        System.out.println("Health Lost:" + encounter1.getPlayer().getHealth());
    }
    private void attack(Box currentBox) {
        // if player wins, delete the box
        if(currentBox.getFight().attack()) {
            delete(currentBox);
        }
        commandMenu();
    }

    // deletes the box if the player wins
    private void delete(Box currentBox) {
        currentBox.setData(null);
        moveUp(currentBox);
        commandMenu();
    }

    // moves the current box to .next
    private void moveUp(Box currentBox) {
        currentBox.setCurrent(false);
        if(currentBox.getData() != null) {
            currentBox.setData(currentBox.getDataHolder());
        }
        currentBox.getNext().setDataHolder(currentBox.getNext().getData());
        currentBox.getNext().setCurrent(true);
        currentBox.getNext().setData(currentBox.getNext().getData() + " You Are Here");
        
        theCurrentBox = currentBox.getNext();
        printDungeon();
        commandMenu();

    }
    // COMBINE INTO ONE METHOD????
    // moves the current box to .previous
    private void moveDown(Box currentBox) {
        currentBox.setCurrent(false);
        if(currentBox.getData() != null) {
            currentBox.setData(currentBox.getDataHolder());
        }
        //
        currentBox.getPrevious().setDataHolder(currentBox.getPrevious().getData());
        currentBox.getPrevious().setCurrent(true);
        currentBox.getPrevious().setData(currentBox.getPrevious().getData() + " You Are Here");
        
        theCurrentBox = currentBox.getPrevious();
        printDungeon();
        commandMenu();
    }
    private void printDungeon() {
        // prints list normally
            for(int i = 0; i < numOfLevels; i++) {  
                if(boxes[i].getData() != null) {
                    System.out.println(boxes[i].getData());
                }
            }
        commandMenu();
    }
    private void startMenu() {
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
            System.out.println(e);
        }
    }

}
