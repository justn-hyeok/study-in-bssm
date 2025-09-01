import { MongoClient } from 'mongodb'
const url = 'mongodb+srv://yui:yuiyui@yuiyui.nkjcery.mongodb.net/?retryWrites=true&w=majority&appName=yuiyui' //DB접속 코드
const options = { useNewUrlParser: true }
let connectDB
//개발 환경에서는 데이터베이스 연결을 캐시에 저장(JS에서 계속 접속 실행 방지)
if (process.env.NODE_ENV === 'development') { 
  if (!global._mongo) {
    global._mongo = new MongoClient(url, options).connect()
  }
  connectDB = global._mongo
} else {
  connectDB = new MongoClient(url, options).connect()
}
export { connectDB }
