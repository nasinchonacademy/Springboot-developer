package org.zerock.springbootdeveloper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class EntityManagerTest {

    @PersistenceContext  // ✅ 올바른 방식
    private EntityManager em;


    public void example(){
        // 1.엔티티 매니저가 엔티티를 관리하지 않는 상태(비영속 상태)
        Member member = new Member(1L,"홍길동");

        // 2.엔티티가 관리되는 상태
        em.persist(member);

        // 3. 엔티티 객체가 분리된 상태
        em.detach(member);

        // 4.엔티티 객체가 삭제된 상태
        em.remove(member);
    }
}
