import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'

export default function ViewUser() {
  const {id}=useParams()

  const [user,setUser]=useState({
    name:"",
    username:"",
    email:""
  })

  const{name, username, email}=user
  
  useEffect(()=>{
    loadUser()
  }, [])

  const loadUser = async()=>{
    const result = await axios.get(`http://localhost:8081/api/usuario/${id}`, user)
    setUser(result.data)
  }
  return (
    <div class="container ">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow" >
          <h2 className="text-center m-4">User Details</h2>
          <div className="card">
            <div className="card-header">
              Details of user id:
              <ul className="list-group list-group-flush">
                <li className="list-group-item">
                    <b>Name:{name}</b>
                </li>
                <li className="list-group-item">
                    <b>Username:{username}</b>
                </li>
                <li className="list-group-item">
                    <b>Email:{email}</b>
                </li>
              </ul>
            </div>
          </div>
          <br/>
          <Link className="btn btn-outline-primary mx-2" to={"/"}>Back Home</Link>
        </div>
      </div>
    </div>
  )
}
