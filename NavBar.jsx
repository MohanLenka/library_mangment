import { useState } from "react"
import MainBody from "./MainBody"
import { useNavigate } from "react-router-dom"

const NavBar=({setsearch})=>{
  const navigate=useNavigate()
    const[input,setinput]=useState("")
    function fetchdata(e){
        setsearch(input)
    }

   return <>
      <div className="nav">
        <p onClick={()=>{navigate('/mainpage')}
        }>Home</p>
        <div className="in">
       <input type="text" placeholder="search by book" onChange={(e)=>{setinput(e.target.value)}}></input>
       <button onClick={(e)=>{fetchdata(e)}}>Search</button>
       </div>
        <p onClick={()=>{navigate("/mybooks")}}>My Books</p>    
      </div>
      
   </>
}
export default NavBar