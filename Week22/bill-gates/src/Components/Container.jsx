import { useState } from "react";
import items from "./Items.js";
import Card from "./Card.jsx";
import Header from "./Header.jsx";
import Items from "./Items.js";
import Money from "./Money.jsx";
import Receipt from "./Receipt.jsx";

const Container = () => {

    const [cartItems, setCartItems] = useState(items);
    const [dollars, setDollars] = useState(100000000000);

    if (dollars === 0) {
        alert("You have no money left!");
    }

    const onAdd = (selectedItem) => { 
        const updateCardItems = cartItems.map(item => {
            if (item.id === selectedItem.id) {
                return {...item, quantity: item.quantity + 1}
            }
            return item;
        });
        if (dollars - selectedItem.price < 0) {
            return;
        } else {
            setCartItems(updateCardItems);
            setDollars(prevDollars => prevDollars - selectedItem.price);
        }
        
    };

    const onRemove = (selectedItem) => {

        const currentQuantity = cartItems.find(item => item.id === selectedItem.id).quantity;

        if (currentQuantity > 0) {
            const updatedCartItems = cartItems.map(item => {
                if (item.id === selectedItem.id) {
                    return {...item, quantity: item.quantity - 1};
                }
                return item;
            });
            setCartItems(updatedCartItems);
            setDollars(prevDollars => prevDollars + selectedItem.price);
        } 
    };

    return (
        <div className="menu">
            <div className="heads">
                <Header />
                <Money dollar={dollars}/>
            </div>
            <div className="cards">
                {Items.map((item, index) => {
                    return (
                        <Card
                        key={item.id}
                        item={item}
                        index={index}
                        onRemove={onRemove}
                        onAdd={onAdd}
                        cartItems={cartItems}
                        />
                    )
                })}
            </div>
            <Receipt cartItems={cartItems}/>
        </div>
    );
};

export default Container;