'use client'
import { signIn, signOut } from 'next-auth/react'
import { useSession } from 'next-auth/react'

export default function LoginBtn() {
    const { data: session } = useSession();
    
    if (session) {
        return <button onClick={()=>signOut()}>로그아웃</button>
    }
    return <button onClick={()=>signIn()}>로그인</button>
}