package com.thinkinnovative.demo_gradle.service.serviceImpl;

import com.thinkinnovative.demo_gradle.dto.BookDTO;
import com.thinkinnovative.demo_gradle.dto.MemberListDTO;
import com.thinkinnovative.demo_gradle.dto.QueueDTO;
import com.thinkinnovative.demo_gradle.entity.LibraryInformation;
import com.thinkinnovative.demo_gradle.entity.MemberTable;
import com.thinkinnovative.demo_gradle.entity.Queue;
import com.thinkinnovative.demo_gradle.repository.LibraryRepository;
import com.thinkinnovative.demo_gradle.repository.MemberRepository;
import com.thinkinnovative.demo_gradle.repository.QueueRepository;
import com.thinkinnovative.demo_gradle.service.QueueService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueueServiceImpl implements QueueService {


    private final LibraryRepository libraryRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public QueueServiceImpl(LibraryRepository libraryRepository, MemberRepository memberRepository, QueueRepository queueRepository) {
        this.libraryRepository = libraryRepository;
        this.memberRepository = memberRepository;
        this.queueRepository = queueRepository;
    }


    private final QueueRepository queueRepository;
    @Override
    @Transactional
    public String addQueue(Integer bookId, Integer memberId) {


        //MemberListDTO memberTable = memberRepository.findByMemberID(memberId);
        //Find the book
        LibraryInformation library = libraryRepository.findBook1ById(bookId);
        if(library == null)
        {
            return "Book not found";

        }

//         If the book does not have a queue, create one
        List<Queue> queue = library.getInqueue();
        if(queue.isEmpty()) {
            queue = new ArrayList<>();

        }
        // Create and add the new Queue entry
        int newPosition = queue.size() + 1;
        Queue newQueue = new Queue(memberId, newPosition, library);
//            Queue queue1 = new Queue();
//
//            queue1.setMember_id(memberId);
//            queue1.setPosition(queue.size()+1);
//            queue1.setLibraryInformation(library);
            //queue.add(queue1);
           //queue.add(queue1);
            //queueRepository.save(newQueue);
           // queue = new ArrayList<Queue>();
            queue.add(newQueue);
        library.setInqueue(queue);
            libraryRepository.save(library);

           // return "You has been added in queue";


// If the book already has a queue, add a new member to the queue with position 2
//        int newPosition = queue.size()+1;
//        Queue newQueue = new Queue();
//        newQueue.setPosition(newPosition);
//        newQueue.setMember_id(memberId);
//        queueRepository.save(newQueue);
//        queue.add(newQueue);
//        // Check if the position is already occupied and update the position of the new member
//        Queue newQueue = new Queue();
//        newQueue.setMember_id(memberId);  // Adding member with ID 9
//        newQueue.setPosition(existingQueue.getPosition()+1);   // Set position to 2
//        queueRepository.save(newQueue);
//
//        // Update the existing queue to reflect the changes
//        // If needed, you could shift positions or just leave them as-is
//        //existingQueue.setPosition(1);
//        queueRepository.save(existingQueue);

//        library.setInqueue(queue);
//        libraryRepository.save(library);

        return "You have been added to the queue with position "+newPosition;


    }

    @Override
    public List<QueueDTO> queueByBookid(Integer bookID) {
      // queueRepository.findQueueWithMemberNameByBookID(bookID);
        return queueRepository.findQueueWithMemberNameByBookID(bookID);
    }
}
