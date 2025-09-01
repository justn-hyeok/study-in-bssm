import { connectDB } from "@/app/util/database";

export default async function Home() {
    let client = await connectDB;
    const db = client.db('board');
    let result = await db.collection('post').find().toArray();

    return (
        <main>
            {result[0].title}
        </main>
    )
}