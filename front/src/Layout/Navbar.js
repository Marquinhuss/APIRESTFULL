import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'

export default function Navbar() {
  
  return (
  <div>
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark  ">
        <div className="container-fluid">
          <a className="navbar-brand" href="#">Eycon</a>
          <button className="navbar-toggler"
           type="button" data-bs-toggle="collapse" 
           data-bs-target="#navbarSupportedContent" 
           aria-controls="navbarSupportedContent" 
           aria-expanded="false" 
           aria-label="Toggle navigation"
           >
            <span className="navbar-toggler-icon"></span>
          </button>

          <Link className="btn btn-outline-light" to="/addUser">Add user</Link>
  </div>
    </nav>
  </div>
  )
}
