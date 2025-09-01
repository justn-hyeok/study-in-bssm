import { NextResponse } from 'next/server'
import { connectDB } from '../../util/database'

export async function GET() {
  const client = await connectDB
  const db = client.db('board')

  const docs = await db
    .collection('post')
    .find({})
    .sort({ _id: -1 })
    .toArray()

  const items = docs.map(d => ({ ...d, _id: d._id.toString() }))
  return NextResponse.json(items, { status: 200 })
}