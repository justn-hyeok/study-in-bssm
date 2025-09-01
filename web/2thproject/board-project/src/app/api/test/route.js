import { NextResponse } from 'next/server'

export async function GET() {
  return NextResponse.json({ message: '성공함' })
}

export async function POST(request) {
  const body = await request.json().catch(() => null)
  return NextResponse.json({ received: body }, { status: 201 })
}