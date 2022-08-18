import {Product} from "../types/ProductType";
import '../CSS/ProductCard.css';

type Card = {
    item : Product
}

export default function ProductCard({item}:Card){
    return(
        <div className="ProductCard">

        </div>
    )
}