package com.thinkinnovative.demo_gradle.service;

import com.thinkinnovative.demo_gradle.dto.BookDTO;
import com.thinkinnovative.demo_gradle.entity.LibraryInformation;

import java.util.List;


public interface LibraryService {

    public String addBooks(LibraryInformation libraryInformation);
    //public String addBook(LibraryInformation libraryInformation);
    //public String getBooksById(Integer Id);
    public List<LibraryInformation> getAllBooks();
//    public String updateBooks(LibraryInformation libraryInformation);
//    public String modifyStatus();
    public String saveBooks( List<LibraryInformation> libraryInformation);
    public List<BookDTO> getAllBooksWithStatus();
    public BookDTO getBookById(Integer id);
}
