import React, {useEffect, useState} from "react";
import {AllProductsService} from "../services/AllProductsService";
import '../CSS/ProductPage.css';
import {User} from "../types/UserType";
import UserCard from "./UserCard";
import ProductCard from "./ProductCard";
import {Product} from "../types/ProductType";
import Navbar from "../components/NavBar";


export default function ProductPage(){
    const[productData, setProductData] = useState([]);
    useEffect(() => {
        AllProductsService().getAllProducts().then((data) => {
            setProductData(data)
        });
    }, []);

    return(
    <div className="productPage">
        <div className="Navi"><Navbar/></div>
        {productData.map((product : Product, i: number) => {
            return(<ProductCard item={product}/>);
        })};


    </div>
);
}