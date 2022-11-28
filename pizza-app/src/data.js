import axios from "axios";

const client = axios.create({
  baseURL: "https://jsonplaceholder.typicode.com/posts"
});

export async function getPosts() {
  let response = await client.get('?_limit=10');
  console.log(response.data);
  return response.data;
}