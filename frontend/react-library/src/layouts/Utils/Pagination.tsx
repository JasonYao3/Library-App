export const Pagination: React.FC<{
  currentPage: number;
  totalPages: number;
  paginate: any;
}> = (props) => {
  const pageNumbers = [];
  const { currentPage, totalPages } = props;

  for (let i = currentPage - 2; i <= currentPage + 2; i++) {
    if (i >= 1 && i <= totalPages) {
      pageNumbers.push(i);
    }
  }

  return (
    <nav aria-label="...">
      <ul className="pagination">
        <li className="page-item" onClick={() => props.paginate(1)}>
          <button className="page-link">First Page</button>
        </li>
        {pageNumbers.map((number) => (
          <li
            key={number}
            onClick={() => props.paginate(number)}
            className={"page-item " + (currentPage === number ? "active" : "")}
          >
            <button className="page-link">{number}</button>
          </li>
        ))}
        <li className="page-item" onClick={() => props.paginate(props.totalPages)}>
          <button className="page-link">Last Page</button>
        </li>
      </ul>
    </nav>
  );
};
