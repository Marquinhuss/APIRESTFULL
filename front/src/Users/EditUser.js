import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

export default function EditUser() {
    
    let navigate=useNavigate()

    const {id}=useParams()

    const [user,setUser]=useState({
        name:"",
        username:"",
        email:"" 
    })

    const{name, username, email}=user

    const onIputChange=(event)=>{ 
        setUser({...user,[event.target.name]:event.target.value})
    }

    useEffect(()=>{
        loadUser()
    }, [])

    const onSubmit= async(event)=>{
        event.preventDefault();
        await axios.put(`http://localhost:8081/api/usuario/${id}`, user)
        navigate("/")
    }

    const loadUser = async ()=>{
        const result=await axios.get(`http://localhost:8081/api/usuario/${id}`)
        setUser(result.data)
    }

    return (
        <div class="container ">
            <div className="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow" >
                    <h2 className="text-center m-4">Edit User</h2>

                    <form onSubmit={(event)=>onSubmit(event)}>

                    <div className="mb-3">
                        <label htmlFor="Name" className="form-label">
                            Name
                        </label>
                        <br></br>
                        <input
                            type={"text"}
                            className="form-control m-2 col-md-10"
                            placeholder="Enter your name"
                            name="name"
                            value={name}
                            onChange={(event)=>onIputChange(event)}
                        />
                    </div>

                    <div className="mb-3">
                        <label htmlFor="UserName" className="form-label">
                            Username
                        </label>
                        <br></br>
                        <input
                            type={"text"}
                            className="form-control m-2 col-md-10"
                            placeholder="Enter your username"
                            name="username"
                            value={username}
                            onChange={(event)=>onIputChange(event)}
                        />
                    </div>

                    <div className="mb-3">
                        <label htmlFor="Email" className="form-label">
                            Email
                        </label>
                        <br></br>
                        <input
                            type={"text"}
                            className="form-control m-2 col-md-10"
                            placeholder="Enter your Email"
                            name="email"
                            value={email}
                            onChange={(event)=>onIputChange(event)}
                        />
                    </div>
                    
                    <button type="cancel" className="btn btn-outline-danger m-2">Cancel</button>
                    <button type="submit" className="btn btn-outline-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    )
}
