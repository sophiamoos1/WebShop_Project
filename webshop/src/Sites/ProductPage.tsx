import React, {useEffect, useState} from "react";
import {AllProductsService} from "../services/AllProductsService";
import '../CSS/ProductPage.css';
import ProductCard from "./ProductCard";
import {Product} from "../types/ProductType";
import NaviBar from "../components/NaviBar";


export default function ProductPage(){
    const[productData, setProductData] = useState([]);
    useEffect(() => {
        AllProductsService().getAllProducts().then((data) => {
            setProductData(data)
        });
    }, []);

    return(
        <div className="try">
            <div className="Navi"><NaviBar/></div>
    <div className="productPage">
        {productData.map((product : Product, i: number) => {
            return(<ProductCard item={product}/>);
        })};
    </div>
        </div>
);
}