'use client'

import Link from 'next/link'

export default function Listitem({item}) {
    return (
        <div className="list-item" key={i}>
            <Link href={'/detail/'+item._id}>
                <h4>{a.title}</h4>
            </Link>
            <p>{item.content}</p>
        </div>
    )
}