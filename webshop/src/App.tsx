import React from 'react';

import './App.css';
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import Users from './Sites/Users';
import StartPage from "./Sites/StartPage";
import ProductPage from "./Sites/ProductPage";
import LoginPage from "./Sites/LoginPage";

function App() {
  return (
      <BrowserRouter>
      <Routes>
          <Route path='/' element={<StartPage/>}/>
          <Route path='/users' element={<Users/>}/>
          <Route path='/product/all' element={<ProductPage/>}/>
          <Route path='/login' element={<LoginPage/>}/>
      </Routes>
      </BrowserRouter>
  );
}

export default App;
