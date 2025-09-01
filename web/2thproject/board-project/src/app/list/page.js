import { connectDB } from '../util/database'
import ListItem from './ListItem'

export const revalidate = 0

export default async function List() {
  const client = await connectDB
  const db = client.db('board')
  const docs = await db.collection('post').find({}).sort({ _id: -1 }).toArray()
  const items = docs.map(d => ({ ...d, _id: d._id.toString() }))

  return (
    <div className="list-bg">
      <ListItem items={items} />
    </div>
  )
}