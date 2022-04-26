import React from 'react';

const Categories = (props) => {
    return (
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"table-responsive"}>
                    {props.categories.map((term) => {
                        return (
                            <p>{term}</p>
                        )
                    })}
                </div>
            </div>
        </div>
    )
}

export default Categories;
