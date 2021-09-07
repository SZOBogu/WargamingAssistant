import React, {useState, createContext} from 'react'

export const GameContext = createContext();

function GameContextProvider(props){
    const [wargameId, setWargameId] = useState(0);

    const changeGame = (newWargameId) => {
        setWargameId(newWargameId);
    }

    return (
        <GameContext.Provider value={{wargameId, changeGame}}>
            {props.children}
        </GameContext.Provider>
    );
}

export default GameContextProvider;