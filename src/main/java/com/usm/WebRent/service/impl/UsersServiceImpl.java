package com.usm.WebRent.service.impl;

import com.usm.WebRent.entity.Users;
import com.usm.WebRent.repository.UsersRepository;
import com.usm.WebRent.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;

    @Override
    public Users save(Users users) {return usersRepository.save(users);}
}
