# DUNGEON GAME

## Created By: Michael Parascandolo

This Dungeon Game is command line based and is created using Java.

The Dungeon is a linked list where the goal is to defeat enemies on each level/node until all enemies have been defeated.

Number of levels is determined by the difficulty the player chooses at the start of the game.

Easy - 5 Levels

Medium - 15 Levels

Hard - 30 Levels

Custom - As many levels as you want (must be > 0)

# Commands

## Attack Command / Combat

The player has 200 HP and 100 Attack

Enemies stats are RNG based

Attack between 0 and 100 and Defense between 0 and 150

If player attack >= enemy defense then the player defeats the enemy

If the player wins the fight then that cell is deleted from the dungeon

If player attack < enemy defense then the enemy loses defense - player attack and player loses hp - enemy attack (player can then attack again if they want)

If the players health goes below zero you lose (obviously)

## Items

When the player wins an encounter there is a small (RNG) change an item will be generated

Items can increase the players HP or attack power and are consumed once they are picked up

## UP / DOWN

Players can move UP and DOWN through the dungeon and tackle the levels in whatever order they want, but you start in the middle by default

UP - Goes up

DOWN- You guessed it . . . goes down

## Run

If a player uses the run command they get to skip/delete the current cell they are on but at the cost of losing 30 HP so you take a chance on running away

## Print

The print command prints out the dungeon's remaining cells as well as the player position within the dungeon

## Quit

The quit command quits the game

###### there might be some cheat codes ;)
