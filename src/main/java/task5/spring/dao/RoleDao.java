package task5.spring.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import task5.spring.model.Role;

public interface RoleDao extends JpaRepository<Role, Long> {
}
