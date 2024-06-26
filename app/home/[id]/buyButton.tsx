"use client";
import { useState, useEffect } from "react";
import { Button } from "@/components/ui/button"

export default function BuyButton({ product }: any) {
  const [isBought, setIsBought] = useState(false)
  
  function setBought() {
    const storedUser = localStorage.getItem("user");
    const user = storedUser && JSON.parse(storedUser);
    const buyerId = user.id;
    fetch(`http://localhost:5000/api/products/${product.id}`)
      .then((response) => response.json())
      .then((data) => {
        if (data.buyer_id == buyerId)
          setIsBought(true)
      })



  }
  function handleSubmit() {
    const id = product.id
    // console.log(id)
    const storedUser = localStorage.getItem("user");
    const user = storedUser && JSON.parse(storedUser);
    const buyerId = user.id;
    const obj = {
      buyer_id: buyerId
    }
    fetch(`http://localhost:5000/api/products/${id}`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(obj),
    })
      .then((response) => response.json())
      .then((data) => {
        // Handle the response data
        // console.log(data);
        setIsBought(true)
      })
      .catch((error) => {
        // Handle any errors
        console.error(error);
      });



  }
  useEffect(() => {
    setBought()
  }, []);

  return (
    <>
      {
        isBought ?
          (
            <Button style={{
              background: "#33b249"
            }}
              onClick={handleSubmit} size="lg">
              Bought
            </Button>
          ) :
          (
            <Button className="" onClick={handleSubmit} size="lg">
              Buy Now
            </Button>

          )
      }
    </>

  )
}