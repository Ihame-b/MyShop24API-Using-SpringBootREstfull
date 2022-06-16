package com.ihame.shop24.dao;

import com.ihame.shop24.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long > {
}
