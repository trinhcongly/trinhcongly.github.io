package com.JAVA.TEST.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JAVA.TEST.model.Work;

@Repository
public interface WorkRepository extends JpaRepository<Work, Integer> {
	Optional<Work> findByWorkName(String workName);
    Optional<Work> findByWorkId(Integer workId);
}
