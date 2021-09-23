package com.ViMiJo.webservicemusicaccount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountuserRepository extends JpaRepository<Accountuser, Long>{

    Optional<Accountuser> findAccountuserByUserName(String userName);

}
