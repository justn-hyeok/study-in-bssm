// src/app/detail/[id]/page.js
import { connectDB } from '../../util/database'
import { ObjectId } from 'mongodb'

const Detail = async ({ params }) => {
  const client = await connectDB
  const db = client.db('board')

  const result = await db
    .collection('post')
    .findOne({ _id: new ObjectId(params.id) })

  if (!result) return <div>존재하지 않는 글이긔…</div>

  return (
    <div>
      <h4>{result.title}</h4>
      <p>{result.content}</p>
    </div>
  )
}

export default Detail