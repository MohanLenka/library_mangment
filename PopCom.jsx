const PopCom=({pop})=>{
    
    return <>
    <div className="pop">
        <p onClick={()=>{pop()}}>X</p>
        <h2>Book was sucessfully barrowed</h2>
    </div>

    </>
}
export default PopCom