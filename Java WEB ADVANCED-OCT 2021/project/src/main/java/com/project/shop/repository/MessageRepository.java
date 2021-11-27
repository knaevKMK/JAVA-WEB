package com.project.shop.repository;

import com.project.shop.model.entity.Message;
import com.project.shop.model.view.MsgListViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface MessageRepository extends JpaRepository<Message, UUID> {
    Collection<Message> findAllByActiveIsTrueAndCreateFrom(String senderUsername);

    Collection<Message> findAllByActiveIsTrueAndRecipient_Username(String recipientUsername);

    Collection<Message> findAllByActiveIsFalseAndCreateFrom(String username);
}
