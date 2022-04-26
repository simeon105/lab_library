import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import LibraryService from "../../repository/libraryRepository";
import Header from "../Header/header";
import Books from "../Books/BookList/books";
import BookAdd from "../Books/ProductAdd/productAdd";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            books: [],
            categories: [],
            authors: []
        }
    }

    render() {
        return (
            <Router>
                <Header/>
                <main>
                    <div className="container">
                        <Routes>
                            <Route path={"/"} element={<Books books={this.state.books}
                                                                   onDelete={this.deleteBook}
                                                                   onEdit={this.getBook}/>}/>
                            <Route path={"/books"} element={<Books books={this.state.books}
                                                                   onDelete={this.deleteBook}
                                                                   onEdit={this.getBook}/>}/>
                            <Route path={"/books/add"} element={<BookAdd categories={this.state.categories}
                                                                         authors={this.state.authors}
                                                                               onAddBook={this.addBook}/>}/>


                        </Routes>

                    </div>
                </main>
            </Router>
        );
    }

    componentDidMount() {
        this.fetchData()
    }

    fetchData = () => {
        this.loadAuthors();
        this.loadCategories();
        this.loadBooks();
    }

    loadAuthors = () => {
        LibraryService.fetchAuthors()
            .then((data) => {
                this.setState({
                    authors: data.data
                })
            })
    }

    loadCategories = () => {
        LibraryService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            })
    }

    loadBooks = () => {
        LibraryService.fetchBooks()
            .then((data) => {
                this.setState({
                    books: data.data
                })
            });
    }

    deleteBook = (id) => {
        LibraryService.deleteBook(id)
            .then(() => {
                this.loadBooks();
            });
    }

    addBook = (name, category, author, availableCopies) => {
        LibraryService.addBook(name, category, author, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }

    getBook = (id) => {
        LibraryService.getBook(id)
            .then((data) => {
                this.setState({
                    selectedBook: data.data
                })
            })
    }

    editProduct = (id, name, category, author, availableCopies) => {
        LibraryService.editBook(id, name, category, author, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }
}

export default App;
