# WargamingAssistant
App contains 3 modules:
  - ScenarioGenerator - randomly generates pair of Depolyment and Scenario pack.
  - DiceRollSimulator - simulates dice rolls according to data submitted in form. Dice rolls are organized in "streams". Can generate random results or calculate most probable outcome.
  - RosterBuilder - allows to create rosters for wargames.
  
 Known issues:
  RosterBuilder:
  - Unique Items are not available after deleting unit despite releasing properly to Pool.
  - Pool of points on option sets is not working properly.
  - No point pools for unit categories.
  - No visual clue on currently spent points during roster creation.
  - Overall chaos in code.
 
 To do:
  - Swing -> Spring
  - Introduce Database (mongoDB)
  - Rework of ScenarioGenerator: allowing to generate missions for whole tournament on one click with or without duplication.
  - BattleScore Calculator
