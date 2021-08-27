package com.spycode.demoapi.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import com.spycode.demoapi.model.*;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query.*;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
 
    @Query(value = "SELECT o FROM Alumno o WHERE o.id=?1")
    Optional<Alumno> buscarPorId(int id);
}
