// src/app/api/post/new/route.js
import { NextResponse } from 'next/server'
import { connectDB } from '../../../util/database'
import { getServerSession } from 'next-auth/next'
import { authOptions } from '../../auth/[...nextauth]/route'

export async function POST(request) {
  let session = await getServerSession(authOptions) // 세션 정보 가져오기
  console.log(session)
  
  try {
    const form = await request.formData()
    const body = Object.fromEntries(form.entries())
    if (!body.title || body.title.trim() === '') {
      return NextResponse.json('제목을 입력해주세요!', { status: 400 })
    }

    // body 정보에 author 추가
    if (session) {
      body.author = session.user.email
    }

    const client = await connectDB
    const db = client.db('board')
    await db.collection('post').insertOne({
      title: String(body.title),
      content: String(body.content ?? ''),
      author: body.author || null // author 정보 추가
    })

    return NextResponse.redirect(new URL('/list', request.url), 302)
  } catch {
    return NextResponse.json('서버 오류', { status: 500 })
  }
}