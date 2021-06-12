package dj.personal.website.book;


import org.springframework.data.jpa.repository.JpaRepository;

interface BookRepository extends JpaRepository<Book, Long> {
    void deleteByIsbn(Long isbn);
}
