import axios from "axios"
import { useState } from "react"
import { useNavigate } from "react-router-dom"

const Login=()=>{
    const navigate=useNavigate()
    const[email,setemail]=useState("")
    const[password,setpassword]=useState("")
    async function login(){
    
        const res=await axios.post("http://localhost:8080/users/login",
            {
                "email":email,
               "password":password
            }
        )
        console.log(res.data.message)
       if(res.status==200 && res.data.message!="Bad credentials"){
       localStorage.setItem("mail",email)
       localStorage.setItem("jwt",res.data);
      navigate("/mainpage")
       }
       else{
        alert("something wrong please try again")
       }
    }
return <>
<center className="login">
    <div> <h1>LOGIN</h1>
    <p>________________</p></div>
   
    <div>
        <p>Email</p>
        <input type="email" placeholder="Enter email" onChange={(e)=>{setemail(e.target.value)}}></input>
    </div>
    <div>
        <p>Password</p>
        <input type="password" placeholder="Enter your password" onChange={(e)=>{setpassword(e.currentTarget.value)}}></input>
    </div>
    <button onClick={()=>{login()}}>Login</button>
    <a href="/creataccount">Dont't have Account?</a>
</center>
</>
}
export default Login