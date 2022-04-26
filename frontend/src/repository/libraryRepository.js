import axios from '../custom-axios/axios';

const LibraryService = {
    fetchBooks: () => {
        return axios.get("/books");
    },
    fetchCategories: () => {
        return axios.get("/books/categories")
    },
    fetchAuthors: () => {
        return axios.get("/authors")
    },
    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`);
    },
    addBook: (name, category, author, availableCopies) => {
        return axios.post("/books/add", {
            "name": name,
            "category": parseInt(category),
            "author": parseInt(author),
            "availableCopies": parseInt(availableCopies)
        });
    },
    editBook: (id, name, category, author, availableCopies) => {
        return axios.put(`/books/edit/${id}`, {
            "name": name,
            "category": parseInt(category),
            "author": parseInt(author),
            "availableCopies": parseInt(availableCopies)
        });
    },
    getBook: (id) => {
        return axios.get(`/books/${id}`);
    },
    markBook: (id) => {
        return axios.put(`/books/mark/${id}`);
    }
}

export default LibraryService;
