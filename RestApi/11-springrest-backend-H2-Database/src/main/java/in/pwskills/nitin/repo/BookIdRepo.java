package in.pwskills.nitin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.nitin.beans.Book;

public interface BookIdRepo extends JpaRepository<Book, Integer> {

}
