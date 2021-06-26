package com.hendisantika.springbootdatajpatest.repository;

import com.hendisantika.springbootdatajpatest.entity.Tutorial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-datajpatest
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 26/06/21
 * Time: 14.42
 */
@DataJpaTest
class TutorialRepositoryTest {
    @Autowired
    TutorialRepository repository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void should_find_no_tutorials_if_repository_is_empty() {
        Iterable<Tutorial> tutorials = repository.findAll();
        assertThat(tutorials).isEmpty();
    }

    @Test
    public void should_store_a_tutorial() {
        Tutorial tutorial = repository.save(new Tutorial("Tut title", "Tut desc", true));

        assertThat(tutorial).hasFieldOrPropertyWithValue("title", "Tut title");
        assertThat(tutorial).hasFieldOrPropertyWithValue("description", "Tut desc");
        assertThat(tutorial).hasFieldOrPropertyWithValue("published", true);
    }

    @Test
    public void should_find_all_tutorials() {
        Tutorial tut1 = new Tutorial("Tut#1", "Desc#1", true);
        entityManager.persist(tut1);

        Tutorial tut2 = new Tutorial("Tut#2", "Desc#2", false);
        entityManager.persist(tut2);

        Tutorial tut3 = new Tutorial("Tut#3", "Desc#3", true);
        entityManager.persist(tut3);

        Iterable<Tutorial> tutorials = repository.findAll();

        assertThat(tutorials).hasSize(3).contains(tut1, tut2, tut3);
    }

    @Test
    public void should_find_tutorial_by_id() {
        Tutorial tut1 = new Tutorial("Tut#1", "Desc#1", true);
        entityManager.persist(tut1);

        Tutorial tut2 = new Tutorial("Tut#2", "Desc#2", false);
        entityManager.persist(tut2);

        Tutorial foundTutorial = repository.findById(tut2.getId()).get();

        assertThat(foundTutorial).isEqualTo(tut2);
    }

    @Test
    public void should_find_published_tutorials() {
        Tutorial tut1 = new Tutorial("Tut#1", "Desc#1", true);
        entityManager.persist(tut1);

        Tutorial tut2 = new Tutorial("Tut#2", "Desc#2", false);
        entityManager.persist(tut2);

        Tutorial tut3 = new Tutorial("Tut#3", "Desc#3", true);
        entityManager.persist(tut3);

        Iterable<Tutorial> tutorials = repository.findByPublished(true);

        assertThat(tutorials).hasSize(2).contains(tut1, tut3);
    }
}

