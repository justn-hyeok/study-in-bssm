// src/app/detaillink/page.js
'use client'
import { useRouter, usePathname } from 'next/navigation'

const DetailLink = () => {
  const r = useRouter()
  const p = usePathname()

  return (
    <div>
      <button onClick={() => r.push('/')}>홈으로</button>
      <button onClick={() => r.back()}>뒤로가기</button>
      <button onClick={() => r.push('/list')}>리스트로</button>
      <p>현재 경로: {p}</p>
    </div>
  )
}

export default DetailLink