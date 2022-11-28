import {getPizzas} from "../data.js";
import {useLoaderData} from "react-router-dom";

export async function loader() {
  const pizzas = await getPizzas();
  return pizzas;
}

export default function Index() {
  const { pizzas } = useLoaderData();
  console.log(pizzas);

  return (
    <>
      {pizzas.length ? (
        <ul>
          {pizzas.map((pizza) => (
            // TODO: replace key with real id
            <li className="pizza" key={pizzas.indexOf(pizza)}>
              <div>{pizza.name}</div>
              <div>{pizza.price}</div>
              <div>{pizza.weight}</div>
              <div>{pizza.size}</div>
            </li>
          ))}
        </ul>
      ) : (
        <p>
          <i>No pizzas</i>
        </p>
      )}
    </>
  );
}