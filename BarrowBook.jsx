import axios from "axios"
import { useEffect, useState } from "react"
import { useNavigate, useParams } from "react-router-dom"
import BookInfo from "./Bookinfo"
import PersonInfo from "./PersonInfo"
import PopCom from "./PopCom"
import NavBar from "../NavBar"

function BarrowBook(){
    const navigate=useNavigate()
    const id=useParams()
    const[pop,setpop]=useState(false)
   async function handlebtn(){
          const mail=localStorage.getItem("mail")
          console.log(id.id)
          const data=await axios.post(`http://localhost:8080/barrowbooks/addinfo/${mail}/${id.id}`)
          if(data.data=="sucessfully added"){
            handlepop()
          }
          else{
            alert("you have already barrowed this book")
          }
        
   }
    function handlepop(){
       setpop(!pop)
      
    }
    return<>
      <NavBar/>
    <div>
     <div className="book"><h2>BOOK INFORMATION</h2>
     <BookInfo id={id.id}></BookInfo></div>
    
    <div className="per">
        <h2>PERSONAL INFORMATION</h2>
    <PersonInfo/>
    </div>
   <button className="barrowbtn" onClick={()=>{handlebtn()}}>Barrow Now</button>
   { pop==true?<PopCom pop={handlepop}/>:""}
   </div>
    </>
}
export default BarrowBook