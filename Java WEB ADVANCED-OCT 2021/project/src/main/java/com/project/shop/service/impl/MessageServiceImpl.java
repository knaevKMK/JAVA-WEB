package com.project.shop.service.impl;

import com.project.shop.model.entity.Message;
import com.project.shop.model.service.MsgServiceModel;
import com.project.shop.model.view.MsgListViewModel;
import com.project.shop.model.view.MsgViewModel;
import com.project.shop.repository.MessageRepository;
import com.project.shop.service.AccountService;
import com.project.shop.service.MessageService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl extends BaseServiceImpl<Message> implements MessageService {
    private final MessageRepository messageRepository;
    private final AccountService accountService;
    private final ModelMapper modelMapper;

    public MessageServiceImpl(MessageRepository messageRepository, AccountService accountService, ModelMapper modelMapper) {
        this.messageRepository = messageRepository;
        this.accountService = accountService;
        this.modelMapper = modelMapper;
    }

    @Override
    public String sendMessage(MsgServiceModel model, String senderUsername) {
        Message msg = modelMapper.map(model, Message.class);

        msg.setRecipient(accountService.findByUsername(model.getRecipientUsername())
                .orElseThrow(()->new NullPointerException("Recipient does not exist")));
                msg = onCreate(msg, senderUsername);
        messageRepository.saveAndFlush(msg);
        return "Message sent";
    }

    @Override
    public MsgViewModel getMessageBiId(UUID id) {
        return modelMapper.map(messageRepository.findById(id).orElseThrow(() -> new NullPointerException("msg missed"))
                , MsgViewModel.class);
    }

    @Override
    public boolean delete(UUID id, String username) {
        Optional<Message> msg = messageRepository.findById(id);
        if (msg.isEmpty()) {
            return false;
        }

        msg.get().setActive(false);
        Message message = onModify(msg.get(), username);
        messageRepository.saveAndFlush(message);
        return true;
    }

    @Override
    public Collection<MsgListViewModel> getMessages(String username, String query) {

        return getMessagesBy(query, username).stream().map(m -> modelMapper.map(m, MsgListViewModel.class))
                .collect(Collectors.toList());
    }

    private Collection<Message> getMessagesBy(String query, String username) {
        switch (query) {
            case "sent":
                return messageRepository.findAllByActiveIsTrueAndCreateFrom(username);
            case "received":
                return messageRepository.findAllByActiveIsTrueAndRecipient_Username(username);
            case "deleted":
                return messageRepository.findAllByActiveIsFalseAndCreateFromOrRecipient_Username(username,username);
            default:
                return messageRepository.findAll();
        }
    }
}
