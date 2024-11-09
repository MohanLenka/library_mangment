import axios from "axios"
import { useState } from "react"
import { useNavigate } from "react-router-dom"

function CreateAccount(){
    const navigate=useNavigate()
    const[email,setemail]=useState("")
    const[password,setpassword]=useState("")
    const[name,setname]=useState("")
    async function login(){
      try{
        const res=await axios.post("http://localhost:8080/users/signup",
            {
               "name":name,
                "email":email,
               "password":password
            }
            
        )
        console.log(res)
        navigate("/")
      }
      catch(e){
          console.log(e)
      }
        
     
       
    }
    return<>
    <center className="login">
    <div> <h1>Create Account</h1>
    <p>________________</p></div>
    <div>
        <p>Enter Your Name</p>
        <input type="text" placeholder="Enter your name" required onChange={(e)=>{setname(e.target.value)}}></input>
    </div>
    <div>
        <p>Enter Your Email</p>
        <input type="email" placeholder="Enter email" required onChange={(e)=>{setemail(e.target.value)}}></input>
    </div>
    <div>
        <p>Set Password</p>
        <input type="password" placeholder="Enter your password" onChange={(e)=>{setpassword(e.currentTarget.value)}} required></input>
    </div>
    <button onClick={()=>{login()}}>Create Account</button>
    <a href="/">Already have an Account?</a>
</center>
    </>
}
export default CreateAccount;