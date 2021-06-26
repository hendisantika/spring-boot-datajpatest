package com.hendisantika.springbootdatajpatest.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

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

}
