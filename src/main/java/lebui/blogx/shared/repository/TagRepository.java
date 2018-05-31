package lebui.blogx.shared.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lebui.blogx.shared.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {

}
