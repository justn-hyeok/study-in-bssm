// src/app/api/post/[id]/route.js
import { NextResponse } from 'next/server'
import { connectDB } from '../../../util/database'
import { ObjectId } from 'mongodb'

export async function DELETE(_req, { params }) {
  try {
    const client = await connectDB
    const db = client.db('board')
    const r = await db.collection('post').deleteOne({ _id: new ObjectId(params.id) })

    if (r.deletedCount === 1) return NextResponse.json('삭제성공', { status: 200 })
    return NextResponse.json('대상이 없음', { status: 404 })
  } catch (e) {
    return NextResponse.json('서버 오류', { status: 500 })
  }
}