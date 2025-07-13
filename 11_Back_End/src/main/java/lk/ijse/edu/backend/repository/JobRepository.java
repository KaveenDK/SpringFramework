package lk.ijse.edu.backend.repository;

import jakarta.transaction.Transactional;
import lk.ijse.edu.backend.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * --------------------------------------------
 * @Author Dimantha Kaveen
 * @GitHub: https://github.com/KaveenDK
 * --------------------------------------------
 * @Created 7/7/2025
 * @Project Spring Framework
 * --------------------------------------------
 **/

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Job SET status = ?2 WHERE id = ?1", nativeQuery = true)
    void updateJobStatus(int jobId, String status);

    List<Job> findJobByJobTitleContainingIgnoreCase(String keyword);
}