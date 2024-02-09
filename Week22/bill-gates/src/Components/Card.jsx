const Card = ({item, onAdd, onRemove, cartItems}) => {

    const inputValue = cartItems.find((cartItem) => cartItem.id === item.id);

    return (
        <div className="cardTop">
            <div className="card">
                <div className="column">
                    <img className="cardImg" src={item.image} alt={item.name} />
                    <h1 className="cardTitle">{item.name}</h1>
                    <p className="cardPrice">{item.price}$</p>
                </div>
                <div className="flex">
                    <button className="cardRemove" onClick={() => onRemove(item)}>Remove</button>
                    <p className= "cardPiece">{inputValue.quantity}</p>
                    <button className="cardAdd" onClick={() => onAdd(item)}>Add</button>
                </div>
            </div>
        </div>
    ) 
};

export default Card;