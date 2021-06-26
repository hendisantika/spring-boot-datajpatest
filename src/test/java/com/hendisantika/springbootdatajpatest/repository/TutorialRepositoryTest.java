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

}

