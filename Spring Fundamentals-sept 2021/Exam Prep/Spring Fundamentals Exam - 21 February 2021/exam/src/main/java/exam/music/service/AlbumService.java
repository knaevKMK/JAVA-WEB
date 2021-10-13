package exam.music.service;

import exam.music.model.service.AlbumServiceModel;
import exam.music.model.service.UserServiceModel;
import exam.music.model.view.AlbumViewModel;

import java.util.List;

public interface AlbumService {
    void add(AlbumServiceModel model, UserServiceModel userModel);

    List<AlbumViewModel> getAll();

    void delete(String id);
}
