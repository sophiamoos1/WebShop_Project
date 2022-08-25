import {Product} from "../types/ProductType";
import '../CSS/ProductCard.css';

type Card = {
    item : Product
}

export default function ProductCardBag({item}:Card){
    return(
        <div className="productCard">
            <img src={item?.picture}/>
            <div className="cardContent">
                <h3 className="productTitle">{item?.title}</h3>
                <ol>
                    <li><span className="description">{item?.description}</span></li>
                    <li><span className="weight">{item?.weight}</span></li>
                    <li><span className="price">{item?.price}$</span></li>
                </ol>
            </div>
        </div>
    )
}