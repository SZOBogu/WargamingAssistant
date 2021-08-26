import './App.css';
import MyContextProvider from './components/MyContext';
import SystemSelectionMenu from './components/SystemSelectionMenu';
import ScenarioComponent from './components/ScenarioComponent';
import DiceRollComponent from './components/DiceRollComponent';
import RosterComponent from './components/RosterComponent';
import NavBar from './components/NavBar';
import {BrowserRouter, Route} from 'react-router-dom'
import DiceContextProvider from "./components/DiceContext";

function App() {
  return (
      <MyContextProvider>
          <div className="App">
              <header className="App-header">
                  Wargaming Assistant
              </header>
              <BrowserRouter>
                  <NavBar/>
                  <Route path="/" component={SystemSelectionMenu}/>
                  <Route path="/scenario" component={ScenarioComponent}/>
                  <DiceContextProvider>
                      <Route path="/dice" component={DiceRollComponent}/>
                  </DiceContextProvider>
                  <Route path="/roster" component={RosterComponent}/>
              </BrowserRouter>
          </div>
      </MyContextProvider>
  );
}

export default App;
