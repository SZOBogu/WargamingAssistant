# WargamingAssistant
App contains 3 modules:
  - ScenarioGenerator - randomly generates pair of Depolment and Scenario pack.
  - DiceRollSimulator - simulates dice rolls according to data submited in form. Dice rolls are organized in "streams". Can generate random results or calculate most probable outcome.
  - RosterBuilder - allows to create rosters for wargames.
  
 Known issues:
  - Unique Items are not available after deleting unit despite releasing properly to Pool.
  - Pool of points on option sets are not working properly.
  - Overall chaos in code.
 
 To do:
  - Swing -> Spring
  - Introduce Database (mongoDB)
  - Rework of ScenarioGenerator: allowing to generate scenarios for whole tournament on one click with or without duplication.
  - BattleScore Calculator
