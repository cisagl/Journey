import React, { createContext, useState } from "react";

export const GlobalContext = createContext();

export const GlobalProvider = ({ children }) => {

    const [starships, setStarships] = useState([]);
    const contextData = { starships, setStarships };

    return (
        <GlobalContext.Provider value={contextData}>
            {children}
        </GlobalContext.Provider>
    );
};

export default GlobalContext;
