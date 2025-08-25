export default async function Post({ params }) {
  const { id } = await params;
  return (
    <h1>post페이지 : {id}</h1>
  );
}