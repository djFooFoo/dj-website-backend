package dj.personal.website.book;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

interface BookCoverRepository extends JpaRepository<BookCover, Long> {

	Optional<BookCover> findByBook(Book book);
}
