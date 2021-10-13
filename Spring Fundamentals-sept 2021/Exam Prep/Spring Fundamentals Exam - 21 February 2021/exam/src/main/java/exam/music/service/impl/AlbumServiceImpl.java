package exam.music.service.impl;

import exam.music.model.entity.Album;
import exam.music.model.service.AlbumServiceModel;
import exam.music.model.service.UserServiceModel;
import exam.music.model.view.AlbumViewModel;
import exam.music.repository.AlbumRepository;
import exam.music.service.AlbumService;
import exam.music.service.ArtistService;
import exam.music.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final ModelMapper modelMapper;
    private final AlbumRepository albumRepository;
    private final ArtistService artistService;
    private final UserService userService;

    public AlbumServiceImpl(ModelMapper modelMapper, AlbumRepository albumRepository, ArtistService artistService, UserService userService) {
        this.modelMapper = modelMapper;
        this.albumRepository = albumRepository;
        this.artistService = artistService;
        this.userService = userService;
    }


    @Override
    public void add(AlbumServiceModel model, UserServiceModel userModel) {
        Album album = modelMapper.map(model, Album.class);
     //   album.setReleasedDate(LocalDate.parse(model.getReleasedDate()));
        album.setArtist(this.artistService.findByName(model.getArtist()));
        album.setAddFrom(this.userService.getUser(userModel));

        this.albumRepository.saveAndFlush(album);
    }

    @Override
    public List<AlbumViewModel> getAll() {
        List<Album> all = this.albumRepository
                .findAll();
        List<AlbumViewModel> collect = all.stream()
                .map(album -> {
                    AlbumViewModel map = modelMapper.map(album, AlbumViewModel.class);
                    map.setArtist(album.getArtist().getSinger().name());
                    return map;
                })
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public void delete(String id) {
        this.albumRepository.deleteById(id);
    }


}
