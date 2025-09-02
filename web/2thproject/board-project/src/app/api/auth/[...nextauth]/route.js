import NextAuth from "next-auth";
import GithubProvider from "next-auth/providers/github"; //1-1
import GoogleProvider from "next-auth/providers/google"; //Google provider 추가
import { MongoDBAdapter } from "@next-auth/mongodb-adapter";
import { connectDB } from "../../../util/database.js";
//주요기능
//깃헙 로그인기능 만들기 (OAuth 로그인)

export const authOptions = {
    providers: [
        // //1-2. 깃헙 로그인 기능 설정
        GithubProvider({
            clientId: process.env.GITHUB_CLIENT_ID,
            clientSecret: process.env.GITHUB_CLIENT_SECRET,
        }),
        // Google 로그인 기능 설정
        GoogleProvider({
            clientId: process.env.GOOGLE_CLIENT_ID,
            clientSecret: process.env.GOOGLE_CLIENT_SECRET,
        }),
    ],
    secret : process.env.NEXTAUTH_SECRET, //1-3
    adapter : MongoDBAdapter(connectDB) //MongoDB adapter 추가
};
const handler = NextAuth(authOptions);

export { handler as GET, handler as POST };
