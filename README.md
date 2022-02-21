# WargamingAssistant
App contains 5 modules:
  - ScenarioGenerator - randomly generates pair of Depolyment and Mission pack.
  - DiceRollSimulator - simulates dice rolls according to data submitted in form. Dice rolls are organized in streams. Can generate random results or calculate most probable outcome.
  - RosterBuilder - allows to create rosters for wargames.
  - ScoringCalculator - calculates exact score of the game according to sum of points and their type.
  - TournamentHandler - lets you to create and sign up to events, supports automatic pairing of players. As of February 2022 in development and still in shambles.
  
 Known issues:
  ScenarioGenerator:
  - Support of premade scenarios.
  - Turning detachments pools into map pools.
  - Decoupling part from wargames entirely.
  RosterBuilder:
  - Pool of points on option sets is not working properly.
  - Overall chaos in code.
  - No detachment rule checking.
  - Suboptimal endpoints.
  - No lazy fetching.
  ScoringCalculator:
  - Faulty calculations.
  - Unecessary implementation of "rules".
 
 To do:
  - TournamentHandler
  - Frontend (basic HTML first, ReacjJS later)
  - Database (PostgreSQL)
