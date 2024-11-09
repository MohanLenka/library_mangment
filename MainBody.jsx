import axios from "axios"
import { useEffect, useState } from "react"
import { useNavigate } from "react-router-dom"
import NavBar from "./NavBar"

const MainBody=({onsearch})=>{
   const[data,setdata]=useState([])
    const navigate=useNavigate()
   useEffect(()=>{
      getbooks(onsearch)
   },[onsearch])
 
 
  async function getbooks(){
   
     if(onsearch==""){
        const res=await axios.get("http://localhost:8080/books/findall")
        setdata(res.data)
     }
     else{
      try{
         const res=await axios.get(`http://localhost:8080/books/findbyname/${onsearch}`)
         setdata(res.data)
      }
      catch{
         console.log("error occured")
         
      }
     }
     

   }
   const handlebutton=(id)=>{
      navigate(`/barrowbook/${id}`)
   }
    return<>
  
    <div className="mainbody">
   {

      data.map(item=>{
         return(
            <div className="mainpage" key={item.id}>
             
         <img src={`${item.image}`}></img>
         <div className="content">
         <p><b>category:</b>{item.category}</p>
         <p><b>Name:</b>{item.name}</p>
         <p><b>No of copies:</b>{item.copies}</p>
         <button onClick={()=>{handlebutton(item.id)}}>Barrow Now</button>
         </div>
         </div>
      )
      })
   }
   </div>
    </>
}
export default MainBody