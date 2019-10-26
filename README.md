# TicTacToeApp #
--------------
A simple TicTacToe game that makes use of two activities. The first activity is a simple "login" screen that asks the two players for their names. The second activity is the game logic where users take turns playing chosen locations and are updated on the game progress.

## Overview ##
This project is designed with an MVC Architecture. The game board is comprised of a 2D array of Cell objects, which themselves consist of a Coordinate object
and a symbol. Each Cell in the 2D array is populated with a blank '-' character to begin with, and is updated with either an 'X' or an 'O' 
as the game is played. Together, the TicTacToeBoard, Cell, and Coordinates classes make up the model of the game.  
  
There are two activities involved with the game, each one with their own corresponding XML files that determines their layout of elements.
The first activity just shows the rules of TicTacToe in case someone does not know how to play, and accepts user input for the names of player 1 and 2.  
The second activity is where the majority of the game happens. It is where the users click on a location to put their mark there. 
Player 1 is represented as an angel icon and player 2 is represented by a devil icon. As soon as a winner is determined or the board is full
with no winner, a "New Game" button appears and allows the user to start a new game. At any point during the game, the user can click the 
"Back to Main Menu" button and refresh themselves on the rules, or can change the name of player 1 or 2.

## MVC Architecture  ##
I chose to design this project with an Model-View-Architecture in oder to increase modularity, encapsulation, and improve expandability.

### Model  ###
(TicTacToeBoard etc)  
The model is the mechanics behind the game. It is the logic that makes the game work the way that it should.
It contains all of the logic-coding that accepts information from the controller and determines whose turn it is, 
whether or not someone has won, etc. The model is comprised of the **TicTacToeBoard class**, the **Cell class**, and the **Coordinate class**.
(Note: the model cannot communicate directly to the view and vice-versa. It must go through the controller to do so)

### View  ###
(activity_play_game.xml etc)  
The view is what the user sees and interacts with. It is made up of Buttons, EditTexts, ImageViews, etc.
It is designed and oriented in the XML file that is associated with each activity.  
(Note: the view cannot communicate directly to the model and vice-versa. It must go through the controller to do so)

### Controller  ###
(PlayGameActivity)  
The controller is the middle-man between the view and the model. The controller speaks directly with both the view and model, because
they cannot communicate with each other. In order for the controller to do its job, it must have both a View object as well
as a model object.  



