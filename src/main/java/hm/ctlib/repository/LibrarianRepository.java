package hm.ctlib.repository;

import hm.ctlib.model.Librarian;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {
	public List<Librarian> findByRoleId(Integer id);
}
