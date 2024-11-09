import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import NavBar from "../MainPage.jsx/NavBar";

function MyBooks(){
    const navigate=useNavigate()
    const mail=localStorage.getItem("mail")
    const[mybooks,setmybooks]=useState([])
    useEffect(()=>{
        getdata()
    },[])
    async function getdata(){
        const data=await axios.get(`http://localhost:8080/barrowbooks/getbooksbyemail/${mail}`,
            {
                headers:{Authorization:`Bearer ${localStorage.getItem("jwt")}` }
            }
        )
        setmybooks(data.data)
    }
    
    async function handlebtn(date){
     const data=await axios.get(`http://localhost:8080/barrowbooks/getbooksbyemail/${mail}/${date}`)
    
     window.location.reload()
    }
  
    return<>
      <NavBar/>
    {mybooks.length==0 ? <h1>You Dont have Books</h1>:
        <div className="mybooks">
            <h1>My Books</h1>
           {
            mybooks.map(book=>{
                return(
                   
                  <div key={book.id} className="mybooksinfo">
                    <img src={book.books.image}></img>
                    <p>{book.books.name}</p>
                    
                   
                    { book.status=="return" ?<>
                        <p><b>Return Date:</b>{book.returndate.slice(0,10)}</p>
                    <p><b>Status:</b>Return</p>
                    </>
                    :<>
                   <p><b>Essue Date:</b>{book.orderdata.slice(0,10)}</p>
                        <button onClick={()=>handlebtn(book.books.id)}>Return</button>
                        </>
                    }
                    
                  </div>
                )
            
            })
        }
    
        </div>
       
           }
       </>    
        
}
export default MyBooks;