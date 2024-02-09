const Receipt = ({ cartItems }) => {
  const filteredCartItems = cartItems.filter((item) => item.quantity > 0);

  return (
    <div className="receipt">
      <h2>Receipt</h2>
      <ul>
        {filteredCartItems.map((item) => (
          <li key={item.id}>
            {item.name} x {item.quantity} - ${item.price * item.quantity}
          </li>
        ))}
        <h3 style={{ marginTop: "20px" }}>TOTAL</h3>
        <h3>
          ${" "}
          {filteredCartItems
            .reduce((acc, item) => acc + item.price * item.quantity, 0)}
        </h3>
      </ul>
    </div>
  );
};

export default Receipt;
