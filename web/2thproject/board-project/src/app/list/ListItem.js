'use client'

const ListItem = ({ items }) => {
  const del = async (id) => {
    const r = await fetch('/api/post/delete', { method: 'POST', body: id })
    if (r.ok) location.reload()
    else alert('삭제 실패')
  }

  const dynDel = async (id) => {
    const r = await fetch('/api/post/' + id, { method: 'DELETE' })
    if (r.ok) location.reload()
    else alert('삭제 실패')
  }

  return (
    <>
      {items.map((a) => (
        <div className="list-item" key={a._id}>
          <h4>{a.title}</h4>
          <p>{a.content}</p>
          <button onClick={() => del(a._id)}>POST 삭제</button>
          <button onClick={() => dynDel(a._id)}>다이나믹 삭제</button>
        </div>
      ))}
    </>
  )
}

export default ListItem