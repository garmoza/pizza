import axios from "axios";

const client = axios.create({
  baseURL: "https://jsonplaceholder.typicode.com/posts"
});

export async function getPizzas() {
  let response = await client.get('http://localhost:8081/pizzas');
  return response.data._embedded;
}