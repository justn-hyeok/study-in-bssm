import { connectDB } from "@/app/util/database"
import { ObjectId } from "mongodb"

export default async function Detail(props) {
    let client = await connectDB;
    const db = client.db('board');
    let result = await db.collection('post').findOne({_id: new ObjectId(props.params.id)});
    console.log(JSON.stringify(props));
    return (
        <div>
            <h4>{result.title}</h4>
            <p>{result.content}</p>
        </div>
    )
}
