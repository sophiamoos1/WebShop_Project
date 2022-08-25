import {Product} from "./ProductType";

export interface Order {
    orderId:string;
    products: Product[];
}
