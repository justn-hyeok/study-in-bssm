// src/app/api/post/new/route.js
import { NextResponse } from 'next/server'
import { connectDB } from '../../../util/database'

export async function POST(request) {
  try {
    const form = await request.formData()
    const body = Object.fromEntries(form.entries())
    if (!body.title || body.title.trim() === '') {
      return NextResponse.json('제목을 입력해주세요!', { status: 400 })
    }

    const client = await connectDB
    const db = client.db('board')
    await db.collection('post').insertOne({
      title: String(body.title),
      content: String(body.content ?? '')
    })

    return NextResponse.redirect(new URL('/list', request.url), 302)
  } catch {
    return NextResponse.json('서버 오류', { status: 500 })
  }
}