import React, {useEffect, useState} from "react";
import {Order} from "../types/Order";
import {CartService} from "../services/ CartService";
import {Product} from "../types/ProductType";
import ProductCard from "./ProductCard";
import ProductCardBag from "./ProductCardBag";
import "../CSS/Bag.css";

export default function CartPage(){
    const[ordertData, setOrderData] = useState<Order>();
    useEffect(() => {
        CartService().getCart().then((data) => {
            setOrderData(data)
        });
    }, []);
    return(
    <div className="product-cart">

            <div className="items-bag">
            {ordertData?.products.map((product : Product, i: number) => {
                return(<ProductCardBag item={product}/>);
            })};
            </div>

    </div>
    );
}