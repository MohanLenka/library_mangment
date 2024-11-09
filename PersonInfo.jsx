import axios from "axios"
import { useState } from "react"

const PersonInfo=()=>{
    const[inf,setinf]=useState([])
    let mail=localStorage.getItem("mail")
   useState(()=>{
    getinfo()
   },[])
  
   async function getinfo(){
    const data=await axios.get(`http://localhost:8080/users/findbymail/${mail}`)
    setinf(data.data)
    console.log(data)
   }
   
    return <>
    <div className="personinfo">
        <p><b>Name:</b>{inf.name}</p>
        <p><b>Email:</b>{inf.email}</p>
    </div>
    </>
}
export default PersonInfo