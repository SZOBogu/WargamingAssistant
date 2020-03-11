# WargamingAssistant
App contains 3 modules:
  - ScenarioGenerator - randomly generates pair of Depolyment and Mission pack.
  - DiceRollSimulator - simulates dice rolls according to data submitted in form. Dice rolls are organized in streams. Can generate random results or calculate most probable outcome.
  - RosterBuilder - allows to create rosters for wargames.
  
 Known issues:
  RosterBuilder:
  - Unique Items are not available after deleting unit despite releasing properly to Pool.
  - Updated initializer, that actually works as advertised.
  - Pool of points on option sets is not working properly.
  - No point pools for unit categories.
  - Overall chaos in code.
 
 To do:
  - Swing -> Spring
  - Mocking
  - Introduce Database (mongoDB)
  - BattleScore Calculator
