package com.project.shop.service;

import com.project.shop.model.service.MsgServiceModel;
import com.project.shop.model.view.MsgListViewModel;
import com.project.shop.model.view.MsgViewModel;

import java.util.Collection;
import java.util.UUID;

public interface MessageService {
    String sendMessage(MsgServiceModel model, String senderUsername);

    MsgViewModel getMessageBiId(UUID id);

    boolean delete(UUID id, String username);

    Collection<MsgListViewModel> getMessages(String username, String query);
}
