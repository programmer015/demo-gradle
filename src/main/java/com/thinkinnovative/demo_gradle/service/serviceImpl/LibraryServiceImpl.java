package com.thinkinnovative.demo_gradle.service.serviceImpl;

import com.thinkinnovative.demo_gradle.dto.BookDTO;
import com.thinkinnovative.demo_gradle.entity.LibraryInformation;
import com.thinkinnovative.demo_gradle.repository.LibraryRepository;
import com.thinkinnovative.demo_gradle.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {
    //BookDTO bookDTOs;
    LibraryRepository libraryRepository;
    @Autowired
    public LibraryServiceImpl( LibraryRepository libraryRepository) {

        this.libraryRepository = libraryRepository;
    }





    @Override
    public String addBooks(LibraryInformation libraryInformation) {
        libraryRepository.save(libraryInformation);
        return "Book added success successfully";
    }

//    @Override
//    public String addBook(LibraryInformation libraryInformation) {
//        libraryRepository.insertBook(libraryInformation);
//        return "Book added success successfully";
//    }


    public List<BookDTO> getAllBooksWithStatus() {
        //System.out.println("Books Retrieved: " + bookDTOs);
        List<BookDTO> books = libraryRepository.findAllBooksWithStatus();
        System.out.println("Books Retrieved: " + books);
        return libraryRepository.findAllBooksWithStatus();
    }

    public BookDTO getBookById(Integer id) {
        return libraryRepository.findBookById(id);
    }

    @Override
    public Page<BookDTO> getBookByPage(int page, int size) {
        return libraryRepository.getBookByPage(PageRequest.of(page, size));
    }


    @Override
    public List<LibraryInformation> getAllBooks() {

        return libraryRepository.findAll();
    }

//

    @Override
    public String saveBooks(java.util.List<LibraryInformation> libraryInformation) {
        libraryRepository.saveAll(libraryInformation);
        return "All books were saves successfully";
    }


}
