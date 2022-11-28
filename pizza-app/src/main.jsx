import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.scss'

import Root from "./routes/root.jsx";
import {createBrowserRouter, RouterProvider} from "react-router-dom";
import Index, {
  loader as rootLoader,
} from "./routes/index.jsx";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Root />,
    children: [
      {
        index: true,
        element: <Index />,
        loader: rootLoader,
      },
    ],
  },
]);

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
)
