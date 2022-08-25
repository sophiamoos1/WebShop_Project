export interface User{
    userId: string;
    password: string;
    email: string;
    lastname: string;
    name: string;
    role: string;
    orders: [
        orderId:string,
        products: [
            productId: string,
            title : string,
            description : string,
            price : string,
            weight : string,
            picture : string
        ]
    ];
}