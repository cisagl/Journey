const Money = (props) => {
    
    var dollar = props.dollar;

    return (
        <div>
        <h1 className="dollar">{dollar}$</h1>
        </div>
    )
}

export default Money;