import { connectDB } from "@/app/util/database"

export default async function List() {
  let client = await connectDB;
  const db = client.db('board');
  let result = await db.collection('post').find().toArray();
  
  return (
    <div className="list-bg">
      {result.map((a, i) => (
        <div className="list-item" key={i}>
          <h4>{a.title}</h4>
          <p>{a.content}</p>
        </div>
      ))}
    </div>
  )
}