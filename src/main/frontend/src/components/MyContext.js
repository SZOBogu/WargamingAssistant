import React, {useState, createContext} from 'react'

export const MyContext = createContext()

function MyContextProvider(props){
    const [wargameId, setWargameId] = useState(0)

    const changeGame = (newWargameId) => {
        setWargameId(newWargameId);
    }

    return (
        <MyContext.Provider value={{wargameId, changeGame}}>
            {props.children}
        </MyContext.Provider>
    );

}

export default MyContextProvider;