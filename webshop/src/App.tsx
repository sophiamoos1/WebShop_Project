import React from 'react';

import './App.css';
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import Users from './Sites/Users';
import StartPage from "./Sites/StartPage";

function App() {
  return (
      <BrowserRouter>
      <Routes>
          <Route path='/' element={<StartPage/>}/>
          <Route path='/users' element={<Users/>}/>
      </Routes>
      </BrowserRouter>
  );
}

export default App;
