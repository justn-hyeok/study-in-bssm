import { connectDB } from "@/util/database.js"

export default async function Home() {
  let client = await connectDB  //1. 
  const db = client.db('board') //db명
  let result = await db.collection('post').find().toArray() //collection명

  return <main>{result[0].title}</main>
}
