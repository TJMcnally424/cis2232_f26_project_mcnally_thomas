# NHL stat tracker
Business Client: Cameron
Lead Developer: Thomas
Quality Control: Jesse

# Description 
Stat tracking application for NHL players
This application allows officials with the NHL to track the stats for the players in the league calculate their points, as well as various derived statistics.

# Colour
Azure

# Required fields
playerFirstName	String
playerLastName	String
playerPosition	String
playerGoals	Int
playerAssists	Int
playerPenaltyMin	Float
playerMatches	Int
playerWins	Int
playerLosses	Int
playerShots	Int
playerSaves	Int
playerPoints	Int
playerPointsPerGame	Double
playerScoringPercentage	Double

# Calculation
Total points:
playerGoals + playerAssists = playerPoints

Points per game
playerPoints / playerMatches = playerPointsPerGame

Scoring Percentage
playerGoals / playerShots * 100 = playerScoringPercentage
