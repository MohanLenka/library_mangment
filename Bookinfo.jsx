import axios from "axios"
import { useEffect, useState } from "react"
import { useParams } from "react-router-dom"
const BookInfo=(id)=>{
    
    const[book,setbook]=useState([])
    useEffect(()=>{
        getdata()
    },[])
   async function getdata(){
    const data=await axios.get(`http://localhost:8080/books/findbyid/${id.id}`)
    setbook(data.data)
    }
    
    return<>
    <div className="bookinfo">
      <h2>{book.name}</h2>
      <img src={book.image}></img>
      <p><b>Category:</b>{book.category}</p>
      <p><b>Author:</b>{book.author}</p>
      <p><b>Available Copies:</b>{book.copies}</p>
    </div>
    </>
}
export default BookInfo