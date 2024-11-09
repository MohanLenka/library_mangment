import { useState } from "react";
import NavBar from "./NavBar";
import NavBAr from "./NavBar";
import MainBody from "./MainBody";

function MainPage(){
    const[search,setsearch]=useState("")

    function handlechange(text){
      
        setsearch(text);
       
    }
  
    return<>
    <NavBar setsearch={handlechange}/>
    <MainBody onsearch={search}/>
    </>
}
export default MainPage