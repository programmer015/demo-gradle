//package com.thinkinnovative.demo_gradle.service.serviceImpl;
//
//import com.thinkinnovative.demo_gradle.dto.BookDTO;
//import com.thinkinnovative.demo_gradle.entity.LibraryInformation;
//import com.thinkinnovative.demo_gradle.entity.Queue;
//import com.thinkinnovative.demo_gradle.repository.LibraryRepository;
//import com.thinkinnovative.demo_gradle.repository.QueueRepository;
//import com.thinkinnovative.demo_gradle.service.QueueService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class QueueServiceImpl implements QueueService {
//
//
//    private LibraryRepository libraryRepository;
//
//    @Autowired
//    public QueueServiceImpl(LibraryRepository libraryRepository, QueueRepository queueRepository) {
//        this.libraryRepository = libraryRepository;
//        this.queueRepository = queueRepository;
//    }
//
//
//    private QueueRepository queueRepository;
//    @Override
//    public String addQueue(Integer bookId, Integer memberId) {
//
//        //Find the book
//        BookDTO library = libraryRepository.findBookById(bookId);
//        if(library == null)
//        {
//            return "Book not found";
//        }
//
//        // If the book does not have a queue, create one
////        Queue queue = library.getInqueue();
////        if(queue == null)
////        {
////            Queue queue1 = new Queue();
////            queue1.setMember_id(memberId);
////            queue1.setPosition(1);
////            queueRepository.save(queue1);
////            return "Success";
////
////        }
//
//     return "";
//
//    }
//}
