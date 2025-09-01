import { connectDB } from '@/app/util/database'
import { ObjectId } from 'mongodb'

export default async function Edit({ params }) {
  const client = await connectDB
  const db = client.db('board')
  const doc = await db.collection('post').findOne({ _id: new ObjectId(params.id) })
  if (!doc) return <div>존재하지 않는 글이긔…</div>

  return (
    <form action="/api/post/edit" method="POST" style={{display:'grid',gap:8,maxWidth:480}}>
      <input name="title" defaultValue={doc.title} />
      <input name="content" defaultValue={doc.content} />
      <input type="hidden" name="_id" defaultValue={doc._id.toString()} />
      <button type="submit">수정</button>
    </form>
  )
}