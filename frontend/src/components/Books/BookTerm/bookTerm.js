import React from 'react';

const bookTerm = (props) => {
    return (
        <tr>
            <td>{props.term.name}</td>
            <td>{props.term.category}</td>
            <td>{props.term.author}</td>
            <td className={"text-right"}>
            </td>
        </tr>
    )
}

export default bookTerm;
