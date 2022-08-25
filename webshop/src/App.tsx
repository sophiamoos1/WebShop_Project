import React from 'react';

import './App.css';
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import StartPage from "./Sites/StartPage";
import ProductPage from "./Sites/ProductPage";
import LoginPage from "./Sites/LoginPage";
import Account from "./Sites/Account";
import CartPage from "./Sites/CartPage";

function App() {
  return (
      <BrowserRouter>
      <Routes>
          <Route path='/' element={<StartPage/>}/>
          <Route path='/product/all' element={<ProductPage/>}/>
          <Route path='/login' element={<LoginPage/>}/>
          <Route path='/account/email/:email' element={<Account/>}/>
          <Route path='/order' element={<CartPage/>}/>
      </Routes>
      </BrowserRouter>
  );
}

export default App;
