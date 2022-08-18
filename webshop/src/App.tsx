import React from 'react';

import './App.css';
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import Users from './Sites/Users';
import StartPage from "./Sites/StartPage";
import ProductPage from "./Sites/ProductPage";

function App() {
  return (
      <BrowserRouter>
      <Routes>
          <Route path='/' element={<StartPage/>}/>
          <Route path='/users' element={<Users/>}/>
          <Route path='/product/all' element={<ProductPage/>}/>
      </Routes>
      </BrowserRouter>
  );
}

export default App;
