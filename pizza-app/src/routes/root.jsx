import {getPosts} from "../data.js";
import {useLoaderData} from "react-router-dom";

export async function loader() {
  const posts = await getPosts();
  return { posts };
}

export default function Root() {
  const { posts } = useLoaderData();

  return (
    <>
      <div id="header">
        <form id="search-form" role="search">
          <input
            id="q"
            aria-level="Search pizza"
            placeholder="Search"
            type="search"
            name="q"
          />
          <div
            id="search-spinner"
            aria-hidden
          />
        </form>
        <nav>
          <a href={`basket`}>Basket</a>
        </nav>
      </div>
      <div id="content"></div>
    </>
  );
}