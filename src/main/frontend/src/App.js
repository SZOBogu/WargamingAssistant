import './App.css';
import ScenarioComponent from './components/ScenarioGenerator/ScenarioComponent';
import DiceRollComponent from './components/DiceRollSimulator/DiceRollComponent';
import RosterComponent from './components/RosterComponent';
import NavBar from './components/NavBar';
import {BrowserRouter, Route} from 'react-router-dom'
import GameContextProvider from "./components/GameContext";

function App() {
  return (
      <GameContextProvider>
          <div className="container">
              <header className="App-header">
                  Wargaming Assistant
              </header>
              <BrowserRouter>
                  <NavBar/>
                  {/*<Route path="/" component={SystemSelectionMenu}/>*/}
                  <Route path="/scenario" component={ScenarioComponent}/>
                  <Route path="/dice" component={DiceRollComponent}/>
                  <Route path="/roster" component={RosterComponent}/>
              </BrowserRouter>
          </div>
      </GameContextProvider>
  );
}

export default App;
