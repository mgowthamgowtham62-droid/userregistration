package userregistration.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import userregistration.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

}

