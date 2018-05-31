package lebui.blogx.shared.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lebui.blogx.shared.entity.Parent;

public interface ParentRepository extends JpaRepository<Parent, Integer> {
    
}
