export default function Root() {
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