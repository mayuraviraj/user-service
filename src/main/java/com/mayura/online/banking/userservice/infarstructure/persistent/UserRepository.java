package com.mayura.online.banking.userservice.infarstructure.persistent;

import com.mayura.online.banking.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
}
