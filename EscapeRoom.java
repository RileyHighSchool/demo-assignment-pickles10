/*
* Problem 1: Escape Room CONOR FLETCHER
* 
* V1.0
* 10/10/2019
* Copyright(c) 2019 PLTW to present. All rights reserved
*/
import java.util.Scanner;

/**
 * Create an escape room game where the player must navigate
 * to the other side of the screen in the fewest steps, while
 * avoiding obstacles and collecting prizes.
 */
public class EscapeRoom
{

      // describe the game with brief welcome message
      // determine the size (length and width) a player must move to stay within the grid markings
      // Allow game commands:
      //    right, left, up, down: if you try to go off grid or bump into wall, score decreases
      //    jump over 1 space: you cannot jump over walls
      //    if you land on a trap, spring a trap to increase score: you must first check if there is a trap, if none exists, penalty
      //    pick up prize: score increases, if there is no prize, penalty
      //    help: display all possible commands
      //    end: reach the far right wall, score increase, game ends, if game ended without reaching far right wall, penalty
      //    replay: shows number of player steps and resets the board, you or another player can play the same board
      // Note that you must adjust the score with any method that returns a score
      // Optional: create a custom image for your player use the file player.png on disk
    
      /**** provided code:
      // set up the game
      boolean play = true;
      while (play)
      {
        // get user input and call game methods to play 
        play = false;
      }
      */

  public static void main(String[] args) 
  {      
    // welcome message
    System.out.println("Welcome to EscapeRoom!");
    System.out.println("Get to the other side of the room, avoiding walls and invisible traps,");
    System.out.println("pick up all the prizes.\n");
    
    GameGUI game = new GameGUI();
    game.createBoard();

    // size of move
    int m = 60; 
    // individual player moves
    int px = 0;
    int py = 0; 
    
    int score = 0;

    Scanner in = new Scanner(System.in);
    String[] validCommands = { "right", "left", "up", "down", "r", "l", "u", "d",
    "jump", "jr", "jumpleft", "jl", "jumpup", "ju", "jumpdown", "jd",
    "pickup", "p", "quit", "q", "replay", "help", "?"};
  
    // set up game
    boolean play = true;
    while (play)
    {
      /* TODO: get all the commands working */
	  /* Your code here */
    // get input from user, move player, then add to score 

    System.out.println("Enter a command");
    String input = UserInput.getValidInput(validCommands);

    if (input.equals("right") || input.equals("r")) { //RIGHT
      px += m;
      if (game.isTrap(px,py)){
        score += game.springTrap(px, py);
      }
      score += game.movePlayer(m, 0);
      System.out.println("You moved right");
    }
      else if (input.equals("left") || input.equals("l")) { //LEFT
        if (game.isTrap(px,py)){
          score += game.springTrap(px, py);
        }
        score += game.movePlayer(-m, 0);
        System.out.println("You moved Left");
        px += -m;

      }
      else if (input.equals("up") || input.equals("u")) { //UP
        py += -m;
        if (game.isTrap(px,py)){
          score += game.springTrap(px, py);
        }
        score += game.movePlayer(0, -m);
        System.out.println("You moved Up");
      }
      else if (input.equals("down") || input.equals("d")) { //DOWN
        py += m;
        if (game.isTrap(px,py)){
          score += game.springTrap(px, py);
        }
        score += game.movePlayer(0, m);
        System.out.println("You moved Down");
      }
      else if (input.equals("jumpright") || input.equals("jr")) { //JRIGHT
        px += m;
        if (game.isTrap(px,py)){
          score += game.springTrap(px, py);
        }
        score += game.movePlayer(m*2, 0);
        System.out.println("You Jumped right");
      }
      else if (input.equals("jumpleft") || input.equals("jl")) { //JLEFT
        px += -m;
        if (game.isTrap(px,py)){
          score += game.springTrap(px, py);
        }
        score += game.movePlayer(-m*2, 0);
        System.out.println("You Jumped Left");
      }
      else if (input.equals("jumpup") || input.equals("ju")) { //JUP
        py += -m;
        if (game.isTrap(px,py)){
          score += game.springTrap(px, py);
        }
        score += game.movePlayer(0, -m*2);
        System.out.println("You Jumped up");
      }
      else if (input.equals("jumpdown") || input.equals("jd")) { //JDOWN
        py += m;
        if (game.isTrap(px,py)){
          score += game.springTrap(px, py);
        }
        score += game.movePlayer(0,m*2);
        System.out.println("You Jumped Down");
      }
      else if (input.equals("pickup") || input.equals("p")) { //PICKUP
      
        score += game.pickupPrize();
        System.out.println("You Picked up a Prize ");
      }
      else if (input.equals("quit") || input.equals("q")) { //QUIT
        score += game.endGame();
        play = false;
        //System.out.println("You quit ");
      }
      else if (input.equals("replay")) { //Replay
        score += game.replay();
        //System.out.println("You wanted to replay ");
      }

    

          //pickup prize 
          //if in.equals pickup || p, add to score 



          //quit
          //if quit print game.endgame


          //replay
          //if replay print game.replay()

          //help button
          //if help, 
    }
  

    score += game.endGame();

    System.out.println("score=" + score);
    System.out.println("steps=" + game.getSteps());
  }
}

